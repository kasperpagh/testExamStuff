package cphbusiness.pagh;

public class Triangle
{
    private int sideA;
    private int sideB;
    private int sideC;

    private int angleA;
    private int angleB;
    private int angleC;


    public Triangle(int sideA, int sideB, int sideC, int angleA, int angleB, int angleC) throws IllegalTriangleException
    {
        if (!InputValidator.angleSumChecker(angleA, angleB, angleC))
        {
            throw new IllegalTriangleException("Vinkelsum er ikke 180");
        }
        if (!InputValidator.naturalNumberChecker(sideA, sideB, sideC, angleA, angleB, angleC))
        {
            throw new IllegalTriangleException("En vinkel eller side er 0 - det må den ikke!");
        }
        if (!InputValidator.inequalityChecker(sideA, sideB, sideC))
        {
            throw new IllegalTriangleException("Siderne overholder ikke Triangle Inequality Theorem");
        }
        else
        {
            System.out.println("Validation passed, constructing Triangle!!");
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.angleA = angleA;
            this.angleB = angleB;
            this.angleC = angleC;
        }
    }


    public String getTriangleType()
    {
        if (TriangleTypeChecker.equilateralCheck(sideA, sideB, sideC, angleA, angleB, angleC)) //ens sider og ens vinkler gør en equilateral trekant
        {
            return "equilateral";
        }
        else if (TriangleTypeChecker.isoscelesCheck(sideA, sideB, sideC, angleA, angleB, angleC))
        {
            return "isosceles";
        }
        else
        {
            //a != b && b != c && c != a Er altid sandt, hvis de ovenstående ikke er sande!
            //Det skyldes at der kun er tre typer trekanter!
            return "scalene triangle";
        }
    }
}
