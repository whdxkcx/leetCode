package Bishi.XiaoMi;

import java.util.*;

public class Main1 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        ArrayList<String> aList=new ArrayList<>();
        String s="";
        while(!(s=in.nextLine()).equals("END")){
            aList.add(s);
        }
        int t=aList.size();
        int b[]=new int[t];
        Map<Integer,Integer>  map=new LinkedHashMap<>();
        for(int i=0;i<t;i++){
             b[i]=toTen(aList.get(i));
             if(map.containsKey(b[i]))
                 map.put(b[i],-1);
             else
                 map.put(b[i],i);
        }
        boolean flag=false;
        for(int val: map.keySet()){
            if(map.get(val)!=-1) {
                System.out.println(aList.get(map.get(val)));
                flag=true;
            }
        }
        if(!flag) System.out.println("None");
    }

    public  static  int toTen(String s){
        String[] sAr=s.split("#");
        int n=Integer.parseInt(sAr[0]);
        return Integer.parseInt(sAr[1],n);
    }
}
