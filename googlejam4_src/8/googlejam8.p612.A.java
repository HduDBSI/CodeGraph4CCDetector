package googlejam8.p612;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A {
	private static String infileName, outFileName;
	private static BufferedReader reader;
	private static BufferedWriter writer;
	public static void main(String[] args) throws IOException {

		infileName = args[0];
		outFileName = infileName.substring(0, infileName.indexOf('.')).concat(
				".out");
		reader = Files.newBufferedReader(Paths.get(infileName));
		writer = Files.newBufferedWriter(Paths.get(outFileName));
		int numTests = Integer.parseInt(reader.readLine());
		for (int i = 0; i < numTests; i++) {
			int parties = Integer.parseInt(reader.readLine());
			int[] in = new int[parties];
			int j = 0;
			for (String s2 : reader.readLine().split("\\s")) {
				in[j++] = Integer.parseInt(s2);
			}
			int[] senates = in;
			int[] senates1 = senates;
			StringBuilder sb = new StringBuilder();
			int evac = 0;
					do{
						String s = "";
						int sum1 = 0;
						for (int s1 : senates1)
							sum1 += s1;
						int sum = sum1;
						int mjor1= (sum - 1)/2 + 1;
						int mjor2= (sum - 2)/2 + 1;
						evac =0;
						int [] temp = Arrays.copyOf(senates1, parties);
						for(int i1 = parties - 1; i1 >= 0; i1--)
						{
							if(temp[i1] >= mjor2)
							{
								temp[i1] = temp[i1] - 1;
								char a = (char) (65+i1);
								s += a;
								evac++;
								i1++;
							}
						}
						if(evac > 1)
						{
							temp = Arrays.copyOf(senates1, parties);
							s="";
							evac =0;
							for(int i3 = parties - 1; i3 >= 0; i3--)
							{
								if(temp[i3] >= mjor1)
								{
									temp[i3] = temp[i3] - 1;
									char a = (char) (65+i3);
									s += a;
									evac++;
								}
							}
						}
						if(evac == 0 )
						{
							for(int i2 = 0; i2 < parties; i2++)
							{
								if(temp[i2] >= 1)
								{
									temp[i2] = temp[i2] - 1;
									char a = (char) (65+i2);
									s += a;
									evac++;
									break;
								}
							}
						}
						sb.append(s).append(" ");
						senates1 = Arrays.copyOf(temp, parties);
					}while(evac != 0);
			String plan = sb.toString();
			Object[] ans = { plan };
			writer.write("Case #" + (i + 1) + ":");
			for (Object a : ans)
				writer.write(" " + a);
			writer.newLine();
		}
		reader.close();
		writer.close();

	}
}

