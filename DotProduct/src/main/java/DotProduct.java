
import java.util.Arrays;
import java.util.stream.IntStream;

public class DotProduct {

    private static int doDotProduct(int[] A, int[] B) {
        if ((A.length == 0) || (A.length != B.length)) {
            throw new IllegalArgumentException("Vectors size must be equal and greater then 0!");
        }

        int[] result = IntStream.range(0, A.length).map(i -> A[i] * B[i]).toArray();
        return Arrays.stream(result).reduce(0, Integer::sum);
    }


    public static void main(String[] args) {
        int[] vector1 = {1, 2, 3, 4, -5};
        int[] vector2 = {-5, 4, 3, 2, 1};
        System.out.println("DotProduct= "+doDotProduct(vector1, vector2));
    }
}
