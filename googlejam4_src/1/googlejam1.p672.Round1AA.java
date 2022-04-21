package googlejam1.p672;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Round1AA 
{
	private int[] stages;
	private String result;
	
	public static void main(String[] args)throws Exception 
	{
		Scanner sc = new Scanner(new FileInputStream(args[0]));
		PrintWriter writer = new PrintWriter(new FileOutputStream(args[1]));
		
		//Scanner sc = new Scanner(System.in);
		//PrintWriter writer = new PrintWriter(System.out);
		
		int numberOftestCases = sc.nextInt();
		
		for(int i=0; i<numberOftestCases ; i++)
		{
			Round1AA round1aa = new Round1AA();
			int count = sc.nextInt();
			round1aa.stages = new int[count];
			for(int i2=0;i2<count;i2++)
			{
				round1aa.stages[i2]= sc.nextInt();
			}
			//sratagy1
			int strategy1 = 0;
			int maxSpeed = 0;
			int intOldData = -1; 
			for(int d : round1aa.stages)
			{
				if(intOldData != -1)
				{
					if(intOldData > d)
					{
						int speed = intOldData - d;
						strategy1 += speed;
						if(maxSpeed < speed)
						{
							maxSpeed = speed;
						}
					}
				}
				intOldData = d;
				
			}
			int strategy2 = 0;
			
			for(int i1=0;i1<(round1aa.stages.length-1);i1++)
			{
				int d=round1aa.stages[i1];
				if(d < maxSpeed)
				{
					strategy2 += d;
				}else
				{
					strategy2 += maxSpeed;
				}
			}
			round1aa.result = ""+strategy1+" "+strategy2;
			writer.println("Case #"+(i+1)+": "+round1aa.result);
			writer.flush();
		}
		sc.close();
		writer.close();
	}
	
	

}
