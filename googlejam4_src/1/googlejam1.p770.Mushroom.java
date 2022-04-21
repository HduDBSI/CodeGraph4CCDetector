package googlejam1.p770;
import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Canon on 2015-04-17.
 */
public class Mushroom {

    public static void main(String[] args) throws IOException{
        String filename = args[0];
        //String filename = "A-input.in.txt";
        BufferedReader in = new BufferedReader(new FileReader(filename));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-ans.txt")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int numCase = Integer.valueOf(st.nextToken());
        for(int c = 1;c<=numCase; c++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.valueOf(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int[] input = new int[N];
            for(int i = 0;i<N;i++) {
                input[i] = Integer.valueOf(st.nextToken());
            }
			int largestGap = 0;
			long sum1 = 0;
			for (int i = 1; i < input.length; i++) {
			    if (input[i - 1] > input[i]) {
			        int gap = input[i - 1] - input[i];
			        if (gap > largestGap) {
			            largestGap = gap;
			        }
			        sum1 += gap;
			    }
			}
			
			long sum2 = 0;
			for (int j = 0; j < input.length - 1; j++) {
			    if (input[j] < largestGap) {
			        sum2 += input[j];
			    } else {
			        sum2 += largestGap;
			    }
			}
            long[] solution = new long[]{sum1,sum2};
            out.println("Case #"+c+": "+solution[0]+" "+solution[1]);
        }
        out.close();
        in.close();

    }
}


