import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;

public class Reports {
	
	//Reports report = new Reports();
	readFiles newFiles = new readFiles();
	//readFiles text1 = new readFiles().getfirstText();
	File[] files = newFiles.getFiles();	
	ArrayList<String> fileArray = new ArrayList<String>();
	
	
	
public  ArrayList<String> makeArrayFiles() {
		for (File file : files) {
			fileArray.add(file.getPath());
		}
		
		return fileArray;
	}
	
public void generalReport() throws IOException {
	
	newFiles.parseWords();
	
		System.out.println("-----------------------------");
		newFiles.printLength();
		System.out.println("The file names are as follows: \n");
		newFiles.printFileNames();
		newFiles.printAllIdentifiers();
		System.out.println("The number of mentions in this folder are: " );
		newFiles.printMentions();
		System.out.println("\nThe number of topics in this folder are: " );
		newFiles.printTopics();
		System.out.println("\nThe number of identifiers in this folder are: " );
		newFiles.printIdentifiers();
		System.out.println("\nThe number of references in this folder are: " );
		newFiles.printReferences();
		System.out.println("-----------------------------");
	}
	public void individualReport1()  {
		newFiles.changeFilePath1();
		
		
		}
	
	}


