package googlejam6.p594;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jbuddha
 */
public class RankAndFile {
		
	// Fixed Code Begins *********
	private static int count = 0;
	private static final String INPUT_FILE = "input.txt";
	private static final Path OUTPUT_PATH = Paths.get("output.txt");
	
	private static final List<String> TESTS = new ArrayList<>();
	private static final List<String> OUTPUT = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
			String line;
			int t = Integer.parseInt(br.readLine());
		    
		    for(int i = 0; i < t; i++){
		        int n = Integer.parseInt(br.readLine());
		        int matrix[][] = new int[2*n - 1][];
		        for(int j = 0; j < 2*n - 1; j++) {
		            matrix[j] = new int[n];
		            String[] row = br.readLine().split(" ");
		            for(int k = 0; k < n; k++)
		            {
		                matrix[j][k] = Integer.parseInt(row[k]);
		            }
		        }
		        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for(int i2 = 0; i2 < 2 * n - 1; i2++)
				{
				    for(int j = 0; j < n; j++)
				    {
				        int element = matrix[i2][j];
				        if(map.containsKey(element))
				            map.put(element,map.get(element)+1);
				        else
				            map.put(element,1);
				    }
				              
				}
				int[] arr = new int[n];
				int i1 = 0;
				for(int height: map.keySet())
				{
				    if(map.get(height) % 2 == 0)
				        continue;
				    
				    arr[i1++] = height;
				}
				StringBuilder sb = new StringBuilder();
				Arrays.sort(arr);
				for(int element: arr)
				    sb.append(element).append(" ");
				
				int c = OUTPUT.size() + 1;
				OUTPUT.add("Case #" + c + ": " + sb.toString().trim());
		    }
			
		}
		Files.write(OUTPUT_PATH, OUTPUT,Charset.defaultCharset());
	}
}
