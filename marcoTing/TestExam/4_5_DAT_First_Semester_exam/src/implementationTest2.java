import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class implementationTest2 {
    ArrayList<person> arr;
    implementation imp = new implementation();
    {
        try {
            arr = person.readFile("src/data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getOldestPeople() {
        ArrayList<person> alp = imp.getOldestPeople(arr);
        assertEquals(5,alp.size());
        assertEquals("Joseph",alp.get(0).getFirstName());
        assertEquals("noga",alp.get(2).getLastName());
        assertEquals(44,alp.get(4).getAge());
    }

    @Test
    public void getYoungestPeople() {
        ArrayList<person> alp = imp.getYoungestPeople(arr);
        assertEquals(3,alp.size());
        assertEquals("david",alp.get(0).getFirstName());
        assertEquals("mouer",alp.get(1).getLastName());
        assertEquals(0,alp.get(2).getAge());
    }

    @Test
    public void sortByLastName() {
        ArrayList<person> alp = imp.sortByLastName(arr);
        assertEquals(500,alp.size());
        assertEquals("marco",alp.get(0).getFirstName());
        assertEquals("pagh",alp.get(499).getLastName());
        assertEquals(18,alp.get(200).getAge(),4);
    }

    @Test
    public void sortByAge() {
        ArrayList<person> alp = imp.sortByAge(arr);
        assertEquals(alp.size(),500);
        assertEquals("david",alp.get(0).getFirstName());
        assertEquals("pagh",alp.get(499).getLastName());
        assertEquals(20,alp.get(300).getAge());
    }

    @Test
    public void getAverageAge() {

        assertEquals(18.50,imp.getAverageAge(arr,-1,2));
        System.out.println(imp.getAverageAge(arr,0,499));
        assertEquals(19.66,imp.getAverageAge(arr,-100,550));
        assertEquals(14.74,imp.getAverageAge(arr,450,100));
        assertEquals(0,imp.getAverageAge(arr,1000,200));
        assertEquals(0,imp.getAverageAge(arr,10,0));
    }

    @Test
    public void calculateCircleArea() {
        implementation imp = new implementation();
        assertEquals(imp.calculateCircleArea(5),78.53);
        assertEquals(imp.calculateCircleArea(-1),-1);
        assertEquals(imp.calculateCircleArea(0),0);
        assertEquals(imp.calculateCircleArea(100),31415.92);
    }

    @Test
    public void divisible() {
        implementation imp = new implementation();
        assertEquals(imp.divisible(6,3),true);
        assertEquals(imp.divisible(-6,-2),true);
        assertEquals(imp.divisible(6,4),false);
    }

    @Test
    public void calculateDifferenceInSeconds() {
        implementation imp = new implementation();
        assertEquals(imp.calculateDifferenceInSeconds("2011-05-04","2011-05-03"),86400);
        assertEquals(imp.calculateDifferenceInSeconds("2011-05-04","2011-06-03"),2592000);
        assertEquals(imp.calculateDifferenceInSeconds("2011-05-04","2012-06-03"),34214400);
    }

    @Test
    public void sumOfNumbers() {
        implementation imp = new implementation();
        assertEquals(imp.sumOfNumbers(new int[]{1, 2, 3, 4, 5}),15);
        assertEquals(imp.sumOfNumbers(new int[]{1, 2, -3, 4, 5}),21);
        assertEquals(imp.sumOfNumbers(new int[]{-1, -2, -3, -4, -5}),55);
        assertEquals(imp.sumOfNumbers(new int[]{}),0);
    }

    @Test
    public void serial() {
        implementation imp = new implementation();
        assertEquals(imp.serial(new int[]{1,2,3,4,5}),5);
        assertEquals(imp.serial(new int[]{1,2,3,6,5,7,1,2,3,4}),4);
        assertEquals(imp.serial(new int[]{7,9,5,8,2,7,6,4}),1);
    }
}