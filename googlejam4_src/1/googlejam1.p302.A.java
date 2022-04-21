package googlejam1.p302;
import java.util.Scanner;

public class A {

	public static void main(String ... hi) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int n=1;n<=cases;n++){
			
			int count = in.nextInt();
			int[] m = new int[count];
			for(int i=0;i<count;i++) m[i]=in.nextInt();
			
			int method1 = 0;
			for(int i=1;i<count;i++){
				int d = m[i]-m[i-1];
				if(d<0){
					method1+=Math.abs(d);
				}
			}
			
			int dif = 0;
			for(int i=1;i<count;i++){
				int d = m[i]-m[i-1];
				if(d<0&&Math.abs(d)>dif){
					dif = Math.abs(d);
				}
			}
			int method2 = 0;
			for(int i=0;i<count-1;i++){
				if(dif>m[i]){
					method2+=m[i];
				}else{
					method2+=dif;
				}
			}
			
			System.out.printf("Case #%d: %s %s\n", n, method1, method2);
		}
		in.close();
	}
	
}
