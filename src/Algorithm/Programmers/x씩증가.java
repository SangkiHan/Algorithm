package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.List;

public class x씩증가 {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		question(a, b);
	}
	
	static List<Long> question(int x, int n) {
		List<Long> answer = new ArrayList<>();
        
        int i=0;
        Long ans = 0L;
        while(i!=n){
            ans+=Long.valueOf(x);
            answer.add(ans);
            i++;
        }
        
        return answer;
	}
}
