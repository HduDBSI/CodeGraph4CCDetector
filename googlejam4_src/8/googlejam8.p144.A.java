package googlejam8.p144;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author astorres
 */
public class A {

    public static final String rutaDatos = "C:\\Users\\Augusto\\Desktop\\Code Jam\\";
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String problem = "A";
        //String input=problem+"-sample.in";
        //String input=problem+"-small-attempt1.in";
        String input=problem+"-large.in";
        Scanner in = new Scanner(new File(rutaDatos+"input\\"+input));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(rutaDatos+"output\\"+input+".out.txt")));    
        
        int T = in.nextInt();
        for(int i=0;i<T;i++) {
            
            String answer = "Case #"+(i+1)+":";
            
            /*********************************/
            
            int ns[] = new int[26];
            int np = in.nextInt();
            for(int j=0;j<np;j++)
                ns[j] = in.nextInt();
            
            
            while(true) {
                int may=0;
                int ts=0;
                for(int j=0;j<26;j++) {
                    if(ns[j]>ns[may])
                        may = j;
                    ts+=ns[j];
                }
                int may2=0;
                for(int j=0;j<26;j++)
                    if(ns[j]-(j==may?1:0)>=ns[may2]-(may2==may?1:0))
                        may2 = j;
                if(ts==0) break;
                ns[may]--;
                answer = answer + " " + (char)(may+'A');
                ts--;
                if(ts==0) break;
                //System.out.println(may+" "+may2);
                /*for(int j=0;j<26;j++)
                    if(ns[j]-(j==may2?1:0)>=(ts-1)/2) continue;*/
                if(ts==2) continue;
                answer = answer + (char)(may2+'A');
                ns[may2]--;
                //System.out.println(answer);
            }
            
            /*********************************/
            
            
            System.out.println(answer);
            out.println(answer);
        }
        out.close();
    }
    
}
