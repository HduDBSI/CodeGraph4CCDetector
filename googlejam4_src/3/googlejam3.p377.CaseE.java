package googlejam3.p377;
import java.util.Scanner;


public class CaseE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T,R,C,W,i,j,k;
		Scanner sca = new Scanner(System.in);
		T =  Integer.parseInt(sca.next());
		int ans[] = new int[T];
		for (i=0;i<T;i++){
			R =  Integer.parseInt(sca.next());
			C = Integer.parseInt(sca.next());
			W = Integer.parseInt(sca.next());
			if (W==1) {
				ans[i]=R*C;
			}
			else {
			if (C%W==0) ans[i] = R*(C/W)+W-1;
			else { ans[i]= (int) (R*Math.floor(C/W)+W);}

			}
		}
		for (i=0;i<T;i++){
			System.out.println("Case #"+(i+1)+": "+ans[i]);
		}
		
	}

}
