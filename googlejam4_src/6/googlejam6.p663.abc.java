package googlejam6.p663;
import java.util.*;
import java.io.*;
import java.math.*;
class abc
{


  public static void main(String[] args) {
  Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int io=in.nextInt();
  for(int pq=1;pq<=io;pq++)
  {
    int tot=in.nextInt();
    int ar[][]=new int[(2*tot)-1][tot];
    int odd[]=new int[tot];
    int even[]=new int[tot*tot];
    int evennum=0,oddnum=0;
    // int row[][]=new int[tot][tot];
    // int col[][]=new int[tot][tot];
    // int final[][] = new int[tot][tot];
    for(int p=0;p<(2*tot)-1;p++)
    {
      for(int q=0;q<tot;q++)
        ar[p][q]=in.nextInt();
    }
    for(int p=0;p<(2*tot)-1;p++)
    {
      AB:for(int q=0;q<tot;q++)
      {
        for(int k=0;k<evennum;k++)
        {
          if(ar[p][q]==even[k]) continue AB;
        }
        for(int k=0;k<oddnum;k++)
        {
          if(ar[p][q]==odd[k]) continue AB;
        }
        int total=0;
        for(int m=0;m<(2*tot)-1;m++)
        {
          for(int n=0;n<tot;n++)
          {
            if(ar[p][q]==ar[m][n])
              total++;
          }
        }
        if(total%2==0)
          {
            even[evennum]=ar[p][q];
            evennum++;
          }
          else
          {
            odd[oddnum]=ar[p][q];
            oddnum++;
          }
      }
    }
    Arrays.sort(odd);
    System.out.print("Case #"+pq+": ");
    for(int o=0;o<odd.length;o++)
    {
      System.out.print(odd[o]+" ");
    }
    System.out.println();
  }
}
}
    // for(int l=0;l<ar.length;l++)
    // {
    //   int small=ar[l][0];
    //   int pos=l;
    //   for(int m=l+1;m<ar.length;m++)
    //   {
    //     if(ar[m][0]<small)
    //     {
    //       small=ar[m][0];
    //       pos=m;
    //     }
    //   }
    //   for(int o=0;o<tot;o++)
    //   {
    //     int temp=ar[l][o];
    //     ar[l][o]= ar[pos][o];
    //     ar[pos][o]=temp;
    //   }
    // }
    // }
    //   int c=0,r=0;
    //   for(int o=0;o<(2*tot-1);o++)
    //   {
    //       if(r==0)
    //       {
    //         for(int ro=0;ro<tot;ro++)
    //           final[0][ro]=ar[o][ro];
    //         r++;
    //       }
    //       else
    //       {
    //         for(int ro=0;ro<tot;ro++)
    //         {
    //           if(ar[o][0]==final[0][co])
    //           {
    //
    //           }
    //         }
    //       }
      //   if(c==0)
      //   {
      //     for(int ro=0;ro<tot;ro++)
      //       row[0][ro]=ar[o][ro];
      //     c++;
      //   }
      //   else
      //   {
      //     boolean n=false;
      //     int m;
      //     for(m=0;m<tot;m++)
      //     {
      //       if(ar[o][m]<=row[c-1][m])
      //         n=true;
      //     }
      //     if(n==false)
      //     {
      //       for(m=0;m<tot;m++)
      //       {
      //         row[c][m]=ar[o][m];
      //       }
      //       c++;
      //     }
      //     else
      //     {
      //       for(m=0;m<tot;m++)
      //       {
      //         col[r][m]=ar[o][m];
      //       }
      //       r++;
      //     }
      //   }
      // }
      // if(c==tot)
      // {
      //   for(int y=0;y<tot;y++)
      //   {
      //     if(row[y][0]!=col[y][0])
      //     {System.out.println(Arrays.deepToString(row));
      //       System.out.println(Arrays.deepToString(col));
      //       System.out.print("Case #"+pq+": ");
      //       for(int u=0;u<tot;u++)
      //       {
      //         System.out.print(row[u][y]+" ");
      //       }
      //       System.out.println();
      //       break;
      //     }
      //   }
      // }
      // else
      // {
      //   for(int y=0;y<tot;y++)
      //   {
      //     if(row[y][0]!=col[y][0])
      //     {System.out.println(Arrays.deepToString(row));
      //       System.out.println(Arrays.deepToString(col));
      //       System.out.print("Case #"+pq+": ");
      //       for(int u=0;u<tot;u++)
      //       {
      //         System.out.print(col[u][y]+" ");
      //       }
      //       System.out.println();
      //       break;
      //     }
      //   }
