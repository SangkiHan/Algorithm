package Algorithm;

import java.util.HashMap;

public class 공평하게나누기 {

	public static void main(String[] args) {
		
		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
		solution(topping);
		
	}
	
	static int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> A = new HashMap<>(); //철수가 가지고 있는 맛
        HashMap<Integer, Integer> B = new HashMap<>(); //동생이 가지고 있는 맛
        A.put(topping[0], 1);//처음값만 넣어줌
        for(int i=1; i<topping.length; i++) {
        	B.put(topping[i], B.getOrDefault(topping[i],0)+1);//처음 이후 맛들 넣어줌
        }
        for(int i=1; i<topping.length; i++) {
        	if(A.size()==B.size()) {//동생과 철수가 가지고 있는 맛이 같으면 answer++
        		answer++;
        	}
        	A.put(topping[i], A.getOrDefault(topping[i], 0)+1);//철수가 가지고 있는 맛에 하나 추가
        	if(B.get(topping[i])-1 == 0) {//동생이 가지고 있는 맛이 없으면 remove
        		B.remove(topping[i]);
        	}
        	else {//같은 맛을 더 가지고있으면 -1
        		B.put(topping[i], B.get(topping[i])-1);
        	}
        }
        return answer;
    }

}
