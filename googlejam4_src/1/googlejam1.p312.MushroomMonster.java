package googlejam1.p312;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MushroomMonster {

	public static void main(String[] args){
		String filePath = "/files/mushroommonster.txt";
		if(args.length > 0)
			filePath = args[0];
		
		List<String> lines = new ArrayList<String>();
		
		try {
			Files.lines(Paths.get(filePath)).forEach(s -> lines.add(s));
        } catch (IOException ex) {

        }
		
		boolean findingNumberCases = true;
		boolean findingN = false;
		boolean readingCase = false;
		
		int numberCases = 0;
		
		Case[] cases = null;
		
		Case filling = null;
		int indexCaseFilling = 0;
		
		for(String line : lines) {
			if(line == null || line.isEmpty())
				continue;
			if(findingNumberCases){
				try{
					numberCases = Integer.parseInt(line);
					cases = new Case[numberCases];
					findingNumberCases = false;
					findingN = true;
				}
				catch(Exception exp){
					
				}
			}
			else if(findingN){
				try{
					int n = Integer.parseInt(line);
					findingN = false;
					readingCase = true;
					
					filling = new Case();
					filling.N = n;
					filling.mushroomsAtPlate = new int[n];
					
					cases[indexCaseFilling++] = filling;
				}
				catch(Exception exp){
					
				} 
			}
			else if(readingCase){
				String[] mushroomsAtPlates = line.split(" ");
				int index = 0;
				for (String mushroomsAtPlate : mushroomsAtPlates) {
					try{
						int value = Integer.parseInt(mushroomsAtPlate);
						filling.mushroomsAtPlate[index] = value;
						index++;
					}
					catch(Exception exp){
						
					}
				}
				readingCase = false;
				findingN = true;
			}
		}
		
		for(Case _case : cases) {
			int sumMethod1 = 0;
			int sumMethod2 = 0;
			int maxMethod2 = 0;
			
			int previous = _case.mushroomsAtPlate[0];
			
			for(int i = 1; i < _case.mushroomsAtPlate.length; i++){
				int actual = _case.mushroomsAtPlate[i];
				
				int delta = previous - actual;
				
				sumMethod1 += delta > 0 ? delta : 0;
				
				if(previous > actual){
					int eated = previous - actual;
					if(eated > maxMethod2)
						maxMethod2 = eated;
				}
				
				previous = actual;
			}
			
			for(int i = 0; i < _case.mushroomsAtPlate.length-1; i++){
				int actual = _case.mushroomsAtPlate[i];
				if(maxMethod2 > actual)
					sumMethod2 += actual;
				else
					sumMethod2 += maxMethod2;
			}
			
			_case.Result = sumMethod1 + " " + sumMethod2;
		}
		
		for(int i = 0; i < cases.length; i++){
			Case _case = cases[i];
			System.out.println("Case #" + (i+1) + ": " + _case.Result);
		}
		
	}
	
}
