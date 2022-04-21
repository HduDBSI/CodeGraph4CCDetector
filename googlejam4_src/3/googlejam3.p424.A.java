package googlejam3.p424;
// -XX:+UseParallelGC
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adam
 */


public class A
{
    public static void main(String[] args) throws Exception
    {
        Scanner s=new Scanner(new FileInputStream(args[0]) );
        int t=s.nextInt();
        TreeSet<Long> keresettek=new TreeSet<Long>();
        LinkedList<Long> keresettek2=new LinkedList<Long>();
        for (int i=1;i<=t;i++)
        {
            int r=s.nextInt();
            int c=s.nextInt();
            int w=s.nextInt();
             System.out.println("Case #"+i+": "+r*
			( (c/w) +(c%w!=0?1:0) +(w-1) ) );
        }
    }


}