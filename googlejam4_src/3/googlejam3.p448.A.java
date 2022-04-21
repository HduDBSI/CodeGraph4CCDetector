package googlejam3.p448;
import java.util.Scanner;

//3
//1 4 2
//1 7 7
//2 5 1
//
//Case #1: 3
//Case #2: 7
//Case #3: 10

class A
{
	public static void main(String arg[])
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt(), r, c, w, ans;
		StringBuilder p = new StringBuilder();
		
		for (int no = 1; no <= t; no++)
		{
			r = scan.nextInt();
			c = scan.nextInt();
			w = scan.nextInt();
			ans = (w + c / w - 1) * r;
			if(c % w != 0)
				ans += 1;
			p.append(String.format("Case #%d: %d\n", no, ans));
		}
		System.out.print(p);
	}
}
