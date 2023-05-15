package Algorithm.BackJun;

import java.util.Scanner;

public class NQueen {
	
	static int n = 0;
	static int count = 0;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new int[n];
		
		dfs(0);
		
		System.out.print(count);
	}
	
	static void dfs(int depth) {
		
		if(depth==n) {
			count++;
			return;
		}
		else {
			for(int i=0; i<n; i++) {
				arr[depth] = i+1;
				if(depth!=0) {
					if(possible(depth+1, i+1)) {
						dfs(depth+1);
					}
				}
				else {
					dfs(depth+1);
				}
			}
		}
	}
	
	static boolean possible(int index, int num) {
		
		for(int i=0; i<index-1; i++) {
			if(arr[i]==num) {
				return false;
			}
			
			if((Math.abs(index-1)-i)==Math.abs(num-arr[i])) {
				return false;
			}
		}
		
		return true;
	}
}
