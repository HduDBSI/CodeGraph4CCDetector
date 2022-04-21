package googlejam8.p295;
import java.util.Scanner;

public class ProblemA 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int c = 1; c <= cases; c++)
		{
			String ans = "";
			int parties = input.nextInt();
			int sens[] = new int[parties];
			int total = 0;
			for(int p = 0; p < parties; p++)
			{
				sens[p] = input.nextInt();
				total += sens[p];
			}
			while(total > 3)
			{
				int largest = 0;
				int second = 0;
				for(int i = 0; i < sens.length; i++)
				{
					if(sens[i] > sens[largest])
					{
						largest = i;
						second = -1;
					}
					else if(sens[i] == sens[largest] && i != 0)
					{
						second = i;
					}
				}
				ans += " " + (char)(65 + largest);
				if(second == -1)
				{
					ans += (char)(65 + largest);
					sens[largest] -= 2;
				}
				else
				{
					ans += (char)(65 + second);
					sens[second] -= 1;
					sens[largest] -= 1;
				}
				total -= 2;
			}
			if(total == 3)
			{
				int place = -1;
				for(int i = 0; i < sens.length; i++)
					if(sens[i] == 1)
					{
						place = i;
						sens[i] = 0;
						break;
					}
				ans += " " + (char)(65 + place);
				int left1 = -1;
				int left2 = -1;
				for(int i = 0; i < sens.length; i++)
				{
					if(sens[i] == 1 && left1 == -1)
					{
						left1 = i;
					}
					else if (sens[i] == 1)
					{
						left2 = i;
						break;
					}
				}
				ans += " " + (char)(65 + left1);
				if(left2 != -1)
					ans += (char)(65 + left2);
			}
			if(total <= 2)
			{
				int left1 = -1;
				int left2 = -1;
				for(int i = 0; i < sens.length; i++)
				{
					if(sens[i] == 1 && left1 == -1)
					{
						left1 = i;
					}
					else if (sens[i] == 1)
					{
						left2 = i;
						break;
					}
				}
				ans += " " + (char)(65 + left1);
				if(left2 != -1)
					ans += (char)(65 + left2);
			}
			System.out.println("Case #" + c + ":" + ans);
		}
	}
}
