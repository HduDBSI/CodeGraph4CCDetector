package googlejam7.p212;


import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			String cScore = scan.next();
			String jScore = scan.next();
			int length = cScore.length();
			/*
			boolean[] cIndicator = new boolean[length];
			boolean[] jIndicator = new boolean[length];
			for(int i=0;i<length;i++){
				if(cScore.charAt(i) != '?'){
					cIndicator[i] = true;
				}
				else{
					cIndicator[i] = false;
				}
			}
			*/
			int maxValue = 0;
			for(int i1=0;i1<length;i1++){
				maxValue = maxValue*10+9;
			}
			
			int minDiff = Integer.MAX_VALUE;
			String cTarget = "";
			String jTarget = "";
			
			for(int cValue = 0; cValue<=maxValue;cValue++){
				String cStr = String.valueOf(cValue);
				if(cStr.length()<length){
					int cdiff = length - cStr.length();
					for(int j=0;j<cdiff;j++){
						cStr = "0" + cStr;
					}
				}
				boolean cmatch = true;
				for(int i2=0;i2<length;i2++){
					if(cScore.charAt(i2) != '?' && cScore.charAt(i2) != cStr.charAt(i2)){
						cmatch = false;
						break;
					}
				}
				if(!cmatch){
					continue;
				}
				//cValue is matched
				
				for(int jValue = 0; jValue<=maxValue;jValue++){
					String jStr = String.valueOf(jValue);
					if(jStr.length()<length){
						int jdiff = length - jStr.length();
						for(int j=0;j<jdiff;j++){
							jStr = "0" + jStr;
						}
					}
					boolean jmatch = true;
					for(int i3=0;i3<length;i3++){
						if(jScore.charAt(i3) != '?' && jScore.charAt(i3) != jStr.charAt(i3)){
							jmatch = false;
							break;
						}
					}
					if(!jmatch){
						continue;
					}
					//jValue is matched
					
					int valueDiff = Math.abs(cValue - jValue);
					if(minDiff > valueDiff){
						minDiff = valueDiff;
						cTarget = cStr;
						jTarget = jStr;
					}
					
					
				}
				
			}
			
			ArrayList<String> list1 = new ArrayList<String>();
			list1.add(cTarget);
			list1.add(jTarget);
			ArrayList<String> list = list1;
			System.out.printf("Case #%d: %s %s\n", i, list.get(0), list.get(1));
		}
		scan.close();
	}

}
