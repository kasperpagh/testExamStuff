package cphbusiness.pagh;

public class InputValidator
{
    public static boolean naturalNumberChecker(int a, int b, int c, int d, int e, int f)
    {
        if (a > 0 && b > 0 && c > 0 && d > 0 && e > 0 && f > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean angleSumChecker(int d, int e, int f)
    {
        if ((d + e + f) == 180)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean inequalityChecker(int a, int b, int c)
    {
        if ((a + b > c) && (a + c > b) && (b + c > a))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
