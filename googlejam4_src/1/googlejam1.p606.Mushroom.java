package googlejam1.p606;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Mushroom {

    public static void main(String[] args) throws IOException {
        Mushroom r = new Mushroom();
		FileInputStream fstream = new FileInputStream("Mushroom.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String strLine;
		String totalTestCases  = br.readLine();
		int lineNo = 1;
		while ((strLine = br.readLine()) != null)   {
		    if(lineNo %2 == 0) {
		        String[] tokens = strLine.split(" ");
		        int[] input = Stream.of(tokens).mapToInt(Integer::parseInt).toArray();
		        int strategy1 = 0;
		        int strategy2 = 0;
		
		        int maxDifference = 0 ;
		        for(int i=0;i< input.length-1;i++) {
		            if(input[i] > input[i+1]) {
		                if(maxDifference < (input[i]- input[i+1])) {
		                    maxDifference = input[i]- input[i+1];
		                }
		                strategy1 += input[i] - input[i+1];
		            }
		        }
		        for(int i=0;i< input.length-1;i++) {
		                if(input[i] < maxDifference) {
		                    strategy2 += input[i];
		                } else {
		                    strategy2 += maxDifference;
		                }
		        }
		
		
		        System.out.println(String.format("Case #%d: %d %d", Mushroom.inputLines++, strategy1, strategy2));
		    }
		    lineNo++;
		
		}
		
		br.close();
    }
    static int inputLines = 1;
}
