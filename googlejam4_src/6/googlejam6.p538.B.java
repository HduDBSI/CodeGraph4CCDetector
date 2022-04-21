package googlejam6.p538;


import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class B {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File("roundA/B.in"));
            PrintWriter w = new PrintWriter(new FileWriter("roundA/B.out"));
            int caseC = scan.nextInt();
            for (int i = 1; i <= caseC; i++) {
                HashSet<Integer> set = new HashSet<Integer>();
                int n = scan.nextInt();
                for(int j=0;j<(2*n-1)*n;j++){
                    int no = scan.nextInt();
                    if(set.contains(no)){
                        set.remove(no);
                    }else{
                        set.add(no);
                    }
                }

                Integer[] list = set.toArray(new Integer[set.size()]);
                Arrays.sort(list);
                w.print(String.format("Case #%d:", i));
                for(Integer number: list){
                    w.print(String.format(" %d", number));
                }
                w.println();
            }
            scan.close();
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
