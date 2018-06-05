package cphbusiness.pagh.test;

import cphbusiness.pagh.MyArrayListWithBugs;
import org.junit.*;

import static org.junit.Assert.*;

public class FurtherTests
{
    private static MyArrayListWithBugs list = null;
    private String testObject = "test";

    @BeforeClass
    public static void setUpClass()
    {
        list = new MyArrayListWithBugs();
    }

    @Test
    public void testCase58()
    {
        assertEquals(list.size(), 0);
        list.add(testObject);
        assertEquals(list.size(), 1);
    }

    @Test
    public void testCase59()
    {
        assertEquals(list.size(), 1);
        assertTrue(list.get(0).toString().equalsIgnoreCase("test"));
        assertEquals(list.size(), 1);
    }

    @Test
    public void testCase60()
    {
        assertEquals(list.size(), 1);
        list.remove(0);
    }

    @Test
    public void testCase61()
    {
        list = new MyArrayListWithBugs();
        assertTrue(list.size() == 0);
        assertTrue(list.realLength() == 5);
        for (int i = 0; i < 6; i++)
        {
            list.add(testObject);
        }
        assertTrue(list.size() == 6);
        assertTrue(list.realLength() == 10);
    }

    @Test
    public void testCase62()
    {
        assertTrue(list.size() == 6);
        assertTrue(list.realLength() == 10);
        for (int i = 0; i < 6; i++)
        {
            list.remove(0);
        }
        assertTrue(list.size() == 0);
        assertTrue(list.realLength() == 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase63()
    {
        list = new MyArrayListWithBugs();
        assertTrue(list.size() == 0);
        list.remove(0);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase64()
    {
        list = new MyArrayListWithBugs();
        assertTrue(list.size() == 0);
        list.get(0);
    }
}
