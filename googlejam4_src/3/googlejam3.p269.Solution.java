package googlejam3.p269;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	
    
	public static void main(String[] args) throws IOException, FileNotFoundException {
    	//Read, NOTICE: nextInt() does not advance but nextLine() do!
		Scanner in=new Scanner(new FileReader("A-large (2).in"));
		//Scanner in=new Scanner(System.in);
    	//Write
    	FileWriter fw=new FileWriter("outputTest.txt");
    	BufferedWriter bw=new BufferedWriter(fw);
		
		int T=in.nextInt();
       for (int t=0;t<T;t++){
    	   int R=in.nextInt();
    	   int C=in.nextInt();
    	   int W=in.nextInt();
    	   
    	   int discoverCost=C/W;
    	   
    	   int lastChange=C%W;
    	   
    	   int output=(lastChange==0?0:1)+discoverCost*R+W-1;
    	   
    	   bw.write("Case #"+(t+1)+": "+output+"\n");
    	   
       }
		
		//bw.write("Case #"+(t+1)+": "+output+"\n");
		    
			
		
		
		
    		//System.out.println();
    		//bw.write("Case #"+(t+1)+":"+"\n");
    
    	
    	    
    	
    	
    	
    		
    		
    	
    	
    	//test Write part
    	//bw.write("asd is art\n");
    	//bw.write("hahaha");
    	
    	
    	//epilogue
		bw.close();
		
        }
    

}
    