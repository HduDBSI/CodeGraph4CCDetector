package googlejam1.p796;
import java.util.*;
import java.io.*;

    class A {
    
    public static void main (String[] args) throws IOException

        {
        
        File text = new File ("A-large.in");
 //    File text = new File ("scanner.in");

        Scanner scn= new Scanner(text);
        FileWriter out = new FileWriter("large-practice.out");
        int N=scn.nextInt(); // setting the number of test cases
        int num_pan;

        for (int i =1;i<=N;i++)
        {
        num_pan=scn.nextInt();
        int arr[] = new int[num_pan];
        for (int j =0;j<num_pan;j++)
            {
            arr[j]=scn.nextInt();
            }
        
        //find first rule
        int num_1=0;int num_2=0;int diff;
        for (int k=0;k<num_pan-1;k++)
            {
            if (arr[k] > arr[k+1])
                {
                 diff=arr[k]-arr[k+1];
                 num_1=num_1+diff;
                            }
           else
            {
                diff=0;
                num_1=num_1+diff;
            }
            
            }
        
        int grt=0;int temp_grt;
        for (int k=0;k< num_pan-1 ;k++)
            {
            temp_grt=arr[k]-arr[k+1];
            if (temp_grt > grt)
                grt=temp_grt;
            
            }
        
        for (int k=0;k<num_pan-1;k++)
            {
            if ((arr[k] < arr[k+1]) && (arr[k] < grt))
                {
                num_2=num_2+arr[k];        
                
                
                }

            else if ((arr[k] < arr[k+1]) && (arr[k] >= grt))
                    num_2=num_2+grt;

            else if ((arr[k] > arr[k+1]) && (arr[k] >= grt))
                {
                num_2=num_2+grt;
                }
            else if ((arr[k] > arr[k+1]) && (arr[k] < grt))
                {
                num_2=num_2+arr[k];
                
                }
            else if ((arr[k]==arr[k+1]) && (arr[k] < grt))
                {
                num_2=num_2+arr[k];

                }
            else if ((arr[k]==arr[k+1]) && (arr[k]== grt))
                num_2=num_2+grt;
            else if ((arr[k]==arr[k+1]) && (arr[k]> grt))
                num_2=num_2+grt;

            }




        out.write("Case #"+i+": "+num_1+" "+num_2+"\n");
        } //main for loop ends here



        out.flush();
        out.close();
        }     // main function ends here
    
    
    
    
    }  //class ends here
