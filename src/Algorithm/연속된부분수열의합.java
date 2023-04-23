package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 연속된부분수열의합 {
	
	public static void main(String[] args) {
		int[] sequence = {2,2,2,2,2};
		int k = 6;
		solution(sequence, k);
	}
	
	static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        List<int[]> list = new ArrayList<>();
        
        int sum = sequence[0];

    	int right=0;
    	int left=0;
    	
        while(true) {
        	if(sum == k) {
        		int[] ans = new int[3];
        		ans[0] = right-left;
        		ans[1] = left;
        		ans[2] = right;
        		list.add(ans);
        	}
        	else if(sum>k) {
        		sum-=sequence[left];
        		sum-=sequence[right];
        		right--;
        		left++;
        	}
        	if(sequence.length-1==right && sequence.length-1==left) {
        		break;
        	}
        	if(right!=sequence.length-1) {
            	right++;
            	sum+=sequence[right];
        	}
        	else {
        		sum-=sequence[left];
        		left++;
        	}
        }
        
        
        Collections.sort(list, (o1,o2)->{return o1[0]-o2[0];});
        answer[0] = list.get(0)[1];
        answer[1] = list.get(0)[2];
        
        return answer;
    }

}
