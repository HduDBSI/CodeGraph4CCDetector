package googlejam8.p412;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class pro1 {
	public static void main(String[] args) {
		Scanner in; 
		PrintStream out;
		String readString;
		
		try{
   				in = new Scanner(System.in);

				out = new PrintStream(System.out);

   				int T = in.nextInt();
   				
   				String ABCD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

for( int t=0; t<T ; t++ ){
        int N = in.nextInt();
        int[] Pi = new int[N];
        int sum = 0;
        for( int n=0; n<N; n++){
			Pi[n] = in.nextInt();
			sum += Pi[n];
		}
		
        out.print("Case #"+(t+1)+":");
		while( sum > 0 ){
			//find maximum & second maximum
			int max_ind = 0;
			int sec_max_ind = 1;
			if( Pi[0] > Pi[1] ){
				max_ind = 1;
				sec_max_ind = 0;
			}
			for( int i=0; i<N; i++){
				if( Pi[max_ind] < Pi[i] ){
					sec_max_ind = max_ind;
					max_ind = i;
				}
				else if( Pi[sec_max_ind] < Pi[i] ){
					sec_max_ind = i;
				}
			}
			
			//out.println(Pi[max_ind]+" "+Pi[sec_max_ind]);
			
			//AA? AB? A?
			if( Pi[max_ind] == Pi[sec_max_ind] && sum!=3){
				Pi[max_ind]--;
				Pi[sec_max_ind]--;
				sum = sum -2 ;
				out.print(" "+ABCD.charAt(max_ind)+ABCD.charAt(sec_max_ind));
			}
			else if( Pi[max_ind] == 1 ){
				Pi[max_ind]--;
				sum = sum-1;
				out.print(" "+ABCD.charAt(max_ind));
			}
			else if( 2*(Pi[max_ind]-2) <= sum ){
				Pi[max_ind]=Pi[max_ind]-2;
				sum = sum-2;
				out.print(" "+ABCD.charAt(max_ind)+ABCD.charAt(max_ind));
			}
			else{
				Pi[max_ind]--;
				sum = sum-1;
				out.print(" "+ABCD.charAt(max_ind));
			}

			//out.println("rate "+Pi[max_ind]*2+" "+sum);
			
			//print AA? AB? A?
			//out.println(" "+str);
		}
		
		out.println();
}




		}
		catch(Exception e){
			;
		}
		
	
	}

}
