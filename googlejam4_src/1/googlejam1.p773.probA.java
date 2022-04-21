package googlejam1.p773;
import java.util.*;

public class probA
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int test = input.nextInt();
        for(int i = 1; i <= test; i++)
        {
            int size = input.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < size; j++)
            {
                list.add(input.nextInt());
            }
			int amount = 0;
			int current = list.get(0);
			for(int i1 = 1; i1 < list.size(); i1++)
			{
			    if(current > list.get(i1))
			        amount += current - list.get(i1);
			    current = list.get(i1);
			}

            int one = amount;
			int per = 0;
			int amount1 = 0;
			
			for(int i2 = 1; i2 < list.size(); i2++)
			{
			    int drop = list.get(i2-1) - list.get(i2);
			    if(drop > per)
			    {
			        per = drop;
			    }    
			}
			
			for(int i1 = 0; i1 < list.size()-1; i1++)
			{
			    amount1 += list.get(i1) > per ? per : list.get(i1);
			}
            int two = amount1;

            System.out.println("Case #"+i+": "+one+" "+two);
        }
    }
}
