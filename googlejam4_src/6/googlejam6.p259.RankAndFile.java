package googlejam6.p259;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RankAndFile {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numCases = Integer.parseInt(in.readLine());
		for (int caseNumber = 1; caseNumber <= numCases; caseNumber++) {
		   int[] sol = new int[2502];
		   int N = Integer.parseInt(in.readLine());
		   for(int i=0;i<(2*N-1);i++)
		   {
			   String s = in.readLine();
			   String[] t = s.split(" ");
			   for(String r : t)
			   {
				   int l = Integer.parseInt(r);
				   sol[l]++;
			   }
		   }
		   
		   ArrayList<Integer> res = new ArrayList<>();
		   
		   for(int j=0;j<sol.length;j++)
		   {
			   if(sol[j]!=0 && sol[j]%2==1)
			   {
				   res.add(j);
			   }
		   }
		   
		   String result = "";
		   for(int k=0;k<res.size();k++)
				result+=" " + res.get(k);
		   System.out.println("Case #" + caseNumber + ":" + result);
		}
	}

}
