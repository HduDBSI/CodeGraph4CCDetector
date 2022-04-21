package googlejam6.p474;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Vo Minh Khoi, SMU, minhkhoi.vo.2013@sis.smu.edu.sg
 */
public class B {

    public static void main(String[] args) {
        Scanner sc = null;
        PrintWriter w = null;
        try {
            w = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("out-rankfile-l.txt", false)));
            sc = new Scanner(new File("B-large.in"));
//             sc = new Scanner("1\n" +
//                     "3\n" +
//                     "1 2 3\n" +
//                     "2 3 5\n" +
//                     "3 5 6\n" +
//                     "2 3 4\n" +
//                     "1 2 3\n"
//             );

            sc.useDelimiter(" |\n");

            int T = sc.nextInt();
            for (int z = 0; z < T; z++) {
                N = sc.nextInt();
                sc.nextLine();
                list = new ArrayList<>(2*N - 1);
                for(int i=0;i< 2*N - 1;i++){
                    String s = sc.nextLine();
                    list.add(s.split(" "));
                }
				String result = "";
				TreeSet<Integer> res = new TreeSet<>();
				HashSet<String> set = new HashSet<>();
				
				for(String[] s: list){
				    for(String ss : s){
				        if(set.contains(ss)) set.remove(ss);
				        else set.add(ss);
				    }
				}
				
				for(String ss: set){
				    res.add(Integer.valueOf(ss));
				}
				
				for(Integer in : res){
				    result += (in + " ");
				}
				result = result.substring(0, result.length() - 1);

                ////////////////////////////////////////////////////
                String ress = result;
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
//    static int[] Ns;
    static ArrayList<String[]>  list;

}
