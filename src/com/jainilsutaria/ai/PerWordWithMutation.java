package  com.jainilsutaria.ai;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class PerWordWithMutation {
	private static boolean DEBUG = true;

	static String[] entries;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		//System.out.println(cd(10));
		String returning = "";
		String entry = "Rich, Powerful and Risky are a few words that best describe Donald Trump. "
				+ "Trump is a business icon that has made over two billion dollars in real estate."
				+ " His home is New York City were he owns many popular building such as Trump Towers and Trump Plaza."
				+ " With Trumps new TV show “The Apprentice” it has catapulted him too celebrity status."
				+ " Trump is viewed as hero to many young adults, who have big business expectations from themselves."
				+ " Trump is the ultimate entrepreneur. "
				+ "Pop culture is hip, groovy way of living, whether it is risk taking or standing up for"
				+ " your beliefs. Trump is an old man and has been through many generations. Trum"
				+ "p has stood strong for many years, because his way of living. Trump is a risk t"
				+ "aker and isn’t afraid to speak out. However Trump has had a downfall in the earl"
				+ "y 90’s, Trump was in debt for more than 1 billion dollars (Trump 18). Although h"
				+ "e was on the bottom, Trump was able to pull himself up like a “hero” and move "
				+ "on to make more than two billion in recent years. "
				+ "Hero is more than just a word it is a lifestyle. A lifestyle that gives to othe"
				+ "r people and out last time. Trump has the lifestyle that can be described as "
				+ "a hero. Trump makes a lot of money but he gives a lot away too. He gives more"
				+ " than just money to charities, he gives people opportunities to succeed. Trum"
				+ "p’s best known in New York for Remolding the City Ice Rink free of cost (Trum"
				+ "p 45). Trump brought many families together by allowing them to spend quality"
				+ " time with each other. Giving is what Trump does on many occasions and a hero"
				+ " gives. Trump will always have his place in history not for being just a bill"
				+ "ionaire but for being a giving billionaire. ";
		//String entry = Main3.readFile("txt.txt", Charset.defaultCharset());
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		entries = entry.split(" ");
		String currentResult = entries[13];
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
		System.out.println("\n" + "\n" + returning);
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