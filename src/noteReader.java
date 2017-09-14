import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class noteReader {
	
	public static void main(String args[]) throws Exception{
		
		String fileLocation =  File.separator + "Users" + File.separator + "Brendan" + File.separator + 
				"eclipse-workspace" + File.separator + "NotesHW1" + File.separator + "test.txt";
		
		//find the file
		File noteFile = new File(fileLocation);
		
		//use bufferedreader that will read file
			
		BufferedReader reader = new BufferedReader(new FileReader(noteFile));
			
		String line = reader.readLine();
			
		Map<String, Integer> frequency = new HashMap<>();
			
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
						
						//if we already have placed this word in the map, we increment its value by 1
						if (frequency.containsKey(processed)) {
							frequency.put(processed, frequency.get(processed) +1);
						}
						
						//we add this new word to the map and make its incremental value = 1
						else {
							frequency.put(processed, 1);
						}
						
					}
				}
				line = reader.readLine();
			}
			
		System.out.println(frequency);
		
	}
}