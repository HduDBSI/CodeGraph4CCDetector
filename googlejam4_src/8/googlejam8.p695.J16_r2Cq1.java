package googlejam8.p695;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class J16_r2Cq1 {
	
	   public static void main(String [] args) {
		    File infile = new File("C:\\Users\\iftikhar\\Downloads\\A-large.in");
	 	    File outFile = new File("C:\\Users\\iftikhar\\Downloads\\A-large.out");

	        try {
	 	    BufferedReader br = new BufferedReader(new FileReader(infile));
	 	    BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
	 	    int testCases = Integer.parseInt(br.readLine());
	 	    
	 	    for(int t=1;t<=testCases;t++){
	 	    	int N = Integer.parseInt(br.readLine()); 
	 	    	String s=br.readLine();
	 	    	String[] line1 = s.split(" ");
	 	    	int[] num=new int [line1.length];String gs="";
	 	    	for(int i=0;i<line1.length;i++){num[i]=Integer.parseInt(line1[i]);gs+=num[i];}
	 	    	boolean flag=true;
	 	    	String FS="";
	 	    	System.out.println(gs);
	 	    	while(flag){
	 	    		int max=0;
	 	    		String maxs="";
	 	    		for (int i = 0; i < num.length; i++) {
	 	    		    if (num[i] > max) {  
	 	    		    	max = num[i];
	 	    		    	maxs = i+" ";
	 	    		    }
	 	    		    else if(num[i]==max)maxs+=i+" ";    
	 	    		}
	 	    		System.out.println(maxs);
	 	    		String[] hhh = maxs.split(" ");
	 	    		if(hhh.length==1){
	 	    			String[] hh = maxs.split(" ");
	 	    			FS+=""+String.valueOf((char)('A' + Integer.parseInt(hh[0])))+""+
	 	    			String.valueOf((char)('A' + Integer.parseInt(hh[0])));
	 	    			num[Integer.parseInt(hh[0])]-=2;
	 	    		}
	 	    		else if(hhh.length==3 && max==1){
	 	    			String[] hh = maxs.split(" ");
	 	    			FS+=""+String.valueOf((char)('A' + Integer.parseInt(hh[0])));
	 	    			num[Integer.parseInt(hh[0])]-=1;
	 	    		}
	 	    		else if(hhh.length>1){
	 	    			String[] hh = maxs.split(" ");
	 	    			
	 	    			FS+=""+String.valueOf((char)('A' + Integer.parseInt(hh[0])))+""+
	 	    			String.valueOf((char)('A' + Integer.parseInt(hh[1])));
	 	    			num[Integer.parseInt(hh[0])]--;
	 	    			num[Integer.parseInt(hh[1])]--;
	 	    		}
	 	    		FS+=" ";
	 	    		flag=false;
	 	    		for(int i=0;i<line1.length;i++)
	 	    			if(num[i]!=0)flag=true;
	 	    		
	 	    		
	 	    		
	 	    		
	 	    		 max=0;int maxn=-1;
	 	    		for (int i = 0; i < num.length; i++) {
	 	    		    if (num[i] > max) {  
	 	    		    	max = num[i];
	 	    		    	maxn=i;
	 	    		    }
	 	    		    
	 	    		}
	 	    		if(maxn!=-1){
	 	    		for (int i = 0; i < num.length; i++) {
	 	    		    if (num[i] > max) {  
	 	    		    	max = num[i];
	 	    		    	maxn=i;
	 	    		    }
	 	    		    
	 	    		}
	 	    		int sum=0;
	 	    		for (int i = 0; i < num.length; i++) {
	 	    			if(maxn!=i)sum+=num[i];	 	    		    
	 	    		}
	 	    		if(sum<num[maxn]){System.out.println("errror:::"+FS);
	 	    		
	 	    		System.exit(0);}
	 	    		
	 	    		}
	 	    	}System.out.println("***********");
	 	    		
	 	    		
	 	    	
	 	    	
		 	    bw.write("Case #"+t+": "+FS+"\n"); 
	 	 
	 	    }
	 	    br.close();
	 	    bw.close();        
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file");                   
	        }
	    }
	 

}
