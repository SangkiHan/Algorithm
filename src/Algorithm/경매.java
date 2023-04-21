package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 경매 {
	public static void main(String[] args) {
		question();
	}
	
	static void question() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int C = in.nextInt();
		
		HashMap<Integer, Integer> hashMoney = new HashMap<>();
		HashMap<Integer, String> hash = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for(int i=0; i<C; i++) {
			String name = in.next();
			Integer mon = in.nextInt();
			hash.put(mon, name);
			
			if(min>mon) {
				if(hashMoney.get(mon)!=null) {
					int count = hashMoney.get(mon)+1;
					hashMoney.put(mon, count);
					min =0;
				}
				else {
					hashMoney.put(mon, 1);
					if(min>mon) {
						min=mon;
					}
				}
			}
		}
		
		System.out.println(hash.get(min)+" "+min);
	}
}
