import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class gameStart {
    private Scanner scan = new Scanner(System.in);
    private int maxGuessVal = 100;
    private int minGuessVal = 1;
    private int randomNum = getRandomInt(maxGuessVal, minGuessVal);

    public void start(boolean aiGame){
        Integer[] badNumbers = {3, 6, 9};
        System.out.println("Welcome to numbersGame! please enter an integer up to 99.");
        inputNumber(aiGame, badNumbers);

    }
    public void gameGuess(int numbersGuess, Integer[] badNums, int currentLives, boolean aiGame) {
        int currentGuessInt = 0;
        do {
            System.out.println("Please guess the number, 1-99");
            try {
                currentGuessInt = aiGame ? getRandomInt(maxGuessVal, minGuessVal) : Integer.parseInt(scan.next());
                System.out.println(currentGuessInt);
                if(currentGuessInt == badNums[0] || currentGuessInt == badNums[1] || currentGuessInt == badNums[2]){
                    currentLives--;
                    if(currentGuessInt == numbersGuess){
                        currentLives--;
                    }
                    System.out.println("Your lives: " + currentLives);
                    if(currentLives == 0){
                        System.out.println("You lose");
                        break;
                    }
                }
                if (currentGuessInt >= 1 && currentGuessInt <= 99) {
                    if (currentGuessInt == numbersGuess) {
                        System.out.println("You win! nerd");
                        break;
                    } else if (numbersGuess < currentGuessInt) {
                        System.out.println("Your guess was higher than the goal number");
                        currentLives--;
                        System.out.println("Your lives: " + currentLives);
                        maxGuessVal = currentGuessInt -1;
                        if(currentLives <= 0){
                            break;
                        }
                    } else if (numbersGuess > currentGuessInt) {
                        System.out.println("Your guess was lower than the goal number.");
                        currentLives--;
                        System.out.println("Your lives: " + currentLives);
                        minGuessVal = currentGuessInt +1;
                        if(currentLives <= 0){
                            break;
                        }
                    }
                }
                else{
                    gameGuess(numbersGuess, badNums, currentLives, aiGame);
                    currentLives--;
                }
            } catch(Exception InputMismatchException){
                System.out.println("Only numbers between 1 and 99");
            }
        }while(currentGuessInt != numbersGuess && currentLives > 0);
    }

    public void inputNumber(boolean aiGame, Integer[] badNumbers) {
        int numbersGuessInt = 0;
        try{
            numbersGuessInt = aiGame ? randomNum : Integer.parseInt(scan.next());
            if(aiGame){
                if(numbersGuessInt>=1 && numbersGuessInt<=99) {
                    gameGuess(numbersGuessInt, badNumbers, 10, true);
                }
            }else if(!aiGame){
                if(numbersGuessInt>=1 && numbersGuessInt<=99) {
                    gameGuess(numbersGuessInt, badNumbers, 10, false);
                } else {
                    System.out.println("Please dont enter anything below 1 or above 99");
                    inputNumber(aiGame, badNumbers);
                }
            }
        }catch(Exception InputMismatchException){
            System.out.println("Please dont enter anything below 1 or above 99");
            inputNumber(aiGame, badNumbers);
        }
    }

    public int getRandomInt(int max, int min) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
