package googlejam6.p459;
import java.util.*;

class Rank_And_File {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t, n, i, j;

		t = sc.nextInt();
		for(i=1; i<=t; i++) {
			n = sc.nextInt();
			int[] arr = new int[(2*n-1)*n];
			for(j=0; j<arr.length; j++)
				arr[j] = sc.nextInt();
			int[] distinct = new int[arr.length]; 
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int p = 0;
			for(j=0; j<arr.length; j++) {
				if(!map.containsKey(arr[j])) {
					distinct[p++] = arr[j];
					map.put(arr[j], 1);
				}
				else
					map.put(arr[j], map.get(arr[j]) + 1);
			}
			int cnt = 0;
			int[] missing = new int[n];
			for(j=0; j<p; j++)
				if(map.get(distinct[j]) % 2 != 0)
					missing[cnt++] = distinct[j];
			Arrays.sort(missing);

			System.out.print("Case #" + i + ":");
			for(j=0; j<n; j++)
				System.out.print(" " + missing[j]);
			System.out.println();
		}
	}
}


