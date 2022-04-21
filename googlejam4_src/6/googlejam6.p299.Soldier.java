package googlejam6.p299;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Sahil on 16/04/16.
 */
public class Soldier {
    public static void main(String[] args) throws IOException {
        {
            {
                String fileAddr = "/users/sahil/Desktop/filename.txt";
                Scanner scanner = new Scanner(System.in).useDelimiter(System.getProperty("line.separator"));
                int numTestcases = scanner.nextInt();
                File file = new File(fileAddr);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                for (int j = 0; j < numTestcases; j++) {
                    int N = scanner.nextInt();
                    HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
                    for (int i = 0; i < 2 * N - 1; i++) {
                        String[] listHeight = scanner.next().split(" ");
                        for (int k = 0; k < N; k++) {
                            if (dictionary.get(listHeight[k]) == null)
                                dictionary.put(listHeight[k], 1);
                            else
                                dictionary.put(listHeight[k], dictionary.get(listHeight[k]) + 1);
                        }
                    }
                    Iterator it = dictionary.entrySet().iterator();
                    List<Integer> missList = new ArrayList<Integer>();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        if ((Integer) pair.getValue() % 2 != 0)
                            missList.add(Integer.parseInt((String)pair.getKey()));
                    }
                    Collections.sort(missList);
                    bw.write("Case #" + (j + 1) + ": ");
                    for (int i : missList) {
                        System.out.print(i);
                        bw.write(Integer.toString(i));
                        bw.write(" ");
                    }
                    bw.newLine();

                }
                bw.close();
                scanner.close();
            }
        }
    }
}
