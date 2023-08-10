package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기 {

	public static void main(String[] args) {
		int n = 5;
		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
	
		
		solution(n, words);
	}
	
	static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<String>();
        answer[0] = 2;
        
        String endWord = words[0].substring(words[0].length()-1,words[0].length());
        list.add(words[0]);
        int cycle = 1;

        for(int i=1; i<words.length; i++) {
        	String frontWord = words[i].substring(0,1);
        	if(!list.contains(words[i])&& endWord.equals(frontWord)) {
        		list.add(words[i]);
        		if(answer[0]>=n) {
        			answer[0]=1;
        			cycle++;
        		}
        		else {
        			answer[0]++;
        		}
        		endWord=words[i].substring(words[i].length()-1,words[i].length());
        	}else {
        		if(words.length==list.size()) {
        			answer[0] = 0;
        			answer[1] = 0;
        		}
        		else {
        			answer[1]=cycle;
        		}
        		break;
        	}
        }

        return answer;
    }
	

}
