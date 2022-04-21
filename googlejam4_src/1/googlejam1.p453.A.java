package googlejam1.p453;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new FileReader("A-large.in"));
            PrintWriter out = new PrintWriter(new FileWriter("outA.txt"));

            int cases = in.nextInt();
            in.nextLine();
            
            for(int i = 0; i < cases; i ++){
            	int n = in.nextInt();
            	int[] a = new int[n];
 
            	for(int j = 0; j < a.length; j ++){
            		a[j] = in.nextInt();
            	}
            	A aa = new A();
				int total = 0;
				for(int i1 = 1; i1 < a.length; i1 ++){
					if(a[i1 - 1] > a[i1]){
						total += (a[i1 - 1] - a[i1]);
					}
				}
            	int total1 = total;
				int total3 = 0, rate = 0;
				for(int i1 = 1; i1 < a.length; i1 ++){
					if(a[i1 - 1] > a[i1] && (a[i1 - 1] - a[i1] > rate)){
						rate = a[i1 - 1] - a[i1];
					}
				}
				for(int i2 = 0; i2 < a.length - 1; i2 ++){
					if(a[i2] < rate){
						total3 += a[i2];
					}else{
						total3 += rate;
					}
				}
            	int total2 = total3;
            	out.println("Case #" + (i + 1) + ": " + total1 + " " + total2);
            }
            in.close();
            out.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
}