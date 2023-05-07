package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 택배상자 {

	public static void main(String[] args) {
		int[] order = {2, 1, 6, 7, 5, 8, 4, 9, 3, 10};
		solution(order); 
	}
	
	static int solution(int[] order) {
        int answer = 0;
        
        Queue<Integer> mainQueue = new LinkedList<>();
        Queue<Integer> orderQueue = new LinkedList<>();
        List<Integer> serve = new ArrayList<>();
        
        for(int i=1; i<order.length+1; i++){
            mainQueue.add(i);
        }
        
        for(int a : order){
            orderQueue.add(a);
        }
        
        int serveIndex = 0;
        
        while(!orderQueue.isEmpty()){
            int product = orderQueue.poll();
            int serveProduct = 0;
            if(serve.size()>0){
                serveProduct = serve.get(serve.size()-1);
            }
            if(product!=serveProduct){
                for(int i=serveIndex+1; i<product; i++){
                    serve.add(mainQueue.poll());
                    serveIndex++;
                }
                if(product!=mainQueue.peek()){
                    break;
                }
                else{
                	mainQueue.remove();
                    answer++;
                }
            }
            else{
                serve.remove(serve.size()-1); 
                serveIndex++;
                answer++;
            }
        }
        
        return answer;
    }

}
