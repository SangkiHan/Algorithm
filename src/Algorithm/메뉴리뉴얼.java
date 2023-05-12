package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class 메뉴리뉴얼 {
	
	static HashMap<String, Integer> setHash = new HashMap<String, Integer>();

	public static void main(String[] args) {
		
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		solution(orders, course);
		
	}
	
	static List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();
        int max = 0;
        
        List<String> orderList = new ArrayList<String>();
        for(int cour : course) {//코스의 개수만큼 반복문 돌리기
        	for(String order : orders) {
        		String[] arr = order.split("");
        		Arrays.sort(arr);//개인마다 주문이 같아도 순서가 다를 수 있기에 정렬을 시켜주서 세트의 순서를 맞춰준다.
                combinate(new boolean[order.length()], order.split(""), 0, cour);//재귀를 돌려 메뉴의 수만큼 조합해준다.
        	}
        	Set<Entry<String, Integer>> entrySet = setHash.entrySet();
        	for(Entry<String, Integer> entry : entrySet) {
        		int num = entry.getValue();
        		if(num==1) {//주문한 조합의 수가 1개이면 continue;
        			continue;
        		}
        		if(num>max) {//메뉴의 수가 최대값보다 크면
        			orderList.clear();//초기화
        			orderList.add(entry.getKey());//세트메뉴 목록에 넣어줌
        			max = num;
        		}
        		else if(num==max){//같으면
        			orderList.add(entry.getKey());//넣어주기만함
        		}
        	}
        	answer.addAll(orderList);//세트메뉴를 정답리스트에 넣어줌
        	orderList.clear();//다음 개수를 위해 빈배열로 초기화
        	setHash.clear();//조합도 초기화
        	max = 0;
        }
        
        Collections.sort(answer);//알파벳순 정렬
        
        return answer;
    }
	
	//조합 재귀함수
	static void combinate(boolean[] visit, String[] order, int index, int course) {
		if(course>0) {
			for(int i=index; i<order.length; i++) {
				visit[i]=true;
				course--;
				index++;
				combinate(visit, order, index, course);
				course++;
				visit[i]=false;
			}
		}
		else {
			String str = "";
			for(int i=0; i<visit.length; i++) {
				if(visit[i]) {
					str+=order[i];
				}
			} 
			setHash.put(str, setHash.getOrDefault(str, 0)+1);
		}
	}
}
