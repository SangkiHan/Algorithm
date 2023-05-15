package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 게임맵최단거리 {
	static List<Integer> answerList = new ArrayList<>();
	static int[] moveX = {0,1,0,-1};
	static int[] moveY = {1,0,-1,0};
	public static void main(String[] args) {
		
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		solution(maps);
	}
	
	static int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];

		int[][] score = new int[maps.length][maps[0].length];
		bfs(maps,visited,score);
		
		if(score[maps.length-1][maps[0].length-1] != 0) {//마지막에 도착한 횟수가 비어있는지 확인
            answer = score[maps.length][maps[0].length]++;
        }
        else {
        	answer = -1;
        }	
		
//        dfs(maps, visited, 0, 0, 0);
        
//        if(answerList.size()>0) {//마지막에 도착한 횟수가 비어있는지 확인
//            Collections.sort(answerList);
//            answer = answerList.get(0);
//        }
//        else {
//        	answer = -1;
//        }	
		
		
		
        return answer;
    }
	
	static void dfs(int[][] maps, boolean[][] visited, int x, int y, int num) {
		boolean[][] visit = new boolean[maps.length][maps[0].length];//객체주소가 같아 visited가 전체에 참조가 되어 초기화
	    for(int i=0; i<visited.length; i++){
	        for(int j=0; j<visited[0].length; j++){
	            visit[i][j] = visited[i][j];
	        }
	    }
		if(x==-1|| x==maps.length||y==-1||y==maps[0].length||visit[x][y]==true||maps[x][y]==0) {//x y가 범위를 벗어났더나 방문한 곳일시 dfs종료
			return;
		}
		else{
			visit[x][y]=true;
			if(x==maps.length-1 && y==maps[0].length-1) {//x,y가 마지막지점일시 answerList에 넣어줌
				answerList.add(num++);
			}
		}
		
		//사방으로 탐색
		dfs(maps, visit, x+1, y, num++);
		dfs(maps, visit, x-1, y, num++);
		dfs(maps, visit, x, y+1, num++);
		dfs(maps, visit, x, y-1, num++);
	}
	
	static void bfs(int[][] maps, boolean[][] visited, int[][] score) {
		int x = 0;
		int y = 0;
		visited[0][0] = true;//시작 0,0
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x,y});//queue에 초기값 넣어줌
		
		while(!queue.isEmpty()) {//queue에 방문할 곳이 남아있지 않을 때까지 반복
			int[] present = queue.poll();//queue에서 가져오고 바로 삭제
			int px = present[0];//현재위치
			int py = present[1];
			
			for(int i=0; i<4;i++) {//반복문으로 사방으로 체크한다.
				int nx = px+moveX[i];
				int ny = py+moveY[i];
				
				if(nx==-1|| nx==maps.length||ny==-1||ny==maps[0].length||visited[nx][ny]==true||maps[nx][ny]==0) {//x y가 범위를 벗어났더나 방문한 곳일시 queue추가X
					continue;
				}
				
				queue.add(new int[]{nx,ny});//방문할 장소 넣어줌
				visited[nx][ny] = true;//방문 true체크
				score[nx][ny] = score[px][py]+1;//다음으로 방문할때마다 +1
			}
		}
	}
}
