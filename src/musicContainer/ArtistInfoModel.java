package musicContainer;

public class ArtistInfoModel {

	


	String debutDate;
	String genre;
	String Company;
	String debutSongName;
	String ArtistName;
	
	public ArtistInfoModel(String debutDate, String genre, String company,
			String debutSongName, String artistName) {
		super();
		this.debutDate = debutDate;
		this.genre = genre;
		Company = company;
		this.debutSongName = debutSongName;
		ArtistName = artistName;
	}

	
	public String getArtistName() {
		return ArtistName;
	}

	public void setArtistName(String artistName) {
		ArtistName = artistName;
	}

	public String getDebutDate() {
		return debutDate;
	}

	public void setDebutDate(String debutDate) {
		this.debutDate = debutDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getDebutSongName() {
		return debutSongName;
	}

	public void setDebutSongName(String debutSongName) {
		this.debutSongName = debutSongName;
	}

	
	public void write() {
		System.out.println(ArtistName+","+debutDate+","+genre+","+Company+","+debutSongName);
	}

	
	
	
	
}
