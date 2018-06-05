
public class Main
{

    public static void main(String[] args)
    {
        try
        {
            Triangle triangle = new Triangle(5, 5, 9, 30, 90, 60);
            System.out.println(triangle.getTriangleType());
        }
        catch (IllegalTriangleException e)
        {
            e.printStackTrace();
        }
    }

}
