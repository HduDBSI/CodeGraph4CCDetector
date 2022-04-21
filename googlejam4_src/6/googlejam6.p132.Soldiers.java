package googlejam6.p132;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Soldiers {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		
		for(int caseNum = 1; caseNum<=t; caseNum++){
			int q =(Integer.parseInt(in.nextLine()) * 2) -1 ;
			int[] heights = new int[2500];
			for(int i = 0; i<q; i++){
				String[] args1 = in.nextLine().split(" ");
				for(String s : args1){
					int foo = Integer.parseInt(s);
					heights[foo-1]++;
				}
			}
			
			List<String> ans = new ArrayList<String>();
			for(int i =0; i<heights.length; i++){
				if(heights[i]%2!=0){
					ans.add(String.valueOf(i+1));
				}
			}
			
			System.out.print("Case #" + caseNum+":");
			for(String s : ans){
				System.out.print(" " + s);
			}
			System.out.println();
		}
	
	}
}
