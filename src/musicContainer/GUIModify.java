package musicContainer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIModify extends JPanel{
private JTextField[] fields;
	
	public GUIModify(){
		
	}
	
	public GUIModify(String[] dataName, int[] lengthLimit) {
		
		
		super(new BorderLayout());
		

		JPanel dataNamePanel = new JPanel(new GridLayout(dataName.length, 1));
		JPanel lengthLimitPanel = new JPanel(new GridLayout(dataName.length, 1));
		add(dataNamePanel, BorderLayout.WEST);
		add(lengthLimitPanel, BorderLayout.CENTER);
		fields = new JTextField[dataName.length];
		 

		String[] partOne = new String[14];
		
		int i= GUIManager.musicTable.getSelectedRow();
		
		System.out.println("selected Row:"+i);
		
		partOne[0] = GUIManager.mySongs.get(i).songName;
		partOne[1] = GUIManager.mySongs.get(i).lyricist;
		partOne[2] = GUIManager.mySongs.get(i).composer;
		partOne[3] = GUIManager.mySongs.get(i).rearranger;
		partOne[4] = GUIManager.mySongs.get(i).featuring;
		partOne[5] = GUIManager.mySongs.get(i).artistName;
		partOne[6] = GUIManager.mySongs.get(i).AlbumName;
		partOne[7] = GUIManager.mySongs.get(i).imageName;
		partOne[8] = GUIManager.mySongs.get(i).genre;
		partOne[9] = GUIManager.mySongs.get(i).realeasedDate;
		partOne[10] = GUIManager.mySongs.get(i).Date;
		partOne[11] = GUIManager.mySongs.get(i).runningTimeInString;
		partOne[12] = GUIManager.mySongs.get(i).ILike;
		partOne[13] = String.valueOf(GUIManager.mySongs.get(i).like);
		for(int j=0; j<14; j++){
		System.out.println(partOne[j]);
		}
		
		
		
		for (int i1=0; i1<dataName.length; i1++) {
			
			fields[i1] = new JTextField(partOne[i1]);
			if (i1 < lengthLimit.length)
				fields[i1].setColumns(lengthLimit[i1]);
			JLabel lab = new JLabel(dataName[i1], JLabel.RIGHT);
			lab.setLabelFor(fields[i1]);
			dataNamePanel.add(lab);
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panel.add(fields[i1]);
			lengthLimitPanel.add(panel);
		}
		
		
		
	}

	public String getText(int i) {
		return (fields[i].getText());
	}

	public void ModifyInterFaceRun() {
		//labels 배열 
		String[] dataName = { "제목", "작사", "작곡", "편곡(없다면 x로 표시)", "피쳐링(없다면 x로 표시)", "아티스트", "앨범", "이미지(o/x)", "장르","발매일(2013.4.28등)","등록 날짜(2015.4.3등)","러닝타임(3:48 등)" ,"좋아요(1~10사이 별점)" ,"좋아요 수(멜론기준)"};
		int[] lengthLimit = { 15, 15, 10, 10, 10, 10, 10, 20, 10, 10, 10, 10, 10, 5};
		
		
		GUIModify ModifyInterface = new GUIModify(dataName, lengthLimit);
		
		int i= GUIManager.musicTable.getSelectedRow();
		JButton putIn = new JButton("수정");
		
		
		JFrame frame = new JFrame("곡 수정");
		frame.getContentPane().add(ModifyInterface, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.add(putIn);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setSize(500, 550);
		frame.setVisible(true);
		
		
		putIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					String songName = ModifyInterface.getText(0);
					String lyricist = ModifyInterface.getText(1);
					String composer = ModifyInterface.getText(2);
					String rearranger = ModifyInterface.getText(3);
					String featuring = ModifyInterface.getText(4);
					String artistName = ModifyInterface.getText(5);
					String AlbumName = ModifyInterface.getText(6);
					String imageName = ModifyInterface.getText(7);
					String genre = ModifyInterface.getText(8);
					String realeasedDate = ModifyInterface.getText(9);
					String Date = ModifyInterface.getText(10);
					String runningTimeInString = ModifyInterface.getText(11);
					String ILike = ModifyInterface.getText(12);
					int like= Integer.parseInt(ModifyInterface.getText(13));
					
					GUIManager.mySongs.remove(i);
					
					GUIManager.mySongs.add(new SongModel(songName,lyricist,composer,rearranger,featuring,artistName,AlbumName,imageName,genre,realeasedDate,Date,runningTimeInString,ILike,like));
						
					GUIManager.musicTable.setModel(new SongTableModel(GUIManager.mySongs));
					frame.setVisible(false);
				
			}
		});
		
		
	}
}
