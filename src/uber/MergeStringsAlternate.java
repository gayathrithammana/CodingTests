package uber;

public class MergeStringsAlternate {
	public static String merge(String a, String b) {
		int l1 = a.length();
		int l2 = b.length();
		int minL = l1 != l2 ? Math.min(l1, l2) : l1;
		StringBuffer s = new StringBuffer();
		for(int i=0;i<minL;i++) {
			s.append(a.charAt(i));
			s.append(b.charAt(i));
		}
		
		if(l1 > l2)
			s.append(a.substring(minL));
		else if(l2 > l1)
			s.append(b.substring(minL));
		
		return s.toString();
	}
	public static void main(String[] args) {
		System.out.println(merge("abcd", "efghi"));
	}

}
