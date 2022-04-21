package googlejam1.p491;
import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		int T = k.nextInt();
		System.out.println();
		for(int i = 0; i < T; i++)
		{
			int N = k.nextInt();
			k.nextLine();
			String input = k.nextLine();
			Scanner sc = new Scanner(input);
			int m1 = sc.nextInt();
			int answer1 = 0;
			int answer2 = 0;
			int max = 0;
			for(int j = 1; j < N; j++)
			{
				int m0 = m1;
				m1 = sc.nextInt();
				if(m0 - m1 > 0)
				{
					answer1+=m0-m1;
					if(m0-m1 > max)
						max = m0-m1;
				}
				
			}
			sc = new Scanner(input);
			for(int j = 0; j < N-1; j++)
			{
				int m = sc.nextInt();
				answer2 += Math.min(m, max);
			}
			System.out.println("Case #"+(i+1)+": "+answer1 + " " + answer2);
		}

	}

}
