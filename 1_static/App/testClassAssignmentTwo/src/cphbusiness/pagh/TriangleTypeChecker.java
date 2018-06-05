package cphbusiness.pagh;

public class TriangleTypeChecker
{

    public static boolean equilateralCheck(int sideA, int sideB, int sideC, int angleA, int angleB, int angleC)
    {
        if((sideA == sideB && sideB == sideC) && (angleA == angleB && angleB == angleC))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isoscelesCheck(int sideA, int sideB, int sideC, int angleA, int angleB, int angleC)
    {
        if((sideA == sideB || sideB == sideC || sideC == sideA) && (angleA == angleB || angleB == angleC || angleA == angleC))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
