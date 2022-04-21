package googlejam1.p403;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Welcome {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = null;
		BufferedReader reader = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/luong/Downloads/"+args[0]+".out", true)));

		String s;
		fis = new FileInputStream("/home/luong/Downloads/"+args[0]+".in");
		reader = new BufferedReader(new InputStreamReader(fis));
		s = reader.readLine();
		int nbLoop = Integer.parseInt(s);
		for (int i = 1; i <= nbLoop; i++){
			String ch ="";
			int n = Integer.parseInt(reader.readLine());
			int[] m = new int[n];
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for(int j=0; j<n; j++){
				m[j] = Integer.parseInt(st.nextToken());
			}
			int y = 0;
			int z = 0;
			int v = 0;
			for(int j=1; j<n; j++){
				if(m[j]<m[j-1]){
					y += m[j-1] - m[j];
					v = Math.max(v, m[j-1] - m[j]); 
				}
			}
			for(int j=1; j<n; j++){
				z += Math.min(m[j-1], v);
			}
			// TODO Code goes here
			bw.write("Case #"+i+": "+y+" "+z);
			bw.newLine();
		}
		reader.close();
		fis.close();
		bw.close();
	}
}