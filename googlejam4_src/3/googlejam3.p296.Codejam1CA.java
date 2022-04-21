package googlejam3.p296;
/*
 * @author Mr E
 */
import java.io.*;
import java.util.*;

public class Codejam1CA {
    
    public static void main(String[] args) throws FileNotFoundException {
        
//        Scanner s=new Scanner(System.in);
        PrintWriter writer=new PrintWriter("al.out");
        Scanner s=new Scanner(new File("al.in"));
        int testcase=s.nextInt();
        for (int i = 0; i < testcase; i++) {
            int r=s.nextInt();
            int c=s.nextInt();
            int l=s.nextInt();
            int x=c/l;
            int xx=x*r;
            int ans=xx+l-1;
            
            if(c%l!=0 && l!=1){
                ans++;
            }
            
            
            
            
            
            
            System.out.println("Case #"+(i+1)+": "+ans);
            writer.println("Case #"+(i+1)+": "+ans);
        }
        writer.close();
        
    }
    
}
