package googlejam6.p216;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B{
    static {
        try {
            System.setIn(new FileInputStream(new File("B-large.in")));
        }
        catch(Exception e){
            System.err.println("Error setting input");
        }
        try {
            System.setOut(new PrintStream(new File("B-large.out")));
        }
        catch(Exception e){
            System.err.println("Error setting output");
        }
    }
    public static void main(String[]args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());

        for(int Case=1;Case<=cases;++Case){
            int count = sc.nextInt();
            ArrayList<Integer> all = new ArrayList<>();
            int total = (count*2-1)*count;
            for(int i=0;i<total;++i){
                all.add(sc.nextInt());
            }
            //System.err.println(all);
            Collections.sort(all);
            int ind = 0;
            out: while(all.size()>count){
                int val = all.get(ind);
                for(int i=ind+1;i<all.size();++i){
                    if(all.get(i)==val){
                        all.remove(i);
                        all.remove(ind);
                        ind = 0;
                        continue out;
                    }
                }
                ind++;  
                //System.err.println(all);

            }
            Collections.sort(all);

            System.out.print("Case #"+Case+":");
            for(int i=0;i<all.size();++i){
                System.out.print(" "+all.get(i));
            }
            System.out.println();
        }
    }
}
