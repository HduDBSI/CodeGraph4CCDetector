package googlejam1.p433;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: WANG
 * Date: 4/17/15
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class r11 {
    public static void main(String[] args) {
        try {

            Scanner input=new Scanner(new File(args[0]));
            PrintWriter output=new PrintWriter(args[1]) ;
            int casenumber = input.nextInt();
            for(int i=0;i<casenumber;i++){
                int len = input.nextInt(), method1=0,method2=0,maxrate=0;
                int[] mushrooms = new int[len];
                mushrooms[0]= input.nextInt();
                for(int j=1;j<len;j++){
                    mushrooms[j]=    input.nextInt();
                    if( mushrooms[j]< mushrooms[j-1]){
                        method1+=   mushrooms[j-1]- mushrooms[j];
                        maxrate = Math.max(maxrate,mushrooms[j-1]- mushrooms[j]) ;
                    }
                }
                for(int j=1;j<len;j++){

                        method2+=  Math.min(maxrate,mushrooms[j-1]) ;


                }
                output.println("Case #"+(i+1)+": "+method1 + " "+ method2);
            }
            output.flush();
        }catch(FileNotFoundException e){}

    }
}
