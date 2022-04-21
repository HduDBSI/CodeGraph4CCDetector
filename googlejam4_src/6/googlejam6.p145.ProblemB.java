package googlejam6.p145;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by luult on 4/9/2016.
 */
public class ProblemB
{
    static String inputPath = "D:\\contest\\trainning\\round1a2016\\src\\main\\resources\\B-large.in";
    static String outputPath = "D:\\contest\\trainning\\round1a2016\\src\\main\\resources\\B-large.out";

    static Scanner in;
    static BufferedWriter bw;
    static int numberTest;


    static Integer n;
    static int[] numberApper = new int[2600];
    static List<Integer> result = new ArrayList();

    public static void main(String[] args) throws IOException
    {
        bw = new BufferedWriter(new FileWriter(outputPath));
        in = new Scanner(new BufferedReader(new FileReader(inputPath)));

        numberTest = in.nextInt();
        for (int i = 0; i < numberTest; i++)
        {
            System.out.println("test :" + (i + 1));
            n = in.nextInt();
			for (int i1 = 0; i1 < 2500; i1++)
			{
			    numberApper[i1] = 0;
			}
			for (int i2 = 0; i2 < 2 * n - 1; i2++)
			{
			    int pre = 0;
			    for (int j = 0; j < n; j++)
			    {
			        int x = in.nextInt();
			        if (x == pre)
			        {
			            System.out.println("-----------------------------");
			        }
			        pre = x;
			        numberApper[x]++;
			    }
			}
            result = new ArrayList();
			for (int i1 = 0; i1 < 2500; i1++)
			    if (numberApper[i1] > 0 && numberApper[i1] % 2 == 1)
			    {
			        result.add(i1);
			    }
            String list = "";
			for (Integer s : result)
			    list += s + " ";
			String result1 = "Case #" + (i + 1) + ": " + list + "\n";
			bw.write(result1);
        }

        bw.close();
    }
}
