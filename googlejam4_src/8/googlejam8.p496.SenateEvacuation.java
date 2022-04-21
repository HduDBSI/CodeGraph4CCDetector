package googlejam8.p496;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Derrick on 2016/05/08.
 *
 */
public class SenateEvacuation {


    public static void main(String[] args){


        Scanner input;
        Formatter output;
        int a=1,b = 1;
        try{
            output = new Formatter( "output.txt" );
            input = new Scanner(new File( "A-large(1).in" ));//Change to console while coding
            //input = new Scanner(System.in);
            int T = input.nextInt();

            char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            for (int i = 0 ; i < T ; i++ ) {

                int N = input.nextInt();
                int[] P = new int[N];
                for( int j = 0 ; j < N ;j++ ){
                    P[j] = input.nextInt();
                }

                int hold = 0;
                boolean cont = true;

                output.format("Case #%d: ",(i+1));
                while( cont){
                    int largest = 0;
                    int num = 0;
                    for( int j = 0 ; j < N ;j++ ){
                        num += P[j];
                    }

                    int count = 0;
                    for( int j = 0 ; j < N ;j++ ){
                        if(P[j] == 0){
                            cont = false;
                            count++;
                        }
                        else{
                            cont = true;
                            break;
                        }
                    }
                    if(count == N){
                        break;
                    }
                    for( int j = 0 ; j < N ;j++ ){
                        if(P[j] > largest){
                            hold = j;
                            largest = P[j];
                        }
                    }
                    System.out.println("hold " + hold);
                    output.format("%c",letters[hold]);

                    P[hold]-= 1;
                    largest = 0;
                    count = 0;
                    if(num %2 != 0){
                        output.format(" ");
                        continue;
                    }
                    for( int j = 0 ; j < N ;j++ ){
                        if(P[j] == 0){
                            cont = false;
                            count++;
                        }
                        else{
                            cont = true;
                            break;
                        }
                    }
                    if(count == N){
                        break;
                    }
                    for( int j = 0 ; j < N ;j++ ){
                        if(P[j] > largest){
                            hold = j;
                            largest = P[j];;
                        }
                    }
                    System.out.println("hold " + hold);
                    output.format("%c ",letters[hold]);
                    P[hold]--;
                }

                output.format("\n");

            }
            output.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }




    }


}