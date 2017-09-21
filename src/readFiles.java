import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class readFiles {
	
	Map<String, Integer> frequency = new HashMap<>();
	Map<String, Integer> mentionsMap = new HashMap<>();
	Map<String, Integer> topicsMap = new HashMap<>();
	Map<String, Integer> identifiersMap = new HashMap<>();
	Map<String, Integer> referencesMap = new HashMap<>();
	
	ArrayList<String> mentions= new ArrayList();
	ArrayList<String> topics = new ArrayList();
	ArrayList<String> identifiers = new ArrayList();
	ArrayList<String> references = new ArrayList();
	
	String folderLocation = File.separator + "Users" + File.separator + "Brendan"
			+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + File.separator + "testFiles";
	
		File[] files = new File(folderLocation).listFiles();
		
	ArrayList<String> fileArray = new ArrayList<String>();
		
	public  ArrayList<String> makeArrayFiles() {
			for (File file : files) {
				fileArray.add(file.getPath());
			}
			return fileArray;
		}
	/*	
	public void  getfirstText() {
		File text1 = new File(fileArray.get(0));
		
	}
	
	public readFiles getSecondText() {
		readFiles text2 = new File(fileArray.get(1));
		return text2;
	}
	
	public readFiles getThirdText() {
		readFiles text3 = new File(fileArray.get(2));
		return text3;
	}
	*/
	public void parseWords() throws IOException {
	
		for(File file : files) {
			
			//find the file
			
			//use bufferedreader that will read file
				
			BufferedReader reader = new BufferedReader(new FileReader(file));
				
			String line = reader.readLine();

				while(line != null){
					
					if (!line.trim().equals("")) {
						//splitting words by spaces between them
						String[] words = line.split(" ");
					
						//iterating through each word in the array of words
						for (String word : words) {
							
							//in case the word is null or an empty space we just want to continue
							if (word == null || word.trim().equals("")) {
								continue;
							}
							
							//to ensure that capital letters don't impact the counting
							String processed = word.toLowerCase();
							
							char firstLetter = processed.charAt(0);
							
							//get the frequency of each word
							if (frequency.containsKey(processed)) {
								frequency.put(processed, frequency.get(processed) +1);
							}
							else {
								frequency.put(processed, 1);
							}
							
							//separating all the identifying words
							if (firstLetter == '@') {
								mentions.add(processed);
							}
							else if (firstLetter == '#') {
								topics.add(processed);
							}
							else if (firstLetter == '!') {
								identifiers.add(processed);
							}
							else if (firstLetter == '^') {
								references.add(processed);
							}
						}
					}
					line = reader.readLine();
				}
				//now iterate through the ArrayLists and add the word to the map and increment its value by one
				for (String a: mentions) {
					if (mentionsMap.containsKey(a)) {
						mentionsMap.put(a, mentionsMap.get(a) +1);
					}
					else {
						mentionsMap.put(a, 1);
					}
				}
				
				for (String b: topics) {
					if (topicsMap.containsKey(b)) {
						topicsMap.put(b, topicsMap.get(b) +1);
					}
					else {
						topicsMap.put(b, 1);
					}
				}
				for (String c: identifiers) {
					if (identifiersMap.containsKey(c)) {
						identifiersMap.put(c, identifiersMap.get(c) +1);
					}
					else {
						identifiersMap.put(c, 1);
					}
				}
				for (String d: topics) {
					if (referencesMap.containsKey(d)) {
						referencesMap.put(d, referencesMap.get(d) +1);
					}
					else {
						referencesMap.put(d, 1);
					}
				}
			}
		}
	
	public File[] getFiles() {
		return files;
	}
	
	public int getLength() {
		return files.length;
	}
	public void printLength() {
		System.out.println("There are " + files.length + " files in this folder.");
	}
	
	public void printFileNames() {
		//System.out.println("The file names are as follows: ");
		for (File file : files ) {
			System.out.print(file.getName() +"\n");
		}
	}
	
	public void printAllIdentifiers() {
		System.out.println("\nThere are four specific identifiers located in these files.");
		System.out.println("They are as follows: (@ : mentions; # : topics; ! : unique identifier; ^ : reference)\n");
	}
	
	public void printMentions() {
		//System.out.println("The number of mentions in this folder are: " );
		for(Entry<String, Integer> entry : mentionsMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printTopics() {
		//System.out.println("\nThe number of topics in this folder are: " );
		for(Entry<String, Integer> entry : topicsMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printIdentifiers() {
		//System.out.println("\nThe number of identifiers in this folder are: " );
		for(Entry<String, Integer> entry : identifiersMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printReferences() {
		//System.out.println("\nThe number of references in this folder are: " );
		for(Entry<String, Integer> entry : referencesMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printFrequency() {
		/*for (String word : frequency.keySet()) {
			System.out.println(frequency.get(word) + " : " + frequency.);
		}*/
		System.out.println(frequency);
	}
	
}
