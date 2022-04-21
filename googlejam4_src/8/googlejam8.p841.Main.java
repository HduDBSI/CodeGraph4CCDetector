package googlejam8.p841;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String s;
		    int lineCount = 0;
		    int testCases = 0;
		    int currentTest = 1;
		    
		    String parties = "";
		    String partyMembers = "";
		
		    try {
		    	
		    	
				while ((s = in.readLine()) != null && s.length() != 0)
				{  	
		
				  if(lineCount == 0)
				  {
					  testCases = Integer.parseInt(s);
				  }
				  else
				  {	  
					  
					  if(parties.equalsIgnoreCase(""))
					  {
				
						  parties = s;
					  }
					  else
					  {
						  if(partyMembers.equalsIgnoreCase(""))
						  {
							  partyMembers = s;
							 
							  System.out.print("Case #"+currentTest+":");
							  int partiesInt = Integer.parseInt(parties);
							  int[] partymemersInt = new int[partiesInt];
							  String[] partymemersString = partyMembers.split(" ");
							  for(int i =0; i< partiesInt; i++)
							  {
								
								  
								  partymemersInt[i]= Integer.parseInt(partymemersString[i]);
							  }
							
							  LinkedList<String> evacuationPlan = new LinkedList<String>();
							  boolean contin = true;
							  while(contin)
							  {
								  
								  int biggest=0;
								  int nextBiggest =0;
								  int biggestParty=0;
								  int nextBiggestParty =0;
								  int totalMembers = 0;
								for(int i=0; i<partiesInt; i++)
								{
									
									if(partymemersInt[i]>=biggest)
									{
										nextBiggest = biggest;
										nextBiggestParty = biggestParty;
										biggestParty = i;
										biggest = partymemersInt[i];
										
									}
									totalMembers+= partymemersInt[i];
								}
								
								if(biggest== nextBiggest)
								{
									if(biggestParty>nextBiggestParty)
									{
										int tmp = biggestParty;
										biggestParty = nextBiggestParty;
										nextBiggestParty = tmp;
									}	
										
								}
								
								
								
								
								if(partymemersInt[biggestParty]==0)
								{
									contin = false;						
								}
							
							
								int evacA=-1;
								int evacB=-1;
								if(partymemersInt[biggestParty]>0)
								{
									partymemersInt[biggestParty]--;
									evacA = biggestParty;
								}
								
								int membersAfterEvacA =0;
								for(int i=0;i<partymemersInt.length;i++)
								{
									membersAfterEvacA+= partymemersInt[i];
								}
								if(membersAfterEvacA!=2)
								{
								
								if(partymemersInt[nextBiggestParty]>0)
								{
									partymemersInt[nextBiggestParty]--;
									evacB = nextBiggestParty;
								}
								}
								
								
								
								if(contin)
								{
										
									evacuationPlan.add( evacA+" "+evacB);
								}
									
							  }
							
							  for (String string : evacuationPlan) {
								String[]paty = string.split(" ");
								if(paty.length>0)
								{
									int patyF = Integer.parseInt(paty[0]);
									if(patyF>-1 && patyF<partyNames.length)
									{
										System.out.print(" ");
									System.out.print(partyNames[patyF]);
									}
									if(paty.length>1)
									{
										int patyB = Integer.parseInt(paty[1]);	
										if(patyB>-1 && patyB<partyNames.length)
										{
											System.out.print(partyNames[patyB]);
										}
									}
									
								}
								
							  }
							  System.out.println("");
							  parties = "";
							  partyMembers = "";
							  currentTest++;
						  }
					  }
					 
					  
					  
					  
				  }
				  
				  lineCount++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	
	  private static String[] partyNames = new String[]{"A","B","C","D","E","F","G", "H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	  
	  

}
