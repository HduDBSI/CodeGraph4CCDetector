package googlejam1.p212;
import java.util.*;

public class A
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int test = 1, cases = Integer.parseInt(sc.nextLine());

		ArrayList<Integer> mushrooms = new ArrayList<Integer>();

		int times;
		int last;
		int curr;

		int minEaten, minRate, rateEaten;

		int i;

		while(test <= cases)
		{
			mushrooms.clear();

			times = sc.nextInt();

			last = sc.nextInt();
			mushrooms.add(last);

			minEaten = 0;
			minRate = 0;

			for(i = 1; i < times; i++)
			{
				curr = sc.nextInt();
				mushrooms.add(curr);

				if(curr < last)
				{
					minEaten += last - curr;
					minRate = Math.max(last - curr, minRate);
				}

				last = curr;
			}

			rateEaten = 0;

			for(i = 0; i < mushrooms.size() - 1; i++)
			{
				curr = mushrooms.get(i);

				if(minRate > curr)
					rateEaten += curr;
				else rateEaten += minRate;
			}

			System.out.println("Case #" + test + ": " + minEaten + " " + rateEaten);

			test++;
		}
	}
}