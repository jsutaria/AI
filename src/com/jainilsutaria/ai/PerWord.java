package  com.jainilsutaria.ai;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Set;

public class PerWord {
	public static void main(String args[]) throws InterruptedException {
		String returning = "";
		String currentResult = "Rich,";
		returning += currentResult;
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
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
		String[] entries = entry.split(" ");
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
			
			currentResult = getHighest(lhm);
			returning += " ";
			returning += currentResult;
			lhm.clear();
			if(returning.length() > 400) break;
			l(currentResult);
			Thread.sleep(200);
		}
		l(returning);
	}
	
	private static String getHighest(LinkedHashMap<String, Integer> lhm) {
		int top = 0;
		Set<String> topA = new HashSet<String>();
		String topk = "";
		for(String key : lhm.keySet()) {
			if(lhm.get(key) == top) {
				topA.add(key);
			}
			if(lhm.get(key) > top) {
				topA.clear();
				topA.add(key);
				top = lhm.get(key);
			}
		}
		Random rand = new Random();
		topk = (String) topA.toArray()[rand.nextInt(topA.size())];
		return topk;
	}
	
	

	public static void l(Object o) {
		System.out.println(o);
	}
	
	public static void l2(Object o) {
		System.out.print(o + " ");
	}
	
}