package googlejam1.p651;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package codejam;

/**
 *
 * @author Saalim
 */
class ushroom {
    public static void main(String[] args) throws java.io.IOException {
        java.io.BufferedReader br =  new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            int diff=0;
            String s[] = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }
            int max=0;
            for (int j = 1; j < n; j++) {
                if(arr[j]<arr[j-1]){
                    diff+=arr[j-1]-arr[j];
                    if((arr[j-1]-arr[j])>max){
                        max=arr[j-1]-arr[j];
                    }
                }
            }
//            int r = max/10;
////            if(max%10!=0){
////                r++;
////            }
//            r=r*10;
            int diff2=0;
            for (int j = 0; j < n-1; j++) {
                if(arr[j]<=max){
                    diff2=diff2+arr[j];
                }else{
                    diff2=diff2+max;
                }
            }
            System.out.println("Case #"+(i+1)+":"+" "+diff+" "+diff2);
        }
    }
}
