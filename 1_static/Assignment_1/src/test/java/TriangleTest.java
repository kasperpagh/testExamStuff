
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest
{
    @Test
    public void angleValidationTester()
    {
        //lave grænseværdier
        assertFalse(InputValidator.angleSumChecker(-1, 0, 0));
        assertFalse(InputValidator.angleSumChecker(0, 0, 0));
        assertFalse(InputValidator.angleSumChecker(1, 0, 0));

        //høje grænseværdier
        assertFalse(InputValidator.angleSumChecker(30, 30, 119));
        assertFalse(InputValidator.angleSumChecker(60, 60, 61));
        assertTrue(InputValidator.angleSumChecker(0, 0, 180));

        //for kong Knud
        assertTrue(InputValidator.angleSumChecker(40, 80, 60));
        assertTrue(InputValidator.angleSumChecker(60, 60, 60));

    }

    @Test
    public void naturalNumberValidationTester()
    {
        //tester lave grænseværdier
        assertFalse(InputValidator.naturalNumberChecker(-1, -1, -1, -1, -1, -1));
        assertFalse(InputValidator.naturalNumberChecker(0, 0, 0, 0, 0, 0));
        assertTrue(InputValidator.naturalNumberChecker(1, 1, 1, 1, 1, 1));

        //Tester høje grænseværdier
        assertTrue(InputValidator.naturalNumberChecker(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1));
        assertTrue(InputValidator.naturalNumberChecker(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertFalse(InputValidator.naturalNumberChecker(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1));
    }


    @Test
    public void inequalityValidationTester()
    {
        //kan ikke fatte og lave grænseværdier på denne
        assertFalse(InputValidator.inequalityChecker(10, 4, 4));

        assertFalse(InputValidator.inequalityChecker(0, 0, 0));

        assertTrue(InputValidator.inequalityChecker(10, 6, 6));

        assertFalse(InputValidator.inequalityChecker(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertTrue(InputValidator.inequalityChecker(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1));
        assertFalse(InputValidator.inequalityChecker(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1));


    }


    private Triangle rightTriangle;
    private Triangle wrongTriangle;

    @Test
    public void constructorTester() throws IllegalTriangleException
    {
        rightTriangle = new Triangle(10, 5, 10, 60, 60, 60);
        assertTrue(rightTriangle != null);
        rightTriangle = null;
        rightTriangle = new Triangle(5, 5, 5, 1, 1, 178);
        assertTrue(rightTriangle != null);

        //Hvis der er exceptions her er noget fucky!
    }


    @Test(expected = IllegalTriangleException.class)
    public void constructorTesterWrong0() throws IllegalTriangleException
    {
        wrongTriangle = new Triangle(-1, -1, -1, -1, -1, -1);
    }

    @Test(expected = IllegalTriangleException.class)
    public void constructorTesterWrong1() throws IllegalTriangleException
    {
        wrongTriangle = new Triangle(0, 0, 0, 0, 0, 0);
    }

    @Test(expected = IllegalTriangleException.class)
    public void constructorTesterWrong2() throws IllegalTriangleException
    {
        wrongTriangle = new Triangle(1, 1, 1, 1, 1, 1);
    }

    @Test(expected = IllegalTriangleException.class)
    public void constructorTesterWrong3() throws IllegalTriangleException
    {
        wrongTriangle = new Triangle(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1);

    }

    @Test(expected = IllegalTriangleException.class)
    public void constructorTesterWrong4() throws IllegalTriangleException
    {
        wrongTriangle = new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

    }

    @Test(expected = IllegalTriangleException.class)
    public void constructorTesterWrong5() throws IllegalTriangleException
    {
        wrongTriangle = new Triangle(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1);

    }


}