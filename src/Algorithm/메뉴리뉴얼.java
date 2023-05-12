package Algorithm;

import java.util.ArrayList;
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
        for(int cour : course) {
        	for(String order : orders) {
                combinate(new boolean[order.length()], order.split(""), 0, cour);
        	}
        	Set<Entry<String, Integer>> entrySet = setHash.entrySet();
        	for(Entry<String, Integer> entry : entrySet) {
        		int num = entry.getValue();
        		if(num==1) {
        			continue;
        		}
        		if(num>max) {
        			orderList.clear();
        			orderList.add(entry.getKey());
        			max = num;
        		}
        		else if(num==max){
        			orderList.add(entry.getKey());
        		}
        	}
        	answer.addAll(orderList);
        	orderList.clear();
        	setHash.clear();
        	max = 0;
        }
        
        Collections.sort(answer);
        
        return answer;
    }
	
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
