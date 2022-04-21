package googlejam4.p138;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("a.in"));
			PrintStream out = new PrintStream("a.out");
			int T = in.nextInt();
			System.out.println(T);
			for(int C=1;C<=T;C++){
				System.out.println("case:"+C);
				int M = in.nextInt();
				int N = in.nextInt();
				char[][] mat = new char[M][N];
				in.nextLine();
				for(int i=0;i<M;i++){
					String temp = in.nextLine();
					for(int j=0;j<N;j++)
						mat[i][j] = temp.charAt(j);
				}
				int ans = 0;
				boolean res = true;
				for(int i=0;i<M;i++){
					for(int j=0;j<N;j++){
						if (mat[i][j]!='.'){
							boolean[] dir = new boolean[4];
							for(int x=0;x<i;x++)
								if (mat[x][j]!='.') {
									dir[0] = true;
									break;
								}
							for(int x=i+1;x<M;x++)
								if (mat[x][j]!='.') {
									dir[1] = true;
									break;
								}
							for(int y=0;y<j;y++)
								if (mat[i][y]!='.'){
									dir[2] = true;
									break;
								}
							for(int y=j+1;y<N;y++)
								if (mat[i][y]!='.'){
									dir[3] = true;
									break;
								}
							boolean can = false;
							for(int d=0;d<4;d++)
								if (dir[d]) can = true;
							if(!can){
								res = false;
								break;
							}
							if (mat[i][j]=='^' && dir[0]) continue;
							if (mat[i][j]=='v' && dir[1]) continue;
							if (mat[i][j]=='<' && dir[2]) continue;
							if (mat[i][j]=='>' && dir[3]) continue;
							ans++;
						}
					}
					if (!res) break;
				}
				if (!res) out.println("Case #"+C+": IMPOSSIBLE");
				else out.println("Case #"+C+": "+ans);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
