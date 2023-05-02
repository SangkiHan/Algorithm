package Algorithm;

public class 숫자변환하기 {
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		int x = 10;
		int y = 40;
		int n = 5;
		
		solution(x,y,n);

	}
	
	static int solution(int x, int y, int n) {
		int[] array = new int[y+1];
		
		for(int i=x+1; i<array.length; i++) {
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			int c = Integer.MAX_VALUE;
			int d = 0;
			if(check(i,2) && (i/2)>=x) {
				a = array[i/2];
			}
			if(check(i,3) && (i/3)>=x) {
				b = array[i/3];
			}
			if((i-n)>=x) {
				c = array[i-n];
			}
			
			d = Math.min(a, b);
			d = Math.min(d, c);
			
			if(d<Integer.MAX_VALUE) {
				array[i] = d+1;
			}
			else {
				array[i] = d;
			}
		}
		
		return (array[y]==Integer.MAX_VALUE)?-1:array[y];
	}
	
	static boolean check(int num, int i) {
		boolean check = false;
		
		if(num%i==0 && num/i>0) {
			check = true;
		}
		
		return check;
	}
}
