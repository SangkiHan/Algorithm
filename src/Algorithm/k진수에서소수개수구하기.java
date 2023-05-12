package Algorithm;

public class k진수에서소수개수구하기 {
	
	public static void main(String[] args) {
		
		int n = 1234567892;
		int k = 3;
		solution(n,k);
		
	}

	static int solution(int n, int k) {
        int answer = 0;
        
        String transNstr = Integer.toString(n,k);
        
        for(int i=0; i<transNstr.length(); i++) {
        	if(transNstr.charAt(i)=='0') {//첫번째숫자가 0이면 continue
        		continue;
        	}
        	for(int j=i+1; j<transNstr.length()+1; j++) {
        		if(transNstr.charAt(j-1)=='0') {//0이 들어간 소수는 안되기 때문에 break;
					break;
				}
    			long tansN = Long.parseLong(transNstr.substring(i,j));
        		if(isPrime(tansN)) {
        			if(i==0 && j!=transNstr.length()) {//앞에 숫자가 없고 뒤에가 0일시
        				if(transNstr.charAt(j)=='0') {
        					answer++;
        				}
        			}
        			else if(i!=0 && j==transNstr.length()){//뒤에 숫자가 없고 앞에가 0일시
        				if(transNstr.charAt(i-1)=='0') {
        					answer++;
        				}
        			}
        			else if(i!=0 && j!=transNstr.length()){//양옆으로 0일시
        				if(transNstr.charAt(i-1)=='0' && transNstr.charAt(j)=='0') {
        					answer++;
        				}
        			}
        			else {//앞뒤로 아무숫자도 없을시
        				answer++;
        			}
        		}
        	}
        }
        return answer;
    }
	
	static boolean isPrime(long n) {//소수검증메소드
		if(n==1) {//1이면 소수X
			return false;
		}
		for (int i = 2; i<=(int)Math.sqrt(n); i++) {
		    if (n % i == 0) {
		    	return false;
		    }
		}
		return true;
	}
}
