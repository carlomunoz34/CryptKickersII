package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CryptKickersII {

	public static String[] words;
	public static int[][] dict;
	public static String compareWord = "the quick brown fox jumps over the lazy dog";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		words = new String[100];
		dict = new int[100][];
		int theGoodOne;
		int [] compareWordDict = preCompute(compareWord);
		int dictIndex = 0;
		
		int number = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int cases = Integer.parseInt(br.readLine());
		line = br.readLine();
		
		
		
		while((cases--) != 0) {
			number = 0;
			dictIndex = 0;
			while(!(line = br.readLine()).equals("")) {
				words[number] = line;
				if(line.length() == compareWord.length()) {
					dict[dictIndex] = preCompute(line);
					if(arrEquals(dict[dictIndex], compareWordDict)) {
						theGoodOne = number;
					}
					dictIndex++;
				}
				number++;
			}
			
		}

	}
	
	public static boolean arrEquals(int[] a, int[] b) {
		for(int i = 0; i < 80; i++) {
			if(a[i] != b[i]) return false;
		}
		
		return true;
	}
	
	public static int[] preCompute(String s) {
		int counter = 1;
		int[] charDict = new int[256];
		int[] keysDict = new int[80];
		
		for(int i = 0; i < s.length(); i ++) {
			if(charDict[s.charAt(i)] == 0) {
				charDict[s.charAt(i)] = counter;
				keysDict[i] = counter;
				counter ++;
			}
			else {
				keysDict[i] = charDict[s.charAt(i)];
			}
		}
		
		return keysDict;
	}
}
