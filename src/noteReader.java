import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class noteReader {
	
	public static void main(String args[]) throws Exception{
		
		/*String fileLocation =  File.separator + "Users" + File.separator + "Brendan" + File.separator + 
				"eclipse-workspace" + File.separator + "NotesHW1" + File.separator + "test.txt";*/
		
		String folderLocation = File.separator + "Users" + File.separator + "Brendan"
				+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + File.separator + "testFiles";
		
		File[] files = new File(folderLocation).listFiles();
		for(File file : files) {
		
		//find the file
		//File noteFile = new File(fileLocation);
		
		//use bufferedreader that will read file
			
		BufferedReader reader = new BufferedReader(new FileReader(file));
			
		String line = reader.readLine();
			
		Map<String, Integer> frequency = new HashMap<>();
		
		//Map<String, Integer> mentions = new HashMap<>();
		//Map<String, Integer> topics = new HashMap<>();
		
		ArrayList<String> mentions= new ArrayList();
		ArrayList<String> topics = new ArrayList();
			
			while(line != null){
				//test line to see if the reader is working
				//System.out.println("processed line" + line);
				
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
						
						if (firstLetter == '@') {
							mentions.add(processed);
						}
						else if (firstLetter == '#') {
							topics.add(processed);
						}
						
						
						//if we already have placed this word in the map, we increment its value by 1
						if (frequency.containsKey(processed)) {
							frequency.put(processed, frequency.get(processed) +1);
						}
						
						//we add this new word to the map and make its incremental value = 1
						else {
							frequency.put(processed, 1);
						}
						
						/*//if we already have placed this word in the map, we increment its value by 1
						if (mentions.containsKey(processed) && processed.charAt(0) == '@') {
							mentions.put(processed, mentions.get(processed) +1);
						}
						
						//we add this new word to the map and make its incremental value = 1
						else {
							mentions.put(processed, 1);
						}
						
						//if we already have placed this word in the map, we increment its value by 1
						if (topics.containsKey(processed) && processed.charAt(0) == '#') {
							topics.put(processed, topics.get(processed) +1);
						}
						
						//we add this new word to the map and make its incremental value = 1
						else {
							topics.put(processed, 1);
						}*/
						
					}
				}
				line = reader.readLine();
			}
			
		///System.out.println(frequency);
		System.out.println(file.getName());
		System.out.println(mentions);
		System.out.println(topics);
		
	}
}
}