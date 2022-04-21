package googlejam8.p782;
import java.util.Scanner;


/**
 *
 * @author edisonarango
 */
public class A {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] l = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.printf("Case #%d: ",i+1);
            int N = in.nextInt();
			int[] array = new int[N];
			for (int i1 = 0; i1 < N; i1++) {
			    array[i1] = in.nextInt();
			}
            int[] sen = array;
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += sen[j];
            }
            while(sum > 0){
                if (sum > 2 && sum % 2 == 0){
                    int conteo = 0;
                    for (int j = 0; j < N; j++) {
                        if(sen[j] == sum/2){
                            conteo++;
                        }
                    }
                    if (conteo == 2){
                        for (int j = 0; j < N; j++) {
                            if(sen[j] == sum/2){
                                sen[j]--;
                                System.out.print(l[j]);
                            }
                        }
                        sum = sum - 2;
                        System.out.print(" ");
                        continue;
                    }
                }
                if(sum == 2){
                    for (int j = 0; j < N; j++) {
                        if(sen[j]>0) {
                            System.out.print(l[j]);
                            sen[j]--;
                        }
                    }
                    sum = sum - 2;
                    System.out.print(" ");
                }
                else{
                    int mayor1 = Integer.MIN_VALUE;
					int index = 0;
					for (int i1 = 0; i1 < sen.length; i1++) {
					    if(sen[i1] > mayor1){
					        mayor1 = sen[i1];
					        index = i1;
					    }
					}
					int mayor = index;
                    System.out.print(l[mayor]+" ");
                    sen[mayor]--;
                    sum--;
                }
                for (int j = 0; j < N; j++) {
                    double p = 0;
                    if(sum != 0){
                        p = 100*sen[j]/sum;
                    }
                    if(p > 50) System.out.println("ERROOOOOOOOOR");
                }
            }
            System.out.println();
        }
    }
    
}
