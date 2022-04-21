package googlejam6.p570;


import java.util.Arrays;
import java.util.Scanner;



public class main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int n;
        for (int i = 1; i <= T; i++)
        {
            System.out.printf("Case #%d:",i);
            int N = in.nextInt();
            int[]  arr= new int[(2*N-1)*N];
            for (int j = 0; j < arr.length ; j++) {
                arr[j]=in.nextInt();
            }
            Arrays.sort(arr);

            int count=0;
            for (int j = 1; j <arr.length ; j+=2) {
                if(arr[j-1]!=arr[j]) {
                    System.out.print(" "+arr[j-1]);
                    j--;
                    count++;
                }
            }
            if(count!=N){
                System.out.print(" "+arr[arr.length-1]);
            }

            System.out.println();
        }



    }
}

