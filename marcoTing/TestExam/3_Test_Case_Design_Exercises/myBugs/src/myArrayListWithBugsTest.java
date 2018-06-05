import org.junit.*;
import static org.junit.Assert.*;
public class myArrayListWithBugsTest {
    @org.junit.Test
    public void add() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        arr.add("add Test");
        assertEquals(1,arr.nextFree);
    }
    @org.junit.Test
    public void size() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 10;i++){
            arr.add("size Test");
        }
        assertEquals(10,arr.size());
    }
    @org.junit.Test
    public void get() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 5;i++) {
            arr.add("get Test" + i);
            assertEquals("get Test" + i, arr.get(i));
        }
    }
    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void get_oob() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 5;i++) {
            arr.add("get Test" + i);
        }
        arr.get(-1);
    }
    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void get_oob2() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 5;i++) arr.add("get Test" + i);
        arr.get(5);

    }
    @org.junit.Test
    public void add1() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 5;i++) {
            arr.add("add Test" + i);
        }
        arr.add(0,"add Test0_new");
        arr.add(6,"add Test6");
        assertEquals("add Test0_new",arr.get(0));
        assertEquals("add Test0",arr.get(1));
        assertEquals("add Test6",arr.get(6));
    }
    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void add1_oob() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 5;i++) {
            arr.add("add Test" + i);
        }
        arr.add(6,"oob");
    }
    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void add1_oob2() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 5;i++) {
            arr.add("add Test" + i);
        }
        arr.add(-1,"oob");
    }
    @org.junit.Test
    public void remove() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 5;i++) {
            arr.add("remove Test" + i);
        }
        assertEquals("remove Test0",arr.remove(0));
        assertEquals("remove Test4",arr.remove(3));
    }
    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void remove_oob() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 5;i++) {
            arr.add("remove Test" + i);
        }
        arr.remove(-1);
    }
    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void remove_oob2() {
        myArrayListWithBugs arr = new myArrayListWithBugs();
        for (int i = 0;i< 5;i++) {
            arr.add("remove Test" + i);
        }
        arr.remove(5);
    }
}