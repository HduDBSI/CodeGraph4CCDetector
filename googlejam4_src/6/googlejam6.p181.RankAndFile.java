package googlejam6.p181;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RankAndFile
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("input.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer output = new StringBuffer();
            
            int lines = Integer.parseInt(bufferedReader.readLine());
            for(int i = 1; i <= lines; i++)
            {
                HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
                int size = Integer.parseInt(bufferedReader.readLine());
                for(int j = 0; j < 2 * size - 1; j++)
                {
                    String[] line = bufferedReader.readLine().split(" ");
                    for(String soldier : line)
                    {
                        int value = Integer.parseInt(soldier);
                        if(map.get(value) == null || map.get(value) == false)
                        {
                            map.put(value, true);
                        }
                        else
                        {
                            map.put(value, false);
                        }
                    }
                }
                
                ArrayList<Integer> array = new ArrayList<Integer>();
                for(Integer soldier : map.keySet())
                {
                    if(map.get(soldier) == true)
                    {
                        array.add(soldier);
                    }
                }
                Collections.sort(array);
                String line = "";
                for(Integer value : array)
                {
                    line += " " + value;
                }
                
                output.append("Case #" + i + ": " + line.substring(1) + "\n");
            }
            fileReader.close();
            
            file = new File("output.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(output.toString());
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}