/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1a = preProcess(str1);
		String str2a = preProcess(str2);
		
		for (int i = 0; i < str1a.length(); i++){
			while (str2a.length() > 0){
				if (letterCount(str1a, str1a.charAt(i)) != letterCount(str2a, str1a.charAt(i))){
					return false;
				}
				str2a = str2a.substring(0, i) + str2a.substring(i + 1);
			}
		}
		return true;
	}

	public static int letterCount(String str, char character){
		int count = 0;
		char current = ' ';
		if (current == ' '){
			return 0;
		}
		for (int i = 0; i < str.length() - 1; i++){
			current = str.charAt(i);
			if (current == character){
				count ++;
			}
		}
		return count;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		String lower_case = "";
		for (int i = 0; i < str.length() - 1; i++)
		{
			char current = str.charAt(i);

			if (!(current >= 33 && current <= 64)){
				lower_case = lower_case + current;
			}
		}
		return lower_case;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String new_string = "";

		while (str.length() > 0){
			int max = str.length() - 1;
			int min = 0;
			int new_index = (int) (Math.random() * ((max-min) + 1)) + min;
			char new_char = str.charAt(new_index);
			new_string = new_string + new_char;
			str = str.substring(0, new_index) + str.substring(new_index + 1);
		}
		return new_string;
	}
}
