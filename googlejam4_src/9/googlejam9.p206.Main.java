package googlejam9.p206;
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=1;c<=cases;c++){
			int B = sc.nextInt();
			long M = sc.nextLong();
			if(M>1<<B-2) System.out.printf("Case #%d: IMPOSSIBLE\n",c);
			else{
				System.out.printf("Case #%d: POSSIBLE\n",c);
				int[][] paths = new int[B][B];
				for(int i=0; i<B;i++){
					for(int j=0;j<B;j++){
						if(j>i) paths[i][j] = 1;
					}
				}
				char[] ch = Long.toBinaryString(M-1).toCharArray();
				for(int i=0;i<B-1;i++) paths[0][i] = 0;
				for(int i=B-ch.length-1;i<B-1;i++) paths[0][i] = ch[i-B+ch.length+1]-48;
				for(int i=0; i<B;i++){
					for(int j=0;j<B;j++){
						System.out.print(paths[i][j]);
					}
					System.out.println();
				}
			}
		}
	}

}