package googlejam1.p353;
import java.io.*;
import java.util.*;

class A {
    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
        PrintWriter pw = new PrintWriter("A.txt");
        int n = Integer.parseInt(br.readLine());
        String line;

        for (int q = 1; q <= n; q++) {
            line = br.readLine()+" "+br.readLine();
            Scanner sc=new Scanner(line);
            int N = sc.nextInt();
            int ar[]=new int[N];
            for(int i=0;i<N;i++)
                ar[i]=sc.nextInt();

            double rate=0;
            for(int i=1;i<N;i++)
                if(ar[i]<ar[i-1] && ar[i-1]-ar[i]>rate)
                    rate=ar[i-1]-ar[i];

            System.out.println(rate/=10);
            int a=0;
            double b=0,bval;
            bval=ar[0];
            for(int i=1;i<N;i++){
                if(ar[i-1]>ar[i]) {
                    a += -ar[i] + ar[i - 1];
                    //aval = ar[i];
                }
                if (bval >= rate*10) {
                    b += rate*10;
                    bval -= rate*10;
                }
                else {
                    b += bval;
                    bval = 0;
                }
                bval = ar[i];
            }
            //if(rate!=0)
            //    b+=bval;
            //a+=aval;

            System.out.println(q+"> "+a+" "+(int)b);
            pw.println("Case #" + q + ": " + a + " " + (int)b);
        }
        pw.close();
    }
}
