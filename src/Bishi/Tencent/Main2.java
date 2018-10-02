package Bishi.Tencent;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int a[][]=new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            a[u][v]=1;
        }
        int res=0;
        for(int i=1;i<n;i++){
            if(isImportant(a,i,n))
                res++;
        }
        System.out.println(res);
    }

    public static  boolean  isImportant(int[][] a,int k,int n){
           int x=0,y=0;
           int xFlag[]=new int[n+1];
           int yFlag[]=new int[n+1];
           xFlag[k]=1;
           yFlag[k]=1;
           Queue<Integer> xQueue=new ArrayDeque<>();
           Queue<Integer> yQueue=new ArrayDeque<>();
           for(int i=1;i<=n;i++){
               if(a[k][i]==1&&k!=i){
                   xQueue.add(i);
                   xFlag[i]=1;
               }
               if(a[i][k]==1&&k!=i) {
                   yQueue.add(i);
                   yFlag[i]=1;
               }
           }
           while(!xQueue.isEmpty()){
                   int temp=xQueue.poll();
                   for(int i=1;i<=n;i++){
                        if(a[temp][i]==1&&xFlag[i]==0){
                            xQueue.add(i);
                            xFlag[i]=1;
                        }
                   }
           }

           while(!yQueue.isEmpty()){
            int temp=yQueue.poll();
            for(int i=1;i<=n;i++){
                if(a[i][temp]==1&&yFlag[i]==0){
                    yQueue.add(i);
                    yFlag[i]=1;
                }
            }
        }

           for(int i=1;i<n;i++){
               if(xFlag[i]==1) x++;
               if(yFlag[i]==1) y++;
           }

          if(y>x) return true;
          return false;



    }
}
