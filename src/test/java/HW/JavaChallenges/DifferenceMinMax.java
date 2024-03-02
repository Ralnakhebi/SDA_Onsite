package HW.JavaChallenges;

public class DifferenceMinMax {

    public static void main(String[] args) {

        int[] a={22,55,66,32,6,7,8};

        int[] b={22,5335,66,3332,6,71,84};

        System.out.println("The deference between biggest and the smallest is: "+deferenceBetween(a));

        System.out.println("The deference between biggest and the smallest is: "+deferenceBetween(b));

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
