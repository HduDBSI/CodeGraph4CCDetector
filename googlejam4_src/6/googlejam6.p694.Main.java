package googlejam6.p694;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int test=1;test<=T;test++) {
      int N = sc.nextInt();
      int rows = 2*N-1;
      int arr[][]=new int[rows][N];
      for(int i=0;i<rows;i++) {
        for(int j=0;j<N;j++) {
          arr[i][j]=sc.nextInt();
        }
      }
      for(int bm=0;bm<(1<<rows);bm++) {
        if (Integer.bitCount(bm)!=N)
          continue;
        int Test[][]=new int[N][N];
        int r=0;
        for(int j=0;j<rows;j++) {
          if ((bm&(1<<j))>0) {
            for(int c=0;c<N;c++) {
              Test[r][c]=arr[j][c];
            }
            r++;
          }
        }
        /*System.out.println("===Before sort===");
        for(int i=0;i<N;i++) {
          for(int j=0;j<N;j++) {
            System.out.print(Test[i][j]+" ");
          }
          System.out.println();
        }*/
        boolean continu=false;
        for(int i=0;i<N;i++) {
          for(int j=i+1;j<N;j++) {
            for(int k=0;k<N;k++) {
              if (Test[i][k]==Test[j][k]) {
                continu=true;
              }
            }
          }
        }
        if(continu)continue;
        int cond = 0;
        for(int i=0;i<N;i++) {
          cond = 0;
          for(int j=i+1;j<N;j++) {
            for(int k=0;k<N;k++) {
              if (Test[i][k]>Test[j][k]) {
                for(int k1=0;k1<N;k1++) {
                  int tmp=Test[i][k1];
                  Test[i][k1]=Test[j][k1];
                  Test[j][k1]=tmp;
                }
              }
            }
          }


        }

        /*System.out.println("===After sort===");
        for(int i=0;i<N;i++) {
          for(int j=0;j<N;j++) {
            System.out.print(Test[i][j]+" ");
          }
          System.out.println();
        }*/
        boolean columns[]=new boolean[N];
        int checkings=0;
        for(int j=0;j<rows;j++) {
          if ((bm&(1<<j))==0) {
            for(int c=0;c<N;c++) {
              int temp=0;
              for(r=0;r<N;r++) {
                if (Test[r][c]!=arr[j][r]) {
                  break;
                } else {
                  temp++;
                }
              }
              if (temp==N) {
                if (!columns[c]){
                  columns[c]=true;
                  checkings++;
                }
              }
            }
          }
        }
        if (checkings!=(N-1)) {
          continue;
        }
        boolean found=false;
        for(int i=0;i<N;i++) {
          if (!columns[i]) {
            System.out.print("Case #"+test+": ");
            for(int j=0;j<N;j++) {
              // System.out.println("answer");
              System.out.print(Test[j][i]+" ");
            }
            System.out.println();
            found=true;
          }
        }
        if(found) break;
      }
    }
  }
}
