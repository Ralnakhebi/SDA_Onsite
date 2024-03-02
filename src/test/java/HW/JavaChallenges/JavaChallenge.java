package HW.JavaChallenges;

public class JavaChallenge {

    public static void main(String[] args) {

        //Task1
        //1. Write a Java Program that reverses a string
        String string= "SDA Onsite";

        System.out.println("reversed String : " + reverseString(string));

        //Task2
        //2. Write a Java Program to swap two numbers
        int number = 2346;
        int number2= 456756;

        System.out.println("First Number: "+number+"\nSecond Number: "+number2);
        int temp;
        temp= number;
        number=number2;
        number2=temp;
        System.out.println("After swapping\nFirst Number: "+number+"\nSecond Number: "+number2);

        //Task3
        //3. Write a Java Program that prints fibonacci number due to given integer (11235811...)
        number = 11223;
        System.out.println("fibonscci Number for "+number+" is: "+fibonscci(number));

        //Task4
        //4. Write a Java Program that checks whether given integer is Prime or not
        System.out.println(isPrime(13));

        //Task5
        //5. Write a Java Program that takes an array and returns the difference between the biggest and the smallest numbers.
        int[] a={22,55,66,32,6,7,8};
        int[] b={22,5335,66,3332,6,71,84};
        System.out.println("The deference between biggest and the smallest is: "+deferenceBetween(a));
        System.out.println("The deference between biggest and the smallest is: "+deferenceBetween(b));


    }

    public static String reverseString(String string){
        String reverse = "";

        for(int i=1 ; i<string.length()+1; i++){
            reverse=reverse+string.charAt(string.length()-i);

        }

        return reverse;
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

    public static boolean isPrime(int num){
        if (num <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // If num is divisible by any number from 2 to sqrt(num), it's not prime
            }
        }
        return true;

    }
    public static int deferenceBetween(int[] arrayOfInt){
        int max =arrayOfInt[0];//for starter  take a random num to be max
        int min =arrayOfInt[0]; //for starter take a random num to be min

        for (int num : arrayOfInt){
            if (max<num){
                max=num;
            }if(min>num){
                min=num;
            }
        }
        int deference = max - min;
        return deference;
    }


}
