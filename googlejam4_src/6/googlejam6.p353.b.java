package googlejam6.p353;
import java.util.*;

public class b {
    private static int flipCount;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNumber = in.nextInt();
        
        for(int i = 0; i < caseNumber; i++) {
            int N = in.nextInt();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j = 0; j < (2 * N - 1) * N; j++) {
                int k = in.nextInt();
                if(map.containsKey(k)) map.put(k, map.get(k) + 1);
                else map.put(k, 1);
            }
            
            int[] miss = new int[N];
            int index = 0;
            for(int key : map.keySet()) {
                if(map.get(key) % 2 == 1) miss[index++] = key;
            } 
            Arrays.sort(miss);
            
            System.out.print("Case #" + (i+1) + ":");
            for(int t = 0; t < N; t++) {
                System.out.print(" " + miss[t]);
            }
            System.out.println();
        }
    }
    
}