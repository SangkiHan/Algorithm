package Algorithm.Programmers;

import java.util.HashMap;

public class Practice {
	public static void main(String[] args) {
		//hash선언
		HashMap<String, Integer> hash = new HashMap<>();
		/*
		 * key : Test
		 * value : 1
		 * */
		hash.put("Test",1);
		
		int value = hash.get("Test");
		System.out.print(value); //1출력
	}
}
