package googlejam4.p184;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("Round22015/A_l.in"));
		System.setOut(new PrintStream("src/Round22015/A_l.out"));
		int T = Integer.parseInt(br.readLine());
		for (int t= 1; t <= T ;t++){
			System.out.print(String.format("Case #%d: ",t));
			
			String tmp[] = br.readLine().trim().split("\\s+");
			int R = Integer.parseInt(tmp[0]);
			int C = Integer.parseInt(tmp[1]);
			String map[] = new String[R];
			for (int i = 0 ;i < R ; i++){
				map[i] = br.readLine();
			}
			int ans = 0;
			boolean isPosible = true;
			boolean chkR[][] = new boolean[R][C];
			boolean chkL[][] = new boolean[R][C];
			boolean chkU[][] = new boolean[R][C];
			boolean chkD[][] = new boolean[R][C];
			for (int k = Math.max(R,C)+1; k > 0 ; k--){
				for (int i = 0 ; i < R; i++){
					for (int j = 0 ; j < C ;j++){
						if (map[i].charAt(j) != '.'){
							if (i > 0) chkD[i-1][j] = true;
							if (i < R-1) chkU[i+1][j] = true;
							if (j > 0) chkR[i][j-1] = true;
							if (j < C-1) chkL[i][j+1] = true;
						} 
						if (i > 0 && chkU[i-1][j]) {
							chkU[i][j] = true;
						} 
						 if (j > 0 && chkL[i][j-1]) {
							chkL[i][j] = true;
						} 
						 if (i < R-1 && chkD[i+1][j]) {
							chkD[i][j] = true;
						} 
						 if (j < C-1 && chkR[i][j+1]) {
							chkR[i][j] = true;
						}
					}
				}
			}
			
			for (int i = 0 ; i < R ;i++){
				for (int j = 0 ; j< C; j++){
					if (map[i].charAt(j)!='.'&&!chkL[i][j]&&!chkR[i][j]&&!chkU[i][j]&&!chkD[i][j]){
						isPosible = false;
					}
				}
			}
			
			if (!isPosible){
				System.out.println("IMPOSSIBLE ");
			} else {
				for (int r = 0 ; r <R ; r++){
					for (int c = 0 ; c < C ; c++){
						char a = map[r].charAt(c);
						if (a == '<' && !chkL[r][c]) ans++;
						if (a == '>' && !chkR[r][c]) ans++;
						if (a == 'v' && !chkD[r][c]) ans++;
						if (a == '^' && !chkU[r][c]) ans++;
					}
				}
				System.out.println(ans);
			}
		}
		
	}

}
