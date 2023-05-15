package Algorithm;

import java.util.Scanner;

public class BJN과M2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		dfs(m,0,new boolean[n]);
	}
	
	static void dfs(int m, int index, boolean[] check) {
		if(m==0) {
			for(int i=0; i<check.length; i++) {
				if(check[i]) {
					System.out.print(i+1+" ");
				}
			}
			System.out.println();
		}
		else {
			for(int i=index; i<check.length; i++) {
				check[i]=true;
				dfs(m-1, index+1, check);
				check[i]=false;
				index++;
			}
		}
	}
}
