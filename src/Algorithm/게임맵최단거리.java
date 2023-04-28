package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class 게임맵최단거리 {
	static List<Integer> answerList = new ArrayList<>();
    static boolean[][] visited ;
	
	public static void main(String[] args) {
		
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		solution(maps);
	}
	
	static int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        dfs(maps, visited, 0, 0, 0);
        
        return answer;
    }
	
	static void dfs(int[][] maps, boolean[][] visited, int x, int y, int num) {
		if(x==-1|| x==maps.length||y==-1||y==maps[0].length||visited[x][y]==true||maps[x][y]==0) {
			return;
		}
		else{
			visited[x][y]=true;
			if(x==maps.length && y==maps[0].length) {
				answerList.add(num);
			}
		}
		
		num++;
		dfs(maps, visited, x+1, y, num);
		dfs(maps, visited, x-1, y, num);
		dfs(maps, visited, x, y+1, num);
		dfs(maps, visited, x, y-1, num);
	}
}
