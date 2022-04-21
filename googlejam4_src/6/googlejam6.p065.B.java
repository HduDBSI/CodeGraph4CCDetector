package googlejam6.p065;
import java.io.*;
import java.util.Scanner;


public class B {

    public static void main(String [] args) throws IOException {
            //Scanner s = new Scanner(new BufferedReader(new FileReader("B-small-attempt0.in")));
            Scanner s = new Scanner(new BufferedReader(new FileReader("B-large.in")));
           // Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int ncase = s.nextInt();
            for (int i = 1; i <= ncase; i++) {
                int N = s.nextInt();
                int[] Height = new int[2501];
				for (int i1 = 1; i1 <= 2*N - 1; i1++) {
				    for (int j = 1; j <= N; j++) {
				        int h = s.nextInt();
				        Height[h-1]++;
				    }
				}
				
				System.out.printf("Case #%d:", i);
				for (int i2 = 0; i2 <= 2500; i2++) {
				    if( Height[i2] % 2 == 1 ) {
				        System.out.printf(" %d", i2+1);
				    }
				}
				System.out.printf("\n");
            }
            s.close();
    }

}
