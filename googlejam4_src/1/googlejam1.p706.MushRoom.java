package googlejam1.p706;


import java.util.Scanner;

public class MushRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();

        int i = 1;

        while (i <= t) {
            int numEle = sc.nextInt();

            int arr[] = new int[numEle];
            long sum1 = 0, sum2 = 0;

            arr[0] = sc.nextInt();
            int maxRate = -1;
            for (int j = 1; j < numEle; j++) {
                arr[j] = sc.nextInt();

                if (arr[j - 1] - arr[j] >= 0) {
                    sum1 += arr[j - 1] - arr[j];
                    maxRate = Math.max(maxRate, arr[j - 1] - arr[j]);
                    
                }
                //else{
                   // maxRate = Math.max(maxRate, arr[j-1]);
                //}
               // System.out.println(maxRate);
               
            }
            
            for(int k =0; k<numEle -1 ; k++){
                if(arr[k]<=maxRate){
                    sum2 += arr[k];
                }else{
                    sum2 += maxRate;
                }
            }

            System.out.println("Case #" + i + ": " + sum1 + " " + sum2);
            i++;
        }
    }
}
