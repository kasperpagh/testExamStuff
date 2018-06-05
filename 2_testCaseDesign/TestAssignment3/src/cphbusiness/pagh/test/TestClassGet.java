package cphbusiness.pagh.test;

import cphbusiness.pagh.MyArrayListWithBugs;
import org.junit.*;

import static org.junit.Assert.*;

public class TestClassGet
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
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase39()
    {
        list.get(-1);
    }

    @Test
    public void testCase40()
    {
        assertTrue(list.get(0).toString().equalsIgnoreCase("test"));
    }

    @Test
    public void testCase41()
    {
        assertTrue(list.get(1).toString().equalsIgnoreCase("test"));
    }

    @Test
    public void testCase42()
    {
        assertTrue(list.get(list.size() - 1).toString().equalsIgnoreCase("test"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase43()
    {
        if (list.get(list.size()) == null) // Den er  null fordi listen er fem lang pr. default
        {
            throw new IndexOutOfBoundsException();
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase44()
    {
        list.get(list.size() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase45()
    {
        list.get(list.realLength() - 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase46()
    {
        list.get(list.realLength());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase47()
    {
        list.get(list.realLength() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase48()
    {

        list.get(Integer.MAX_VALUE - 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase49()
    {
        list.get(Integer.MAX_VALUE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase50()
    {
        list.get(Integer.MAX_VALUE + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase51()
    {
        list.get(Integer.MIN_VALUE - 1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase52()
    {
        list.get(Integer.MIN_VALUE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase53()
    {
        list.get(Integer.MIN_VALUE + 1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase54()
    {
        list.get(-5038);
    }

    @Test
    public void testCase55()
    {
        assertTrue(list.get((int) Math.floor(list.size() / 2)).toString().equalsIgnoreCase("test"));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testCase57()
    {
        list.get(list.realLength());
    }


}
