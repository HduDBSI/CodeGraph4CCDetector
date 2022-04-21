package googlejam6.p023;
import java.util.*;
import java.io.*;

public class RankAndFile{
    
    static final String filename = "C:/Users/Kevin/algs4/CodeJam/RankAndFile/B-large.in";
    static final String output = "largeoutput.txt";
    
    
    
    
    
    public static void main(String[] args){
       
        try{
            Scanner sc = new Scanner(new FileInputStream(new File(filename)));
            int no_of_times = sc.nextInt();
            
            for(int i = 0; i < no_of_times; ++i){
                int N = sc.nextInt();
                int[][] array = new int[2*N-1][N];
                for (int j = 0; j < 2*N-1; ++j) {
                    for (int k = 0; k < N; ++k) {
                        array[j][k] = sc.nextInt();
                    }
                }
				HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
				
				int[] ret = new int[array[0].length];
				
				for (int j1 = 0; j1 < array.length; ++j1) {
				    for (int k = 0; k < array[0].length; ++k) {
				        if (!count.containsKey(array[j1][k])) {
				            count.put(array[j1][k], 1);
				        } else {
				            count.put(array[j1][k], count.get(array[j1][k])+1);
				        }
				    }
				}
				
				int index = 0;
				
				for (Integer key : count.keySet()) {
				    if (count.get(key) % 2 != 0) {
				        ret[index] = key;
				        index++;
				    }
				}
				
				Arrays.sort(ret);
                
                int[] soln = ret;
                
                FileOutputStream fos = new FileOutputStream(output, true);
                fos.write(("Case #" + (i+1) + ":").getBytes());
                for (int j = 0; j < soln.length; ++j) {
                    fos.write((" " + soln[j]).getBytes());
                }
                fos.write(("\n").getBytes());
                fos.close();
                
                
            }
            sc.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}