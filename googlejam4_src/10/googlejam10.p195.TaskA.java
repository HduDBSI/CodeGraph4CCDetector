package googlejam10.p195;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        String fileName = "A-small-attempt1.in";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".out"))) {
                int tests = Integer.valueOf(br.readLine());
                for (int test = 1; test <= tests; ++test) {
                    Scanner scanner = new Scanner(br.readLine());
                    int nn = scanner.nextInt();
                    int rr = scanner.nextInt();
                    int pp = scanner.nextInt();
                    int ss = scanner.nextInt();
                    List<String> res = new ArrayList<>();
  /*                  char tmp[] = new char[(int)Math.pow(2, nn)];
                    Arrays.fill(tmp, 'P');
                    String tmpRes = null;
                    while (true) {
                        int cur = tmp.length - 1;
                        int r = rr;
                        int p = pp;
                        int s = ss;
                        boolean good = true;
                        for (char c: tmp) {
                            if ('P' == c)
                                --p;
                            if ('R' == c)
                                --r;
                            if ('S' == c)
                                --s;
                            if (p < 0 || s < 0 || r < 0) {
                                good = false;
                                break;
                            }
                        }
                        if (good) {
                            char tPrev[] = Arrays.copyOf(tmp, tmp.length);
                            while (tPrev.length > 1) {
                                char tCur[] = new char[tPrev.length / 2];
                                for(int i =0; i < tCur.length; ++i) {
                                    if ((tPrev[i*2] == 'R' && tPrev[i*2+1] == 'P')
                                        || (tPrev[i*2] == 'P' && tPrev[i*2+1] == 'R'))
                                        tCur[i] = 'P';
                                    else if ((tPrev[i*2] == 'R' && tPrev[i*2+1] == 'S')
                                            || (tPrev[i*2] == 'S' && tPrev[i*2+1] == 'R'))
                                        tCur[i] = 'R';
                                    else if ((tPrev[i*2] == 'P' && tPrev[i*2+1] == 'S')
                                            || (tPrev[i*2] == 'S' && tPrev[i*2+1] == 'P'))
                                        tCur[i] = 'S';
                                    else {
                                        good = false;
                                        break;
                                    }
                                }
                                tPrev = tCur;
                            }
                            if (good) {
                                String tt = new String(tmp);
                                if (tmpRes == null)
                                    tmpRes = tt;
                                else if (tmpRes.compareTo(tt) > 0)
                                    tmpRes = tt;
                            }
                        }

                        while( cur >= 0 && tmp[cur] == 'S')
                            --cur;
                        if (cur < 0)
                            break;
                        if (tmp[cur] == 'P')
                            tmp[cur] = 'R';
                        else if (tmp[cur] == 'R')
                            tmp[cur] = 'S';
                        for (int i = cur + 1; i < tmp.length; ++i)
                            tmp[i] = 'P';
                    }
                    if (tmpRes != null)
                        bw.write(tmpRes + "\n");
                    else
                        bw.write("IMPOSSIBLE" + "\n");
*/

                    start:
                    for (int start = 0; start <= 2; ++start) {
                        int n = nn;
                        int r = rr;
                        int p = pp;
                        int s = ss;
                        int prevLen = 1;
                        char prev[] = new char[prevLen];
                        if (start == 0)
                            prev[0] = 'P';
                        if (start == 1)
                            prev[0] = 'R';
                        if (start == 2)
                            prev[0] = 'S';
                        int curLen;
                        while (n-- > 0) {
                            curLen = prevLen * 2;
                            char cur[] = new char[curLen];
                            for (int i = 0; i < prevLen; ++i) {
                                if (prev[i] == 'P') {
                                    cur[i*2] = 'P';
                                    cur[i*2 + 1] = 'R';
                                } else if (prev[i] == 'R') {
                                    if (n == 0) {
                                        cur[i*2] = 'R';
                                        cur[i*2 + 1] = 'S';
                                    } else {
                                        cur[i*2] = 'S';
                                        cur[i*2 + 1] = 'R';
                                    }
                                } else if (prev[i] == 'S') {
                                    if (n >= 2) {
                                        cur[i*2] = 'S';
                                        cur[i*2 + 1] = 'P';
                                    } else {
                                        cur[i*2] = 'P';
                                        cur[i*2 + 1] = 'S';
                                    }
                                }
                            }
                            prevLen = curLen;
                            prev = cur;
                        }
                        int a = 1;
                        for (char c: prev) {
                            if ('P' == c)
                                --p;
                            if ('R' == c)
                                --r;
                            if ('S' == c)
                                --s;
                            if (p < 0 || s < 0 || r < 0)
                                continue start;
                        }
                        res.add(new String(prev));
                    }
                    bw.write("Case #" + test + ": ");
                    if (res.isEmpty())
                        bw.write("IMPOSSIBLE");
                    else {
                        String result = null;
                        for (String s: res) {
                            if (result == null)
                                result = s;
                            else {
                                if (result.compareTo(s) > 0)
                                    result = s;
                            }
                        }
                        bw.write(result);
                    }
                    bw.write("\n");
                }
                bw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
