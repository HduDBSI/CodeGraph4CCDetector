package googlejam6.p321;


import java.util.*;
public class Solution {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			
			int numR = sc.nextInt();
			//number of lines
			int[] arr = new int[2505];
			for(int j = 0; j < numR*2-1; j++){
				//number of integers
				for(int k = 0; k < numR; k++){
					int temp = sc.nextInt();
					//System.out.println("Here"+ temp);
					arr[temp]++;
				}
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int x = 0; x < arr.length; x++){
				if( arr[x] % 2 == 1){
					list.add(x);
				}
			}
			Collections.sort(list);
			System.out.print("Case #"+i+": ");
			int p = 0;
			for( p = 0; p < list.size()-1; p++){
				System.out.print(list.get(p)+" ");
			}
			System.out.println(list.get(p));
		}
		
		
	}
}
