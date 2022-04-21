package googlejam6.p264;
import java.util.*;
class B{
	public static void main(String []args){
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int i=1; i<=T; i++){
			int n=s.nextInt();
			int k=((n*2)-1)*n;
			int arreglo[]=new int[2501];
			for(int j=0; j<2501; j++){
				arreglo[j]=0;
			}
			for(int j=0; j<k; j++){
				int alt=s.nextInt();
				arreglo[alt]++;
			}
			System.out.print("Case #"+i+":");
			for(int j=0; j<2501; j++){
				if( arreglo[j]%2==1 ){
					System.out.print(" "+j);
				}
			}
			System.out.println();
		}
	}
}
