package googlejam9.p137;


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
public class B1 {

    public static final String rutaDatos = "C:\\Users\\Augusto\\Desktop\\Code Jam\\";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String problem = "B";
        //String input=problem+"-sample.in";
        //String input=problem+"-small-attempt1.in";
        String input=problem+"-large.in";
        Scanner in = new Scanner(new File(rutaDatos+"input\\"+input));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(rutaDatos+"output\\"+input+".out.txt")));    
        
        int T = in.nextInt();
        for(int i=0;i<T;i++) {
            
            /*********************************/
            
            int B = in.nextInt();
            long M = in.nextLong();
            
            
            
            String answer = "Case #"+(i+1)+": ";
            
            long l = 1;
            for(int j=0;j<B-2;j++) l = l*2;
            
            if(M>l) {
                answer += "IMPOSSIBLE";
                System.out.println(answer);
                out.println(answer);
            }
            else {
                answer += "POSSIBLE";
                System.out.println(answer);
                out.println(answer);
                for(int j=0;j<B;j++) {
                    for(int k=0;k<B;k++) {
                        int d=0;
                        if(k>j&&k<B-1) {
                            d = 1;
                        }
                        if(j==0&&k==B-1) d=1;
                        else if(k==B-1) {
                            long p = M-1;
                            String s = Long.toBinaryString(p);
                            //System.out.println("*"+s+"*");
                            if(j>s.length()) d=0;
                            else d = (s.charAt(s.length()-j))-'0';
                        }
                        System.out.print(d);
                        out.print(d);
                    }
                    System.out.println();
                    out.println();
                }
            }
            
            
            
            
            /*********************************/
            
            
        }
        out.close();
    }
    
}
