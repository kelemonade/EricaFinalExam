package musicContainer;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SongIO {
	
	
	
	public void takeShortTxtAndStoreAtTempDB() {	
		
		
		String line = null;

		try {
			File file = new File("songDataTXT.txt");
			int k=1;
			BufferedReader bufferedReader  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
			while ((line = bufferedReader.readLine()) != null) {
				String[] spliter = line.split(",");
				
				System.out.println("txt splitter");
				
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
				
				songName = spliter[0];
				lyricist = spliter[1];
				composer = spliter[2];
				rearranger = spliter[3];
				featuring = spliter[4];
				artistName = spliter[5];
				AlbumName = spliter[6];
				imageName = spliter[7];
				genre = spliter[8];
				realeasedDate = spliter[9];
				Date = spliter[10];
				runningTimeInString = spliter[11];
				ILike = spliter[12];
				like = Long.parseLong(spliter[13]);
				
				System.out.println(k);

				GUIManager.mySongs.add(new SongModel(songName,lyricist,composer,rearranger,featuring,artistName, AlbumName, imageName, genre, realeasedDate, Date, runningTimeInString, ILike, like));
				k+=1;
			}
			
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file");
		} catch (IOException ex) {
			System.out.println("Error reading file");
			// Or we could just do this:
			// ex.printStackTrace();
		}

	}
	
	
public void takeShortTxtAndStoreAtTempDBINF() {	
		
		
		String line = null;

		try {
			File file = new File("artistDataTXT.txt");
			int k=1;
			BufferedReader bufferedReader  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
			while ((line = bufferedReader.readLine()) != null) {
				String[] spliter = line.split(",");
				
				System.out.println("txt splitter");
				
				String debutDate;
				String genre;
				String Company;
				String debutSongName;
				String ArtistName;
				
				ArtistName = spliter[0];
				genre = spliter[1];
				Company = spliter[2];
				debutSongName = spliter[3];
				debutDate = spliter[4];
				System.out.println("ArtistMore 더해짐"+k);
				GUIManager.ArtistMore.add(new ArtistInfoModel(debutDate,genre,Company,debutSongName,ArtistName));
				k+=1;
			}
			
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file");
		} catch (IOException ex) {
			System.out.println("Error reading file");
			// Or we could just do this:
			// ex.printStackTrace();
		}

	}
	
	
	public ArrayList<String> takeLongTxtAndStoreAtTempDB(String songName){
		
		String line = null;
		
		
		try {
			String songNameSecond = songName.concat(".txt");
			File file = new File(songNameSecond);
			
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), "euc-kr"));
			
			int i=0;
			ArrayList<String> lines = new ArrayList<String>();
			
			while ((line = bufferedReader.readLine()) != null) {	
				lines.add(line);
				i+=1;
			}
			
			return lines;
			

			// Always close files.
			//bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file");
		} catch (IOException ex) {
			System.out.println("Error reading file");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		return null;
		
		
	}
	


public void writeObjectAtDat() {
	FileOutputStream fout = null;
	ObjectOutputStream oos = null;

	
	try {

		fout = new FileOutputStream("songDataDAT.dat");
		oos = new ObjectOutputStream(fout);

		oos.writeObject(GUIManager.mySongs);
		
	}catch(Exception e){
		
	}finally{
        try{
            oos.close();
            fout.close();
        }catch(IOException ioe){}
    }
}

public String returnSongImageFileName(int index){
	
	String filename=GUIManager.mySongs.get(index).AlbumName;
	
	return filename;

}

public Image receiveNameAndReturnPicture(String name){
	String nameSecond =name.concat(".jpg");
	System.out.println("jpg추가된 이름 : "+ nameSecond);
	ImageIcon icon = new ImageIcon(nameSecond);
	Image img = icon.getImage(); 
	return img;
	
}


public String returnSongNameFileName(int index) {
	
	String filename=GUIManager.mySongs.get(index).songName;
	
	return filename;
}


}


/*
	public void readTempToConsole() {

		for (int i = 0; i < BookManager.bookList.size(); i++) {
			System.out.println(BookManager.bookList.get(i).write());
		}
	}

	public void tempToTxt() {

		PrintWriter writer;

		try {

			writer = new PrintWriter("bookdata.txt", "UTF-8");

			for (int i = 0; i < BookManager.bookList.size(); i++) {
				Book a = new Book();
				a = BookManager.bookList.get(i);
				writer.println(a.write());
			}

		} catch (Exception ex) {
		} finally {
			try {

			} catch (Exception ioe) {
			}
		}

		for (int i = 0; i < BookManager.bookList.size(); i++) {

		}
	}

	
/*
	public void sendObjectToTempDB() {

		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("booklist.dat"));

			ArrayList list = (ArrayList) ois.readObject();

			for (int i = 0; i < list.size(); i++) {

				BookManager.bookList.add((Book) list.get(i));
			}

		} catch (Exception ex) {
		}

	}

	public void readObjectToConsole() {

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("booklist.dat"));

			ArrayList list = (ArrayList) ois.readObject();

			for (int i = 0; i < list.size(); i++) {

				System.out.println(((Book) list.get(i)).write());
			}

		} catch (Exception ex) {
		}
	}

	public void ModelToTxt() {

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			/*fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin);
			
			File file = new File("booklist2.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			
			ArrayList list = (ArrayList) ois.readObject();
			list = (ArrayList)ois.readObject();
			*/
	
	/*
			File file = new File("bookdata.txt");
			FileWriter fw = new FileWriter(file);
			
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < BookManager.bookList.size(); i++) {
				Book temp = BookManager.bookList.get(i);
				System.out.println("�ㅼ�닿�");
				bw.write(temp.write());
				bw.newLine();
			}
			bw.close();
			ois.reset();

		} catch (Exception ex) {
		} /*finally {
			try {
				//ois.close();
				//fin.close();
			} catch (IOException ioe) {
			}
		}*/
	/*
	}

} // class end
}
*/
