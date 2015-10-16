import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ogheneruona
 * Date: 1/4/15
 * Time: 12:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class questionGames {
    String Animal;    //user's input
    String Question = "Is it a Mammal? \n"; //User's question
    Scanner in = new Scanner(System.in);  //user's input scanned

    TreeNode leftchild = new TreeNode("Horse");
    TreeNode rightChild = new TreeNode("Snake");
    TreeNode root = new TreeNode(Question,leftchild,rightChild);
    /**
     * Start interface of the 20 question game
     */
    public void Startgame(){
       /* *
         * Start the interface.*/

            String choice = new String();
            displayMainMenu();
            System.out.println("I bet I can guess what animal is on your Mind? Try me :");
            choice = readResponseWithPrompt(" Do you want to play ? Enter YES to Play and NO to exit");
            while (!(choice.equals("NO"))){
                executeChoice(choice);
                choice = readResponseWithPrompt("Do you want to play again? ");
            }
            System.out.println("Thanks for Playing!");

    }

    /**
     * Displays a menu for the user to decide on what to do
     */
    private void displayMainMenu() {
       System.out.println("Welcome to the 20 Question game. The goal of the game is to figure out what animal is on your mind?");
       System.out.println("How to Play the game?");
        System.out.println("First think of an Animal and let's play. I would figure out what animal you are thinking of in less than 20 questions");
    }

    private String readResponseWithPrompt(String request) {
        String response;
        System.out.println(request);
        response = in.nextLine();
        return response;
    }

    private void executeChoice(String choice){
        System.out.println();
        if (choice.equals("YES"))
            playGame ();
        else
            System.out.println(choice + " is not valid input.");

    }

    /**
     * Playing of the 20 question game
     */

    private void playGame() {
        boolean moreQuestions = true;
        String response;
        TreeNode currentNode  = root;
        while(moreQuestions){
             response = readResponseWithPrompt(currentNode.getItem() + " enter YES or NO other wise"); //ask the question
            if (response.equals("YES")){
               if (currentNode.getLeft().isaleaf()){
                      System.out.println("I guess it is a " + currentNode.getLeft().getItem());
                      response = readResponseWithPrompt("Is that correct? <Enter YES or NO> ");
                      if(response.equals("YES")){
                          System.out.println("I WON, I TOLD U I WOULD GET YOU");
                          moreQuestions = false;
                      }

                      else if (response.equals("NO")){
                          System.out.println("YAY!!!!, YOU WON");
                          String correctAnswer = readResponseWithPrompt("What animal were you think <Enter in the name of the animal>");
                          response = readResponseWithPrompt("Give a question that relates to your answer: Is it a reptile if the animal you were thinking of is a snake? for example");
                          TreeNode temp = currentNode.getLeft();
                          currentNode.setLeft(new TreeNode(response,new TreeNode(correctAnswer),temp));
                          moreQuestions = false;

                      }
               }   else {
                   currentNode = currentNode.getLeft();
               }
            }

            else if (response.equals("NO")){
                if (currentNode.getRight().isaleaf()){
                    System.out.println("I guess it is a " + currentNode.getRight().getItem());
                    response = readResponseWithPrompt("Is that correct? <Enter YES or NO> ");
                    if(response.equals("YES")){
                        System.out.println("I WON, I TOLD U I WOULD GET YOU");
                        moreQuestions = false;
                    }

                    else if (response.equals("NO")){
                        System.out.println("YAY!!!!, YOU WON");
                        String correctAnswer = readResponseWithPrompt("What animal were you think <Enter in the name of the animal>");
                        response = readResponseWithPrompt("Give a question that relates to your answer: Is it a reptile if the animal you were thinking of is a snake? for example");
                        TreeNode temp = currentNode.getRight();
                        currentNode.setLeft(new TreeNode(response,new TreeNode(correctAnswer),temp));
                        moreQuestions = false;

                    }
                }   else {
                    currentNode = currentNode.getRight();
                }
            }

            else{
                System.out.println(response + " is an invalid answer\n Try again !!! (YES or NO answer)");
            }

        }
    }


}
