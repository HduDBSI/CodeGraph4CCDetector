package googlejam6.p703;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scnr=new Scanner(System.in);
    
    int t=scnr.nextInt();
    String ans[]=new String[t];
    scnr.nextLine();   
    for(int i=0;i<t;i++){
    	HashMap<Integer,Boolean> data=new HashMap<>();
    	int n=scnr.nextInt();
    	Integer j=0;
    	Integer constant=2*n*n-n;
    	while(j<constant){
    		Integer in=scnr.nextInt();
    		if(data.containsKey(in)){
    			data.remove(in);
    		}
    		else{
    			data.putIfAbsent(in, false);
    		}
    		j++;
    	}
    	StringBuilder reqString=new StringBuilder();
    	for(j=1;j<=2500;j++){
    		if(data.containsKey(j)){
    			reqString.append(j);
    			reqString.append(" ");
    		}
    	}
    	
    	ans[i]=reqString.toString();
    }
    for(int i=0;i<t;i++){
    	System.out.println("Case #"+(i+1)+": "+ans[i]);
    }
    } 
    }
