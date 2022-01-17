package microsoft;

public class F3ProductSign {

	public static void main(String[] args) {
		System.out.println(sign(new int[] {-1,-2,-3,-4,3,2,1}));	//1
		System.out.println(sign(new int[] {1,5,0,2,-3}));	//0
		System.out.println(sign(new int[] {-1,1,-1,1,-1}));	//-1
	}
	
	private static int sign(int[] a) {
		int s = 1;
		
		for(int num : a) {
			if(num == 0)
				return 0;
			if(num < 0)
				s = -s; // s * -1 = -s
		}
		return s;	
	}

}
