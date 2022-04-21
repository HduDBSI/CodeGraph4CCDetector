package googlejam8.p215;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution1 {
    final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String [] bank = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("/Users/ratmir/Downloads/A-large (3).in");
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(fileInputStream);
        FileOutputStream outputStream = new FileOutputStream("/Users/ratmir/Documents/code/hackerrank/algs/src/codejam/y2016/r3/z1/z2.txt");
        PrintWriter printWriter = new PrintWriter(outputStream);
        int t = sc.nextInt();
        for (int ti=1;ti<=t;ti++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int cnt = 0;
            TreeMap<Integer, Set<Integer>> tm = new TreeMap<Integer, Set<Integer>>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                cnt += arr[i];
                Set<Integer> integers = tm.get(arr[i]);
                if (integers ==null) {
                    integers = new HashSet<Integer>();
                    tm.put(arr[i], integers);
                }
                integers.add(i);
            }
            StringBuilder sb = new StringBuilder();
            while (cnt > 0) {
                if (cnt==3 && tm.size()==1 || (cnt==3 && tm.size()==2 && tm.containsKey(0) && tm.containsKey(1))) {
                    System.err.println(tm);
                    Set<Integer> integers = tm.get(1);
                    Iterator<Integer> iterator = integers.iterator();
                    Integer mx1 = iterator.next();
                    Integer mx2 = iterator.next();
                    Integer mx3 = iterator.next();
                    String c1 = alphabet.substring(mx1, mx1 + 1);
                    String c2 = alphabet.substring(mx2, mx2 + 1);
                    String c3 = alphabet.substring(mx3, mx3 + 1);
                    sb = sb.append(c1+" "+c2+c3);
                    cnt -=3;
                    break;
                }
                System.err.println(tm);
                Map.Entry<Integer, Set<Integer>> entry = tm.lastEntry();
                Integer key = entry.getKey();
                Set<Integer> value = entry.getValue();
                Iterator<Integer> iterator = value.iterator();
                int mx = iterator.next();
                if (value.size()>1) {
                    int mx1 = iterator.next();
                    value.remove(mx);
                    value.remove(mx1);
                    if (value.size()==0) {
                        tm.remove(key);
                    }
                    String c = alphabet.substring(mx, mx + 1);
                    String c1 = alphabet.substring(mx1, mx1 + 1);
                    sb = sb.append(c+c1+" ");
                    Set<Integer> integers = tm.get(key - 1);
                    if (integers ==null) {
                        integers = new HashSet<Integer>();
                        tm.put(key-1, integers);
                    }
                    integers.add(mx);
                    integers.add(mx1);
                    cnt -= 2;
                } else {
                    tm.remove(key);
                    if (key > 1) {
                        String c = alphabet.substring(mx, mx + 1);
                        sb = sb.append(c + c + " ");
                        Set<Integer> integers = tm.get(key - 2);
                        if (integers == null) {
                            integers = new HashSet<Integer>();
                            tm.put(key - 2, integers);
                        }
                        integers.add(mx);
                        cnt -= 2;
                    } else {
                        String c = alphabet.substring(mx, mx + 1);
                        sb = sb.append(c + c + " ");
                        Set<Integer> integers = tm.get(key - 1);
                        if (integers == null) {
                            integers = new HashSet<Integer>();
                            tm.put(key - 1, integers);
                        }
                        integers.add(mx);
                        cnt -= 1;
                    }
                }
                //selfcheck
                if (cnt>0) {
                    Map.Entry<Integer, Set<Integer>> entry1 = tm.lastEntry();
                    if (entry1.getValue().size()==1) {
                        if (entry1.getKey()>cnt/2) {
                            System.err.println(entry1.getKey()+" "+cnt);
                            throw new RuntimeException();
                        }
                    }
                }
            }
            String res = "Case #" + ti + ": " + sb.toString();
            System.out.println(res);
            printWriter.write(res + "\n");
        }
        printWriter.close();
    }

}
