import com.google.gson.Gson;
import entities.Person;
import exceptions.IllegalNameException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Controller implements AssignmentInterface
{
    /*
     * No border values since no input
     * Reads a text file full of name
     * The name of the file is nameFile
     *
     */

    public String readFile(String fileName) throws IOException
    {

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        try
        {
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                sb.append(scanner.next()+", ");

            }
            scanner.close();
        }
        finally
        {
            scanner.close();
        }

        return sb.toString();
    }

    /*
     * Makes a new person object from a name
     *
     *
     */
    public Person parsePerson(String name) throws IllegalNameException
    {
        return new Person(name);
    }

    /*
     *
     * returns all the people in the file as an arraylist
     *
     */
    public ArrayList<Person> getAllPeople(String fileName) throws IOException, IllegalNameException
    {

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList<Person> pplList = new ArrayList<>();
        try
        {
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                pplList.add(new Person(scanner.next()));
            }
            scanner.close();
        }
        finally
        {
            scanner.close();
        }
        return pplList;
    }

    /*
     * find the person fomr the file with the longest name
     *
     *
     */
    public Person getPersonWithLongestName(ArrayList<Person> pplList)
    {
        Person currentLongestName = null;

        for (Person p : pplList)
        {
            if (currentLongestName == null || p.getName().length() > currentLongestName.getName().length())
            {
                currentLongestName = p;
            }
        }

        return currentLongestName;
    }

    /*
     *
     * find the shortest name in the file
     *
     */
    public Person getPersonWithShortestName(ArrayList<Person> pplList)
    {
        Person currentShortestName = null;

        for (Person p : pplList)
        {
            if (currentShortestName == null || p.getName().length() < currentShortestName.getName().length())
            {
                currentShortestName = p;
            }
        }

        return currentShortestName;
    }

    /*
     * returns a captain planet person object
     *
     */
    public Person byOurPowersCombinedWeAreCaptainPlanet(Person a, Person b) throws IllegalNameException
    {
        String first = a.getName();
        String second = b.getName();
        return new Person("by our powers combined, we are Captain planet");
    }

    /*
     *
     * takes a list of people and sorts them by name
     *
     */
    public ArrayList<Person> sortPeopleByName(ArrayList<Person> pplList) throws IllegalNameException
    {
        ArrayList<String> tempList = new ArrayList<>();

        for (Person p : pplList)
        {
            tempList.add(p.getName());
        }

        Collections.sort(tempList, String.CASE_INSENSITIVE_ORDER);
        ArrayList<Person> pList = new ArrayList<>();
        for (String s : tempList)
        {
            pList.add(new Person(s));
        }
        return pList;
    }

    /*
     *
     * saves a list of person objects to file
     *
     */

    public boolean savePersonListToFile(boolean append, ArrayList<Person> pplList, String fileName) throws FileNotFoundException, IllegalArgumentException
    {
        if (pplList == null)
        {
            throw new IllegalArgumentException();
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, true)))
        {
            if (append)
            {
                System.out.println("appending...");
                for (Person p : pplList)
                {
                    pw.append(p.getName() + ",");
                }
            }
            else
            {
                PrintWriter pwNonAppend = new PrintWriter(new FileWriter("nameFile"));
                System.out.println("not appending");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pplList.size(); i++)
                {
                    if (i == pplList.size() - 1)
                    {
                        sb.append(pplList.get(i).getName() + ", ");
                    }
                    else
                    {
                        sb.append(pplList.get(i).getName() + ", ");
                    }
                }
                pwNonAppend.print(sb.toString());
                pwNonAppend.close();
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    /*
     * parses a list of person objects to JSON
     *
     *
     */
    public String makeJsonList(ArrayList<Person> pplList)
    {
        Gson gson = new Gson();
        return gson.toJson(pplList);
    }

    /*
     *
     *
     * parses a person object to JSON
     */
    public String makeJsonPerson(Person person)
    {
        Gson gson = new Gson();
        return gson.toJson(person);
    }
}
