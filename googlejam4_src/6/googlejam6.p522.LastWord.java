package googlejam6.p522;
import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by andyyzhengg on 4/15/2016.
 */
public class LastWord {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            int t = Integer.parseInt(br.readLine());
            BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
            for(int i = 1; i <= t; i++) {
                int n = Integer.parseInt(br.readLine());
                HashMap<String, Integer> heightsToCount = new HashMap<>();
                for(int j = 0; j < 2 * n - 1; j ++) {
                    String[] split = br.readLine().split(" ");
                    for(String s : split) {
                        if(heightsToCount.containsKey(s))
                            heightsToCount.put(s, heightsToCount.get(s) + 1);
                        else
                            heightsToCount.put(s, 1);
                    }
                }
                List<Integer> collect = heightsToCount.entrySet().stream().filter(set -> set.getValue() % 2 != 0).map(Map.Entry::getKey).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
                Collections.sort(collect);
                bw.write(String.format("Case #%d:", i));
                for(Integer c : collect) bw.write( String.format(" %d", c));
                bw.write("\n");
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
