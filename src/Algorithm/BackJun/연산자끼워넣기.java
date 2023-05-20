package Algorithm.BackJun;

import java.util.Scanner;

public class 연산자끼워넣기 {
	
	static int n;
	static int[] operatorArr;
	static int[] arr;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		operatorArr = new int[4];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<4; i++) {
			operatorArr[i] = sc.nextInt();
		}
		
		dfs(1, arr[0]);
		System.out.println(max);
		System.out.print(min);
		return;
	}
	
	static void dfs(int depth, int value) {
		if(depth==n) {//n만큼 깊이에 들어왔을경우
			if(max<value) {
				max=value;
			}
			if(min>value) {
				min=value;
			}
			return;
		}
		
		if(operatorArr[0]>0) {//+연산자가 있을 경우
			operatorArr[0]=operatorArr[0]-1;
			dfs(depth+1, value+arr[depth]);
			operatorArr[0] = operatorArr[0]+1;
		}
		if(operatorArr[1]>0) {//-연산자가 있을 경우
			operatorArr[1]=operatorArr[1]-1;
			dfs(depth+1, value-arr[depth]);
			operatorArr[1] = operatorArr[1]+1;
		}
		if(operatorArr[2]>0) {//*연산자가 있을 경우
			operatorArr[2]=operatorArr[2]-1;
			dfs(depth+1, value*arr[depth]);
			operatorArr[2] = operatorArr[2]+1;
		}
		if(operatorArr[3]>0) {// /연산자가 있을 경우
			operatorArr[3]=operatorArr[3]-1;
			dfs(depth+1, value/arr[depth]);
			operatorArr[3] = operatorArr[3]+1;
		}
	}
}
