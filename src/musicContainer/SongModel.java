package musicContainer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class SongModel implements Serializable {
	
	
	
	String songName;
	String lyricist;
	String composer;
	String rearranger;
	String featuring;
	String artistName;
	String AlbumName;
	String imageName;
	String genre;
	String realeasedDate;
	String Date;
	String runningTimeInString;
	String ILike;
	long like;
	
	public SongModel(String songName, String lyricist,String composer, String rearranger, String featuring,String artistName, String albumName, String imageName,String genre, String realeasedDate, String date,String runningTimeInString, String iLike, long like) {
		super();
		this.songName = songName;
		this.lyricist = lyricist;
		this.composer = composer;
		this.rearranger = rearranger;
		this.featuring = featuring;
		this.artistName = artistName;
		this.AlbumName = albumName;
		this.imageName = imageName;
		this.genre = genre;
		this.realeasedDate = realeasedDate;
		this.Date = date;
		this.runningTimeInString = runningTimeInString;
		this.ILike = iLike;
		this.like = like;
	}

	
	
	

	public SongModel(SongModel temp) {
		this.songName=temp.songName;
		this.lyricist=temp.lyricist;
		this.composer=temp.composer;
		this.rearranger=temp.rearranger;
		this.featuring=temp.featuring;
		this.artistName=temp.artistName;
		this.AlbumName=temp.AlbumName;
		this.imageName=temp.imageName;
		this.genre=temp.genre;
		this.realeasedDate=temp.realeasedDate;
		this.Date=temp.Date;
		this.runningTimeInString=temp.runningTimeInString;
		this.ILike=temp.ILike;
		this.like=temp.like;
	}


	
	
	public void WriteWithoutLyrics(){
		System.out.println(songName+"  "+"  "+lyricist +"  "+ composer+"  "+ rearranger+"  "+ featuring+"  "+artistName +"  "+ AlbumName+"  "+imageName +"  "+genre +"  "+realeasedDate +"  "+ Date+"  "+runningTimeInString +"  "+ILike+"  "+like);
	
	}
	
	public void WriteLyrics(String[] lyrics){
		for(int i=0; i<lyrics.length; i++){
		System.out.println(lyrics[i]+"\n");
		}
	}
	
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getRearranger() {
		return rearranger;
	}

	public void setRearranger(String rearranger) {
		this.rearranger = rearranger;
	}

	public String getFeaturing() {
		return featuring;
	}

	public void setFeaturing(String featuring) {
		this.featuring = featuring;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return AlbumName;
	}

	public void setAlbumName(String albumName) {
		AlbumName = albumName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRealeasedDate() {
		return realeasedDate;
	}

	public void setRealeasedDate(String realeasedDate) {
		this.realeasedDate = realeasedDate;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getRunningTimeInString() {
		return runningTimeInString;
	}

	public void setRunningTimeInString(String runningTimeInString) {
		this.runningTimeInString = runningTimeInString;
	}

	public String getILike() {
		return ILike;
	}

	public void setILike(String iLike) {
		ILike = iLike;
	}

	public long getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}


	
	
}
	


