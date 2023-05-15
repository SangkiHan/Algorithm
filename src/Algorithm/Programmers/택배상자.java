package Algorithm.Programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 택배상자 {

	public static void main(String[] args) {
		int[] order = {2, 1, 3, 5, 4};
		solution(order); 
	}
	
	static int solution(int[] order) {
        int answer = 0;
        
        Queue<Integer> orderQueue = new LinkedList<>();//주문내역
        Queue<Integer> mainQueue = new LinkedList<>();//컨테이너 벨트에서 내려는 상품
        Stack<Integer> serveStack = new Stack<>();//서브컨테이너
        
        for(int i=1; i<=order.length; i++) {//컨테이너에서 내려오는 상품 세팅
        	mainQueue.add(i);
        }
        
        for(int num : order) {//주문내역 큐로 변환
        	orderQueue.add(num);
        }
        
        int serveIndex = 1;//현재 서브컨테이너에 들어있는 상품 최대값
        
        while(true) {
        	if(orderQueue.peek()==mainQueue.peek()) {//컨테이너벨트에서 내려오는 상품과 주문내역이 맞으면 둘다 삭제하고 answer++;
        		answer++;
        		serveIndex++;
        		orderQueue.remove();
        		mainQueue.remove();
        	}
        	else {
        		int serveNum=0;
        		if(serveStack.size()>0) {//서브컨테이너에 상품있으면 가져옴
        			serveNum = serveStack.peek();
        		}
        		if(serveNum==orderQueue.peek()) {//서브컨테이너에 상품과 주문내역 일치하면 answer++;
        			answer++;
        			serveStack.pop();
        			orderQueue.remove();
        		}
        		else {
        			if(serveIndex>orderQueue.peek()) {//서브컨테이너 상품의 최대값이 주문내역 첫번째 상품보다 크면 더이상 채울수 없으므로 break
        				break;
        			}
        			for(int i=serveIndex; i<=orderQueue.peek(); i++) {//서브컨테이너에 넣어줌
        				serveStack.add(i);
        				if(mainQueue.size()>0) {
            				mainQueue.remove();
        				}
        			}
        			serveIndex = orderQueue.peek()+1;
        		}
        	}
        	if(serveStack.size()>orderQueue.size() || orderQueue.size()==0) {//주문내역이 비어있거나 서브컨테이너가 주문내역보다 크면 break;
            	break;
        	}
        }
        
        return answer;
    }
}
