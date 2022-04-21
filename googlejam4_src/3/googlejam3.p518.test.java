package googlejam3.p518;


import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        InputStream inputStream = new FileInputStream("D:\\test2.in");
        BufferedReader r = new BufferedReader (new InputStreamReader (inputStream));
        int numtestcase=0;
        //while (!(s=r.readLine()).startsWith("42")) System.out.println(s);
        numtestcase=Integer.parseInt(r.readLine());
        for(int i=1;i<=numtestcase;i++)
        {
            String s=r.readLine();
            String[] s1=s.split(" ");
            int R=Integer.parseInt(s1[0]);
            int c=Integer.parseInt(s1[1]);
            int w=Integer.parseInt(s1[2]);
            int result=0;
            if(w==1) result=R*c;
            else
            if(w==R*c) result=R*c;
            else
            if(c%w==0) result=c/w+w-1;
            else {
                int temp=c/w;
                result = temp+w;
            }
            System.out.println("Case #"+Integer.toString(i)+": "+Integer.toString(result));

        }
    }
}