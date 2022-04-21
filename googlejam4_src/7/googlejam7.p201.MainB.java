package googlejam7.p201;
import java.util.Scanner;

public class MainB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= T; t++) {
            String a = sc.next();
            String b = sc.next();
            String ab = a+b;
            int min = 9999,fa=9999,fb=9999;
            String sfa="",sfb="";

            int cab = ab.length() - ab.replace("?", "").length();
            for(int i=0;i<Math.pow(10, cab);i++) {
                String s=Integer.toString(i);
                int asasas = cab-s.length();
                for(int j=0;j<asasas;j++) {
                    s="0" + s;
                }
                char ch[] = ab.toCharArray();
                for(int j=0,k=0;j<ch.length;j++) {
                    if(ch[j]=='?'){
                        ch[j]=s.charAt(k++);
                    }
                }

                String f=new String(ch);
                int av = Integer.parseInt(f.substring(0, a.length()));
                int bv = Integer.parseInt(f.substring(a.length()));
                int diff = Math.abs(av-bv);
                if(diff<min) {
                    min=diff;
                    fa=av;
                    fb=bv;
                    sfa = f.substring(0, a.length());
                    sfb = f.substring(a.length());
                } else if(diff==min) {
                    if(av<fa){
                        fa=av;
                        fb=bv;
                        sfa = f.substring(0, a.length());
                        sfb = f.substring(a.length());
                    } else if(av==fa && bv<fb) {
                        fb=bv;
                        sfb = f.substring(a.length());
                    }
                }
            }

            System.out.println("Case #" + t + ": " + sfa + " " + sfb);
        }
    }
}
