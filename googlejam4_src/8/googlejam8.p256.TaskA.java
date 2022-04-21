package googlejam8.p256;
import java.io.*;
import java.util.Arrays;

public class TaskA {

    public static String[] chars = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static void main(String args[]){
        File file = new File("C:\\tests\\inputA.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            PrintWriter writer = new PrintWriter("C:\\tests\\outputA.txt", "UTF-8");
            int count = Integer.parseInt(br.readLine());

            for(int i = 0; i < count; i++) {
                String out = "Case #" + (i+1) + ": ";

                int n = Integer.parseInt(br.readLine());
                int[] p = new int[n];
                String[] str = br.readLine().split(" ");
                int c = 0;
                for(int j = 0; j < n; j++){
                    p[j] = Integer.parseInt(str[j]);
                    c += p[j];
                }

                while(c > 0) {
                    int max = p[0]; int maxi = 0;
                    for(int j = 1; j < p.length; j++){
                        if(p[j] > max){
                            max = p[j];
                            maxi = j;
                        }
                    }

                    if(c == 3){
                        out += chars[maxi] + " ";
                        c--;
                        p[maxi]--;
                        continue;
                    }

                    boolean find = false;
                    for (int j = 0; j < p.length; j++) {
                        if (j != maxi && p[j] == max) {
                            out += chars[j] + chars[maxi] + " ";
                            p[j]--;
                            p[maxi]--;
                            c -= 2;

                            find = true;
                            break;
                        }
                    }

                    if (!find) {
                        if(p[maxi] >= 2) {
                            out += chars[maxi] + chars[maxi] + " ";
                            c -= 2;
                            p[maxi] -= 2;
                        }
                        else{
                            out += chars[maxi] + " ";
                            c--;
                            p[maxi]--;
                        }
                    }
                }

                writer.println(out);
            }

            writer.close();
        }
        catch(Exception e){
            System.out.println("Error:" + e);
        }
    }

}

