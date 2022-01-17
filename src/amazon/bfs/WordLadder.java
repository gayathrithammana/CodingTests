package amazon.bfs;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/
 * https://www.youtube.com/watch?v=M9cVl4d0v04
 * 
 * BFS
 */
public class WordLadder {
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<String>();
        for(String s:wordList)
        	set.add(s);
        
        if(!set.contains(endWord))
        	return 0;
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int level = 1;
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for(int i=0;i<size;i++) {
        		System.out.println(queue.peek() + level);
        		char[] currentCharArray = queue.poll().toCharArray();
        		
        		//replace each character in word with a to z
        		//to generate new words
        		for(int j=0;j<currentCharArray.length;j++) {
        			char originalChar = currentCharArray[j];
        			for(char k='a';k<'z';k++) {
        				if(k == originalChar)
        					continue;
        				else {						//generate new word
        					currentCharArray[j] = k;
        					String newWord = String.valueOf(currentCharArray);
        					
        					if(newWord.equals(endWord)) 
        						return level + 1;
        					if(set.contains(newWord)) {
        						set.remove(newWord);
        						queue.offer(newWord);
        					}
        				}
        			}
        			currentCharArray[j] = originalChar;
        		}
        	}
        	level++;
        }
        
        return 0;
    }

	public static void main(String[] args) {
		System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
	}

}
