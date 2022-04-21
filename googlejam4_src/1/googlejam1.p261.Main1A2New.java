package googlejam1.p261;
import java.util.*;

public class Main1A2New {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int Case = 0; Case < numCases; Case++){
			
			int times = in.nextInt();
			int[] mushs = new int [times];
			long consumptionOne = 0;
			long consumptionTwo = 0;
			long maxRate = 0;
			for(int i = 0; i < times; i++){
				mushs[i] = in.nextInt();
				if(i > 0 && mushs[i] < mushs[i-1]){
					consumptionOne += mushs[i-1] - mushs[i];
				}
				if(i > 0 && (mushs[i-1] - mushs[i] > maxRate)){
					maxRate = mushs[i-1] - mushs[i];
				}
			}
			consumptionTwo = maxRate*(times-1);
			for(int i = 0; i < times - 1; i++){
				if (mushs[i] < maxRate){
					consumptionTwo = consumptionTwo + mushs[i] - maxRate;
				}
				
			}
			
			System.out.println("Case #" + (Case+1) + ": " + consumptionOne + " " + consumptionTwo);
			
		}
		
	}
	
}