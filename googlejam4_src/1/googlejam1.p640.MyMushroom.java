package googlejam1.p640;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vishal
 */
public class MyMushroom {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=1;k<=t;k++){
            int n = sc.nextInt();
            int a[] = new int[n];
            int i=0;
            for(i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            int max = 0;
            int total2=0;
            int total1=0;
            int diff;
            for(i=0;i<n-1;i++){
                diff=a[i]-a[i+1];
                if(diff>max)
                    max = diff;

            }
            for(i=0;i<n-1;i++){
                if(a[i]>a[i+1])
                    total1+=a[i]-a[i+1];

            }
            for(i=0;i<n-1;i++){
                if(a[i]<max)
                    total2+=a[i];
                else
                    total2+=max;
            }
            System.out.println("Case #"+k+": "+total1+" "+total2);

        }
    }
}
