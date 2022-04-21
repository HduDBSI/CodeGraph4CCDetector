package googlejam1.p840;
import java.util.Scanner;


public class MushroomMonster {

    private static Scanner s;

    public static void main(String args[])
    {
        s = new Scanner(System.in);
        int count = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= count; i ++)
        {
            int y = 0;
			int z = 0;
			
			
			int n = s.nextInt();
			int[] nums = new int[n];
			s.nextLine();
			for(int i1 = 0; i1 < nums.length; i1++){
			    nums[i1] = s.nextInt();
			}
			
			//method 1
			int cur = nums[0];
			int biggestDif = 0;
			for(int i3 = 1; i3 < nums.length; i3++){
			    if(nums[i3] < cur){
			        int dif = cur - nums[i3];
			        y += dif;
			        if(biggestDif < dif){
			            biggestDif = dif;
			        }
			    }
			    cur = nums[i3];
			}
			
			for(int i2 = 0; i2 < nums.length-1; i2++){
			   z+=Math.min(biggestDif, nums[i2]);
			}
			
			System.out.println("Case #"+i+": " + y + " " + z);
			s.nextLine();

        }

    }
}