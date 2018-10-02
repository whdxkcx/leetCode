package AndCheck;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int s[]=new int[n+1];
        for(int i=0;i<n;i++){
            s[i]=i;
        }
        for(int i=1;i<=n;i++){
            int from=edges[i][0],to=edges[i][1];
            if(find(from,s)==find(to,s))
                return edges[i];
            union(from,to,s);
        }
        return new int[2];
    }

    public int find(int i,int s[]){
         if(i!=s[i]){
             s[i]=find(s[i],s);
         }
         return s[i];
    }
    public void  union(int from,int to,int s[]){
        s[find(from,s)]=find(to,s);
    }

}
