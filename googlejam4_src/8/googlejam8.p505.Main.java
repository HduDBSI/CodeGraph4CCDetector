package googlejam8.p505;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            //these variables handle input and output from plain text files
            in = new Scanner(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");

            final char FIRST_CHAR = 'A';

            int totalCases = in.nextInt();
            for (int testCase = 1; testCase <= totalCases; testCase++) {

                int n = in.nextInt();
                int[] parties = new int[n];
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    parties[i] = in.nextInt();
                    sum += parties[i];
                }//end input

                out.printf("Case #%d: ",testCase);


                int maxIndex = 0;
                if(sum % 2 == 1){

                    maxIndex = 0;
                    for (int i = 1; i < n; i++) {
                        if(parties[maxIndex]<parties[i]){
                            maxIndex = i;
                        }
                    }
                    out.printf("%c ",FIRST_CHAR + ((char) maxIndex));
                    sum--;
                    parties[maxIndex]--;

                }//end removing oddity


                int weak;
                int strong;
                int temp =  0;
                while(sum>0){
                    weak = 0;
                    strong = 1;
                    if(parties[0]>= parties[1]){
                        strong = 0;
                        weak = 1;
                    }
                    for (int i = 2; i < n; i++) {
                        if(parties[weak]<parties[i]){
                            weak = i;
                            if(parties[weak]>parties[strong]){
                                temp = strong;
                                strong = weak;
                                weak = temp;
                            }
                        }
                    }//end finding two max indices
                    out.printf("%c%c ",FIRST_CHAR+((char) weak),FIRST_CHAR+((char) strong));
                    parties[weak]--;
                    parties[strong]--;
                    sum -=2;
                }
                out.println();
                out.flush();


            }//end for cases


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }
}
