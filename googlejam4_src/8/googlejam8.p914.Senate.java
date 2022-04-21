package googlejam8.p914;
import java.util.*;
import java.io.*;

public class Senate {

	public static void main(String[] args) {
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); // MY_PROGRAM < large_input.txt > large_output.txt
    	int testCases = in.nextInt();

    	for (int i = 1; i <= testCases; i++) {
    		int n = in.nextInt();
    		String[] senators = new String[n];
    		int currentParty = 65;
    		int totalSen = 0; 
    		String evacuation = "";

    		for (int j = 0; j < n; j++) {
    			int sen = in.nextInt();
				String toReturn = "";
				for (int i1 = 0; i1 < sen; i1++) {
					toReturn += (char) currentParty;
				}
    			senators[j] = toReturn;
    			currentParty++;
    			totalSen += sen;
    		}
			Arrays.sort(senators, new Comparator<String>(){
						@Override
						public int compare(String s1, String s2) {
							return s2.length() - s1.length();
						}
			});

    		senators = senators;

    		if (totalSen % 2 != 0) {
    			evacuation += senators[0].charAt(0) + " ";
				StringBuilder sb = new StringBuilder(senators[0]);
				sb.deleteCharAt(0);
    			senators[0] = sb.toString();
				Arrays.sort(senators, new Comparator<String>(){
							@Override
							public int compare(String s1, String s2) {
								return s2.length() - s1.length();
							}
				});
    			senators = senators;
    		}

    		while (!senators[0].equals("")) {
    			evacuation += senators[0].charAt(0);
    			if (senators[1].length() != 0) {
    				evacuation += senators[1].charAt(0);
					StringBuilder sb = new StringBuilder(senators[1]);
					sb.deleteCharAt(0);
    				senators[1] = sb.toString();
    			}
				StringBuilder sb = new StringBuilder(senators[0]);
				sb.deleteCharAt(0);

    			senators[0] = sb.toString();
    			evacuation += " ";
				Arrays.sort(senators, new Comparator<String>(){
							@Override
							public int compare(String s1, String s2) {
								return s2.length() - s1.length();
							}
				});
    			senators = senators;
    		}

    		System.out.println("Case #" + i + ": " + evacuation.trim());
    	}
	}

}