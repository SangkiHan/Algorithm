package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJN과M {
	
	static List<List<Integer>> answerList = new ArrayList<>();
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		dfs(n, m, 0, new boolean[n]);
		for(List<Integer> list : answerList) {
			System.out.print(list.toString());
		}
	}
	
	static void dfs(int n, int m, int index, boolean[] check) {
		if(m==0) {
			List<Integer> answerArr = new ArrayList<>();
			for(int i=0; i<check.length; i++) {
				if(check[i]) {
					answerArr.add(arr[i]);
				}
			}
			answerList.add(answerArr);
		}
		else {
			for(int i=index; i<check.length; i++) {
				check[i]=true;
				dfs(n, m-1, index+1, check);
				check[i]=false;
			}
		}
	}
}
