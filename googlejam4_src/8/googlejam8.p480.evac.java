package googlejam8.p480;
import java.io.*;
import java.util.*;

class evac {

    public static void main(String[] args) throws IOException {
        File file = new File("src/input.in");
        File of = new File("src/out.txt");

        FileWriter fw = new FileWriter(of, true);
        PrintWriter pw = new PrintWriter(fw);
        Scanner sc = new Scanner(file);
        
        int iter = sc.nextInt();
        
        for (int i = 0; i < iter; i++) {
            int num = sc.nextInt();
            ArrayList<Integer> pnum = new ArrayList<Integer>();
            String res = "Case #" + (i + 1) + ": ";
            
            for (int j = 0; j < num; j++) {
                pnum.add(sc.nextInt());
            }
            
            int total = 0;
            System.out.print("[");
            for (int j = 0; j < pnum.size(); j++) {
                total += pnum.get(j);
                System.out.print(pnum.get(j) + ", ");
            }
            System.out.println("]");
            
            while (total > 0) {
                System.out.println(total);
                int firstVal = Collections.max(pnum);
                System.out.print(firstVal + ", ");
                int firstIndex = pnum.indexOf(firstVal);
                System.out.println(firstIndex);
                
                pnum.set(firstIndex, pnum.get(firstIndex) - 1);
                total -= 1;
                
                int secondVal = Collections.max(pnum);
                System.out.print(secondVal + ", ");
                int secondIndex = -1;
                
                if (secondVal > (double)total / 2) {
                    secondIndex = pnum.indexOf(secondVal);
                    
                    pnum.set(secondIndex, pnum.get(secondIndex) - 1);
                    total -= 1;
                }
                
                System.out.println(secondIndex);
                
                res += (char)('A' + firstIndex);
                
                if (secondIndex != -1) {
                    res += (char)('A' + secondIndex);
                }
                
                res += " ";
            }
            
            pw.println(res);
            System.out.println(res);
        }

        sc.close();
        pw.close();
    }
}
