package googlejam8.p942;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 *
 * @author Admin
 */
public class senate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int f=1;f<=t;f++)
        {
            System.out.print("Case #"+f+": ");
            //code here
            int n=s.nextInt();
            int[] p=new int[n];
            for(int i=0;i<n;i++)
                p[i]=s.nextInt();
            
            while(true)
            {
                int max=0,m_ind=-1;
                int sec=0,s_ind=-1;
                int count=0,flag=0;
                if(n%2!=0)
                {
                for(int i=0;i<n&&p[i]==1;i++)
                        count++;
                if(count==n)
                    flag=1;
                }
                if(flag==0)
                {
                for(int i=0;i<n;i++)
                {
                    if(max<p[i])
                    {
                        max=p[i];
                        m_ind=i;
                    }
                }
                
                if(max==0)
                    break;
                for(int i=0;i<n;i++)
                {
                    if(sec<p[i]&&i!=m_ind)
                    {
                        sec=p[i];
                        s_ind=i;
                    }
                }
            p[m_ind]--;
            p[s_ind]--;
            int on=65+m_ind;
            int tw=65+s_ind;
            System.out.print((char)on);
            System.out.print((char)tw);
            System.out.print(" ");
        
                    }
            
            else
                {
                    p[0]--;
                    int on=65;
                    System.out.print((char)(on)+" ");
                    flag=0;
                }
              }
            System.out.println();
            }
            
            
            
        }
    }
    

