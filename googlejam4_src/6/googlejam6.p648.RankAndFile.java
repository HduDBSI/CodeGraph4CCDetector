package googlejam6.p648;
import java.io.File;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Derrick on 2016/04/16.
 */
public class RankAndFile {


    public static void main(String[] args){


        Scanner input;
        Formatter output;
        int b = 1;
        try{
            output = new Formatter( "output.txt" );
            input = new Scanner(new File( "B-large(1).in" ));//Change to console while coding
            //input = new Scanner(System.in);
            int T = input.nextInt();

            for (int i = 0 ; i < T ; i++ ) {
                int N = input.nextInt();
                int[][] grid = new int[(2*N)-1][N];
                int[][] sqr = new int[N][N];
                for(int j = 0 ; (j < (2*N)-1) ; j++){
                    for( int k = 0 ; k < N ; k++ ){
                        grid[j][k] = input.nextInt();
                    }
                }
                int[] miss = new int[50000];
                for (int c = 0; c < ((2*N)-1) ; c++) {
                    for (int d = 0; d < N; d++) {
                        miss[grid[c][d]]++;
                    }
                }
                int []num = new int[N];
                int count = 0;
                for (int c = 0; c < 2500 ; c++) {
                    if((miss[c]%2) != 0){
                        num[count] = c;
                        count++;
                    }
                }

                output.format("Case #%d: ",(i+1));
                for (int c = 0; c < N ; c++) {
                    output.format("%d ",num[c]);
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
