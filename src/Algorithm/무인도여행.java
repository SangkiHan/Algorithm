package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 무인도여행 {
	static boolean[][] check;
	public static void main(String[] args) {
		
		String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
		solution(maps);
	}
	
	static List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        check = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
        	for(int j=0; j<maps[0].length(); j++) {
        		//시작지점이 X가 아니거나 방문하지 않았을 시
        		if(!("X".equals(String.valueOf(maps[i].charAt(j)))||check[i][j]==true)){	
        			answer.add(answer(maps, i, j));
        		}
        	}
        }
        if(answer.size()==0) {
        	answer.add(-1);
        }
        
        //내림차순 정렬
        Collections.sort(answer);
        
        return answer;
    }
	
	static int answer(String[] maps, int x, int y) {
		if(x==-1|| x==maps.length||y==-1||y==maps[0].length()||check[x][y]==true) {
			return 0;
		}
		else {
			if("X".equals(String.valueOf(maps[x].charAt(y)))) {
				return 0;
			}
			check[x][y]=true;
		}
		
		return Character.getNumericValue(maps[x].charAt(y))+answer(maps, x+1, y)+answer(maps,x,y+1)+answer(maps,x-1,y)+answer(maps,x,y-1);
	}
}
