package BitManipulation;

public class HammingDistance416 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
