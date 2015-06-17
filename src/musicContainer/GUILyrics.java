package musicContainer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GUILyrics extends JFrame {
	
	public GUILyrics(){
		SongIO io = new SongIO();
		ArrayList<String> lyricsTemp=io.takeLongTxtAndStoreAtTempDB(io.returnSongNameFileName(GUIManager.musicTable.getSelectedRow()));
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(1,lyricsTemp.size()));
		JPanel panel = new JPanel();
		ArrayList<JLabel> labelTemp = new ArrayList<JLabel>();
		for(int i=0; i<lyricsTemp.size(); i++){
		labelTemp.add(new JLabel(lyricsTemp.get(i)));
		panel.add(labelTemp.get(i));
		}
		//jlabel.setFont(new Font("Verdana",1,20));
		
		//panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
		frame.add(panel);
		//frame.add(panel, BoxLayout.Y_AXIS);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//닫기 누르면 setVisible false되게
		
		
	}



	
}


