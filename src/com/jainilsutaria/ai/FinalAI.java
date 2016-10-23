package  com.jainilsutaria.ai;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class FinalAI {
	private static boolean DEBUG = true;

	static String[] entries;
	public static void main(String args[]) throws InterruptedException, IOException {
		System.out.println(createSentence("The"));
	}
	
	public static String createSentence(String beginning) throws InterruptedException, IOException {
		//System.out.println(cd(10));
		String returning = "";
		String entry = FinalAI.readFile("txt.txt", Charset.defaultCharset());
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		entries = entry.split(" ");
		if(beginning == null) beginning = entries[0];
		String currentResult = beginning;
		returning += currentResult;
		while(true) {
			for(int x = 0; x < entries.length; x++) {
				try {
					String n = entries[x];
					if(n.equalsIgnoreCase(currentResult)) {
						String nextWord = entries[x + 1];
						if(lhm.containsKey(nextWord)) {
							lhm.put(nextWord, lhm.get(nextWord) + 1);
						} else {
							lhm.put(nextWord, 1);
						}
					}
					
				} catch (Exception e) {
					
				}
				
			}
			
			currentResult = getRandom(lhm);
			//if(returning.length() + currentResult.length() + 1 > 250) break;
			if(returning.contains(".")) break;
			returning += " ";
			returning += currentResult;
			lhm.clear();
		}
		return returning;
	}
	
	
	private static String getRandom(LinkedHashMap<String, Integer> lhm) {
		List<String> ordered = new ArrayList<String>();
		int x = 1;
		while(!lhm.isEmpty()) {
			try {
			for(String key : lhm.keySet()) {
				if(lhm.get(key) == x) {
					debug(key + " " + lhm.get(key) + "; ");
					ordered.add(key);
					lhm.remove(key);
				}
			}
			x++;
			} catch(Exception e) {}
		}
		debug("\n");
		Random rand = new Random();
		try {
		int i = rand.nextInt(cd(ordered.size())) + 1;
		for(int n = 0; n < ordered.size(); n++) {
			if(i >= cd(n) && i < cd(n + 1)) {
				return ordered.get(n);
			} else {
				continue;
			}
		}
		return ordered.get(ordered.size() - 1);
		}
		catch (Exception e) {
			return " ";
		}
	}
	
	public static int cd(int n) {
		int a = 0;
		while(n > 0) {
			a += n;
			n--;
		}
		return a;
	}

	public static void l(Object o) {
		System.out.println(o);
	}
	
	public static void l2(Object o) {
		System.out.print(o + " ");
	}
	
	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	private static void debug(String n) {
		if(DEBUG ) System.out.print(n);
	}
}