package microsoft;

public class CompareVersions {
	
	private static int compare(String version1, String version2) {
	    int i1 = 0, i2 = 0;
	    int n1 = version1.length(), n2 = version2.length();

	    int[] pair1 = new int[2];
	    int[] pair2 = new int[2];
	    
	    while (i1 < n1 || i2 < n2) {
	      pair1 = getNextChunk(version1, n1, i1);
	      pair2 = getNextChunk(version2, n2, i2);
	      
	      if (pair1[0] != pair2[0]) {
	        return pair1[0] > pair2[0] ? 1 : -1;
	      }
	      
	      i1 = pair1[1];
	      i2 = pair2[1];
	    }
	    
	    return 0;
	  }

	private static int[] getNextChunk(String version, int n, int l) {
	    if (l >= n) {
	      return new int[] {0, l};
	    }
	    
	    int val;
	    int r = l;
	    while (r < n && version.charAt(r) != '.') {
	      ++r;
	    }
	    
	    if (r != n - 1) {
	      val = Integer.parseInt(version.substring(l, r));
	    } else {
	      val = Integer.parseInt(version.substring(l, n));
	    }
	    
	    l = r + 1;

	    return new int[] {val, l};
	}

	public static void main(String[] args) {
		System.out.println(compare("1.01", "1.001"));		//0
		System.out.println(compare("1.0", "1.0.0"));		//0
		System.out.println(compare("0.1", "1.1"));			//-1
		System.out.println(compare("1.0.1", "1"));			//1
		System.out.println(compare("7.5.2.4", "7.5.3"));	//-1
	}

}
