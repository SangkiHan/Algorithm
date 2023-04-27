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
        			answer.add(dfs(maps, i, j));
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
	
	static int dfs(String[] maps, int x, int y) {
		//x와 y가 maps범위내에서 벗어 났을시 return 0
		if(x==-1|| x==maps.length||y==-1||y==maps[0].length()||check[x][y]==true) {
			return 0;
		}
		else {
			//범위 내지만 만약 X면 return0
			if("X".equals(String.valueOf(maps[x].charAt(y)))) {
				return 0;
			}
			//방문했으니 방문처리
			check[x][y]=true;
		}
		
		//사방으로 dfs돌리기
		return Character.getNumericValue(maps[x].charAt(y))+dfs(maps, x+1, y)+dfs(maps,x,y+1)+dfs(maps,x-1,y)+dfs(maps,x,y-1);
	}
}
