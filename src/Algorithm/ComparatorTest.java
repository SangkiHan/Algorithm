package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
	public static void main(String[] args) {
		int[][] array = {{4, 2},{4, 6},{7, 10},{25, 42123}};
		
		List<int[]> list = new ArrayList<>();
		list.add(array[0]);
		list.add(array[1]);
		list.add(array[2]);
		list.add(array[3]);
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0]) {
					return 1;
				}
				else if(o1[0]==o2[0]) {
					if(o1[1]>o2[1]) {
						return 1;
					}
					else {
						return -1;
					}
				}
				else {
					return -1;
				}
			}
		});
		
		for(int[] a : list) {
			System.out.println(a[0]+","+a[1]);
		}
	}
}
