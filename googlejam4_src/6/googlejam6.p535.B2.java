package googlejam6.p535;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Skipper on 4/15/2016.
 */
public class B2 {

    public static void main(String[] args) {

//Find the numbers that are not in even values
        //sort those rows

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for( int i = 0; i < T; i++ ){
            int n = sc.nextInt();
            Vector<Integer> numbers = new Vector<Integer>();
            int amount = ( 2 * n ) - 1;
            while( amount != 0 ){

                for( int j = 0; j < n; j++ ){
                    int temp = sc.nextInt();

                    numbers.add( temp );
                }
                amount--;
            }
            int[] num = new int[ numbers.size() ];
            for( int ni = 0; ni < numbers.size(); ni++ ){
                num[ ni ] = numbers.get( ni );
            }
			int[] sorted = num.clone();
			Arrays.sort(sorted);
			
			boolean odd = true;
			int len = 0;
			for (int i1 = 1; i1 < sorted.length; ++i1) {
			    if (sorted[i1] == sorted[i1 - 1]) {
			        odd = !odd;
			    } else {
			        if (odd) {
			            sorted[len++] = sorted[i1 - 1];
			        }
			        odd = true;
			    }
			}
			
			if (odd) {
			    sorted[len++] = sorted[sorted.length - 1];
			}
            int[] done = Arrays.copyOf(sorted, len);

            //System.out.println("please work");
            String finaldone = "";
            for( int joe = 0; joe < done.length; joe++ ){
                finaldone = finaldone +  done[joe] + " ";
            }

            Arrays.sort( done );

/*
            System.out.println("Should have a list of numbers");
            for( int q1= 0; q1 < numbers.size(); q1++ ){
                System.out.println( numbers.get( q1 ) );
                */


            //First find the row with the smalled calumn
            //look for integers that appear in odd numbers, those are the odd numbers and will need a second integer
            int index = i + 1;
            System.out.println( "Case #" + index + ": " + finaldone );

        }




    }

}
