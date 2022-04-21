package googlejam1.p258;
//Author Jon Keenan
import java.util.Scanner;
public class problem1{
     
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int numTestCases = sc.nextInt();
		
		//Variable declarations
		int N,m,a,b,c,d,temp;
		int[] arr;
		
		/*

		a = min amount from 1st method

		b = min amount from 2nd method

		*/

		
		for (int i = 0; i < numTestCases; i++) {
			//Main working area//		 
			N = sc.nextInt();
			arr = new int[N];
			//Input//
			for(int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
		  
			//Calculate A
			a=0;
			for(int j = 0; j < N-1; j++) {
				d = arr[j] - arr[j+1];			
				if(d > 0){
					a+=d;
				}
			}

		


			//Calculate B
			b=0;
			temp = 0;
			for(int j = 0; j < N-1; j++) {
				c = arr[j] - arr[j+1];


				if(c > 0 && c > temp){	
					temp = c;
				}
			}

			
			for(int j = 0; j < N-1; j++) {
				c = arr[j];

				
				if(c >= temp){	
					b += temp;
				}
				else{
					b += c;
				}
				
			}
			


			


			//Output//
			System.out.println("Case #"+ (i+1) +": " + a + " " + b);

		}
	}
}
