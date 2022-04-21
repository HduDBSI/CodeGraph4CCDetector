package googlejam8.p543;
import java.io.*;
import java.util.*;

public class A {

	private final String problemName = "A";
	//private final String inTheMiddle = "-small";
	private final String inTheMiddle = "-large";
	private final String inTheEnd = "";
	//private final String inTheEnd = "-attempt0";
	private int caseC;

	public static void main(String[] args) throws IOException {
		A my = new A();
		BufferedReader r = new BufferedReader(new FileReader(new File(my.problemName+my.inTheMiddle+my.inTheEnd+".in")));
		BufferedWriter w = new BufferedWriter(new FileWriter(my.problemName+my.inTheMiddle+my.inTheEnd+".out"));
		my.caseC = Integer.parseInt(r.readLine());
		for (int c=0; c<my.caseC;c++) {
			w.write("Case #" + (c+1) +": ");
			int N = Integer.parseInt(r.readLine());
			int[] partySize = new int[N];
			String[] args1 = r.readLine().split("\\s+");
			int sum = 0;
			for(int i=0 ; i<N ; i++) {
				partySize[i] = Integer.parseInt(args1[i]);
				sum += partySize[i];
			}
			while(sum!=0) {
				int biggestPartyIndex1 = -1;
				int biggestPartyIndex2 = -1;
				int biggestPartySize = 0;
				for(int i=0 ; i<N ; i++) {
					if(partySize[i]>biggestPartySize) {
						biggestPartyIndex1 = i;
						biggestPartySize = partySize[i];
						biggestPartyIndex2 = -1;
					} else if(partySize[i]==biggestPartySize) {
						biggestPartyIndex2 = i;
					}
				}
				int evacuated = (biggestPartyIndex1==-1 ? 0 : 1) + (biggestPartyIndex2==-1 ? 0 : 1);
				if(sum!=3) {
					w.write((biggestPartyIndex1 == -1 ? "" : (char) ('A' + biggestPartyIndex1)) + "" + (biggestPartyIndex2 == -1 ? "" : (char) ('A' + biggestPartyIndex2)));
					if (sum - evacuated != 0) {
						w.write(" ");
					}
					sum -= evacuated;
					if (biggestPartyIndex1 != -1) {
						partySize[biggestPartyIndex1] -= 1;
					}
					if (biggestPartyIndex2 != -1) {
						partySize[biggestPartyIndex2] -= 1;
					}
				} else {
					w.write((biggestPartyIndex1 == -1 ? "" : (char) ('A' + biggestPartyIndex1)) + " ");
					sum -= 1;
					if (biggestPartyIndex1 != -1) {
						partySize[biggestPartyIndex1] -= 1;
					}
				}
			}
			w.write("\n");
		}
		r.close();
		w.close();
	}

}
