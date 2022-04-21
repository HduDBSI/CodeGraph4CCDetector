package googlejam1.p846;
import java.util.*;
import java.io.*;
public class mush{
public static void main()throws Exception
{
String inFile = "mush0.in";
String outFile = "mush.out";
Scanner sc = new Scanner(new File(inFile));
PrintWriter writer = new PrintWriter(outFile);
int num_test = sc.nextInt();

for(int i = 1; i<= num_test; i++)
{
int term = sc.nextInt();
sc.nextLine();
String s = sc.nextLine();
Scanner scan = new Scanner(s);
Vector <Integer> v = new Vector <Integer> (0);
while (scan.hasNext())
v.add(scan.nextInt());
int one = 0;
int two = 0;
for (int j = 0; j <= (v.size() - 2); j++)
if (v.get(j)>v.get(j+1))
one += -(v.get(j+1)-v.get(j));
else
one += 0;
//System.out.println(v.size());
Integer arr[] = new Integer[v.size()];
v.toArray(arr);
//Arrays.sort(arr);
int index = v.size()-1;
/*while (arr[index] == arr[index-1])
index--;*/
int max = 0;
for (int u = 0; u<(v.size()-1); u++)
{if ((arr[u]-arr[u+1])>max)
max = arr[u]-arr[u+1];}
//System.out.println(max);}

int rate = max;

//int rate = v.get(v.size()-2)-v.get(v.size()-1);
for (int y = 0; y<= (v.size() - 2); y++)
if (v.get(y)<=rate)
two += v.get(y);
else
two += (rate);

writer.println("Case #" + i + ": " + one + " " + two);
}
writer.close();}
}