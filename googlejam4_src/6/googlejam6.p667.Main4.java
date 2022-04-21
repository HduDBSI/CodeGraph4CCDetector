package googlejam6.p667;


import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main4 {



    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        BufferedReader br = null;
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("B-large.in"));
            fos = new FileOutputStream(new File("outputL.txt"));
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            final int CASES = Integer.valueOf(br.readLine());
            String[] line = null;
            int N = 0;
            StringBuilder sb = null;
            Set<Integer> result = new HashSet<Integer>();
            for (int i = 1; i <= CASES; i++) {
                result = new HashSet<Integer>();
                sb = new StringBuilder();
                N = Integer.valueOf(br.readLine());
                for (int j=1; j <= 2*N - 1; j++) {
                    line = br.readLine().split("\\s+");
                    for (String stn: line) {
                        if (result.contains(Integer.valueOf(stn))) {
                            result.remove(Integer.valueOf(stn));
                        } else {
                            result.add(Integer.valueOf(stn));
                        }
                    }
                }
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.addAll(result);
                Collections.sort(arrayList);
                sb = new StringBuilder();
                for (int z = 0; z < arrayList.size(); z++) {
                    if(z != arrayList.size() -1 ) {
                        sb.append(String.format("%s ",arrayList.get(z)));
                    } else {
                        sb.append(String.format("%s",arrayList.get(z)));
                    }
                }

                bw.write(String.format("Case #%s: %s",i,sb.toString()));
                bw.newLine();
            }
            br.close();
            bw.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
