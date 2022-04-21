package googlejam1.p689;
import java.io.*;
import java.math.*;
 
 class Main {
 public static void main (String [] args) throws  IOException
    {	
    //	BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
    	BufferedReader b = new BufferedReader(new FileReader("in.txt"));
    	PrintWriter out = new PrintWriter("System.out");
    	long test = Long.parseLong(b.readLine());
    	for(long i=0;i<test;i++){
    		int size = Integer.parseInt(b.readLine());
    		String s = b.readLine();
    		String st[]= s.split("\\s+");
    		Long array[]= new Long[size];
    		for(int k=0;k<size;k++){
    		array[(int)k]=Long.parseLong(st[k]);
    	//	System.out.println(array[k]);
    	
    		
    		}
    		long ans=0;
    		for(int k=0;k<size-1;k++){
    			if(array[k]-array[k+1]>0){
    				ans=ans+(array[k]-array[k+1]);
    				//System.out.println(ans);
    			}
    		}
    		long constant=0;
    		long max=0;
    		for(int k=0;k<size-1;k++){
    			if(array[k]-array[k+1]>0){
    				if((array[k]-array[k+1])>max){
    					max=(array[k]-array[k+1]);
    				}
    			}
    		}
    		
    		long ans2=0;
    		for(int k=0;k<size-1;k++){
    			
    				if(array[k]>max){
    					ans2=ans2+max;	
    				}
    				else{
    					ans2= ans2+(array[k]);
    					
    				}
    			
    		}
    		
    		out.println("Case #"+(i+1)+": "+ans+" "+ans2);
    	
    		
    	}
        out.flush();
       
    }
}