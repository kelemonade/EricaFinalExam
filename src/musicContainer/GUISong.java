package musicContainer;

	import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
	


	public class GUISong extends JFrame {
		private javax.swing.JButton artistInfoButton;
		private javax.swing.JButton lyricsInfoButton;
		private javax.swing.JPanel buttonPanel;
		
		Container contentPane;
		
		
		GUISong() {
			SongIO io = new SongIO();
			int index= GUIManager.musicTable.getSelectedRow();
			String songName=io.returnSongImageFileName(index);
			String songNameSecond = songName.concat(".jpg");
			JFrame frame = new JFrame();
			setTitle("곡 상세정보");
			contentPane = getContentPane();
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			ArrayList<JLabel> labelTemp = new ArrayList<JLabel>();
			frame.setLayout(new GridLayout(3,1));
			labelTemp.add(new JLabel(GUIManager.mySongs.get(GUIManager.musicTable.getSelectedRow()).songName));
			labelTemp.add(new JLabel(GUIManager.mySongs.get(GUIManager.musicTable.getSelectedRow()).artistName));
			labelTemp.add(new JLabel(GUIManager.mySongs.get(GUIManager.musicTable.getSelectedRow()).Date));
			labelTemp.add(new JLabel(new ImageIcon(songNameSecond)));
			for(int i=0; i<4; i++){
				panel.add(labelTemp.get(i));
				}
			
			setSize(600, 350);
			//setSize(getPreferredSize());
			setVisible(true);
			
			artistInfoButton = new javax.swing.JButton();
			lyricsInfoButton= new javax.swing.JButton();
			buttonPanel = new javax.swing.JPanel();
			
			artistInfoButton.setText("아티스트 상세정보");
			
			
			
			System.out.println("imgName:"+songNameSecond);
			
			
			artistInfoButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					artistInfoButtonActionPerformed(evt);
				}

				private void artistInfoButtonActionPerformed(ActionEvent evt) {
					GUIArtistInfo inf = new GUIArtistInfo();
				}
			});
			
			
			lyricsInfoButton.setText("가사");
			
			lyricsInfoButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					lyricsInfoButtonActionPerformed(evt);
				}
				
				private void lyricsInfoButtonActionPerformed(ActionEvent evt) {
					GUILyrics lyrics = new GUILyrics();
					
					
				}
				
			});
			
			
		
		
			buttonPanel.add(artistInfoButton);
			buttonPanel.add(lyricsInfoButton);
			getContentPane().add(buttonPanel, java.awt.BorderLayout.PAGE_END);
		
		}	

		/*class MyPanel extends JPanel {
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setClip(0, 0, 700, 700); 
				
				int index= GUIManager.musicTable.getSelectedRow();
				
				SongIO io = new SongIO();
				String songName=io.returnSongImageFileName(index);
				System.out.println("songName"+songName);
				Image img=io.receiveNameAndReturnPicture(songName);
				
				
				Graphics2D g2d = (Graphics2D) g;
		        FontMetrics fm = g2d.getFontMetrics();
		        Rectangle2D r = fm.getStringBounds(songName, g2d);
		        
				int x = (this.getWidth() - (int) r.getWidth() + songName.length()) / 2-20;
		        int y = (this.getHeight() - (int) r.getHeight()) / 10 + fm.getAscent();
		        
		        g.drawImage(img, this.getWidth()/50, 20, 110, 100, this);
		        
		        g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		        
		        g.drawString(songName, x, y);
		        
		       
				
				
			}	
			
		}
		
		public static void main(String [] args) {
			//new GUISong();
		}
	 */
}
