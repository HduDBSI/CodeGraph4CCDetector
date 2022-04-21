package googlejam3.p348;
import java.util.Scanner;


public class ca_2015 {

	public static void main(String[] args) {
		int x=0,T=0;
		Scanner s1= new Scanner(System.in);
		T = s1.nextInt();
		while(T!=0)
		{
			T--;
			x++;
			int R = s1.nextInt();
			int C = s1.nextInt();
			int W = s1.nextInt();
			int cal = ((C-1)/W)+W;
			if(R != 1)
				cal += ((R-1)*(C/W));
			if(W > C)
				cal = 0;
			System.out.println("Case #" + x + ": " + cal);
		}

	}

}
