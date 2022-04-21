package googlejam3.p344;
import java.util.Scanner;


public class Pr1C1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int r, c, w, ans;
		f: for(int t=1; t<=T; t++){
			r = s.nextInt();
			c = s.nextInt();
			w = s.nextInt();
			
			ans = (r-1) * (c/w);
			//System.out.println(ans);
			
			if(w==1){
				ans+= c;
				System.out.println("Case #"+t+": "+ans);
				continue f;
			}
			if(w==c){
				ans+= c;
				System.out.println("Case #"+t+": "+ans);
				continue f;
			}
			
			if(c<=2*w){
				ans+=w+1;
				System.out.println("Case #"+t+": "+ans);
				continue f;
			}
			else{
				ans = ans+ w+1 + ((c-w-1)/w);
				System.out.println("Case #"+t+": "+ans);
				continue f;
			}
		}
	}

}
