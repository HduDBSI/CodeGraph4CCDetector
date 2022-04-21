package googlejam3.p219;
import java.util.Scanner;

public class first {
	 public static void main(String[] args) {
	        Scanner sin = new Scanner(System.in);
	        int t = sin.nextInt();
	        for(int i = 1; i <= t; i++){
	            int R = sin.nextInt();
	            int C = sin.nextInt();
	            int W = sin.nextInt();
	            int x1 = R * (C/W);
		         if(C % W > 0){
		             x1 = x1 + W;
		         }else{
		             x1= x1 + W - 1;
		         }
	            System.out.println("Case #"+i+": "+x1);
	            
	            
	        }
	    }
	     
	   
	     
}