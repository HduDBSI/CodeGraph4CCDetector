package googlejam6.p177;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Nejc on 16.04.2016.
 */
public class B1A {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();
            for(int i = 0; i < N*2-1; i++){
                String[] split = br.readLine().split(" ");
                for(String s : split){
                    int num = Integer.parseInt(s);
                    if(count.containsKey(num)){
                        count.put(num, count.get(num)+1);
                    }
                    else{
                        count.put(num, 1);
                    }
                }
            }
            System.out.print("CASE #" + t + ":");
            for(Map.Entry<Integer, Integer> e : count.entrySet()){
                if(e.getValue() % 2 == 1) System.out.print(" "+ e.getKey());
            }
            System.out.println();
        }
    }
}
