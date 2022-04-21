package googlejam1.p179;
import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("a.in"));
    	PrintWriter printer = new PrintWriter(new FileWriter("a.out"));
    	int t = s.nextInt();
    	for(int i=0; i<t; i++) {
    		int n = s.nextInt();
    		int[] arr = new int[n];
    		int b = 0;
    		for(int j=0; j<n; j++)
    			arr[j] = s.nextInt();
    		int a = 0;
    		for(int j=0; j<n-1; j++)
    			if(arr[j]-arr[j+1] >= 0) a += arr[j]-arr[j+1];
    		int k = 0;
    		for(int j=0; j<n-1; j++)
    			if(arr[j] > arr[j+1]) k = Math.max(k, arr[j]-arr[j+1]);
    		for(int j=0; j<n-1; j++)
    			b += Math.min(arr[j], k);
    		System.out.println(a + " " + b);
    		printer.println("Case #" + (i+1) + ": " + a + " " + b);
    	}
    	printer.close();
    }
}
