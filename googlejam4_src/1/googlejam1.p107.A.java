package googlejam1.p107;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		

		// BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		
		int numCases = s.nextInt();
		
		for(int numC = 0; numC < numCases; ++numC)
		{
			int n = s.nextInt();
			
			int[] numbers = new int[n];
			
			for(int i = 0; i < n; ++i)
			{
				numbers[i] = s.nextInt();
			}
			
			int firstMethod = 0;
			for(int i = 1; i < n; ++i)
			{
				int diff = numbers[i-1] - numbers[i];
				
				if(diff > 0)
				{
					firstMethod += diff;
				}
			}
			
			int curr = 0;
			int eaten = 0;
			
			while(true)
			{
				boolean valid = true;
				eaten = 0;
				for(int i = 1; i < n && valid; ++i)
				{
					int after = numbers[i-1] - curr;
					
					eaten += curr;
					if(after < 0)
					{
						eaten += after;
						after = 0;
					}
					if(after > numbers[i])
					{
						valid = false;
					}
					int added = numbers[i] - after;
				}
				if(valid)
				{
					break;
				}
				
				curr++;
			}
			
			int secondMethod = eaten;
			
			System.out.print("Case #");
			System.out.print(numC+1);
			System.out.print(": ");
			System.out.print(firstMethod);
			System.out.print(' ');
			System.out.println(secondMethod);
		}

	}

}
