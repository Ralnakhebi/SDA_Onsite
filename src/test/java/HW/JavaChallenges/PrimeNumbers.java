package HW.JavaChallenges;

public class PrimeNumbers {

    public static void main(String[] args) {
        System.out.println(isPrime(13));

    }

    public static boolean isPrime(int num){
        if (num <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // If n is divisible by any number from 2 to sqrt(n), it's not prime
            }
        }
        return true;

    }
}
