package googlejam8.p721;
import java.util.Scanner;

public class finalc {

	public static void main (String [] args){
	
		
		Scanner scan=new Scanner(System.in);
		String huruf[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		int a=scan.nextInt();
		
		for(int i=0;i<a;i++){
			int b=scan.nextInt();
			
			int sum=0;
			int max=0;
			int maxindex=0;
			
			
				int x[]=new int [b];
				for(int j=0;j<b;j++){
					x[j]=scan.nextInt();
					sum=sum+x[j];
					
					if(max<x[j]){
						max=x[j];
						maxindex=j;
					}
				}
				
			System.out.print("Case #"+(i+1)+": ");
			int maxdua=0;
			int maxdin=0;
			for(int j=0;j<b;j++){
				if((maxdua<x[j])&&(j!=maxindex)){
					maxdua=x[j];
					maxdin=j;
				}
					
			}
			int hahaha=max-maxdua;
			for(int j=0;j<hahaha;j++){
				
				System.out.print(huruf[maxindex]+" ");
				max--;
			}
			
			for(int j=0;j<b;j++){
				if((j!=maxdin)&&(j!=maxindex)){
					for(int k=0;k<x[j];k++){
						System.out.print(huruf[j]+" ");
					}
				}
			}
				
			for(int j=0;j<max;j++){
				System.out.print(huruf[maxindex]+huruf[maxdin]+" ");
			}
			System.out.println();
		}
		
		
	}
}
