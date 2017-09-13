import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class noteReader {
	
	public static void main(String args[]) {
		
		String fileLocation =  File.separator + "Users" + File.separator + "Brendan" + File.separator + 
				"eclipse-workspace" + File.separator + "NotesHW1" + File.separator + "test.txt";
		
		//find the file
		File noteFile = new File(fileLocation);
		
		try {
			//use scanner that will read file
			Scanner noteScanner = new Scanner(noteFile);
			
			String nextLine = noteScanner.nextLine();
			
			System.out.println("Next line: " + nextLine);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}