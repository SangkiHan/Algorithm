package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 귤고르기 {

	public static void main(String[] args) {
		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
		solution(4, tangerine);
	}
	
	static int solution(int k, int[] tangerine) {
		int answer = 0;
		List<Integer> answerList = new ArrayList<>();
		HashMap<Integer, Integer> countMap = new HashMap<>();//tangerine count를 담을 hash
		
		for(int a : tangerine) {
			countMap.put(a, countMap.getOrDefault(a, 0)+1);//tangerine count를 담음
		}

		List<Integer> tangerineList = new ArrayList<>(countMap.keySet());//countMap의 키값으로 List생성
		
		Collections.sort(tangerineList,(a, b)->{//포함 개수많은 순으로 정렬
			if(countMap.get(a)>countMap.get(b)) {
				return -1;
			}
			else if(countMap.get(a)==countMap.get(b)) {//같을때를 안해주니 runtime에 발생
				return 0;
			}
			else {
				return 1;
			}
		});
		
		int count=0;
		int index=0;
		while(count<k) {//count가 k를 넘을때까지 반복
			count+=countMap.get(tangerineList.get(index));
			answerList.add(tangerineList.get(index));
			index++;
		}
		
		answer = answerList.size();
		
		return answer;
	}
}
