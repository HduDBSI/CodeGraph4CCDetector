package googlejam1.p443;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class A {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Nejc/Desktop/input.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:/Users/Nejc/Desktop/output.txt")));
		byte T=Byte.parseByte(br.readLine());
		for(byte t=0; t<T; t++){
			int y=0;
			int z=0;
			int N=Integer.parseInt(br.readLine());
			String[]split=br.readLine().split(" ");
			int[]m=new int[N];
			for(int i=0; i<N; i++)
				m[i]=Integer.parseInt(split[i]);
			int max=0;
			for(int i=1; i<N; i++){
				if(m[i]<m[i-1]){
					int eaten = m[i-1]-m[i];
					y+=eaten;
					if(eaten>max)max=eaten;
				}
			}
			for(int i=1; i<N; i++){
				if(m[i-1]<max)z+=m[i-1];
				else z+=max;
			}
			bw.write("Case #"+(t+1)+": "+y+" "+z);
			bw.newLine();
		}
		br.close();
		bw.close();
		System.out.println("done");
	}
}
