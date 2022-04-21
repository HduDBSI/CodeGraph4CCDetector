package googlejam1.p154;
import static java.lang.Integer.parseInt;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class A2015 {


    public static void main(String[] args) throws IOException {
        A2015 trans = new A2015();
        Path path = Paths.get("inputs/"+A2015.NAME + ".in");
		List<String> lines = Files.readAllLines(path);
		
		BufferedWriter out = new BufferedWriter(new FileWriter("output/"+A2015.NAME+".out"));
		try {
		    try {
		        int count = parseInt(lines.remove(0));
		
		        for (int i=0;i<count;i++) {
		            String s[] = lines.get(2*i+1).split(" ");
					int C = Integer.parseInt(lines.get(2*i).trim());
					
					int is[] = new int[C];
					
					for (int i2 = 0; i2 < C; i2++) {
					    is[i2] = Integer.parseInt(s[i2]);
					}
					
					int prev = is[0];
					int maxv1 = 0;
					
					int mI = 0;
					for (int i1 = 1; i1 < C; i1++) {
					    if (is[i1] < prev) {
					        maxv1 += prev - is[i1];
					        mI = Math.max(mI, prev - is[i1]);
					    }
					    prev = is[i1];
					}
					
					int maxv2 = 0;
					
					for (int i3 = 0; i3 < C - 1; i3++) {
					    maxv2 += Math.min(is[i3], mI);
					}
					String str = maxv1 + " " + maxv2;
		            out.write("Case #"+(i + 1)+": "+str);
		            if (i<count-1)
		                out.write(System.getProperty("line.separator"));
		            System.out.println(lines.get(i));
		            System.out.println(str);
		        }
		    } finally {
		        out.flush();
		        out.close();
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
    }
//    private static final String ID = "practice";
//    private static final String SIZE = "small";
//    private static final String CODE = "A";

    private static final String NAME = "A-large";//"B-small-attempt3";//CODE+"-"+SIZE+"-"+ID;

}
