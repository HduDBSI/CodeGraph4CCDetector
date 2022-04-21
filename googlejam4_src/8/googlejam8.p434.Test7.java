package googlejam8.p434;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test7 {
    public static void main(String[] args) throws NumberFormatException, IOException {
         //BufferedReader br = new BufferedReader(new
         //InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("text3")));
        int testCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCount; i++) {
            int number = Integer.parseInt(br.readLine());
            int sena[] = new int[number];
           double sum = 0;
           Map<Character,Integer> map = new HashMap<>();
           String[] string = br.readLine().split(" ");
            for(int j=0;j<number;j++) {
                sena[j] = Integer.parseInt(string[j]);
                map.put((char) (j+65), sena[j]);
                sum +=sena[j];
            }
            String answer = "";
            while(sum>0) {
            Map.Entry<Character, Integer> maxEntry = null;

            for (Map.Entry<Character, Integer> entry : map.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }
            answer += maxEntry.getKey().toString();
            map.put(maxEntry.getKey(),maxEntry.getValue()-1);
            sum--;
            if(sum>0 && sum!=2) {
            for (Map.Entry<Character, Integer> entry : map.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }

            answer=answer+maxEntry.getKey().toString();
            map.put(maxEntry.getKey(),maxEntry.getValue()-1);
            sum--;
            }
            answer+=" ";
            }

            System.out.println("Case #" + i + ": " + answer.trim());
        }
    }
}
