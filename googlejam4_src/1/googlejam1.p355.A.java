package googlejam1.p355;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("A-large.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("out.txt")));
        //Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("a.txt"));
        int T  = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int arr[] = new int [N];
            int met1 = 0;
            
            float maxdif = 0;
            for (int j = 0; j < N; j++) {
                int n = sc.nextInt();
                arr[j] = n;
                
                if(j != 0 && arr[j] < arr[j-1]){
                    met1 += arr[j-1] - arr[j];
                    if(arr[j-1] - arr[j] > maxdif){
                        maxdif = arr[j-1] - arr[j];
                    }
                }
            }
            maxdif = maxdif/10.0f;
            int met2 = 0;
            if(maxdif!=0){
                for (int j = 0; j < arr.length-1; j++) {
                    if(arr[j] < (maxdif*10)){
                        met2 += arr[j];
                    }else{
                        met2 += maxdif*10;
                    }
                }
            }
            
            System.out.println("Case #" + (i+1) + ": " + met1 + " " + met2);
            bw.write("Case #" + (i+1) + ": " + met1 + " " + met2);
            bw.newLine();
            
        }
        bw.close();
    }
}
