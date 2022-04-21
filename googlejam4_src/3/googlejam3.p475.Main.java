package googlejam3.p475;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int answ, R, C, W;
		for(int z  = 1; z <= T; z++){
			R = in.nextInt();
			C = in.nextInt();
			W = in.nextInt();
			if(W == 1){
				answ = R * C;
			}else{
				answ = ((C + (W - 1)) / W);
				answ *= R;
				answ += W - 1;
			}
			
			System.out.println("Case #" + z + ": " + answ);
			
		}
	}	

}