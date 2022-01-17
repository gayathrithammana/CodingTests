import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	
	private static List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0)
			return Collections.emptyList();
		
		Map<Integer, List<Character>> map = new HashMap<>();
		map.put(2, Arrays.asList('a', 'b', 'c'));
		map.put(3, Arrays.asList('d','e','f'));
		map.put(4, Arrays.asList('g','h','i'));
		map.put(5, Arrays.asList('j','k','l'));
		map.put(6, Arrays.asList('m','n','o'));
		map.put(7, Arrays.asList('p','q','r','s'));
		map.put(8, Arrays.asList('t','u','v'));
		map.put(9, Arrays.asList('w','x','y','z'));
		
		List<String> result = new ArrayList<>();
		solve(digits, 0, "", map, result);
		return result;
	}

	private static void solve(String digits, int index, String temp, Map<Integer, List<Character>> map,
			List<String> result) {
		if(index == digits.length())
			result.add(temp);
		else {
			Integer digit = Character.getNumericValue(digits.charAt(index));
			List<Character> charsList = map.get(digit);
			for(char c : charsList) 
				solve(digits, index+1, temp + c, map, result);
		}
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

}
