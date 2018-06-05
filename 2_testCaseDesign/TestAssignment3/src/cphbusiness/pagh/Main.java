package cphbusiness.pagh;

public class Main
{

    public static void main(String[] args)
    {
        MyArrayListWithBugs l = new MyArrayListWithBugs();
//
//        l.add(0, new String("bob"));

        l.add(new String("1"));
        l.add(new String("2"));
        l.add(new String("3"));

        l.add(1, new String("test"));

//        l.remove(0);
//        l.remove(1);



        System.out.println(l.remove(0));


    }
}
