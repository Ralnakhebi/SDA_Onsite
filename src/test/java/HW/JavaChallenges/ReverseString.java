package HW.JavaChallenges;

public class ReverseString {

    public static void main(String[] args) {
        String string= "SDA Onsite";

        System.out.println("reversed String : " + reverseString(string));

    }

    public static String reverseString(String string){
        String reverse = "";

        for(int i=1 ; i<string.length()+1; i++){
            reverse=reverse+string.charAt(string.length()-i);

        }

        return reverse;
    }
}
