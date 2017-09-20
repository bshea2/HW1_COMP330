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
	
	public void printMentions() {
		for(Entry<String, Integer> entry : mentionsMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printTopics() {
		for(Entry<String, Integer> entry : topicsMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printIdentifiers() {
		for(Entry<String, Integer> entry : identifiersMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printReferences() {
		for(Entry<String, Integer> entry : referencesMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void generalReport() {
		
		/*for(File file : files) {
			System.out.println("-----------------------------");
			System.out.println("File name: " + file.getName());
			System.out.println("The number of mentions in this file are as follows:");
			for(Entry<String, Integer> entry : mentionsMap.entrySet())
		    {   //print keys and values
		         System.out.println(entry.getKey() + " : " +entry.getValue());
		    }
			System.out.println(((Entry<String, Integer>) mentionsMap).getKey() );
			System.out.println("-----------------------------");
			System.out.println("The number of topics in this file are as follows:");
			for(Entry<String, Integer> entry : topicsMap.entrySet())
		    {   //print keys and values
		         System.out.println(entry.getKey() + " : " +entry.getValue());
		    }
			System.out.println("-----------------------------");
			System.out.println("The number of identifiers in this file are as follows:");
			for(Entry<String, Integer> entry : identifiersMap.entrySet())
		    {   //print keys and values
		         System.out.println(entry.getKey() + " : " +entry.getValue());
		    }
			System.out.println("-----------------------------");
			System.out.println("The number of references in this file are as follows:");
			for(Entry<String, Integer> entry : referencesMap.entrySet())
		    {   //print keys and values
		         System.out.println(entry.getKey() + " : " +entry.getValue());
		    }
			System.out.println("-----------------------------");
			*/
		System.out.println("-----------------------------");
		System.out.println("There are " + files.length + " files in this folder.\n");
		System.out.println("The file names are as follows: ");
		for (File file : files ) {
			System.out.print(file.getName() +"\n");
		}
		System.out.println("\nThere are four specific identifiers located in these files.");
		System.out.println("They are as follows: (@ : mentions; # : topics; ! : unique identifier; ^ : reference)\n");
		System.out.println("The number of mentions in this folder are: " );
		System.out.println(mentionsMap + "\n");
		System.out.println("The number of topics in this folder are: " );
		System.out.println(topicsMap + "\n");
		System.out.println("The number of identifiers in this folder are: " );
		System.out.println(identifiersMap + "\n");
		System.out.println("The number of references in this folder are: " );
		System.out.println(referencesMap + "\n");
	}
	
}
