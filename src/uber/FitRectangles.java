package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/949185/uber-codesignal-oa
 * https://leetcode.com/discuss/interview-question/1019465/Quora-or-New-Grad-or-OA-2021
 * https://leetcode.com/discuss/interview-question/891655/Postmates-or-OA-or-Rectangle-Boxes
 * 
 */

public class FitRectangles {
	
	private static List<Boolean> isFitting(List<List<Integer>> list) {
		List<Integer[]> rect = new ArrayList<>();
		List<Integer[]> boxes = new ArrayList<>();
		for(List<Integer> oneOp : list) {
			if(oneOp.get(0) == 0) {
				int first = oneOp.get(1);
				int second = oneOp.get(2);
				if(first < second) {
					rect.add(new Integer[] {first, second});
				} else {
					rect.add(new Integer[] {second, first});
				}
			} else {
				int first = oneOp.get(1);
				int second = oneOp.get(2);
				if(first < second) {
					boxes.add(new Integer[] {first, second});
				} else {
					boxes.add(new Integer[] {second, first});
				}
			}
		}
		
		if(rect.size() == 0)
			return Arrays.asList(true);
		
		List<Boolean> result = new ArrayList<>();
		for(Integer[] box : boxes) {
			//for evry box (operation 1) check if every rectangle fits
			result.add(isFit(box, rect));
		}
		
		
		return result;
	}

	private static Boolean isFit(Integer[] box, List<Integer[]> rect) {
		for(Integer[] pair : rect) {
			if(!(pair[0] <= box[0] && pair[1] <= box[1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(0, 1, 3));
		list.add(Arrays.asList(0, 4, 2));
		list.add(Arrays.asList(1, 3, 4));
		list.add(Arrays.asList(1, 3, 2));
		
		System.out.println(isFitting(list));
		
		list = new ArrayList<>();
		list.add(Arrays.asList(1, 1, 1));
		System.out.println(isFitting(list));
	}

}
