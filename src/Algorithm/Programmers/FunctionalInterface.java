package Algorithm.Programmers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalInterface {
	public static void main(String[] args) {
		Consumer<String> consumer = s -> System.out.println(s);
		List<String> list = Arrays.asList("apple", "banana", "orange");
		list.forEach(consumer);
	}
}
