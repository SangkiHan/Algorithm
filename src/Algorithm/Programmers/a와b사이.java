package Algorithm.Programmers;

public class a와b사이 {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		question(a, b);
	}
	
	static long question(int a, int b) {
		long answer = 0;
        
        if(a>b){
            for(int i=a; i>=b; i--){
                answer+=i;
            }
        }
        else{
            for(int i=a; i<=b; i++){
                answer+=i;
            }
        }
        
        return answer;
	}
}
