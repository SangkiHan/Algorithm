package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 새로운달력 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=1; i<=T; i++) {
			System.out.println("Case #"+i+" "+question(in));
		}
	}
	
	static int question(Scanner in) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		for(int j=0; j<3; j++) {
			list.add(in.nextInt());
		}
		
		int a = 0;
		for(int i=0; i<list.get(0); i++) {
			if(i==0) {
				if((list.get(1)%list.get(2))==0) {
					answer += (list.get(1))/list.get(2);
				}
				else {
					answer += (list.get(1))/list.get(2) +1;
				}
				a = (list.get(1))%list.get(2);
			}else {
				if((list.get(1)+a)%list.get(2)==0) {
					answer += (list.get(1)+a)/list.get(2);
				}
				else {
					answer += (list.get(1)+a)/list.get(2) +1;
				}
				a = (list.get(1)+a)%list.get(2);
			}
		}
		
		return answer;
	}
}
