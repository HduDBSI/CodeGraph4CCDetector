package googlejam8.p725;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Copyright (c) 2015 Chutong Technologies All rights reserved.
 *
 */

public class Main {
    public static void main(String[] args) throws Exception {
        String in = "d:/A-large (1).in";
        String out = "d:/a.out";
        BufferedReader reader = new BufferedReader(new FileReader(in));
        BufferedWriter write = new BufferedWriter(new FileWriter(out));
        String line = reader.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            String[] nums = reader.readLine().split(" ");
			String string = "";
			List<StringBuilder> list = new ArrayList<StringBuilder>();
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
			    int n = Integer.parseInt(nums[j]);
			    sum += n;
			    StringBuilder line1 = new StringBuilder();
			    for (int i1 = 0; i1 < n; i1++) {
			        line1.append((char) ('A' + j));
			    }
			    list.add(line1);
			}
			
			int index = 0;
			while (sum-- > 0) {
			
			    for (StringBuilder builder : list) {
			        try {
			            string += builder.charAt(index);
			        } catch (Exception e) {
			        }
			    }
			    index++;
			}
			StringBuilder stringBuilder = new StringBuilder(string);
			StringBuilder reverse = stringBuilder.reverse();
			string = "";
			if (reverse.length() % 2 == 0) {
			    for (int p = 0; p < reverse.length() - 2; p += 2) {
			        string = string + reverse.charAt(p) +  reverse.charAt(p + 1) + " ";
			    }
			} else {
			    for (int p = 0; p < reverse.length() - 3; p += 2) {
			        string = string + reverse.charAt(p) +  reverse.charAt(p + 1) + " ";
			    }
			    string = string + reverse.charAt(reverse.length() -3) + " ";
			}
			string = string + reverse.substring(reverse.length() - 2);
            String solve = string;
            write.write("Case #" + (i + 1) + ": " + solve + "\r\n");
        }

        reader.close();
        write.close();
    }
}
