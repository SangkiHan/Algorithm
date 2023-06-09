package Algorithm.Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 테이블해쉬함수 {

	public static void main(String[] args) {
		
		int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
		int col = 2;
		int row_begin = 2;
		int row_end = 3;
		solution(data, col, row_begin, row_end);
		
	}
	static  int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[col-1]==o2[col-1]) {//col번째 행이 같으면 첫번째행 내림차순
					return o2[0]-o1[0];
				}
				else {
					return o1[col-1]-o2[col-1];//col번째 행이 같지 않으면 col번째행 오름차순
				}
			}
		});
        
        for(int i=row_begin-1; i<row_end; i++) {
        	int num = 0;
        	for(int j=0; j<data[0].length; j++) {
        		num+=data[i][j]%(i+1);//행으로 나누어 나머지 누적
        	}
        	
        	answer^=num;//비트연산자로 num만큼 이동
        }
        
        return answer;
    }
}
