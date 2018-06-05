import java.util.ArrayList;
import java.util.Date;

public interface HandleInterface {
    //use the method below to get data.
    //ArrayList<person> arr = person.generateData();

    //return a list of all the oldest people from the data set.
    public ArrayList<person> getOldestPeople(ArrayList<person> people);

    //return a list of all the youngest people from the data set.
    public ArrayList<person> getYoungestPeople(ArrayList<person> people);

    //sort the data set by last name.
    public ArrayList<person> sortByLastName(ArrayList<person> people);

    //sort the data set by age.
    public ArrayList<person> sortByAge(ArrayList<person> people);

    //calculate the average age of the "number" of people starting from index start.
    // getAverageAge(100,200) -> 10
    // getAverageAge(0,1000) -> 10
    // getAverageAge(1000,200) -> 11
    // getAverageAge(10,15) -> 3
    public double getAverageAge(ArrayList<person> people, int start,int number);

    // feed it a radius and return the area of the circle with said radius.
    // it can't have more than 2 decimals
    // negative radius must return with -1
    public double calculateCircleArea(int radius);

    //if the number is divisible with the divisor return true
    //for example number = 6 and divisor is2 it should return true
    //or number = 5 and divisor is 3 it should return false
    public boolean divisible(int number, int divisor);

    // feed it 2 dates and it should then return the difference in seconds
    // in the format of "yyyy-mm-dd"
    public int calculateDifferenceInSeconds(String date1, String date2);

    // feed it a list of numbers, where all positive numbers are added, and negative number are multiplied by themselves
    // sumOfNumbers([2,-5,7]) -> 34
    public int sumOfNumbers(int[] numbers);

    //given a list of numbers, return the length of the longest chain of adjacent numbers that are sequential.
    //serial(1,2,3,4,8,9,1,2,3]) -> 4
    //dupliSeries([1,2,3,8,9,1,2,3]) -> 3
    //dupliSeries([78,48,7,5,7,2,3,6,48,7,5,7]) -> 2
    //serial([1,2,3,4,5,6]) -> 6
    public int serial(int[] numbers);
}
