package googlejam3.p278;


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
                int R = input.nextInt(),C=input.nextInt(),W=input.nextInt(),count=0;
                if(C%W == 0)
                    count=(R-1)*(C/W)+C/W+W-1;
                else
                    count=(R-1)*(C/W)+C/W+W;
                output.println("Case #"+(i+1)+": "+count);
            }
            output.flush();
        }catch(FileNotFoundException e){}

    }
}
