package googlejam6.p312;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Height {
		
		
	public static void main(String[] args){
		
		
		 Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 
		 int problemcount  = scan.nextInt();
		 int i = 1;
		 
		
		 
		 while(i <= problemcount)
		 {

			int count = scan.nextInt() ;
			int countmen = count;
			
			count *= count;
			
			count *= 2;
			count -= countmen;
			
			int[] heights  = new int[2501];
			
			
			while(count > 0){
				
				int height = scan.nextInt();
				
				heights[height]++;
				
				count--;
				
			}
			
			int[] missing = new int[countmen];
			int index = 0;
			
			for(int k = 0; k<heights.length;k++){
				if(heights[k] % 2 == 1){
					missing[index] = k;
					index++;
					
				}
			}
			
			Arrays.sort(missing);
			
			String aux = "";
			
			for(Integer k : missing){
				
				aux += k + " ";
				
			}
			
			aux.trim();
			
			 System.out.println("Case #" + i + ": " + aux);
			 
			 i++;
		 }
		
	}

}
