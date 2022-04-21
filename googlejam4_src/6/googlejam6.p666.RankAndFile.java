package googlejam6.p666;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by aneezjoseph on 16/04/16.
 */
public class RankAndFile {
    public static void main(String a[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("RankAndFile.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter  = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        int n = Integer.parseInt(scanner.nextLine());
        int x=1;
        while(n-->0) {
            Map<String,Integer> map = new HashMap<>();
            int arrLength=Integer.parseInt(scanner.nextLine());
            int noOfLines = arrLength*2;
            noOfLines--;
            while(noOfLines-->0) {
                String line = scanner.nextLine();
                String str[] = line.split(" ");
                for (String s : str) {
                    Integer count = map.get(s);
                    if (count == null)
                        count = 0;
                    map.put(s, ++count);
                }
            }
            int []arr=new int[arrLength];
            int index=0;
            for (Map.Entry<String, Integer> entry : map.entrySet())
            {
                if(entry.getValue()%2!=0)
                    arr[index++]=Integer.valueOf(entry.getKey());
                if(index==arrLength)
                    break;

            }
            Arrays.sort(arr);
            String temp="";
            for(int i:arr)
                temp+=i+" ";
            bufferedWriter.write("Case #" + x++ + ": " +temp+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        }
}
