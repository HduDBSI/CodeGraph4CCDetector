package googlejam6.p037;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int a =0; a < n; a++){
			int k = input.nextInt();
			ArrayList<Integer> hugeList = new ArrayList<Integer>();
			for(int b = 0; b < k*((2*k)-1); b++){
				hugeList.add(input.nextInt());
			}
			int[] freqDist = new int[50000];
			for(Integer b:hugeList){
				freqDist[b]++;
			}
			ArrayList<Integer> output = new ArrayList<Integer>();
			for(int b = 0; b < freqDist.length; b++){
				if(freqDist[b]%2 != 0){
					output.add(b);
				}
			}
			Collections.sort(output);
			System.out.print("Case #" + (a+1) + ":" + " ");
			for(int b = 0; b < output.size(); b++){
				System.out.print(output.get(b)+" ");
			}
			System.out.println();
		}
	}

}
