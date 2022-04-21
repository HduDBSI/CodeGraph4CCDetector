package googlejam8.p809;
import java.util.*;
import java.io.*;

class Solution implements Comparable<Solution>
{
	static String filename= "output.txt";
  char alpha;
  int no;

  Solution(char a,int k)
  {
    alpha=a;
    no=k;
  }

  @Override
    public int compareTo(Solution otherRequest)
    {
            return Integer.compare(no, otherRequest.no);
    } 




	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
       int t=in.nextInt();
       for(int k=1;k<=t;k++)
       {
                  System.out.print("Case #"+k+": ");
                  int n=in.nextInt();
                  ArrayList<Solution> party=new ArrayList<Solution>();
                  for(int i=0;i<n;i++)
                  {
                    int p=in.nextInt();
                    party.add(new Solution((char)(i+'A'),p));
                  }
                  
                    //System.out.println(party.get(n-1).alpha);
                    Collections.sort(party);
                  while(!party.isEmpty() && party.get(n-1).no!=0)
                  {
                        if(party.get(n-1).no==1)
                        {
                          for(int i=0;i<n-2;i++)
                          {
                            if(party.get(i).no!=0)
                            {
                               party.get(i).no--;
                               System.out.print((char)party.get(i).alpha);
                               System.out.print(" ");
                             }
                          }
                        }
                       if(party.get(n-1).no!=0&&party.get(n-2).no!=0)
                       {
                        party.get(n-1).no--;
                        party.get(n-2).no--;
                        System.out.print((char)party.get(n-1).alpha);
                        System.out.print((char)party.get(n-2).alpha);
                        System.out.print(" ");
                       }
                       else if(party.get(n-2).no==0)
                       {
                        party.get(n-1).no--;
                        //party.get(n-2).no--;
                        System.out.print((char)party.get(n-1).alpha);
                        System.out.print(" ");
                       }
                       Collections.sort(party);

                       /*for(int i=0;i<n;i++)
                        if(party.get(i).no!=0)break;
                       else party.remove(i);*/

                  }

               System.out.println();   
                  
       		
       }
    }
 }     