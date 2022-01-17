package microsoft.OA;

public class LongestNotMoreThan2ab {
	
	public static String longest(String str) {
		int i = 0;
		int j = 1;
		
		int count = 1;
		int maxSize = 0;
		int strI = 0;
		
		while (j < str.length()) {
			if (str.charAt(j) == str.charAt(j - 1))
                count++;
            else
                count = 1;
            
			if (count <= 2) {
				if(j-i+1 > maxSize) {
					maxSize = j - i + 1;
					strI = i;
				}
				j++;
			}
			else{
				i = j - 1;
				count = 2;
				j++;
			}
		}
		
		return str.substring(strI, maxSize);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longest("aabbaaaaabb"));
	}

}
