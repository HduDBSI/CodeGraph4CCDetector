package googlejam1.p483;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("A-small.in"));
        int cases = sc.nextInt();
        for (int i=1;i<=cases ;i++){
            int N = sc.nextInt();
            int m[] = new int[N];
            String temp = sc.nextLine().trim();

            for (int j=0;j<N;j++){
                m[j] = sc.nextInt();
            }

            //First method
            int prev=0;
            long first=0;
            for (int m0 : m){
                first += Math.max(prev-m0,0);
                prev=m0;
            }

            //Second method
            long second=0;
            int min_eat_per_turn=0;
            prev=0;
            for (int m0 : m){
                min_eat_per_turn = Math.max(min_eat_per_turn,prev-m0);
                prev=m0;
            }
            for (int m0 : Arrays.copyOf(m,N-1)){
                second += Math.min(m0,min_eat_per_turn);
            }


            System.out.println("Case #"+i+": "+first+" "+second);
        }
    }
}
