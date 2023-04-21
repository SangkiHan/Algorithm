package Algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class 너의평점은 {
	
	public static void main(String[] args) {
		System.out.println(question());
	}
	
	static double question() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		HashMap<String, Double> score = new HashMap<>();
		score.put("A+", 4.5);
		score.put("A0", 4.0);
		score.put("B+", 3.5);
		score.put("B0", 3.0);
		score.put("C+", 2.5);
		score.put("C0", 2.0);
		score.put("D+", 1.5);
		score.put("D0", 1.0);
		score.put("F", 0.0);
		score.put("P", 0.0);
		
		double sum = 0;
		double s = 0;
		double sSum =0;
		for(int i=1; i<=60; i++) {
			String K = in.next();
			if((i%3)==1) {
				continue;
			}
			else if((i%3)==2) {
				s = Double.parseDouble(K);
			}
			else if((i%3)==0) {
				if("F".equals(K)) {
					sSum+=s;
				}
				else {
					if(!"P".equals(K)) {
						sSum+=s;
						sum += s*score.get(K);
					}
				}
			}
		}
		
		return sum/sSum;
	}

}
