package googlejam8.p522;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Saumil
 */
public class roundOne{

    int val;
    char c;
    
    public roundOne(int val, char c)
    {
        this.val = val;
        this.c = c;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        
        
        for(long i = 0; i < n;)
        {
            i++;
            
            ArrayList<roundOne> hm = new ArrayList<roundOne>();
            
            int numberOfParties = sc.nextInt();
            
            char c = 'A';
            
            int sum = 0;
            for(int k = 0; k < numberOfParties; k++)
            {
                int p = sc.nextInt();
                sum = sum + p;
                hm.add(new roundOne(p, c++));
            }
            
            System.out.print("Case #" + i + ":");
            Collections.sort(hm, new Comparator<roundOne>(){
			        public int compare(roundOne o1, roundOne o2){
			            if(o1.val == o2.val)
			                return 0;
			            return o1.val < o2.val ? 1 : -1;
			        }
			   });
            roundOne r1, r2;
            
            do
            {
                System.out.print(" ");
                r1 = hm.get(0);
                
                System.out.print(r1.c);
				r1.val--;
                
                r2 = hm.get(1);
                sum--;
                
                if(sum != 2)
                {
                    sum--;
                    if(r1.val > r2.val) {
						System.out.print(r1.c);
						r1.val--;
					} else if(r2.val > 0) {
						System.out.print(r2.c);
						r2.val--;
					}
                }
                
                    
                
                Collections.sort(hm, new Comparator<roundOne>(){
				        public int compare(roundOne o1, roundOne o2){
				            if(o1.val == o2.val)
				                return 0;
				            return o1.val < o2.val ? 1 : -1;
				        }
				   });    
            }while(hm.get(0).val > 0);
            
            System.out.println();
        }
    }
}
