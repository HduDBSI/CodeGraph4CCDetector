package googlejam8.p595;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		int numOfCases;
		File file = new File(System.getProperty("user.dir")+"/"+"TestCase");
		try{
			Scanner sc = new Scanner(file);
			numOfCases = sc.nextInt();
			//Scanner sc = new Scanner(System.in);
			
			for (int num = 1; num<=numOfCases; num++){
				int[] s = new int[1000];
				int n;
				int total;
				
				n = sc.nextInt();
				total = n;
				for (int i=0; i<n; i++){
					s[i] = sc.nextInt();
				}
				
				int indx=0;
				int indx2=0;
				int temp1=-1;
				int temp2=-1;
				System.out.print("Case #"+num+": ");
				while (true){
					int max=0;
					
					if (temp1 ==-1){
						indx = 0;
						indx2 = 0;
					}
					
					for (int i=0; i<n; i++){
						if (s[i] >= max){
							max = s[i];
							indx = i;
						}
					}
					s[indx]--;
					
					int t;
					boolean not=false;
					total = n;
					for (t=0; t<n; t++){
						if (s[t] != 0){not=true;}
						else
							total--;
					}
					
					if (!not){
						System.out.print((char)(indx+'A')+" ");
						if (temp1 != -1){
							System.out.print((char)(temp1+'A'));
							System.out.print((char)(temp2+'A'));
						}
						break;
					}
					
					if (total ==2){
						int a=0, b=0;
						for (int i=0; i<n; i++){
							if (s[i] > 0 && a ==0){
								a = s[i];
							}
							else {
								b = s[i];
							}
						}
						if (a==b){
							System.out.print(" ");
							continue;
						}
					}
					
					max = 0;
					for (int i=0; i<n; i++){
						if (s[i] >= max){
							max = s[i];
							indx2 = i;
						}
					}
					s[indx2]--;
					
					not = false;
					total = n;
					for (t=0; t<n; t++){
						if (s[t] != 0){not = true;}
						else
							total--;
					}
					//System.out.println(total);
					
					if (total !=1){
						System.out.print((char)(indx+'A'));
						System.out.print((char)(indx2+'A')+" ");
					}
					else{
						temp1=indx;
						temp2=indx2;
					}
					if (!not)
						break;
				}
				System.out.println("");
			
			}
			sc.close();
			}
		catch (Exception e) {
	       System.out.println(e);
	       }

	}
	
}
