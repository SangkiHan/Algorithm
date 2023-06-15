package Algorithm.Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = 	{"123","456","789"};
		solution(phone_book);
	}
	
	static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> hashSet = new HashSet<String>(Arrays.asList(phone_book));
        
        for(int i=0; i<phone_book.length; i++) {
        	for(int j=1; j<phone_book[i].length(); j++) {
        		if(hashSet.contains(phone_book[i].substring(0,j))) {
            		answer = false; 
            		break;
            	}
        	}
        }
        
        return answer;
    }
}
