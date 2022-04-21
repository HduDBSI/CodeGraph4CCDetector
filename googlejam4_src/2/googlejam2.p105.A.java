package googlejam2.p105;
import java.util.Scanner;


public class A {

	public static void main(String[] args) {

		Scanner k = new Scanner(System.in);
		int T = k.nextInt();

		for(int i = 0; i < T; i++)
		{
			long input = k.nextLong();
			long output = 0;

			while(input != 0)
			{
				//System.out.println(input);
				if(input <= 20)
				{
					output += input;
					break;
				}
				long flipThis = input;
				long reverse = 0;
				while( flipThis != 0 )
				{
					reverse = reverse * 10;
					reverse = reverse + flipThis%10;
					flipThis = flipThis/10;
				}
				long flipped = reverse;
				if(flipped < input && input % Math.pow(10, (int)(Math.log10(input)+1)/2) == 1)
				{
					input = flipped;
				}
				else
				{
					input--;
				}
				output++;
			}
			System.out.println("Case #"+(i+1)+": " + output);
		}
	}
}