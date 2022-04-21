package googlejam1.p849;


import java.io.*;

public class A {

	public static void main(String[] args) throws Exception {
		File input = new File("/Users/sean/Desktop/GG/a.in");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
		File output = new File("/Users/sean/Desktop/GG/ansA.txt");
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
		int t = Integer.parseInt(reader.readLine());
		String infos[];
		long minNeedPlanA, minNeedPlanB;
		long maxDis;
		int n;
		long vals[];
		for(int i=1; i<=t; ++i){
			minNeedPlanA = minNeedPlanB = 0;
			maxDis = 0;
			n = Integer.parseInt(reader.readLine());
			infos = reader.readLine().split(" ");
			vals = new long[n];
			vals[0] = Long.parseLong(infos[0]);
			for(int j=1; j<n; ++j){
				vals[j] = Long.parseLong(infos[j]);
				if(vals[j] < vals[j-1]){
					minNeedPlanA += (vals[j-1] - vals[j]);
					maxDis = Math.max(maxDis, vals[j-1] - vals[j]);
				}
			}
			for(int j=0; j<n-1; ++j){
				minNeedPlanB += Math.min(vals[j], maxDis);
			}
			writer.write("Case #" + i + ": " + minNeedPlanA + " " + minNeedPlanB +"\r\n");
		}
		reader.close();
		writer.flush();
	}

}
