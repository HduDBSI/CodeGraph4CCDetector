package googlejam6.p364;
//package com.smart.autoserver;

//import android.support.annotation.NonNull;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class MainClass {
    static Scanner scan;
    static PrintWriter writer;

    public static void main(String[] args) {
        File file = new File("E://B-large.in");
        try {
            writer = new PrintWriter("E://B-large.out");
            scan = new Scanner(file);
            int test = scan.nextInt();
            scan.nextLine();
            for(int i=0;i<test;i++) {
                writer.print("Case #" + (i + 1) + ": ");
                int n = scan.nextInt();
				        HashMap<Integer, Integer> M = new HashMap<>();
				        int[][] A = new int[n*2-1][n];
				        for(int i2=0;i2<n*2-1;i2++) {
				            for(int j=0;j<n;j++) {
				                int tmp = scan.nextInt();
				                if(M.containsKey(tmp)) {
				                    int t = M.get(tmp);
				                    M.remove(tmp);
				                    M.put(tmp, t+1);
				                } else {
				                    M.put(tmp, 1);
				                }
				                //A[i][j] = scan.nextInt();
				            }
				        }
				        Set<Integer> K = M.keySet();
				        List<Integer> KQ = new ArrayList<>();
				        for (Integer i3 : K) {
				            int t = M.get(i3);
				            if(t%2==1)
				                KQ.add(i3);
				        }
				        Collections.sort(KQ);
				        for(int i1=0;i1<KQ.size();i1++) {
				            writer.print(KQ.get(i1) + " ");
				        }
				        writer.println();
				//        for(int i=1;i<n*2-1;i++) {
				//            if(A[i-1][0] > A[i][0]) {
				//                int[] B = new int[n];
				//                for(int j = 0;j < n;j++)
				//                    B[j] = A[i-1][j];
				//                for(int j = 0;j < n;j++)
				//                    A[i-1][j] = A[i][j];
				//                for(int j = 0;j < n;j++)
				//                    A[i][j] = B[j];
				//            }
				//        }
				//        int[][] C = new int[n][n];
				//        for(int i=0;i<n;i++)
				//            C[0][i] = A[0][i];
				//        int i = 0;
				//        int j = 1;
				//        while (true) {
				//            if(A[j][0] == C[i][0]) {
				//                for(int k=0;k<n;k++)
				//                    C[i][k] = A[j][k];
				//            } else {
				//
				//            }
				//        }
            }
            writer.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
