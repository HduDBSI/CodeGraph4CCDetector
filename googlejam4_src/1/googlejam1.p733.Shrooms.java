package googlejam1.p733;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by robert on 18.04.15.
 */
public class Shrooms {

    public static void main (String [] args)throws Exception{
        Scanner input = new Scanner(new FileReader("A-large.in"));
        int numCases = input.nextInt();
        String out = "";
        for (int i = 0; i < numCases; i++) { //loop through cases
            int looks = input.nextInt();
            int m1=0,m2=0, spr = 0;//spr = shrooms per round
            int [] shrooms = new int[looks];
            for (int j = 0; j < looks; j++) { //loop through looks

                shrooms[j]=input.nextInt();
                if (j>0) {
                    if (shrooms[j-1] > shrooms[j]) {
                        m1 += shrooms[j-1] - shrooms[j];
                        if (shrooms[j-1] - shrooms[j] > spr) {
                            spr=shrooms[j-1]-shrooms[j];
                        }
                    }
                }
            }
            for (int j=0;j < looks-1;j++) {
                if (shrooms[j]-spr>=0){
                    m2+=spr;
                }else {
                    m2+=shrooms[j];
                }
            }
            out+="Case #"+(i + 1)+": "+m1+" "+m2+"\n";
        }
        //System.out.println(out);
        //writing
		try {
		    FileWriter fw = new FileWriter ("Solution.out");
		    BufferedWriter bw = new BufferedWriter (fw);
		    PrintWriter fileOut = new PrintWriter (bw);
		    fileOut.println (out);
		    fileOut.close();
		    System.out.println("the file " + "Solution.out" + " is created!");
		}
		catch (Exception e){
		    System.out.println(e.toString());
		}
    }


}
