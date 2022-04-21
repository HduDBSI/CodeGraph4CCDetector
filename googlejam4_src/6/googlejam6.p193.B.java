package googlejam6.p193;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class B
{
    public static void main(String[] args) throws Exception
    {
        String round = "large";
        String baseName = B.class.getName().replace('.', '/');
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(baseName + "-" + round + ".in")));
        PrintWriter writer = new PrintWriter(new FileWriter(baseName + "-" + round + ".out"));

        System.out.println("Running: " + round);

        int count = scanner.nextInt();
        for (int i = 0; i < count; i++)
        {
            writer.print("Case #" + (i + 1) + ":");
            int N = scanner.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < (2 * N - 1) * N; j++)
            {
                int v = scanner.nextInt();
                if (map.containsKey(v))
                    map.put(v, map.get(v) + 1);
                else
                    map.put(v, 1);
            }
            List<Integer> heights = new ArrayList<Integer>();
            for (Entry<Integer, Integer> entry : map.entrySet())
                if (entry.getValue() % 2 > 0)
                    heights.add(entry.getKey());
            heights.sort(new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    return o1 - o2;
                }
            });
            for(int result : heights)
                writer.print(" " + result);
            writer.println();
        }
        writer.close();
        scanner.close();
    }
}
