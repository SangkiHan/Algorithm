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
		
		for(int i=0; i<n; i++) {
			dfs(arr[i], m-1, 0, new boolean[n]);
		}
		
		for(List<Integer> list : answerList) {
			System.out.println(list.toString());
		}
	}
	
	static void dfs(int i, int m, int index, boolean[] check) {
		if(m==0) {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			for(int j=0; j<check.length; j++) {
				if(check[j]) {
					list.add(arr[j]);
				}
			}
			answerList.add(list);
		}
		else {
			for(int j=index; j<check.length; j++) {
				if(j+1!=i) {
					check[j] = true;
					dfs(i, m-1, index+1, check);
					check[j] = false;
					index++;
				}
				else {
					index++;
				}
			}
		}
	}
}
