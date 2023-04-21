package Algorithm;

public class 체육복 {
	public static void main(String[] args) {
		
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {3};
		
		question(n, lost, reserve);
	}
	
	static void question(int n, int[] lost, int[] reserve) {
		boolean[] lostTrue = new boolean[lost.length];
		boolean[] reserveTrue = new boolean[reserve.length];
		int answer = n-lost.length;
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(!lostTrue[i] && !reserveTrue[j] && check(lost[i], reserve[j])) {
					lostTrue[i]=true;
					reserveTrue[j]=true;
					answer++;
				}
			}
		}
		System.out.print(answer);
	}
	
	static boolean check(int i, int reserve) {
		boolean check = true;
		if(Math.abs(i-reserve)>1) {
			check=false;
		}
		return check;
	}
}
