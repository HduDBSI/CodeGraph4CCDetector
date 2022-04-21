package googlejam3.p052;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class A2015 {


    public static void main(String[] args) throws IOException {
        A2015 trans = new A2015();
        File file = new File("./inputs/"+A2015.NAME + ".in");
		BufferedWriter out = new BufferedWriter(new FileWriter("./output/"+A2015.NAME+".out"));
		try {
		    //use buffering, reading one line at a time
		    //FileReader always assumes default encoding is OK!
		    BufferedReader input = new BufferedReader(new FileReader(file));
		    try {
		        String line = input.readLine();
		        int count = Integer.parseInt(line);
		
		        for (int i=0;i<count;i++) {
		            line = input.readLine();
		            System.out.println(line);
					StringTokenizer tokens = new StringTokenizer(line.trim());
					int[] a= new int[tokens.countTokens()];
					int i1 = 0;
					while(tokens.hasMoreElements()) {
					    a[i1++] = Integer.parseInt(tokens.nextToken());
					}
					int[] params = a;
					int rows = params[0];
					int cols = params[1];
					int width = params[2];
					
					int count1 = 0;
					
					int perrow = cols/width;
					
					count1 = perrow * rows;
					
					count1 += width - 1;
					
					if (perrow*width < cols) {
					    count1++;
					}
		            String str = Integer.toString(count1);
		            out.write("Case #"+(i+1)+": "+str);
		            if (i<count-1)
		                out.write(System.getProperty("line.separator"));
		            System.out.println(str);
		        }
		    } finally {
		        input.close();
		        out.flush();
		        out.close();
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
    }

    private static final String NAME = "A-large";

}
