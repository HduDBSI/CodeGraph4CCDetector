package googlejam6.p651;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.Arrays;


     class a {
    
    
    public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
     int tt=sc.nextInt();
     
    
   int c;
     for(int z=0;z<tt;z++)
     {
          int n=sc.nextInt();
          
        
         int[] a=new int[2501];
         for(int i=0;i<(2*n)-1;i++)
         {
             for(int j=0;j<n;j++)
             {
                 c=sc.nextInt();
                 a[c]+=1;
                
                 
                
                 
                 
                 
             }
                
         }
           
       
         Arrays.sort(a);
           System.out.print("Case #" + (z+1) + ":" +" " );
          for(int i=0;i<2501;i++)
          if(a[i]%2!=0){
           System.out.print(a[i] + " ");}
           System.out.println();
         }
         
         
}}