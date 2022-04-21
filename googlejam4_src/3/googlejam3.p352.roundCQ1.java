package googlejam3.p352;
import java.util.Scanner;

public class roundCQ1 {
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        for(int i = 1; i <= testCase; i++){
            int R = scan.nextInt();
            int C = scan.nextInt();
            int W = scan.nextInt();
			int num1 = R * (C/W);
			 if(C % W > 0){
			     num1 = num1 + W;
			 }else{
			     num1 = num1 + W - 1;
			 }
            
            int num = num1;
            System.out.println("Case #"+i+": "+num);
            
            
        }
    }
     
}
