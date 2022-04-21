package googlejam6.p578;
import java.util.*;
import java.io.*;

public class B
{
    public static void main(String ... orange) throws Exception
    {
		//System.setIn(new FileInputStream("B-small-attempt0.in"));
		//System.setOut(new PrintStream(new File("B-small-output-file.txt")));


		System.setIn(new FileInputStream("B-large.in"));
		System.setOut(new PrintStream(new File("B-large-output-file.txt")));

        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();



        for (int n = 0; n < numCases; n++)
        {

            //String s = input.next();
			//long N = input.nextLong();
            int N = input.nextInt();



			//		System.out.printf("Case #%d: INSOMNIA\n", n + 1);

		int a;
        int[] b= new int[2501];
        int[] c= new int[N];

        for(int j=0; j<2*N-1; j++){
            for(int k=0; k<N; k++){
                a = input.nextInt();
                b[a]++;
            }
        }

        int index=0;
        for(int j=0; j<2501; j++)
            if(b[j]!=0&&b[j]%2!=0)
                    c[index++]=j;

       System.out.printf("Case #%d: ", n + 1);
        for(int j=0; j<N; j++)
        	System.out.printf("%d ", c[j]);

        System.out.print("\n");

        } // cases
    } // main


}
