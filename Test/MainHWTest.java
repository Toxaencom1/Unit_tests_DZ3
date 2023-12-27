import DZ3.hw.MainHW;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


public class MainHWTest {

    MainHW mainHW;

    @BeforeEach
    void setup(){
        mainHW = new MainHW();
    }

    @Test
    void isEvenTest(){
        assertTrue(mainHW.evenOddNumber(2));
    }

    @Test
    void isOddTest(){
        assertFalse(mainHW.evenOddNumber(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {15,25,100,115})
    void negativeTest(int n){
        boolean res = mainHW.numberInInterval(n);
        assertFalse(res);
    }

    @ParameterizedTest
    @ValueSource(ints = {26,30,90,99})
    void positiveTest(int n){
        boolean res = mainHW.numberInInterval(n);
        assertTrue(res);
    }
}
