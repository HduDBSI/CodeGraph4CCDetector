package googlejam8.p865;


import java.util.ArrayList;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner scn  = new Scanner(System.in);
		int t = scn.nextInt();
		
		
		for(int i=1;i<=t;i++){
			int n = scn.nextInt();
			ArrayList<Integer> nums = new ArrayList<Integer>();
			double sum = 0;
			for(int j=0;j<n;j++){
				nums.add(scn.nextInt());
				sum += nums.get(j);
			}
			String plan = "";
			while (sum>0) {
				sum = 0;
				int maxVal = -1;
				int maxLoc = -1;
				for(int j=0;j<n;j++){
					if(nums.get(j) > maxVal){
						maxVal = nums.get(j);
						maxLoc = j;
					}
					sum+=nums.get(j);
				}
				if(maxVal>0){
					nums.set(maxLoc, maxVal-1);
				
					char c = (char)(maxLoc + 65);
					plan += c;
				}
			}
			String finalPlan = "";
			int cnt = 0;
			for(int j=plan.length()-1;j>=0;j--){
				if(cnt>0 && cnt%2==0){
					finalPlan = " "+finalPlan;
				}
				finalPlan = plan.charAt(j)+finalPlan;
				cnt++;
				
			}
			
			System.out.println("Case #"+i+": "+finalPlan);
		}
		
		scn.close();

	}

}
