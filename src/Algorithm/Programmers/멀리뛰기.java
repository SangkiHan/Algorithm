package Algorithm.Programmers;

public class 멀리뛰기 {
<<<<<<< Updated upstream

	public static void main(String[] args) {
		int n = 4;
		solution(n);
=======
	
	static long count = 0;

	public static void main(String[] args) {
		int n=1;
		System.out.println(solution(n));
>>>>>>> Stashed changes
	}
	
	static long solution(int n) {
        long answer = 0;
        
        long[] dp = new long[n+1];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2; i<n+1; i++) {
        	dp[i]=(dp[i-1]+dp[i-2])%1234567;
        }
        
<<<<<<< Updated upstream
        answer=dp[n]%(long)1234567;
        return answer;
    }

=======
        answer=dp[n];
        return answer;
    }
>>>>>>> Stashed changes
}
