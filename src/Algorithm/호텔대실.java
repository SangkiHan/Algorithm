package Algorithm;

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
        	bookTime[i][0] = Integer.parseInt(book_time[i][0].replace(":", ""));
        	int endTime = Integer.parseInt(book_time[i][1].replace(":", ""));
        	endTime+=10;
        	if((endTime%100)>=60) {
        		endTime+=40;
        	}
        	bookTime[i][1] = endTime;
        }
        
        Arrays.sort(bookTime, new Comparator<int[]>() {

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
        	
        	if(queue.peek()==null) {
        		queue.add(book[1]);
        		continue;
        	}
        	
        	if(queue.peek()<=book[0]) {
        		queue.poll();
        		queue.add(book[1]);
        	}
        	else {
        		queue.add(book[1]);
        	}
        	
        }
        
        
        return queue.size();
    }
}
