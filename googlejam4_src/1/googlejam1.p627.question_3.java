package googlejam1.p627;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class question_3 {
	public static void main(String[] args){
		Scanner scanner;
		try {
			scanner = new Scanner(new File("A-large.in"));
			int noofTests = scanner.nextInt();
			
			
			int i=0;
			
			while(i<noofTests){
				ArrayList no =  new ArrayList();	
				int temptwo=0;
			int noOfEaten = scanner.nextInt();
			for(int j=0;j<noOfEaten;j++){
				no.add(scanner.nextInt());								
			}
			int sum=0;
			for(int j=0;j<no.size();j++){
				sum+=(int) no.get(j);
			}
			int tmp= (int) no.get(0);
			int sumTmp=0;
			for(int j=1;j<no.size();j++){
				if(tmp > (int) no.get(j))
					sumTmp  += tmp -(int) no.get(j);
				tmp = (int) no.get(j);
			}
			
			int rateSum=0;
				int rate = (int)no.get(noOfEaten-2) - (int)no.get(noOfEaten-1);
				int tmpdiff=0;
				int diff=0;
				for(int j=0;j<no.size()-1;j++){					
					if((int)no.get(j) > (int)no.get(j+1)){
						tmpdiff = (int)no.get(j) - (int)no.get(j+1);
					}
					if(tmpdiff > diff){
						diff = tmpdiff;
					}
				}
				for(int j=0;j<no.size()-1;j++){
					if((int)no.get(j) > diff){
						rateSum += diff;
					}
					else{
						rateSum+=(int)no.get(j);											
					}
				}
				
				temptwo = sum - ((int)no.get(noOfEaten-1)*2) ;
				System.out.println("Case #"+(i+1)+": "+sumTmp + " " + rateSum);
				
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
