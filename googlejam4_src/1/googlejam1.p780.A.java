package googlejam1.p780;


import java.util.Scanner;

/**
 * Created by Rathinakumar on 4/17/2015.
 */
public class A {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int N = sc.nextInt();
            int[] arr = new int[N];
            int first = 0, second=0;
            int maxDff=0;
            for(int n=0; n<N; n++)
            {
                arr[n] = sc.nextInt();

                if(n>0)
                {
                    if(maxDff<(arr[n-1]-arr[n]))
                        maxDff = (arr[n-1]-arr[n]);
                    if(arr[n-1]>arr[n])
                        first+=(arr[n-1]-arr[n]);
                }
            }
            for(int n=0; n<N-1; n++)
            {
                if(arr[n]<maxDff)
                    second+=arr[n];
                else
                    second+=maxDff;
            }
            System.out.println("Case #"+t+": "+first+" "+second);
        }
    }
}
