package Algorithm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class 연속된부분수열합의갯수 {

	public static void main(String[] args) {
		
		int[] elements = {7,9,1,1,4};
		solution(elements);
	}
	
	static int solution(int[] elements) {
        int answer = 0;
        List<Integer> list = new ArrayList<>(); //elements에서 더해야하는 길이가 elements를 초과하면 첫번째 인덱스로 이동하기 때문에 2배로 길이를 늘렸다
        Set<Integer> answerSet = new LinkedHashSet<Integer>();
        
        for(int j=0; j<2; j++) {//elements 길이 2배로 늘림
        	for(int i=0; i<elements.length; i++) {
            	list.add(elements[i]);
            }
        }
        
        for(int i=0; i<elements.length; i++) {
        	for(int j=0; j<elements.length; j++) {
        		int num = 0;//더한 합을 담음
        		for(int z=0; z<i+1; z++) {
        			num+=list.get(j+z);
        		}
        		answerSet.add(num);
        	}
        }
        
        answer = answerSet.size();
        
        return answer;
    }
}
