package googlejam6.p599;


import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        Solution solution1 = new Solution();
		String file = "/Users/gaohan/Downloads/B-large.in";
		Scanner scanner = new Scanner(new FileInputStream(new File(file)));
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
		    int N = scanner.nextInt();
		    int lines = 2 * N - 1;
		    int[][] array = new int[lines][N];
		    for (int m = 0; m < lines; m++) {
		        for (int n = 0; n < N; n++) {
		            array[m][n] = scanner.nextInt();
		        }
		    }
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int[] row : array) {
			    for (int cell : row) {
			    	Integer count = map.get(cell);
			        if (count == null) {
			            count = 0;
			        }
			        map.put(cell, count + 1);
			    }
			}
			List<Integer> res1 = new ArrayList<Integer>();
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			    int val = entry.getValue();
			    if (val % 2 != 0) {
			        res1.add(entry.getKey());
			    }
			}
			Collections.sort(res1);
		    List<Integer> res = res1;
		    System.out.print("Case #" + (i + 1) + ":");
		    for (int num : res) {
		        System.out.print(" " + num);
		    }
		    System.out.println();
		}
    }
}
