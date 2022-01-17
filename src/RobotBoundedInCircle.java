//https://leetcode.com/problems/robot-bounded-in-circle/
//https://www.youtube.com/watch?v=3ZG3V_6BUGM
//check notes in ipad
public class RobotBoundedInCircle {
	
	public static boolean isBounded(String instructions) {
        int[][] points = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};	//N=0 E=1 S=2 W=3
        
        
        int x = 0;
        int y = 0;
        
        int dir = 0;
        
        for(int i=0;i<instructions.length();i++){
            char c = instructions.charAt(i);
            
            if(c == 'G'){
                x += points[dir][0];
                y += points[dir][1];
            } else if(c == 'R'){
            	/**
            	 * Suppose when you are at 
            	 * point 0 and turning right means you ll go to point 1
            	 * point 1 and turning right means you ll go to point 2
            	 * point 2 and turning right means you ll go to point 3
            	 * point 3 and turning right means you ll go to point 4
            	 * 
            	 * so dir = dir + 1
            	 * 
            	 * and % 4 because (3 -> 0)
            	 */
                dir = (dir + 1) % 4;
            } else{ //L
                dir = (dir - 1 + 4) % 4;
            }
            
        }
        
        return (x == 0 && y == 0) || (dir != 0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isBounded("GGLLGG"));	//true
		System.out.println(isBounded("GL"));		//true
		System.out.println(isBounded("GG"));		//false
	}

}
