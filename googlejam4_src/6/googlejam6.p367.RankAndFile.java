package googlejam6.p367;


/**
 * Created by vbhavsar on 4/15/16.
 */

import java.util.*;

public class RankAndFile {

    private static boolean debug = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int _t = 1; _t <= t; _t++) {

            int n = sc.nextInt();
            sc.nextLine();

            List<Integer> list = new ArrayList<>(2*n-1);
            for (int _n=0; _n<2*n-1; _n++) {
                String[] arr = sc.nextLine().split(" ");
                for (int i=0; i<arr.length; i++) {
                    list.add(Integer.parseInt(arr[i]));
                }
            }
			// Build histo
			Map<Integer, Integer> histo = new HashMap<>();
			for (int i=0; i<list.size(); i++) {
			    int key = list.get(i);
			    if (histo.containsKey(key)) {
			        histo.put(key, histo.get(key)+1);
			    } else {
			        histo.put(key, 1);
			    }
			}
			
			List<Integer> odd = new ArrayList<>();
			for (Map.Entry<Integer, Integer> e : histo.entrySet()) {
			    if (e.getValue() % 2 == 1) {
			        odd.add(e.getKey());
			    }
			}
			Collections.sort(odd);
			
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<odd.size(); i++) {
			    sb.append(String.format("%d ", odd.get(i)));
			}

            String result = sb.toString().trim();
            System.out.printf("Case #%d: %s%n", _t, result);
        }
    }
}
