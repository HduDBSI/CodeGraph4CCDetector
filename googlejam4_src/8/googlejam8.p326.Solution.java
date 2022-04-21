package googlejam8.p326;
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
    for(int i=0;i<t;i++){
    	StringBuilder evac=new StringBuilder();
    int n=scnr.nextInt();
    int[] parties=new int[n];
    int pcount=0;
    for(int j=0;j<n;j++){
    	parties[j]=scnr.nextInt();
    	pcount+=parties[j];
    }
    while(pcount>0){
    	int max=0,smax=0,tmax=0;
    	char c='A',d='A';
    	for(int j=0;j<n;j++){
    		if(parties[j]>=parties[max]){
    			tmax=smax;
    			smax=max;
    			max=j;
    		}
    	}
    		if(parties[max]==parties[smax]&&parties[max]==parties[tmax]&&smax!=tmax){
    			if(parties[max]>0){parties[max]-=1;
    			c+=max;
    			evac.append(c);
    			pcount-=1;
    			}
    		}
    		else if(parties[max]-parties[smax]>1){
    			if(parties[max]>0){parties[max]-=1;
    			c+=max;
    			evac.append(c);
    			pcount-=1;
    			}
    			if(parties[max]>0){parties[max]-=1;
    			evac.append(c);
    			pcount-=1;
    			}
    		}
    		else{
    		if(parties[max]>0){	parties[max]-=1;
    			c+=max;
    			evac.append(c);
    			pcount-=1;}
    		if(parties[smax]>0){parties[smax]-=1;
    			d+=smax;
    			evac.append(d);
    			pcount-=1;}
    		}
    		evac.append(" ");
    	}
    ans[i]=evac.toString();
    }
    
    	
   
    for(int i=0;i<t;i++){
    	System.out.println("Case #"+(i+1)+": "+ans[i]);
    }
    } 
    }
