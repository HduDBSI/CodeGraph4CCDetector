package googlejam8.p269;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args){
		A r = new A();
		Scanner sc = new Scanner(System.in);
		
		int testNum = sc.nextInt();
		for(int t=1;t<=testNum;t++){
			r.n = sc.nextInt();
			r.a = new int[r.n];
			r.sum = 0;
			for(int i=0;i<r.n;i++){
				r.a[i] = sc.nextInt();
				r.sum += r.a[i];
			}
			StringBuilder sb = new StringBuilder();
			
			while(true){
				if(r.sum==2){
					for(int i=0;i<r.n;i++){
						if(r.a[i]!=0){
							sb.append((char)(i+65));
						}
					}
					break;
				}
				
				int max = -1;
				int id = -1;
				for(int i=0;i<r.n;i++){
					if(r.a[i]>max){
						max = r.a[i];
						id = i;
					}
				}
				r.a[id]--;
				r.sum--;
				sb.append((char)(id+65));
				
				if(r.sum==2){
					sb.append(' ');
					for(int i=0;i<r.n;i++){
						if(r.a[i]!=0){
							sb.append((char)(i+65));
						}
					}
					break;
				}
				
				for(int i=0;i<r.n;i++){
					if((double)r.a[i]/r.sum >= 0.5){
						r.a[i]--;
						r.sum--;
						sb.append((char)(i+65));
						break;
					}
				}
				
				
				sb.append(' ');
			}
			String ans = sb.toString().trim();
			System.out.println("Case #" + t + ": " + ans);
		}
	}

	int n, sum;
	int[] a;


	
}
