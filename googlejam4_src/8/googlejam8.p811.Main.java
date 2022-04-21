package googlejam8.p811;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
		    System.out.print("Case #" + i + ":");

			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		    int n = in.nextInt();
			//int[] pList = new int[n];
			int total = 0;
		    for (int j = 0; j < n; ++j) {
			    //pList[j] = in.nextInt();
				int p = in.nextInt();
				ArrayList<Integer> tmp = map.get(p);
				if (tmp == null) {
				    tmp = new ArrayList<Integer>();
					map.put(p, tmp);
				}
				tmp.add(j);
				total += p;//pList[j];
			}

			while (total != 0) {
			    Map.Entry<Integer, ArrayList<Integer>> entry = map.lastEntry();
				int key = entry.getKey();
				ArrayList<Integer> value = entry.getValue();

				ArrayList<Integer> tmp = map.get(key - 1);
				if (tmp == null) {
				    tmp = new ArrayList<Integer>();
					map.put(key - 1, tmp);
				}

				boolean hasSingleOne = value.size() % 2 == 1;
				for (int index = 0; index < value.size(); ++index) {
				    System.out.print(" "+(char)('A' + value.get(index)));
					tmp.add(value.get(index));
					total--;
				    if (hasSingleOne) {
						hasSingleOne = false;
					} else {
					    index++;
					    System.out.print((char)('A' + value.get(index)));
					    tmp.add(value.get(index));
						total--;
					}
				}
				map.remove(key);
			}
				
			//System.out.print(convertToChar(j)+" "+pList[j]);

			System.out.print("\n");
        }
    }
}
