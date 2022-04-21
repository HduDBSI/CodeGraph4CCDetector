package googlejam3.p556;
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
			
			for(int q=0;q<testcase;q++){
				int r= in.nextInt();
				int c = in.nextInt();
				int w = in.nextInt();
				int e= c%w;
				int out=0;
				//if(e==w-1)
				 out =(c/w)+w;
				
				//System.out.println(out+" "+e);
				//if(c/)
				if(w==1){
					out =c;
					
				}else{
				out =(c/w)+w;
				if(c%w==0){
					out--;
				}
				}
				
				writer.println("Case #"+(q+1)+": "+out);
				
			}
			
			
			
			
			writer.close();
		}catch(IOException e){
			
			}
	}
}