package Bishi.YY;




import java.util.*;

public class Main1 {
    public  static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer>  sL=new ArrayList();
        ArrayList<Integer>  tempL=new ArrayList<>();
        for(int i=0;i<n;i++){
            sL.add(in.nextInt());
        }
       Collections.sort(sL);
       Set<Integer>  set=new HashSet<>();
       int count=0;
       while(sL.size()!=0) {
           count++;
           for (int val : sL) {
               if (!set.add(val)) tempL.add(val);
           }
           sL.clear();
           ArrayList temp=sL;
           sL=tempL;
           tempL=temp;
       }
       System.out.println(count);
    }

}
