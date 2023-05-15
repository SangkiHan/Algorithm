package Algorithm.Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 스텔라가치킨을선물했어요 {
	public static void main(String[] args) {
		System.out.println(question());
	}
	
	static int question() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		int answer = 0;
		
		int[][] array = new int[T][2];
		
		for(int i=0; i<T; i++) {
			for(int j=0; j<2; j++) {
				array[i][j] = in.nextInt();
			}
		}
		
		if(array.length>5) {
			Arrays.sort(array, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]==o2[0]) {
						return o1[1]-o2[1];
					}
					else {
						return o2[0]-o1[0];
					}
				}
			});
			
			
			int a = array[4][0];
			
			for(int i=5; i<T; i++) {
				if(a==array[i][0]) {
					answer++;
				}
				else {
					break;
				}
			}
		}
		
		return answer;
	}
}
