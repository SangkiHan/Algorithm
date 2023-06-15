package Algorithm.Programmers;

public class 나라의숫자 {

	public static void main(String[] args) {
		int n = 9;
		solution(n);
	}
	
	static String solution(int n) {
        String answer = "";
        String[] number = {"4","1","2"};
        int num=n;
        while(num!=0) {
        	int remain = num%3;
        	num=num/3;
    		answer+=number[remain];
    		if(remain==0) {
    			num--;
    		}
        }
        StringBuilder builder = new StringBuilder(answer);
        
        return builder.reverse().toString();
    }
}
