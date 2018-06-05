package cphbusiness.pagh.test;


import cphbusiness.pagh.MyArrayListWithBugs;
import org.junit.*;

import static org.junit.Assert.*;

public class TestClassAdd
{

    private MyArrayListWithBugs list = null;
    private String testObject = "test";

    @Before
    public void setUpBeforeEachTest()
    {
        list = null;
        list = new MyArrayListWithBugs();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase1()
    {
        list.add(-1, testObject);
    }

    @Test
    public void testCase2()
    {
        assertEquals(list.size(), 0);
        list.add(0, testObject);
        assertEquals(list.size(), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase3()
    {
        list.add(1, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase4()
    {
        list.add(list.size() - 1, testObject);
    }

    @Test
    public void testCase5()
    {
        assertEquals(list.size(), 0);
        list.add(list.size(), testObject);
        assertEquals(list.size(), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase6()
    {
        list.add(list.size() + 1, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase7()
    {
        list.add(list.realLength() - 1, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase8()
    {
        list.add(list.realLength(), testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase9()
    {
        list.add(list.realLength() + 1, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase10()
    {
        list.add(Integer.MAX_VALUE - 1, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase11()
    {
        list.add(Integer.MAX_VALUE, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase12()
    {
        list.add(Integer.MAX_VALUE + 1, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase13()
    {
        list.add(Integer.MIN_VALUE - 1, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase14()
    {
        list.add(Integer.MIN_VALUE, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase15()
    {
        list.add(Integer.MIN_VALUE + 1, testObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase16()
    {
        list.add(-5038, testObject);
    }

    @Test
    public void testCase17()
    {
        assertEquals(list.size(), 0);
        list.add((int) Math.floor(list.size() / 2), testObject);
        assertEquals(list.size(), 1);

    }

//    @Test
//    public void testCase18()
//    {
//        int tempIndex = list.size() - list.realLength();
//    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase19()
    {
        list.add(list.realLength() + 2, testObject);
    }


}
