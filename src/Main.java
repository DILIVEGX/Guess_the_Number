import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int level, lives, exit, highLevel = 1, rnd, guess;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                ¡Welcome to Guess the Number: The Game!\
                
                Rules:\
                
                - To level up, you have to guess the number within the current level's range.\
                
                - You have 5 lives. Each wrong guess costs one life.\
                
                - If you run out of lives, it's game over.""");
        do{
            level = 1;
            lives = 5;
            rnd = (int) (Math.random() * (level+1)) + 1;
            while (lives>0) {
                System.out.println("\nHigh Score:" + highLevel);
                System.out.println("Actual Level:" + level);
                System.out.println("Lives:" + lives + "♥");
                System.out.println("\nGuess the random number between 1-" + (level + 1));
                guess = scanner.nextInt();
                if(guess == rnd) {
                    System.out.println("\nThat's the number!\n Entering level " + level + "...");
                    level++;
                    rnd = (int) (Math.random() * (level+1)) + 1;
                } else if (lives>1) {
                    if (guess < rnd){
                        System.out.println("\nThe number is higher than " + guess);
                    } else if (guess > rnd){
                        System.out.println("\nThe number is lower than " + guess);
                    }
                    lives--;
                } else {
                    System.out.println("\nOh no! You are out of lives");
                    System.out.println("\n Your max level was:" + level);
                    if (level > highLevel) {
                        System.out.println("   *   ");
                        System.out.println("  * *  ");
                        System.out.println(" ***** ");
                        System.out.println("*  *  *");
                        System.out.println("Congratulations! New High Score Level!");
                        System.out.println("*  *  *");
                        System.out.println(" ***** ");
                        System.out.println("  * *  ");
                        System.out.println("   *   ");
                        highLevel = level;
                    }
                    lives--;
                }
            }
            System.out.println("Do you want to exit the game? 1) Yes. or 2) To play again.");
            exit = scanner.nextInt();
        }while(exit != 1);
    }
}