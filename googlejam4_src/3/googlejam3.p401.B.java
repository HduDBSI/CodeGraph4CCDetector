package googlejam3.p401;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class B {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Nejc/Desktop/input.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:/Users/Nejc/Desktop/output.txt")));
		int T=Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
			String[] line = br.readLine().split(" ");
			int R = Integer.parseInt(line[0]);
			int C = Integer.parseInt(line[1]);
			int W = Integer.parseInt(line[2]);
			int result=0;
			if(R==1){
				if(C%W==0)result=C/W+W-1;
				else result=C/W+W;
			}
			else System.out.println("Error");
			bw.write("Case #"+(t+1)+": "+result);
			bw.newLine();
		}
		br.close();
		bw.close();
		System.out.println("done");
	}
}
