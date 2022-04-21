package googlejam1.p410;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Mushrooms {
	
	static final String filename = "A-large (2).in";
	
	static Scanner seer;
	static int T;
	static int n;
	static int i;
	static ArrayList<Integer> numlist;

	public static void main(String[] args) throws FileNotFoundException {
		//seer = new Scanner(System.in);
		seer = new Scanner(new File(filename));
		T = seer.nextInt();
		for(i = 0; i < T; i++){
			n = seer.nextInt();
			int sumdifs = 0;
			int maxdif = 0;
			int last = 0;
			int curr = 0;
			numlist = new ArrayList<Integer>();
			for(int j = 0; j < n; j++){
				curr = seer.nextInt();
				numlist.add(curr);
				if(last > curr){
					int currdif = last-curr;
					sumdifs += last-curr;
					if(maxdif < currdif)
						maxdif = currdif;
				}
				last = curr;
			}
			int sum2 = 0;
			for(int ind = 0; ind < n-1; ind++){
				sum2 += (int) Math.min(numlist.get(ind), maxdif);
			}
			System.out.printf("Case #%d: %d %d\n",i+1,sumdifs,sum2);
		}
		
	}

}
