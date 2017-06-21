package apitestrest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortArray {

	public static void main(String[] args) {
		
		Integer [] arr={3,5,9,1,2};
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(5);
		list.add(9);
		list.add(4);
		
		System.out.println(list.contains(4));
		System.out.println(list.indexOf(4));
		
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
//		
//		
//		Arrays.sort(arr, Collections.reverseOrder());
//		for(int i=0;i<arr.length;i++){
//			System.out.println(arr[i]);
//		}	
		
		System.out.println(Arrays.binarySearch(arr,2));

	}

}
