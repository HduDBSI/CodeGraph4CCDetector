package googlejam1.p205;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ismael
 */
public class ProblemA {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader f= new FileReader("C:\\Users\\Ismael\\Desktop\\inputA.txt");
        PrintWriter out =new PrintWriter("C:\\Users\\Ismael\\Desktop\\outputA.txt");
        Scanner in = new Scanner(f);
        int cant= in.nextInt();
        in.nextLine();
        for (int i = 0; i < cant; i++) {
            
            int mus=in.nextInt();
            int m[]=new int[mus];
            for (int j = 0; j < mus; j++) {
                m[j]=in.nextInt();
                
                
                
            }
            int acum=0;
            for (int j = 0; j < mus-1; j++) {
                acum=acum+Math.min(0, m[j+1]-m[j]);
                
            }
            acum=-acum;
            
            int rate=0;
            for (int j = 0; j < mus-1; j++) {
                if(rate<-(m[j+1]-m[j])){
                    rate=-(m[j+1]-m[j]);
                }
              
            }

            int acum2=0;
            for (int j = 0; j < mus-1; j++) {
                if(m[j]>=rate){
                    acum2=acum2+rate;
                }else{
                    acum2=acum2+m[j];
                }
            }
            
            
            
            
            
            String res=acum+" "+acum2;
            out.println("Case #"+(i+1)+": "+res);
            
        }
        in.close();
        out.close();
    }
}
