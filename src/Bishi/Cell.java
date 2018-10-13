package Bishi;



import java.lang.reflect.Array;
import java.util.*;

public class Cell {
    public static  void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s1=in.nextLine();
        int lindex1=s1.indexOf('[');
        int rindex1=s1.indexOf(']');
        String sA=s1.substring(lindex1+1,rindex1);
        int lindex2= s1.lastIndexOf('[');
        int rindex2=s1.lastIndexOf(']');
        String sB=s1.substring(lindex2+1,rindex2);
        String strA[]=sA.split(",");
        String strB[]=sB.split(",");
        int lenA=strA.length;
        int lenB=strB.length;
        int numA[]=new int[lenA];
        int numB[]=new int[lenB];
        for(int i=0,j=0;i<lenA||j<lenB;i++,j++){
            if(i<lenA) numA[i]=Integer.parseInt(strA[i]);
            if(j<lenB) numB[i]=Integer.parseInt(strB[i]);
        }

        System.out.println(maxAdvantage(numA,numB));
    }
    //主要使用TreeMap的getHigherEntry函数。找到比B当前元素大的最小值，若没有比它大的，就用最小值来对它（田忌赛马）。
    public static   ArrayList<Integer>  maxAdvantage(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>  res=new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            Map.Entry<Integer, Integer> matchingEntry = map.higherEntry(B[i]);
            if (matchingEntry == null) {
                matchingEntry = map.firstEntry();
            }

            res.add(matchingEntry.getKey());
            if (matchingEntry.getValue() == 1) {
                map.remove(matchingEntry.getKey());
            } else {
                map.put(matchingEntry.getKey(), matchingEntry.getValue() - 1);
            }
        }
        return res;
    }
}
