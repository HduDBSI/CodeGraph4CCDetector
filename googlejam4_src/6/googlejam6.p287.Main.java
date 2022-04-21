package googlejam6.p287;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by talik on 16.04.16.
 */
public class Main {


    public static void main(String[] args) {
        String line;
        int tab[] = new int[2500];
        int tmp;
        int n=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("/home/talik/Dokumenty/1RoundB/B-large.in")));
            Path path = Paths.get("/home/talik/Dokumenty/1RoundB/output.txt");
            // Path file = Files.createFile(path);
            PrintWriter writer = new PrintWriter(path.toString());
            int numberOfLines = Integer.parseInt(reader.readLine());
            for(int i=1;i<=numberOfLines;i++){
                Arrays.fill(tab,0);
                line = reader.readLine();
                n = Integer.parseInt(line);
                for(int j=0;j<(2*n-1);j++) {
                    line = reader.readLine();
                    String[] cos = line.split("\\s+");
                    for (String x: cos) {
                        tmp = Integer.parseInt(x);
                        tab[tmp-1]++;
                    }
                }
                writer.print("Case #"+i+":");
                for (int j=0;j<tab.length;j++){
                    if(tab[j]%2==1){
                        writer.print(" "+(j+1));
                    }
                }
                writer.println();
            }
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io){
            io.printStackTrace();
        }


    }


}
