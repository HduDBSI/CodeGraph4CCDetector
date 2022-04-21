package googlejam4.p045;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	static int r ;
	static int c;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		String eol = System.getProperty("line.separator");
		byte[] eolb = eol.getBytes();
		try {
			String str = br.readLine();
			int t = Integer.parseInt(str);
			for(int i = 0 ; i < t ; i++) {
				int ans = 0;
				str = br.readLine();
				int blank = str.indexOf(" ");
				r = Integer.parseInt(str.substring(0, blank));
				c = Integer.parseInt(str.substring(blank+1));
				char[][]ar = new char[r][c];
				for(int j = 0 ; j < r ; j++) {
					str = br.readLine();
					ar[j] = str.toCharArray();
				}
				boolean impos = false;
				boolean val = false;
				int row = 0;
				int col = 0;
				for(int j = 0 ; j < r ; j++) {
					for(int k = 0 ; k < c ; k++) {
						switch(ar[j][k]) {
						case '^' :
							row = j-1;
							if(row>=0) {
								while(ar[row][k]=='.') {
									row--;
									if(row<0) {
										break;
									}
								}
							}
							if(row<0) {
								ans++;
							}
							boolean ans1 = true;
							for(int a = 0 ; a < j ; a++) {
								if(ar[a][k]!='.') {
									ans1 = false;
								}
							}
							for(int a = 0 ; a < k ; a++) {
								if(ar[j][a]!='.') {
									ans1 = false;
								}
							}
							for(int a = j+1 ; a < r ; a++) {
								if(ar[a][k]!='.') {
									ans1 = false;
								}
							}
							for(int a = k+1 ; a < c ; a++) {
								if(ar[j][a]!='.') {
									ans1 = false;
								}
							}
							val = ans1;
							if(val==true){
								impos= true;
							}
							break;
						case '<' :
							col = k-1;
							if(col>=0) {
								while(ar[j][col]=='.') {
									col--;
									if(col<0) {
										break;
									}
								}
							}
							if(col<0) {
								ans++;
							}
							boolean ans2 = true;
							for(int a = 0 ; a < j ; a++) {
								if(ar[a][k]!='.') {
									ans2 = false;
								}
							}
							for(int a = 0 ; a < k ; a++) {
								if(ar[j][a]!='.') {
									ans2 = false;
								}
							}
							for(int a = j+1 ; a < r ; a++) {
								if(ar[a][k]!='.') {
									ans2 = false;
								}
							}
							for(int a = k+1 ; a < c ; a++) {
								if(ar[j][a]!='.') {
									ans2 = false;
								}
							}
							val = ans2;
							if(val==true){
								impos= true;
							}
							break;
						case '>' :
							col = k+1;
							if(col<c) {
								while(ar[j][col]=='.') {
									col++;
									if(col>=c) {
										break;
									}
								}
							}
							if(col>=c) {
								ans++;
							}
							boolean ans3 = true;
							for(int a = 0 ; a < j ; a++) {
								if(ar[a][k]!='.') {
									ans3 = false;
								}
							}
							for(int a = 0 ; a < k ; a++) {
								if(ar[j][a]!='.') {
									ans3 = false;
								}
							}
							for(int a = j+1 ; a < r ; a++) {
								if(ar[a][k]!='.') {
									ans3 = false;
								}
							}
							for(int a = k+1 ; a < c ; a++) {
								if(ar[j][a]!='.') {
									ans3 = false;
								}
							}
							val = ans3;
							if(val==true){
								impos= true;
							}
							break;
						case 'v' :
							row = j+1;
							if(row<r) {
								while(ar[row][k]=='.') {
									row++;
									if(row>=r) {
										break;
									}
								}
							}
							if(row>=r) {
								ans++;
							}
							boolean ans4 = true;
							for(int a = 0 ; a < j ; a++) {
								if(ar[a][k]!='.') {
									ans4 = false;
								}
							}
							for(int a = 0 ; a < k ; a++) {
								if(ar[j][a]!='.') {
									ans4 = false;
								}
							}
							for(int a = j+1 ; a < r ; a++) {
								if(ar[a][k]!='.') {
									ans4 = false;
								}
							}
							for(int a = k+1 ; a < c ; a++) {
								if(ar[j][a]!='.') {
									ans4 = false;
								}
							}
							val = ans4;
							if(val==true){
								impos= true;
							}
							break;
						case '.' :
							break;
						}
					}
				}
				bos.write("Case #".getBytes());
				bos.write(new Integer(i+1).toString().getBytes());
				bos.write(": ".getBytes());
				if(impos) {
					bos.write("IMPOSSIBLE".getBytes());
				} else {
					bos.write(new Integer(ans).toString().getBytes());
				}
				bos.write(eolb);
			}
			bos.flush();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
