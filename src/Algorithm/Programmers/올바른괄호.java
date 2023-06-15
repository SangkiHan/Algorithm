package Algorithm.Programmers;

public class 올바른괄호 {

	public static void main(String[] args) {
		String s = "(())()";
		solution(s);
	}
	
	static boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i)=='(') {
        		count++;
        	}
        	else if(s.charAt(i)==')'){
        		if(count>0) {
        			count--;
        		}
        		else {
        			answer = false;
        			break;
        		}
        	}
        }
        
        if(count>0) {
        	answer=false;
        }
        return answer;
    }
	
}
