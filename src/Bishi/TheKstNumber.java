package Bishi;

import java.util.Random;

public class TheKstNumber {


    public static void main(String[] args){
         int a[]={8,5,9,12,15,86,23};
         TheKstNumber thn=new TheKstNumber();
         thn.theKstNum(a,4);
    }
    public void theKstNum(int a[], int k) {
        int start = 0, end = a.length ;
        if (k <= 0 || k > end ) return ;
        int i=getMaxK(a,start,end,k);
        for(int j=i;j<end;j++)
            System.out.print(a[j]+" ");

    }

    public int getMaxK(int a[],int start,int end,int k){
        int mid = 0;
        mid=partion(a,start,end,k);
        if(mid==end-k) return mid;
        if(mid<end-k) return getMaxK(a,mid+1,end,k);
        else return getMaxK(a,start,mid,k-(end-mid));
    }

    public int partion(int a[], int start, int end, int k) {
        Random rd = new Random();
//        int x = (rd.nextInt() + start) % (end - start);
//        swap(a,x,end-1);
        int i = start - 1;
        for (int j = 0; j < end; j++)
            if (a[j] < a[end - 1]) swap(a, ++i, j);
        swap(a,++i,end-1);
        return i;
    }


    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

