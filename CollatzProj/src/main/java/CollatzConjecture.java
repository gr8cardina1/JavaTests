public class CollatzConjecture {
    public static void doCollatzConjecture(final int n) {
        System.out.println(n);
        if (n > 1) doCollatzConjecture(n % 2 == 0 ? n / 2 : 3 * n + 1);
    }

    public static void main(String[] args) {
        doCollatzConjecture(7 );
    }
}
