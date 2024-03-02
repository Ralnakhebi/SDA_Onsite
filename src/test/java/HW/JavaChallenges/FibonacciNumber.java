package HW.JavaChallenges;

public class FibonacciNumber {

    public static void main(String[] args) {

        // f(n) = f(n-1)+f(n-2)
        int number = 11223;
        System.out.println("fibonscci Number for "+number+" is: "+fibonscci(number));


    }

    public static int fibonscci(int num){

        if (num <= 1) {
            return num;
        }
        int prev1 = 1, prev2 = 0, fib = 0;
        for (int i = 2; i <= num; i++) {
            fib = prev1 + prev2;
            prev2 = prev1;
            prev1 = fib;
        }
        return fib;
    }
}
