public class P509 {

    public static void main(String[] args) {
        System.out.println(new P509().fib(30));
        System.out.println(new P509().fibFlat(30));
    }

    public int fib(int n) {
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public int fibFlat(int n) {
        if (n < 2) return n;

        int temp;
        int previous = 0;
        int current = 1;

        for (; n > 1; n--) {
            temp = current;
            current = current + previous;
            previous = temp;
        }
        return current;
    }

}
