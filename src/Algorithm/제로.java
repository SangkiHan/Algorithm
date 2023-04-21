package Algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 제로{

	public static void main(String[] args) {
		System.out.println(question());
	}
	
	static int question() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		int K = in.nextInt();
		List<Integer> list = new ArrayList<>();
		
		int answer = 0;
		
		for(int i=0; i<K; i++) {
			int a = in.nextInt();
			if(a!=0) {
				list.add(a);
			}
			else {
				list.remove(list.size()-1);
			}
		}
		
		for(int num : list) {
			answer+=num;
		}
		
		return answer;
	}

}
