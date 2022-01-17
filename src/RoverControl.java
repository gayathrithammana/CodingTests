/**
 * https://leetcode.com/discuss/interview-question/985703/Amazon-or-OA-or-Rover-Control
 */
public class RoverControl {
	
	private static int getPosition(String[] commands, int n) {
		int x = 0;
		int y = 0;
		for(String command : commands) {
			int dx = 0;
			int dy = 0;
			if(command == "RIGHT")
				dy = 1;
			else if(command == "LEFT")
				dy = -1;
			else if(command == "DOWN")
				dx = 1;
			else if(command == "UP")
				dx = -1;
			
			if((x+dx) >= 0 && (x+dx) < n && (y+dy) >= 0 && (y+dy) < n) {
				x += dx;
				y += dy;
			}
		}
		
		return x*n + y;
	}

	public static void main(String[] args) {
		System.out.println(getPosition(new String[] {"RIGHT", "UP", "DOWN", "LEFT", "DOWN", "DOWN"}, 4));
	}

}
