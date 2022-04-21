package googlejam6.p483;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/* Kristin Hamilton
 * 15-Apr-2016
 */
public class RankAndFile
{
	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String [] soldiers = new String[]{};
		List<Integer> soldierList = new ArrayList<Integer>();
		int n = 0;
		int intCount = 0;
		int sld = 0;
		int sldIndex = 0;
		
		for(int i = 1; i < t + 1; i++)
		{
			sb.append("Case #" + i + ": ");
			n = sc.nextInt();
			sc.nextLine();
			soldierList.clear();
			intCount = ((n * n) + (n * (n - 1)));
			
			for(int j = 0; j < intCount; j++)
			{
				sld = (Integer) sc.nextInt();
				sldIndex = soldierList.indexOf(sld);
				
				if(sldIndex > -1)
				{
					soldierList.remove(sldIndex);
				}
				else
				{
					soldierList.add(sld);
				}
			}
		
			soldierList.sort(null);
			for(int j = 0; j < soldierList.size(); j++)
			{
				sb.append(soldierList.get(j));
				if(j < soldierList.size() - 1) sb.append(" ");
			}
			
			if(i < t) sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
