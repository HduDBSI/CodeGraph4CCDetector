package googlejam6.p350;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Jam5 {

	
   
  public static void main(String[] args){
	
	
	
	Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	int t=in.nextInt();
	in.nextLine();
	
	for(int k=1; k<=t;k++){
		System.out.print("Case #"+ k + ": ");
		int[] height=new int[2501];
		for(int temp=0;temp<=2500;temp++){
			height[temp]=0;
		}
		
		int n=in.nextInt();//size
		in.nextLine();
		//String n = in.nextLine();
	    for(int j=1;j<=2*n-1;j++){
	    	for(int x=1;x<=n;x++){
	    		int h=in.nextInt();//hright
	    		height[h]++;
	    	}
	    	in.nextLine();
	    }
	    
	    
	    for(int temp=0;temp<=2500;temp++){
			if(height[temp]%2==1){
				System.out.print(temp+" ");
			}
		}
	    
	    System.out.println();
		//String ans=calculate(n);
		
        
	}
    
	in.close();
  }
  
 
}
