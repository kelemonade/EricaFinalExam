package musicContainer;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTable.DropLocation;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


public class GUIManager extends javax.swing.JFrame {
	
	/*String songName;
	String lyrics;
	String lyricist;
	String composer;
	String rearranger;
	String featuring;
	String artistName;
	String AlbumName;
	String runningTimeInString;
	String genre;
	String imageName;
	String realeasedDate;
	String ILike;
	int runningTimeInInt;
	int like;
	SongModel temp;
		*/
	
	private javax.swing.JButton addButton;
	private javax.swing.JButton loadButton;
	private javax.swing.JButton saveButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton modifyButton;
	private javax.swing.JButton toDetailsButton;
	static javax.swing.JScrollPane scrollpane;
	static javax.swing.JTable musicTable;
	private javax.swing.JPanel buttonPanel;
	
	static ArrayList<SongModel> mySongs = new ArrayList<SongModel>();
	ArrayList<SongModel> finder = new ArrayList<SongModel>();
	static ArrayList<ArtistInfoModel> ArtistMore = new ArrayList<ArtistInfoModel>();
	
	public GUIManager() {
		initTableComponents();
		ToolBar();
	}
	
	
	
	
	private void initTableComponents() {
			 
		scrollpane = new javax.swing.JScrollPane();
		musicTable = new javax.swing.JTable();
		loadButton = new javax.swing.JButton();
		deleteButton  = new javax.swing.JButton();
		buttonPanel = new javax.swing.JPanel();
		addButton = new javax.swing.JButton();
		modifyButton = new javax.swing.JButton();
		saveButton  = new javax.swing.JButton();
		toDetailsButton = new javax.swing.JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        
			
		setTitle("노래 관리 프로그램");
		setFont(new Font("Arial", Font.ITALIC, 14));
		setSize(getPreferredSize());
			
		scrollpane.setViewportView(musicTable);
		musicTable.setModel(new SongTableModel(mySongs));
		
		addButton.setText("추가");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed(evt);
			}
		});
		
		modifyButton.setText("수정");
		modifyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				modifyButtonActionPerformed(evt);
			}
		});
		
		saveButton.setText("저장");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});
			
		getContentPane().add(scrollpane, java.awt.BorderLayout.CENTER);
			
		loadButton.setText("로드");
		loadButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadButtonActionPerformed(evt);
			}
		});
			
		deleteButton.setText("삭제");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("delete!!!!!!!!!!!!!");
				int index = musicTable.getSelectedRow();
				
				
				deleteButtonActionPerformed(evt,index);
			}
		});
		
		toDetailsButton.setText("상세정보");
		toDetailsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int index = musicTable.getSelectedRow();
				toDetailsButtonActionPerformed(evt,index);
			}

			private void toDetailsButtonActionPerformed(ActionEvent evt, int index) {
				GUISong info = new GUISong();
				
			}
		});

		buttonPanel.add(addButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(modifyButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(toDetailsButton);
		
		getContentPane().add(buttonPanel, java.awt.BorderLayout.PAGE_END);
			
		getContentPane().repaint();
			
		pack();
			
		
			
}
	
	
	
	public void ToolBar() {
		JToolBar bar = new JToolBar("찾기 툴바");
		bar.setBackground(Color.LIGHT_GRAY);
		//bar.add(new JButton("New"));
		//bar.add(new JButton(new ImageIcon("images/open.jpg")));
		//bar.addSeparator();
		
		JButton findButton = new JButton(new ImageIcon("find.png"));
		bar.add(findButton);
		Dimension dim = new Dimension(20,20);
		findButton.setSize(dim);
		
		bar.add(new JLabel("찾기"));
		JTextField textField =new JTextField("여기에 입력하세요.");
		bar.add(textField);
		JComboBox combo = new JComboBox();
		combo.addItem("곡명");
		combo.addItem("아티스트");
		combo.addItem("좋아요 수");
		combo.addItem("발매 년도");
		combo.addItem("장르");
		combo.addItem("작곡");
		combo.addItem("작사");
		combo.addItem("피쳐링");
		combo.addItem("편곡");
		combo.addItem("등록 년도");
		combo.addItem("나의 좋아요");
		bar.add(combo);
		add(bar, BorderLayout.NORTH);
		
		bar.setSize(800, 20);
	
		
	
	findButton.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			String findInserted =textField.getText();
			finder.clear();
			System.out.println(findInserted);
			System.out.println("index:"+combo.getSelectedIndex());
			/*
					switch (combo.getSelectedIndex()) {
					case 0:
						findSongName(findInserted);
					case 1:
						findByArtist(findInserted);
					case 2:
						findByLike(findInserted);
					case 3:
						findByRealeasedDate(findInserted);
					case 4:
						findByGenre(findInserted);
					case 5:
						findByComposer(findInserted);
					case 6:
						findByLyricist(findInserted);
					case 7:
						findByFeaturing(findInserted);
					case 8:
						findByRearranger(findInserted);
					case 9:
						findByDate(findInserted);
					case 10:
						findByILike(findInserted);
					}
				//switch문으로 해놓아서 추가할때에 if else문보다 조금 더 깔끔하게 생긴 코딩으로 
				//case와 메소드 이름만 집어 넣으면 됩니다.(확장성)
			*/
			
			if(combo.getSelectedIndex()==0){
				findSongName(findInserted);
			}else if(combo.getSelectedIndex()==1){
				findByArtist(findInserted);
			}else if(combo.getSelectedIndex()==2){
				findByLike(findInserted);
			}else if(combo.getSelectedIndex()==3){
				findByRealeasedDate(findInserted);
			}else if(combo.getSelectedIndex()==4){
				findByGenre(findInserted);
			}else if(combo.getSelectedIndex()==5){
				findByComposer(findInserted);
			}else if(combo.getSelectedIndex()==6){
				findByLyricist(findInserted);
			}else if(combo.getSelectedIndex()==7){
				findByFeaturing(findInserted);
			}else if(combo.getSelectedIndex()==8){
				findByRearranger(findInserted);
			}else if(combo.getSelectedIndex()==9){
				findByDate(findInserted);
			}else if(combo.getSelectedIndex()==10){
				findByILike(findInserted);
			}else{

			}
			
			
			
			}
		});
	}
		
	
	
	public void findSongName(String findInserted){
		
		for(int i=0; i<mySongs.size(); i++){
			if(findInserted.equals(mySongs.get(i).songName)){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
		
		
		//6/20 토 318호에서 시험
	}
	
	
	public void findByArtist(String findInserted){
		for(int i=0; i<mySongs.size(); i++){
			if(findInserted.equals(mySongs.get(i).artistName)){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
		
		
	}
	
	
	public void findByComposer(String findInserted){
		for(int i=0; i<mySongs.size(); i++){
			if(findInserted.equals(mySongs.get(i).composer)){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
		
	}
	
	
	
	public void findBySongName(String findInserted){
		for(int i=0; i<mySongs.size(); i++){
			if(findInserted.equals(mySongs.get(i).songName)){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
		
	}
	
	
	
	public void findByLyricist(String findInserted){
		for(int i=0; i<mySongs.size(); i++){
			if(findInserted.equals(mySongs.get(i).lyricist)){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
		
	}
	
	
	
	public void findByRearranger(String findInserted){
		for(int i=0; i<mySongs.size(); i++){
			if(findInserted.equals(mySongs.get(i).rearranger)){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
		
	}
	
	
	
	public void findByFeaturing(String findInserted){
		for(int i=0; i<mySongs.size(); i++){
			if(findInserted.equals(mySongs.get(i).featuring)){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
		
	}
	
	
	
	public void findByGenre(String findInserted){
		for(int i=0; i<mySongs.size(); i++){
			if(findInserted.equals(mySongs.get(i).genre)){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
		
	}
	
	
	
	public void findByRealeasedDate(String findInserted){
		for(int i=0; i<mySongs.size(); i++){
			String find;
			find = mySongs.get(i).realeasedDate.substring(0,4);
			
			if(findInserted.equals(find)){
				finder.add(mySongs.get(i));
			}else{
				
			}
			
		}
		musicTable.setModel(new SongTableModel(finder));
		
	}
	
	
	
	public void findByDate(String findInserted){
		for(int i=0; i<mySongs.size(); i++){
			String find;
			find = mySongs.get(i).Date.substring(0,4);
			
			if(findInserted.equals(find)){
				finder.add(mySongs.get(i));
			}else{
				
			}
			
		}
		musicTable.setModel(new SongTableModel(finder));
		
	}
	
	
	
	public void findByILike(String findInserted){
		long longnum =Long.valueOf(findInserted);
		for(int i=0; i<mySongs.size(); i++){
			long likenum = Long.valueOf(mySongs.get(i).ILike);
			if(likenum==longnum){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
		
	}
	
	
	
	public void findByLike(String findInserted){
		
		long longnum =Long.valueOf(findInserted);
		for(int i=0; i<mySongs.size(); i++){
			long likenum = Long.valueOf(mySongs.get(i).like);
			if(likenum>longnum){
				finder.add(mySongs.get(i));
			}else{
				
			}
		}
		musicTable.setModel(new SongTableModel(finder));
	
	}
	
	
	
	public SongModel getValue(int rowIndex) {
		return GUIManager.mySongs.get(rowIndex);
    }
		
	private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt,int index){
		
		int ind = musicTable.getSelectedRow();
		GUIManager.mySongs.remove(ind);
		musicTable.setModel(new SongTableModel(mySongs));
	
	}
	
	private void saveButtonActionPerformed(ActionEvent evt) {
		
		SongIO io = new SongIO();
		io.writeObjectAtDat();
		
	}
	
	private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {
		GUIModify modifier = new GUIModify();
		modifier.ModifyInterFaceRun();
	}

	private void addButtonActionPerformed(java.awt.event.ActionEvent evt){
			
		GUIAdd adder = new GUIAdd();
		adder.AddInterFaceRun();
		GUIManager.musicTable.setModel(new SongTableModel(GUIManager.mySongs));
		}
		
	private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_okButtonActionPerformed
		SwingWorker worker = new SwingWorker() {
		
			@Override
			protected Object doInBackground() throws Exception {
				
				System.out.println("inside loadbutton evt");
				
				mySongs.clear();
				FileInputStream fin = null;
		        ObjectInputStream ois = null;
				
				
				try {
					
					System.out.println("inside try evt");
					fin = new FileInputStream("songDataDAT.dat");
					ois = new ObjectInputStream(fin);
					ArrayList list = (ArrayList) ois.readObject();
					
					for (int i = 0; i < list.size(); i++){
						
						
						mySongs.add((SongModel) list.get(i));
						mySongs.get(0).WriteWithoutLyrics();
						System.out.println("Added"+i+"th data");
						}
					
				
					
					musicTable.setModel(new SongTableModel(mySongs));
					
					
					
					musicTable.setRowSelectionAllowed(true);
					    
					    
				} catch (Exception e) {
					System.out.println("error in 濡���");
				} finally {
					try {
						ois.close();
						fin.close();
					} catch (IOException ioe) {
					}
				}
				
					
				return null;
			}
		};
		worker.execute();
	}

	
	public static void main(String args[]) {
		
			SongIO io = new SongIO();
			io.takeShortTxtAndStoreAtTempDB();
			io.writeObjectAtDat();
			io.takeShortTxtAndStoreAtTempDBINF();
			mySongs.clear();
			new GUIManager().setVisible(true);
			
		
		//GUILyrics lyrics = new GUILyrics();
		
			
			
			
		}


	}


		

	

	
	

