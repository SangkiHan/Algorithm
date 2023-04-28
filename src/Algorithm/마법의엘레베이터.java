package Algorithm;

public class 마법의엘레베이터 {

	public static void main(String[] args) {
		
		int strey = 555;
		
		solution(strey);
	}
	
	// 마법의 돌 종류 : 10의 n승
	static int solution(int storey) {
        int answer = 0;
        
        while(storey!=0) {				//요청값이 0이 될 때 까지 반복문
        	int a = storey%10;			//1자리수 가져오기
        	if(a>5) {					//5이상이면 +하는게 이듯
        		answer+=(10-a);
        		storey+=10;
        	}
        	else if(a<5){				//5이하면 -하는게 이득
        		answer+=a;
        	}
        	else{						
        		if((storey/10)%10>4) {	//1자리수가 5이고 그 다음 자리수가 5이상일시는 +를 하여 다음자리수를 한자리 올려주는게 이득
            		storey+=10;
        		}
    			answer+=(10-a);			//요청값 storey가 한자리수 일때는 (storey/10)%10>4 이 조건을 충족시키기 않기 때문에 밖에다가 +해줬다.
        	}
        	storey/=10;					//storey에 다음자리수부터 초기화
        }
        return answer;
    }
}
