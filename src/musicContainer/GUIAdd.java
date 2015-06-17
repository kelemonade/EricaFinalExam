package musicContainer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.*;


public class GUIAdd extends JPanel{

	private JTextField[] fields;
	
	public GUIAdd(){
		
	}
	
	public GUIAdd(String[] dataName, int[] lengthLimit) {

		super(new BorderLayout());

		JPanel dataNamePanel = new JPanel(new GridLayout(dataName.length, 1));
		JPanel lengthLimitPanel = new JPanel(new GridLayout(dataName.length, 1));
		add(dataNamePanel, BorderLayout.WEST);
		add(lengthLimitPanel, BorderLayout.CENTER);
		fields = new JTextField[dataName.length];
		 
		for (int i=0; i<dataName.length; i++) {
			
			fields[i] = new JTextField();
			if (i < lengthLimit.length)
				fields[i].setColumns(lengthLimit[i]);
			JLabel lab = new JLabel(dataName[i], JLabel.RIGHT);
			lab.setLabelFor(fields[i]);
			dataNamePanel.add(lab);
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panel.add(fields[i]);
			lengthLimitPanel.add(panel);
		}
		
	}

	public String getText(int i) {
		return (fields[i].getText());
	}

	public void AddInterFaceRun() {
		//labels 배열 
		String[] dataName = { "제목", "작사", "작곡", "편곡(없다면 X로 표시)", "피쳐링(없다면 X로 표시)", "아티스트", "앨범", "이미지(o,x)", "장르","발매일(2013.4.28등)","등록 날짜(2015.4.3등)","러닝타임(3:48 등)" ,"평점(1~10사이 별점,소수점은 안됨)" ,"좋아요 수(멜론기준)"};
		int[] lengthLimit = { 15, 10, 10, 10, 10, 10, 20, 10, 10, 10, 10, 10, 5, 10};
		
		
		GUIAdd AddInterface = new GUIAdd(dataName, lengthLimit);
		
		JButton putIn = new JButton("Add");
		
		JFrame frame = new JFrame("곡 등록하기");
		frame.getContentPane().add(AddInterface, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.add(putIn);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setSize(500, 550);
		frame.setVisible(true);
		
		
		putIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String songName = AddInterface.getText(0);
					String lyricist = AddInterface.getText(1);
					String composer = AddInterface.getText(2);
					String rearranger = AddInterface.getText(3);
					String featuring = AddInterface.getText(4);
					String artistName = AddInterface.getText(5);
					String AlbumName = AddInterface.getText(6);
					String imageName = AddInterface.getText(7);
					String genre = AddInterface.getText(8);
					String realeasedDate = AddInterface.getText(9);
					String Date = AddInterface.getText(10);
					String runningTimeInString = AddInterface.getText(11);
					String ILike = AddInterface.getText(12);
					long like= Long.parseLong(AddInterface.getText(13));
					
				
			
					
					GUIManager.mySongs.add(new SongModel(songName,lyricist,composer,rearranger,featuring,artistName,AlbumName,imageName,genre,realeasedDate,Date,runningTimeInString,ILike,like));
					GUIManager.mySongs.get(0).WriteWithoutLyrics();
					
					GUIManager.musicTable.setModel(new SongTableModel(GUIManager.mySongs));
					frame.setVisible(false);
			}
		});
		
		
	}
}
