package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 요격시스템 {
	public static void main(String[] args) {
		int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
		solution(targets);
	}
	
	static int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {return o1[1]-o2[1];});
        
        List<int[]> list = new ArrayList<>();
        Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
        
        int launch = -1;
        
        for(int[] target : targets){
            if(launch==-1){
                launch = target[1]-1;
                answer++;
                continue;
            }
            if(target[0]<=launch && target[1]>=launch){
                continue;
            }
            
            launch = target[1]-1;
            answer++;
        }
        
        return answer;
    }
}
