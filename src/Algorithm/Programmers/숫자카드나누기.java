package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 숫자카드나누기 {
	public static void main(String[] args) {
		
		int[] arrayA = {14, 35, 119};
		int[] arrayB = {18, 30, 102};
		
		solution(arrayA, arrayB);
	}
	
	static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int a = Answer(arrayA, arrayB);
        int b = Answer(arrayB, arrayA);
        
        answer = (a>b)?a:b;
        
        return answer;
    }
	
	static int Answer(int[] arrayA, int[] arrayB) {
		List<Integer> alist = new ArrayList<>();//arrayA로 들어온 리스트 최솟값의 약수들을 담는다.
		Arrays.sort(arrayA);//공약수는 arrayA보다 절대 클 수는 없기 때문에 오름차순으로 정렬한다.
		
		List<Integer> maxNum = new ArrayList<>();//
		
		for(int i=arrayA[0]; i>1; i--) {
			if(arrayA[0]%i==0) {
				alist.add(i);
			}
		}
		
		for(int a : alist) {//arrayA에 담긴 값들이 최솟값의 약수들이 다 나눠지는지 확인한다 -> 공약수
			boolean check = true;
			for(int b : arrayA) {
				if(b%a!=0){//하나라도 안나눠지면 반복문 break;
					check=false;
					break;
				}
			}
			if(check) {//공약수를 담아준다.
				maxNum.add(a);
			}
		}
		
		int max = 0;
		for(int num : maxNum) {
			boolean check = true;
			for(int b : arrayB) {
				if(b%num==0) {
					check=false;
					break;
				}
			}
			if(check && max<num) {//arrayB와의 최대공약수를 구해준다.
				max = num;
			}
		}
		
		return max;
	}
}
