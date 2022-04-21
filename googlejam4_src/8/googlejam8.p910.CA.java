package googlejam8.p910;
import java.util.*;
import java.io.*;

public class CA {

	public static void main(String[] args) {
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    	int testCases = in.nextInt();

    	for (int i = 1; i <= testCases; i++) {
    		int n = in.nextInt();
    		String[] senators = new String[n];
    		int currentParty = 65;
    		int sens = 0; 
    		String plan = "";

    		for (int j = 0; j < n; j++) {
    			int sen = in.nextInt();
				String toReturn = "";
				for (int i1 = 0; i1 < sen; i1++) {
					toReturn += (char) currentParty;
				}
    			senators[j] = toReturn;
    			currentParty++;
    			sens += sen;
    		}
			Arrays.sort(senators, new Comparator<String>(){
						@Override
						public int compare(String s1, String s2) {
							return s2.length() - s1.length();
						}
			});

    		senators = senators;

    		if (sens % 2 != 0) {
    			plan += senators[0].charAt(0) + " ";
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
    			plan += senators[0].charAt(0);
    			if (senators[1].length() != 0) {
    				plan += senators[1].charAt(0);
					StringBuilder sb = new StringBuilder(senators[1]);
					sb.deleteCharAt(0);
    				senators[1] = sb.toString();
    			}
				StringBuilder sb = new StringBuilder(senators[0]);
				sb.deleteCharAt(0);

    			senators[0] = sb.toString();
    			plan += " ";
				Arrays.sort(senators, new Comparator<String>(){
							@Override
							public int compare(String s1, String s2) {
								return s2.length() - s1.length();
							}
				});
    			senators = senators;
    		}

    		System.out.println("Case #" + i + ": " + plan.trim());
    	}
	}

}
