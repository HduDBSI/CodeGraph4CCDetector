package googlejam6.p318;
/**
 * File Name: Round1A2016B.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:10:09 PM Apr 15, 2016
 * Author: Yaolin Zhang
 */

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:10:09 PM Apr 15, 2016
 */
public class Round1A2016B {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			int N = scan.nextInt();
			scan.nextLine();
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i = 0; i < 2 * N - 1; ++i){
				String[] str = scan.nextLine().split(" ");
				//System.out.println(str);
				for(String s : str){
					int cur = Integer.parseInt(s);
					if(map.containsKey(cur)){
						map.put(cur, map.get(cur) + 1);
					}else{
						map.put(cur, 1);
					}
				}
			}
			int[] result = new int[N];
			int index = 0;
			for(Map.Entry<Integer, Integer> e : map.entrySet()){
				//System.out.println(e.getKey() + " " + e.getValue());
				if(e.getValue() % 2 != 0){
					result[index++] = e.getKey();
				}
			}
			Arrays.sort(result);
			String s = "";
			for(int i = 0; i < N - 1; ++i){
				s += result[i] + " ";
			}
			s += result[N - 1];
			System.out.printf("Case #%d: %s\n", t, s);
		}
		scan.close();
	}
}
