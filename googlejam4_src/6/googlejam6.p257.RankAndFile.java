package googlejam6.p257;
import java.util.*;

/**
 * Created by BinghongFu on 4/15/16.
 */
public class RankAndFile {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = Integer.valueOf(s.nextInt());
        String[] result = new String[m];
        for(int i = 0; i < m; ++i){
            int n = Integer.valueOf(s.nextInt());
            int[] input = new int[n * (2 * n - 1)];
            for(int j = 0; j < n * (2 * n - 1); ++j){
                input[j] = s.nextInt();
            }
			HashMap<Integer, Integer> counter = new HashMap<>();
			for(int i1 : input){
			    if(!counter.containsKey(i1))
			        counter.put(i1, 0);
			    counter.put(i1, counter.get(i1) + 1);
			}
			
			ArrayList<Integer> result1 = new ArrayList<>();
			
			for(HashMap.Entry<Integer, Integer> entry : counter.entrySet()){
			    if(entry.getValue() % 2 != 0){
			        result1.add(entry.getKey());
			    }
			}
			
			Collections.sort(result1);
			StringBuilder sb = new StringBuilder();
			for(int i2 : result1){
			    sb.append(i2);
			    sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
            result[i] = sb.toString();
        }


        for(int i = 0; i < m; ++i){
            System.out.print("Case #" + String.valueOf(i + 1) + ": ");
            System.out.println(result[i]);
        }

    }
}
