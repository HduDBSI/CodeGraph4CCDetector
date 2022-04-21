package googlejam1.p420;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class A {

    public static void main(String[] args) throws IOException {
	BufferedReader inFile = new BufferedReader (new FileReader ("A-large.in"));
	PrintWriter outFile = new PrintWriter (new File ("a.out"));
	StringTokenizer tok = new StringTokenizer(inFile.readLine());
	int T = Integer.parseInt(tok.nextToken());
	for (int t = 1 ; t <= T; t ++){
	    tok = new StringTokenizer(inFile.readLine());
	    int N = Integer.parseInt(tok.nextToken());
	    
	    tok = new StringTokenizer(inFile.readLine());
	    int [] m = new int [N];
	    for (int i = 0; i < N; i++){
		m[i] = Integer.parseInt(tok.nextToken());
	    }
	    
	    int y = 0;
	    for (int i = 1; i < N; i++){
		if (m[i] < m[i-1]){
		    y += m[i - 1] - m[i];
		}
	    }
	    
	    int z = 0;
	    int r = 0;
	    for (int i = 1; i < N; i++){
		if (m[i] < m[i-1]){
		    if (m[i-1] - m[i] > r){
			r = m[i-1] - m[i];
		    }
		}
	    }
	    
	    for (int i = 0; i < N - 1; i++){
		if (m[i] > r){
		    z += r;
		} else {
		    z += m[i];
		}
	    }
	    
	    outFile.printf("Case #%d: %d %d %n",t, y, z);
	}
	inFile.close();
	outFile.close();
    }

}
