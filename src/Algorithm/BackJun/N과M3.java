package Algorithm.BackJun;

import java.util.Scanner;

public class N과M3 {
	
	static int[] arr;
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[m];
		
		dfs(n, m, 0, 0);
		
		System.out.println(str);
	}
	
	static void dfs(int n, int m, int index, int depth) {
		if(m==depth) {
			for(int i=0; i<m; i++) {
				str.append(arr[i]+" ");
			}
			str.append("\n");
		}
		else {
			for(int i=0; i<n; i++) {
				arr[index]=i+1;
				dfs(n, m, index+1, depth+1);
			}
		}
	}
}
