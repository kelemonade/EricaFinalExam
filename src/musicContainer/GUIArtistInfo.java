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

public class GUIArtistInfo extends JFrame {
	
	public GUIArtistInfo(){
		SongIO io = new SongIO();
		
		ArrayList<String> ArtistInfoTemp = new ArrayList<String>();
		ArtistInfoTemp.clear();
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		ArrayList<JLabel> labelTemp = new ArrayList<JLabel>();
		
		
		
		int k = GUIManager.musicTable.getSelectedRow();
		for(int j=0; j<GUIManager.ArtistMore.size(); j++){
			if(GUIManager.ArtistMore.get(j).ArtistName.equals(GUIManager.mySongs.get(k).artistName)){
				ArtistInfoTemp.add(GUIManager.ArtistMore.get(j).ArtistName);
				ArtistInfoTemp.add(GUIManager.ArtistMore.get(j).debutSongName);
				ArtistInfoTemp.add(GUIManager.ArtistMore.get(j).debutDate);
				ArtistInfoTemp.add(GUIManager.ArtistMore.get(j).Company);
				for(int l=0; l<4; l++){
						
						labelTemp.add(new JLabel(ArtistInfoTemp.get(l)));
						panel.add(labelTemp.get(l));
				}
			
		}
		}
		
		frame.setLayout(new GridLayout(0,1));
		frame.add(panel);
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}



	
}
