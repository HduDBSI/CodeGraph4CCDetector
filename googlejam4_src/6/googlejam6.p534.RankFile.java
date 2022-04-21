package googlejam6.p534;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Arrays;


public class RankFile{

    public static void main(String[] args){
        try{
            File inputFile = new File("B-large.in");
            FileInputStream streamin = new FileInputStream(inputFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(streamin));
            String line = br.readLine();
            int numTests = Integer.parseInt(line);
            int testNum = 0;
            File outputFile = new File("B-large-solution.txt");
            PrintWriter writer = new PrintWriter(outputFile);
            while ((line = br.readLine()) != null){
                testNum++;
                int N = Integer.parseInt(line);
                int[][] input = new int[2*N-1][N];
                for(int i = 0; i < 2*N-1; i++){
                    line = br.readLine();
                    String[] parts = line.split(" ");
                    for(int j = 0; j < N; j++){
                        input[i][j] = Integer.parseInt(parts[j]);
                    }
                }
				HashMap<Integer,Integer> map = new HashMap<>();
				for(int i = 0; i < 2*N-1; i++){
				    for(int j1 = 0; j1 < N; j1++){
				        Integer count = map.get(input[i][j1]);
				        if(count != null){
				            map.put(input[i][j1], count+1);
				        }else{
				            map.put(input[i][j1], 1);
				        }
				    }
				}
				int[] res1 = new int[N];
				int count = 0;
				for(int key : map.keySet()){
				    if(map.get(key) % 2 != 0){
				        res1[count] = key;
				        count++;
				    }
				}
				Arrays.sort(res1);
                int[] res = res1;
                String out;
                out = "Case #" + testNum + ":";
                for(int j = 0; j < N; j++){
                    out = out + " " + res[j];
                }
                writer.println(out);
            }
            writer.close();
        }catch (IOException e){
            System.out.println("IOException");
        }
    }
}
