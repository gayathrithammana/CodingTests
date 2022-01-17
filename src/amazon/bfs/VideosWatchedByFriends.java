package amazon.bfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Leetcode 1311. Get Watched Videos by Your Friends
 * https://www.youtube.com/watch?v=u4LHrR6UD_Y
 * 
 * BFS
 */

public class VideosWatchedByFriends {
	public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		//Part 1: BFS to get friends of id at level k
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> seen = new HashSet<Integer>();
		seen.add(id);
		queue.add(id);
		
		while(level > 0) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				int current = queue.poll();
				
				//get adjacent/neighbor friends of current friend and process
				for(int neighbor : friends[current]) {
					if(!seen.contains(neighbor)) {
						seen.add(neighbor);
						queue.add(neighbor);
					}
				}
			}
			
			level--;
			
		}
		
		//means we are at level k
		//Part2: get the watched movies of level k friends and sort them
		Map<String, Integer> freqMap = new HashMap<String, Integer>();
		for(int friend : queue) {
			for(String oneVideo : watchedVideos.get(friend)) {
				freqMap.put(oneVideo, freqMap.getOrDefault(oneVideo, 0) + 1);
			}
		}
		
		List<String> result = new ArrayList<>(freqMap.keySet());
		
		result.sort((a, b) -> {
			int v1 = freqMap.get(a);
			int v2 = freqMap.get(b);
			
			if(v1 != v2)
				return v1 - v2;
			else
				return a.compareTo(b);
		});
		
		return result;
    }
	
	public static void main(String[] args) {
		List<List<String>> watchedVideos = new ArrayList<>();
		watchedVideos.add(Arrays.asList("A", "B"));
		watchedVideos.add(Arrays.asList("C"));
		watchedVideos.add(Arrays.asList("B", "C"));
		watchedVideos.add(Arrays.asList("D"));
		
		System.out.println(watchedVideosByFriends(watchedVideos, 
												  new int[][] {{1,2}, {0,3}, {0,3}, {1,2}}, 
												  0, 
												  1));			//[B, C]
		
		watchedVideos = new ArrayList<>();
		watchedVideos.add(Arrays.asList("A", "B"));
		watchedVideos.add(Arrays.asList("C"));
		watchedVideos.add(Arrays.asList("B", "C"));
		watchedVideos.add(Arrays.asList("D"));
		
		System.out.println(watchedVideosByFriends(watchedVideos, 
												  new int[][] {{1,2}, {0,3}, {0,3}, {1,2}}, 
												  0, 
												  2));			//[D]
	}
	
}

