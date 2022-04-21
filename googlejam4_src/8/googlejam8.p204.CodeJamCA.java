package googlejam8.p204;
import java.util.Scanner;

public class CodeJamCA {
	public static void main(String []args){
		Scanner reader = new Scanner(System.in);
		int g = reader.nextInt();
		
		for(int k=0;k<g;k++){
			int N = reader.nextInt();
			int [] t = new int[N];
			int tot = 0;
			for(int i=0;i<N;i++){
				t[i] = reader.nextInt();
				tot+= t[i];
			}
			System.out.print("Case #"+(k+1)+":");
			while(tot !=0){
				String answ = "";
				int max = 0;
				int mindex = 0;
				for(int i =0;i<N;i++){
					if(max < t[i]){
						max = t[i];
						mindex = i;
					}
				}
				t[mindex]--;
				tot--;
				answ += (char) (((int) 'A')+mindex);

				max = 0;
				mindex = 0;
				for(int i =0;i<N;i++){
					if(max < t[i]){
						max = t[i];
						mindex = i;
					}
				}
				if(tot == 1){
					tot--;
					answ+= (char) (((int) 'A')+mindex);
				}
				else if(max !=0 && tot!=2){
					tot--;
					answ+= (char) (((int) 'A')+mindex);
					t[mindex]--;
				}
				System.out.print(" "+answ);
				
				
				
			}
			System.out.println();
		}
		
		
		reader.close();
	}
}
