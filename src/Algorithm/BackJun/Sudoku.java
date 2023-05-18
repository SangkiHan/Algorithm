package Algorithm.BackJun;

import java.util.Scanner;

public class Sudoku {
	
	static int[][] answerArr;
	static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = 9;
		int m = 9;
		
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			int[] serveArr = new int[m];
			for(int j=0; j<m; j++) {
				serveArr[j] = sc.nextInt();
			}
			arr[i] = serveArr;
		}
		
		dfs(0,0,0,arr);
		
		System.out.println(builder);
	}
	
	static void dfs(int index, int jindex, int depth, int[][] arr) {
		if(depth==81) {
			answerArr = arr.clone();
			return;
		}  
		int[][] dfsArr = arr.clone();
		if(dfsArr[index][jindex]==0) {
			for(int i=1; i<=9; i++) {
				if(area(index, jindex, i, dfsArr) && vertical(jindex, i, dfsArr) && horizon(index, i, dfsArr)) {
					dfsArr[index][jindex]=i;
					if(jindex>=8) {
						if(index>=8) {
							return;
						}
						index++;
						depth++;
						jindex=0;
					}
					else {
						jindex++;
						depth++;
					}
					dfs(index, jindex, depth, dfsArr);
				}
			}
			if(dfsArr[index][jindex]==0) {
				return;
			}
		}
		else {
			if(jindex>=8) {
				if(index>=8) {
					return;
				}
				index++;
				depth++;
				jindex=0;
			}
			else {
				jindex++;
				depth++;
			}
			dfs(index, jindex, depth, dfsArr);
		}
	}
	
	static boolean area(int index, int jindex, int num, int[][] arr) {
		int a = (index/3)*3;
		int b = (jindex/3)*3;
		
		for(int i=a; i<a+3; i++) {
			for(int j=b; j<b+3; j++) {
				if(arr[i][j]==num) {
					return false;
				}
			}
		}
		return true;
	}
	
	static boolean vertical(int index, int num, int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i][index]==num) {
				return false;
			}
		}
		return true;
	}
	
	static boolean horizon(int index, int num, int[][] arr) {
		for(int i=0; i<arr[index].length; i++) {
			if(arr[index][i]==num) {
				return false;
			}
		}
		return true;
	}
}
