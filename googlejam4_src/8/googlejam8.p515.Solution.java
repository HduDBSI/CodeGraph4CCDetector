package googlejam8.p515;


import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			int numParties = scan.nextInt();
			int[] partyPeopleCount = new int[numParties];
			for(int j=0;j<numParties;j++){
				partyPeopleCount[j] = scan.nextInt();
			}
			char[] partyName = new char[numParties];
			for(int i1=0;i1<numParties;i1++){
				partyName[i1] = (char)('A'+i1);
			}
			
			int numTotalPeople = 0;
			for(int i2=0;i2<numParties;i2++){
				numTotalPeople += partyPeopleCount[i2];
			}
			
			String plan1 = "";
			while(numTotalPeople>0){
				int maxIndex1 = -1;
				int maxValue1 = Integer.MIN_VALUE;
				for(int i1=0;i1<numParties;i1++){
					if(partyPeopleCount[i1]>maxValue1){
						maxValue1 = partyPeopleCount[i1];
						maxIndex1 = i1;
					}
				}
				int maxIndex = maxIndex1;
				int nextMaxIndex1 = -1;
				int nextMaxValue1 = Integer.MIN_VALUE;
				for(int i1=0;i1<numParties;i1++){
					if(i1 != maxIndex && partyPeopleCount[i1]>nextMaxValue1){
						nextMaxValue1 = partyPeopleCount[i1];
						nextMaxIndex1 = i1;
					}
				}
				int nextMaxIndex = nextMaxIndex1;
				int maxValue = partyPeopleCount[maxIndex];
				int nextMaxValue = partyPeopleCount[nextMaxIndex];
				
				if(maxValue>=2){
					//evacuate two of max party
					partyPeopleCount[maxIndex] -= 2;
					numTotalPeople -= 2;
					int maxIndex2 = -1;
					int maxValue2 = Integer.MIN_VALUE;
					for(int i2=0;i2<numParties;i2++){
						if(partyPeopleCount[i2]>maxValue2){
							maxValue2 = partyPeopleCount[i2];
							maxIndex2 = i2;
						}
					}
					int newMaxIndex = maxIndex2;
					if(partyPeopleCount[newMaxIndex] > numTotalPeople/2){
						//recover
						partyPeopleCount[maxIndex] += 2;
						numTotalPeople += 2;
					}
					else{
						plan1 += String.valueOf(partyName[maxIndex]);
						plan1 += String.valueOf(partyName[maxIndex]);
						plan1 += " ";
						continue;
					}
				}
				
				if(nextMaxValue>=1){
					//evacuate one of max party, one of next max party
					partyPeopleCount[maxIndex]--;
					partyPeopleCount[nextMaxIndex]--;
					numTotalPeople -= 2;
					int maxIndex2 = -1;
					int maxValue2 = Integer.MIN_VALUE;
					for(int i2=0;i2<numParties;i2++){
						if(partyPeopleCount[i2]>maxValue2){
							maxValue2 = partyPeopleCount[i2];
							maxIndex2 = i2;
						}
					}
					int newMaxIndex = maxIndex2;
					if(partyPeopleCount[newMaxIndex] > numTotalPeople/2){
						//recover
						partyPeopleCount[maxIndex]++;
						partyPeopleCount[nextMaxIndex]++;
						numTotalPeople += 2;
					}
					else{
						plan1 += String.valueOf(partyName[maxIndex]);
						plan1 += String.valueOf(partyName[nextMaxIndex]);
						plan1 += " ";
						continue;
					}
				}
				
				//evacuate one from max party
				partyPeopleCount[maxIndex]--;
				numTotalPeople--;
				plan1 += String.valueOf(partyName[maxIndex]);
				plan1 += " ";
				
			}
			String plan = plan1;
			System.out.printf("Case #%d: %s\n", i, plan.trim());
		}
		scan.close();
	}

}
