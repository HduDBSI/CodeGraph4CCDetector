package googlejam6.p214;
import java.util.*;
import java.io.*;
import java.math.*;





public class Main {

	static int[][] map;
	static int index;
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cases =scan.nextInt();
        for(int round = 1; round <= cases; round++) {
        	int n = scan.nextInt();
        	int[] arr = new int[2501];
        	Arrays.fill(arr, 0);
        	for(int i = 0; i < n * (2*n-1); i++) {
        		arr[scan.nextInt()]++;
        	}
        	
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	for(int i = 0; i < arr.length; i++) {
        		if(arr[i] % 2 == 1) list.add(i);
        	}
        	
        	
//        	map = new int[2 * n - 1][n];
//        	for(int i = 0; i < 2 * n - 1; i++) {
//        		for(int j = 0; j < n; j++) {
//        			map[i][j] = scan.nextInt();
//        		}
//        	}
//        	for(int i = 0; i < n; i++) {
//        		index = i;
//            	Arrays.sort(map, new Comparator<int[]>() {
//            		@Override
//            		public int compare(int[] o1, int[] o2) {
//            			return Integer.compare(o1[index], o2[index]);
//            		}
//            	});
//        		
//            	int(i =)
//        		
//        	}
        	
        	Collections.sort(list);
        	
        	System.out.printf("Case #" + round + ":");
        	for(Integer i: list) {
        		System.out.printf(" %d", i);
        	}
        	System.out.println();
        }
	}

}
 