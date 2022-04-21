package googlejam1.p595;
import java.util.*;
import java.io.*;
import java.math.*;
//writer.print("Case #"+(i+1)+": ");
//writer.close();
class jam3{
	public static void main(String [] abb){
		try{
			Scanner in = new Scanner(new File("safia.in"));
			PrintWriter writer = new PrintWriter("out2.in", "UTF-8");
			
			int testcase = in.nextInt();
			int tab [][] = new int[5][5];
			
			for(int p=0;p<testcase;p++){
			int n = in.nextInt();
			int inp[] = new int[n];
			int max=0;
			for(int i=0;i<n;i++){
				
				
				inp[i]=in.nextInt();
				if(i!=0){
					max=Math.max(max,(inp[i-1]-inp[i]));
				}
			}
			System.out.println(max);
				int out1=0;
				int out2=0;
				
			for(int j=0;j<n-1;j++){
				if(inp[j+1]<inp[j]){
					out1=inp[j]-inp[j+1]+out1;
				}
				if(inp[j]<max){
					out2=out2+inp[j];
				}else{
					out2=out2+max;
				}
			}
			
				writer.println("Case #"+(p+1)+": "+out1+" "+out2);
				
			}
			
			
			
			
			writer.close();
		}catch(IOException e){
			
			}
	}
}