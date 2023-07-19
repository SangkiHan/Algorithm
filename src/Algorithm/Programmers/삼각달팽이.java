package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이 {
	/**
	4	[1,2,9,3,10,8,4,5,6,7]
	5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
	6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
	 * */
	static int[][] arr;
	static List<Integer> answer = new ArrayList<Integer>();

	public static void main(String[] args) {
		int n=6;
		arr = new int[n+1][n+1];
		solution(n);
	}
	
	static List<Integer> solution(int n) {
		int count = n;
		int num = 1;
		int type = 1;
		int a=0;
		int b=0;
		while(count!=0) {
			if(type==1) {
				for(int i=0; i<count; i++) {
					arr[a][b]=num++;
					a++;
				}
				a--;
				type=2;
			}
			else if(type==2) {
				for(int i=0; i<count; i++) {
					b++;
					arr[a][b]=num++;
				}
				type=3;
			}
			else {
				for(int i=0; i<count; i++) {
					a-=1;
					b-=1;
					arr[a][b]=num++;
				}
				a++;
				type=1;
			}
			count--;
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j]==0) {
					break;
				}
				answer.add(arr[i][j]);
			}
		}
		return answer;
	}
}
