package googlejam6.p496;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;


public class Bsmall {
    public Bsmall() {
        super();
    }

    public static void main(String[] args) {
        Bsmall bsmall = new Bsmall();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for (int i = 1; i <= t; ++i) {
            map.clear();
            int n=in.nextInt();
            for (int j=0;j<n*(2*n-1);j++) {
               
                String s=in.next();              
               
                    Integer integ=Integer.valueOf(s);
                    if(map.get(integ)==null)
                    map.put(integ,1);
                    else {
                       int val= map.get(integ);
                        val=(val+1)%2;
                        map.put(integ, val);
                    }
                
            }
            Set<Integer> keySet = map.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            String result ="";
            while(iterator.hasNext()) {
                Integer integer = iterator.next();
                if(map.get(integer)==1)
                result+=" "+integer;
            }
            System.out.println("Case #"+i+":"+result);
          
        }
    }
}
