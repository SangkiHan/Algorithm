package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 최후의승자는누구 {
	public static void main(String[] args) {
		question();
	}
	
	static void question() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int C = in.nextInt();
		
		int[][] array = new int[T][C];
		
		for(int i=0; i<T; i++) {
			for(int j=0; j<C; j++) {
				array[i][j] = in.nextInt();
			}
		}


		for(int i=0; i<T; i++) {
			Arrays.sort(array[i]);
		}

		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<C; i++) {
			int max = 0;
			for(int j=0; j<T; j++) {
				if(max<array[j][i]) {
					max = array[i][j];
					list.clear();
					list.add(j+1);
				}
				else if(max==array[i][j]) {
					list.add(j+1);
				}
			}
		}
		
		for(int a : list) {
			System.out.println(a+" ");
		}
	}
}
