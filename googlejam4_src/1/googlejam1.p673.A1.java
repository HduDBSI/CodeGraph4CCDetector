package googlejam1.p673;
import java.util.*;
import java.lang.Math;

public class A1{

  public static void main(String[] args){
	Scanner inp=new Scanner(System.in);
    int t=inp.nextInt();
    for(int i=0;i<t;i++){
    	int n=inp.nextInt();
    	int[] arr=new int[n];
    	for(int j=0;j<n;j++){
    		arr[j]=inp.nextInt();
    	}
    	int sum1=0;
    	int sum2=0;
    	for(int k=0;k<n-1;k++){
    		
    		int y=(arr[k]-arr[k+1]>0)? arr[k]-arr[k+1]:0;
    		sum1+=y;
    	
    	}
    	int v=0;
    	for(int h=0;h<n-1;h++){
    		v=Math.max(v,arr[h]-arr[h+1]);
    	}
    	for(int d=0;d<n-1;d++){
    		int x=(arr[d]<=v)?arr[d]:v;
    		sum2+=x;
    	}

    	System.out.println("Case #"+(i+1)+": "+sum1+" "+sum2);
    }
}
}