package googlejam1.p275;
import java.util.Scanner;


public class Mushrooms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
        	
            int n = sc.nextInt();
            int[] ar = new int[n];
            for(int j=0; j<n; j++){
            	ar[j] = sc.nextInt();
            }
			long sum = 0;
			for(int i1=0; i1<ar.length-1;i1++){
				if(ar[i1]>ar[i1+1]){
					sum += ar[i1]-ar[i1+1];
				}
			}
            long c1 = sum;
			int rate = 0;
			for(int i2=0; i2<ar.length-1;i2++){
				if(ar[i2]>ar[i2+1]){
					if(ar[i2]-ar[i2+1] > rate){
						rate = ar[i2]-ar[i2+1];
					}
				}
			}
			
			long sum1 = 0;
			for(int i1=0; i1<ar.length-1;i1++){
					if(ar[i1] >= rate){
						sum1 += rate;
					} else {
						sum1 += ar[i1];
					}
			}
            long c2 = sum1;
            
            System.out.println("Case #"+(i+1)+": "+c1+" "+c2);

        }
    }

}
