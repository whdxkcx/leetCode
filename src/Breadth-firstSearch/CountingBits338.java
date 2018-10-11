public class CountingBits338 {
    public int[] countBits(int num) {
        int f[]=new int[num+1];
        for(int i=0;i<=num;i++){
            f[i]=i%2+f[i/2];
        }
        return f;
    }
}
