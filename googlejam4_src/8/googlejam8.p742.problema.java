package googlejam8.p742;
import java.util.*;
class problema{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int i=1; i<=T; i++){
			int n=s.nextInt();
			int enteros[]=new int[n];
			for(int j=0; j<n; j++){
				enteros[j]=s.nextInt();
			}
			System.out.print("Case #"+i+":");
			while(true){
				int nocero=0;
				int max=0;
				int pos=-1;
				for(int j=0; j<n; j++){
					if( enteros[j]>0 )
						nocero++;
					if( enteros[j]>max ){
						pos=j;
						max=enteros[j];
					}
				}
				if(max==0){
					break;
				}
				int segundo=0;
				int pos2=-1;
				for(int j=0; j<n; j++){
					if( enteros[j]>segundo & j!=pos ){
						pos2=j;
						segundo=enteros[j];
					}
				}
				if( max==segundo && nocero!=3 ){
					enteros[pos]--;
					enteros[pos2]--;
					System.out.print(" "+  ((char)((int)('A')+pos)) + ((char)((int)('A')+pos2)) );
				}
				else{
					enteros[pos]--;
					System.out.print(" "+  ((char)((int)('A')+pos))  );
				}
			}
			System.out.println();
		}
	}
}
