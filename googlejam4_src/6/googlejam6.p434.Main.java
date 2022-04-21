package googlejam6.p434;


import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static Map<BigInteger, BigInteger> map = new HashMap<BigInteger, BigInteger>();
    public static void main(String[] args) {
        try {

            String filePath = "/Users/jimmychou516/Downloads/";
            String inputFileName = "B-large.in.txt";
//            String inputFileName = "D-small-attempt0.in.txt";
//            String inputFileName = "D-large.in.txt";
            String outputFileName = "output.txt";
            //File file = new File(args[0]);

            // Uncomment to output the file
            PrintStream myconsole = new PrintStream(new File(filePath+outputFileName));
            System.setOut(myconsole);

            Scanner in = new Scanner(new BufferedReader(new FileReader(new File(filePath + inputFileName))));

            //Your Code Here
            int n = in.nextInt(); // number of cases
            for (int i = 1; i <= n; i++) {
                int size = in.nextInt(); // number of N
                List<Integer> list = new LinkedList<Integer>();

                for (int cases = 1; cases <= size*size*2-size; cases++) {
                    int num = in.nextInt();
                    list.add(num);
                }

                Collections.sort(list);
                int index = 0;
                List<Integer> temp = new LinkedList<Integer>();
                while (index < list.size() - 1) {
                    if (list.get(index).equals(list.get(index + 1)) && index < list.size()) {
                        index = index + 2;
                    } else {
                        temp.add(list.get(index));
                        index++;
                    }
                }
                if (temp.size() != size) {
                    temp.add(list.get(list.size() - 1));
                }

                Collections.sort(temp);

                String str = "";
                for (Integer number : temp) {
                    str = str + " " + number;
                }
                System.out.println("Case #" + i + ": "+ str.trim());

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
