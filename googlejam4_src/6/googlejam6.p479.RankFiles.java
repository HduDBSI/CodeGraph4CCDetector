package googlejam6.p479;
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


public class RankFiles {
	public static void main(String[] args) throws IOException{
		RankFiles rf = new RankFiles();
		//System.out.println(lw.lastWord("CAB"));
		String inputPath = args[0];
		String outputPath = args[1];
		FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        int size = Integer.parseInt(bufferedReader.readLine());
        //String[] tests = new String[size];
        ArrayList<ArrayList<ArrayList<Integer>>> tests = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int i = 0;
        while(i < size) {
        	int d = Integer.parseInt(bufferedReader.readLine());
        	ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
        	for (int j = 2*d - 1; j > 0; j--){
        		line = bufferedReader.readLine();
        		ArrayList<Integer> lineHeights = new ArrayList<Integer>();
        		for (String s : line.split(" ")) lineHeights.add(Integer.parseInt(s));
        		test.add(lineHeights);
        	}
        	tests.add(test);
            i++;
        }   
        // Always close files.
        bufferedReader.close();
		ArrayList<String> output = new ArrayList<String>();
		for (int j = 0; j < size; j++) {
			//int out = pc.flipAllPancakes(tests[j]);
			ArrayList<ArrayList<Integer>> test = tests.get(j);
			HashMap<Integer, Integer> stats = new HashMap<Integer, Integer>();
			int[] res = new int[(test.size()+1)/2];
			for (ArrayList<Integer> ai : test){
				for (Integer h : ai){
					if (stats.containsKey(h)) stats.put(h, stats.get(h)+1);
					else stats.put(h, 1);
				}
			}
			int k = 0;
			for (Integer h : stats.keySet()){
				if (stats.get(h)%2 == 1) res[k++] = h; 
			}
			Arrays.sort(res);
			StringBuilder sb = new StringBuilder();
			for (int ni : res) sb.append(" "+ni);
			String out = sb.toString();
            output.add("Case #"+(j+1)+":"+out);
            System.out.println(out);
		}
		
		Path file = Paths.get(outputPath);
		Files.write(file, output, Charset.forName("UTF-8"));
	}
}
