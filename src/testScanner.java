import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * User: Ogheneruona
 * Date: 1/9/15
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class testScanner {
    static Scanner in = new Scanner(System.in);


    public static String getResponsewithPrompt(String request){
        System.out.println(request);
        String response = in.nextLine();

        return response;
    }

    public static void main(String [] args){
        String Question = "Is it a mammal?";
        String Question2 = "Is it a reptile?";
        String resonse = getResponsewithPrompt(Question) ;
        System.out.println(resonse);
        String resonse2 = getResponsewithPrompt(Question2) ;
                System.out.println(resonse2) ;
    }
}
