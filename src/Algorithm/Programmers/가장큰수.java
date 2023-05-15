package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 가장큰수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String solution(int[] numbers) {
        String answer = "";
        String[] answerList = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
        	answerList[i] = String.valueOf(numbers[i]);
        }
        
        List<Integer> asd = new ArrayList<>();
        
        Arrays.sort(answerList, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return (b+a).compareTo(a+b);
			}
		});
        
        return answer;
    }
}
