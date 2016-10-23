package  com.jainilsutaria.ai;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Set;

public class PerLetter {
	public static void main(String args[]) throws InterruptedException {
		String currentResult = " r";
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		String entry = " this will eventually turn into an automated program in which random words are made from when we get a lot of paragraphs and things that people said from the internet this will turn into an automated bot that checks the fitness of different strings and compares them to others hi my name is jainil sutaria and i am a cool kid i love to eat lots of food and i hate people and i love bob and this is just a really long string";
		while(true) {
			for(int x = 0; x < entry.length(); x++) {
				try {
					String n = entry.substring(x, x + currentResult.length());
					if(n.equalsIgnoreCase(currentResult)) {
						String nextChar = entry.substring(x+currentResult.length(),x+currentResult.length()+1);
						if(lhm.containsKey(nextChar)) {
							lhm.put(nextChar, lhm.get(nextChar) + 1);
						} else {
							lhm.put(nextChar, 1);
						}
					}
					
				} catch (Exception e) {
					
				}
				
			}
			
			currentResult += getHighest(lhm);
			lhm.clear();
			if(currentResult.length() > 100) break;
			l(currentResult);
			Thread.sleep(500);
		}
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