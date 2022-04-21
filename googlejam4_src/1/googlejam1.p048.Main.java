package googlejam1.p048;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		String eol = System.getProperty("line.separator");
		byte[] eolb = eol.getBytes();
		try {
			String str = br.readLine();
			int t = Integer.parseInt(str);
			for(int i = 0 ; i < t ; i++) {
				str = br.readLine();
				int n = Integer.parseInt(str);
				str = br.readLine();
				StringTokenizer st = new StringTokenizer(str," ");
				int [] ar = new int[n];
				int iter = 0;
				while(st.hasMoreTokens()) {
					ar[iter++] = Integer.parseInt(st.nextToken());
				}
				int ansY = 0;
				int ansZ = 0;
				int dip = 0;
				for(int j = 0 ; j < n-1 ; j++) {
					dip = Math.max(dip,ar[j]-ar[j+1]);
					if(ar[j+1]<ar[j]) {
						ansY += ar[j]-ar[j+1];
					}
				}
				for(int j = 0 ; j < n-1 ; j++) {
					int x = Math.min(ar[j],dip);
					ansZ += x;
				}
				bos.write("Case #".getBytes());
				bos.write(new Integer(i+1).toString().getBytes());
				bos.write(": ".getBytes());
				bos.write(new Integer(ansY).toString().getBytes());
				bos.write(" ".getBytes());
				bos.write(new Integer(ansZ).toString().getBytes());
				bos.write(eolb);
			}
			bos.flush();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
