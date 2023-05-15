package Algorithm.Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 호텔대실 {

	public static void main(String[] args) {
		
		String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
		solution(book_time);
		
	}
	
	
	static  int solution(String[][] book_time) {
		int[][] bookTime = new int[book_time.length][2];
        
        for(int i=0; i<book_time.length; i++) {
        	bookTime[i][0] = Integer.parseInt(book_time[i][0].replace(":", ""));	//String시간을 int로 변경
        	int endTime = Integer.parseInt(book_time[i][1].replace(":", ""));
        	endTime+=10;
        	if((endTime%100)>=60) {													//뒤 두자리가 60이상이면 1시간이기 때문에 변경
        		endTime+=40;
        	}
        	bookTime[i][1] = endTime;
        }
        
        Arrays.sort(bookTime, new Comparator<int[]>() {	//book을 시작시간 순으로 정렬

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}
				else {
					return o1[0]-o2[0];
				}
			}
		});
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int[] book : bookTime) {
        	
        	if(queue.peek()==null) {					//큐에 없으면 첫번째 종료시간넣어주기
        		queue.add(book[1]);
        		continue;
        	}
        	
        	if(queue.peek()<=book[0]) {					//큐에 제일 작은 종료시간이 book의 시작시간보다 10분 뒤면 큐값 없애도 새로 갱신
        		queue.poll();
        		queue.add(book[1]);
        	}
        	else {										//큐에 제일 작은 종료시간이 book의 시작시간보다 늦으면 새로운 종료시간 넣어주기
        		queue.add(book[1]);
        	}
        	
        }
        
        
        return queue.size();
    }
}
