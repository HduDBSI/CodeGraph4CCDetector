package googlejam4.p044;


import java.util.Scanner;

public class Main{
	static boolean[][] hashLeft;
	static boolean[][] hashRight;
	static boolean[][] hashUp;
	static boolean[][] hashDown;
	static char[][] map;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t=1;t<=T;t++){
			int r=sc.nextInt();
			int c=sc.nextInt();
			sc.nextLine();
			hashLeft=new boolean[r][c];
			hashRight=new boolean[r][c];
			hashUp=new boolean[r][c];
			hashDown=new boolean[r][c];
			map=new char[r][c];
			for (int i=0;i<r;i++){
				String temp=sc.nextLine();						
				for (int j=0;j<c;j++){
					map[i][j]=temp.charAt(j);
				}
			}
			for (int i=0;i<r;i++){
				for (int j=1;j<c;j++){
					if (hashLeft[i][j-1]){
						hashLeft[i][j]=true;
					}else{
						if (map[i][j-1]!='.'){
							hashLeft[i][j]=true;
						}
					}
				}
			}
			
			for (int i=1;i<r;i++){
				for (int j=0;j<c;j++){
					if (hashUp[i-1][j]){
						hashUp[i][j]=true;
					}else{
						if (map[i-1][j]!='.'){
							hashUp[i][j]=true;
						}
					}
				}
			}
			
			for (int i=0;i<r;i++){
				for (int j=c-2;j>=0;j--){
					if (hashRight[i][j+1]){
						hashRight[i][j]=true;
					}else{
						if (map[i][j+1]!='.'){
							hashRight[i][j]=true;
						}
					}
				}
			}
			
			for (int i=r-2;i>=0;i--){
				for (int j=0;j<c;j++){
					if (hashDown[i+1][j]){
						hashDown[i][j]=true;
					}else{
						if (map[i+1][j]!='.'){
							hashDown[i][j]=true;
						}
					}
				}
			}
			
			int ans=0;
			
			boolean find=false;
			label:
			for (int i=0;i<r;i++){
				for (int j=0;j<c;j++){
					char cc=map[i][j];
					if (cc=='.'){
						continue;
					}
					if (cc=='>'){
						if (hashRight[i][j]){
							continue;
						}
						if (hashLeft[i][j]||hashUp[i][j]||hashDown[i][j]){
							ans++;
						}else{
							find=true;
							break label;
						}
					}
					if (cc=='<'){
						if (hashLeft[i][j]){
							continue;
						}
						if (hashRight[i][j]||hashUp[i][j]||hashDown[i][j]){
							ans++;
						}else{
							find=true;
							break label;
						}
					}
					if (cc=='v'){
						if (hashDown[i][j]){
							continue;
						}
						if (hashLeft[i][j]||hashUp[i][j]||hashRight[i][j]){
							ans++;
						}else{
							find=true;
							break label;
						}
					}
					if (cc=='^'){
						if (hashUp[i][j]){
							continue;
						}
						if (hashLeft[i][j]||hashDown[i][j]||hashRight[i][j]){
							ans++;
						}else{
							find=true;
							break label;
						}
					}
				}
			}
			if (find){
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}else{
				System.out.println("Case #"+t+": "+ans);
			}
		}
	}
}
