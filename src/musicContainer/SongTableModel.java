package musicContainer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class SongTableModel extends AbstractTableModel{

	
	private final static String[] COLUMNS = { "곡명", "작사",
		"작곡", "편곡", "피쳐링", "아티스트", "앨범", "이미지", "장르", "발매일", "추가날짜", "러닝타임", "좋아요", "(멜론) 좋아요" };
	
	private ArrayList<SongModel> songs;

	public SongTableModel(ArrayList<SongModel> mySongs) {
		this.songs = mySongs;
	}

	@Override
	public int getRowCount() {
		return songs.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMNS.length;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMNS[column];
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		SongModel song = (SongModel) songs.get(rowIndex);
		/*
		switch (columnIndex) {
		case 0:
			return song.getSongName();
		case 1:
			return song.getLyricist();
		case 2:
			return song.getComposer();
		case 3:
			return song.getRearranger();
		case 4:
			return song.getFeaturing();
		case 5:
			return song.getArtistName();
		case 6:
			return song.getAlbumName();
		case 7:
			return song.getImageName();
		case 8:
			return song.getGenre();
		case 9:
			return song.getRealeasedDate();
		case 10:
			return song.getDate();
		case 11:
			return song.getRunningTimeInString();
		case 12:
			return song.getILike();
		case 13:
			return song.getLike();
		}
		*/
		if(columnIndex==0){
			return song.getSongName();
		}else if(columnIndex==1){
			return song.getLyricist();
		}else if(columnIndex==2){
			return song.getComposer();
		}else if(columnIndex==3){
			return song.getRearranger();
		}else if(columnIndex==4){
			return song.getFeaturing();
		}else if(columnIndex==5){
			return song.getArtistName();
		}else if(columnIndex==6){
			return song.getAlbumName();
		}else if(columnIndex==7){
			return song.getImageName();
		}else if(columnIndex==8){
			return song.getGenre();
		}else if(columnIndex==9){
			return song.getRealeasedDate();
		}else if(columnIndex==10){
			return song.getDate();
		}else if(columnIndex==11){
			return song.getRunningTimeInString();
		}else if(columnIndex==12){
			return song.getILike();
		}else if(columnIndex==13){
			return song.getLike();
		}else{
			return null;	
		}
		
		
		
	}

}
