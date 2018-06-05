package cphbusiness.pagh.test;

import cphbusiness.pagh.MyArrayListWithBugs;
import org.junit.*;

import static org.junit.Assert.*;


public class TestClassRemove
{
    private MyArrayListWithBugs list = null;
    private String testObject = "test";


    @Before
    public void setUpBeforeEachTest()
    {
        list = null;
        list = new MyArrayListWithBugs();
        list.add(testObject);
        list.add(testObject);
        list.add(testObject);
        list.add(testObject);
        list.add(testObject);
        list.add(testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase20()
    {
        list.remove(-1);
    }

    @Test
    public void testCase21()
    {
        assertEquals(list.size(), 6);
        list.remove(0);
        assertEquals(list.size(), 5);
    }

    @Test
    public void testCase22()
    {
        assertEquals(list.size(), 6);
        list.remove(1);
        assertEquals(list.size(), 5);
    }

    @Test
    public void testCase23()
    {
        assertEquals(list.size(), 6);
        list.remove(list.size() - 1);
        assertEquals(list.size(), 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase24()
    {
        list.remove(list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase25()
    {
        list.remove(list.size() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase26()
    {
        list.remove(list.realLength() - 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase27()
    {
        list.remove(list.realLength());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase28()
    {
        list.remove(list.realLength() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase29()
    {
        list.remove(Integer.MAX_VALUE - 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase30()
    {
        list.remove(Integer.MAX_VALUE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase31()
    {
        list.remove(Integer.MAX_VALUE + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase32()
    {
        list.remove(Integer.MIN_VALUE - 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase33()
    {
        list.remove(Integer.MIN_VALUE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase34()
    {
        list.remove(Integer.MIN_VALUE + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase35()
    {
        list.remove(-5038);
    }

    @Test
    public void testCase36()
    {
        assertEquals(list.size(), 6);
        list.remove((int) Math.floor(list.size() / 2));
        assertEquals(list.size(), 5);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase38()
    {
        list.remove(list.realLength()*2);
    }
}
