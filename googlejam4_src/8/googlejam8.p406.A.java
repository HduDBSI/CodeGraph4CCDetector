package googlejam8.p406;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A {

    public static void main(String[] args) throws IOException, URISyntaxException {
        int caseNum = 0;
        List<String> lines = new ArrayList<>();
        String result = new String();
        int parties = 0;
        for (String line : Files.readAllLines(Paths.get(ClassLoader.getSystemResource("A-large.in").toURI()))) {
            if (caseNum == 0) {
                ++caseNum;
                continue;
            }

            if (parties == 0) {
                parties = Integer.valueOf(line);
                continue;
            }

            String[] nesto = line.split(" ");
            int[] members = new int[nesto.length];
            for (int i = 0; i < nesto.length; i++) {
                members[i] = Integer.valueOf(nesto[i]);
            }

            boolean evacuated = false;

            int f = -1, fi = -1, s = -1, si = -1, sum = 0;
            int[] sorted;
            while (!evacuated) {
                sorted = Arrays.copyOf(members, members.length);
                Arrays.sort(sorted);
                f = sorted[sorted.length - 1];
                s = sorted[sorted.length - 2];
                if (f == 0) {
                    evacuated = true;
                    break;
                }
                for (int i = 0; i < members.length; i++) {
                    sum += members[i];
                    if (f == members[i] && fi == -1) {
                        fi = i;
                    }
                    if (si == -1 && s == members[i] && i != fi) {
                        si = i;
                    }
                }

                if (sum == 3) {
                    result += (String.valueOf((char)(fi + 65)) + " ");
                    members[fi]--;
                } else {
                    result += String.valueOf((char)(fi + 65)) + String.valueOf((char)(si + 65)) + " ";
                    members[fi]--;
                    if (si != -1) {
                        members[si]--;
                    }
                }
                s = -1;
                f = -1;
                si = -1;
                fi = -1;
                sum = 0;
            }

            lines.add(String.format("Case #%s: %s", caseNum++, result.trim()));
            result = new String();
            parties = 0;
        }
        Files.write(Paths.get("src\\a.out"), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }

}
