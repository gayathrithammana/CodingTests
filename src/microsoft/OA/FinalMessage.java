package microsoft.OA;

/**
 * There are N people, numbered from 0 to N-1, playing a game. The K-th person is assigned the letter S[K].
At the beginning the oth person sends a message, consisting of a single letter S[0], to the A[O]-th person.
When the K-th person receives the message, they append their letter S[K] to the message and forward it to A[K].
The game ends when the 0th person receives the message. Find the final message.
You can assume that A contains every integer from 0 to N-1 exactly once.
Write a function: def solution(S, A) that given a string S and an array of
integers A, both of length N, returns a string denoting the final message received by the 0th person.
Examples:

Given S = "cdeo" and A = [3, 2, 0, 1), your function should returns "code".
At the beginning, the 0th person sends a message 'c" to the 3rd person.
Next, the 3rd person forwards the message 'co" to the 1st person.
After that the 1st person forwards the message "cod" to the 2nd person.
After appending the letter 'e' to it, the 2nd person forward it to the 0th person. The final message, received by 0th person, is "code".
Given S = "cdeenetpi" and A = [5, 2,0, 1, 6, 4,8,3,7), your function should returns "centipede".
Given S = "bytdag" and A = [4, 3, 0, 1, 2, 5), your function should returns "bat". Notice, that not all letters from S have to be used.
 *
 */

public class FinalMessage {
	private static String getMessage(String s, int[] a)
	{
		char[] chars = s.toCharArray();
		// Initial message
		String finalMessage = String.valueOf(chars[0]);
		int destination = a[0];
		while (destination != 0)
		{
		finalMessage += chars[destination];
		destination = a[destination];
		}
		return finalMessage;
	}
	
	public static void main(String[] args) {
		System.out.println(getMessage("cdeenetpi", new int[]{5, 2, 0, 1, 6, 4, 8, 3, 7}));	//centipede
		System.out.println(getMessage("bytdag", new int[]{4, 3, 0, 1, 2, 5}));	//bat

	}

}
