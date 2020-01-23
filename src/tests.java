import org.junit.Assert;
import org.junit.Test;

public class tests {
    gameStart testGame = new gameStart();
    Integer[] badNums = {3, 6, 9};
    int input = 5;


    @Test
    public void testNumberInput(){
        //Assert.assertEquals("WrongTard", 5, testGame.start());
    }

    @Test
    public void testNumCompare(){
       // Assert.assertEquals("No.", true, testGame.gameGuess(input, badNums,10));
    }

    @Test
    public void automatedLifeTest(){
       // Assert.assertEquals("Incorrect", true, testGame.gameGuess(input, badNums, 10));
    }

    @Test
    public void testRandomInt() {
        Assert.assertEquals("not 1" , 1, testGame.getRandomInt(1, 1));
        int randomNumber = testGame.getRandomInt(99, 1);
        Assert.assertEquals("not between 1 - 99" , true, randomNumber >= 1);
        Assert.assertEquals("not between 1 - 99" , true, randomNumber <= 99);
    }
}
