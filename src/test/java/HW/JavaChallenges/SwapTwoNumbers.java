package HW.JavaChallenges;

public class SwapTwoNumbers {
    public static void main(String[] args) {

        int number = 2346;
        int number2= 456756;

        System.out.println("First Number: "+number+"\nSecond Number: "+number2);

        int temp;
        temp= number;
        number=number2;
        number2=temp;
        System.out.println("After swapping\nFirst Number: "+number+"\nSecond Number: "+number2);


    }

}
