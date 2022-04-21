package googlejam8.p823;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Vo Minh Khoi, SMU, minhkhoi.vo.2013@sis.smu.edu.sg
 */
public class A {


    public static void main(String[] args) {
        Scanner sc = null;
        PrintWriter w = null;
        try {
            w = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("out-C-A.txt", false)));
            sc = new Scanner(new File("A-large.in"));
//             sc = new Scanner("4\n" +
//                     "2\n" +
//                     "2 2\n" +
//                     "3\n" +
//                     "3 2 2\n" +
//                     "3\n" +
//                     "1 1 2\n" +
//                     "3\n" +
//                     "2 3 1"
//             );

            sc.useDelimiter(" |\n");

            int T = sc.nextInt();
            for (int z = 0; z < T; z++) {
                N = sc.nextInt();
                Ns = new int[N];

                for(int i =0;i<N;i++){
                    Ns[i] = sc.nextInt();
                }
				String res = "";
				        HashMap<Integer,Integer> map = new HashMap<>();
				        int count = 0;
				        for(int i =0;i<N;i++){
				            map.put(i,Ns[i]);
				            count += Ns[i];
				        }
				
				//        System.out.println(count);
				        while(true){
				            int maxValue = Collections.max(map.values());
				
				            if(count > 0 && ((double)maxValue/count) > 0.5){
				                System.out.println("bingo!");
				                System.out.println(((double)maxValue/count));
				                System.out.println(count);
				            }
				
				            if(maxValue == 0) break;
				
				            int key1 = 0;
				            int key2 = 0;
				            int co = 0;
				            for(Map.Entry<Integer,Integer> en : map.entrySet()){
				                if(en.getValue() == maxValue){
				                    co++;
				                    if(co == 1) key1 = en.getKey();
				                    if(co == 2) {
				                        key2 = en.getKey();
				                        break;
				                    }
				                }
				            }
				
				            if(count  == 3) {
				                char c1 = (char)(key1 + A);
								res += String.valueOf(c1) + " ";
				                map.put(key1, map.get(key1) - 1);
				                count --;
				                continue;
				            }
				
				            if(co == 1){
				                HashMap<Integer,Integer> map1 = new HashMap<>(map);
				                map1.remove(key1);
				                int nextMaxValue = (Integer)Collections.max(map1.values());
				                int time = maxValue - nextMaxValue;
				
				                while(time > 0){
				                    if(time == 1) {
				                        char c1 = (char)(key1 + A);
										res += String.valueOf(c1) + " ";
				                        map.put(key1,map.get(key1) - 1);
				                        time--;
				                        count--;
				                    }
				                    else {
				                        char c1 = (char)(key1 + A);
										char c2 = (char)(key1 + A);
										res+= String.valueOf(c1) + String.valueOf(c2) + " ";
				                        map.put(key1,map.get(key1) - 2);
				                        time -= 2;
				                        count-= 2;
				                    }
				
				                }
				            }else{
				                char c1 = (char)(key1 + A);
								char c2 = (char)(key2 + A);
								res += String.valueOf(c1) + String.valueOf(c2) + " ";
				                map.put(key1,map.get(key1) - 1);
				
				                map.put(key2,map.get(key2) - 1);
				                count-=2;
				            }
				        }


                ////////////////////////////////////////////////////
                String ress = res.substring(0,res.length()-1);
                System.out.println("Case #" + (z + 1) + ": " + ress);
                w.println("Case #" + (z + 1) + ": " + ress);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
            w.close();
        }
    }

    ///////////variables
    static int N;
    static int[] Ns;

    static char A = 'A';

}
