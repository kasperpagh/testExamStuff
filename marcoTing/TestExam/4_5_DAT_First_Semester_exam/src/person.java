import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class person {
    private String firstName,lastName,hairColor;
    private int age;
    public person(String firstName, String lastName,String hairColor, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hairColor = hairColor;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static ArrayList<person> readFile(String filename) throws IOException {
        StringBuilder builder = new StringBuilder();
        String br = System.lineSeparator();
        Stream<String> stream = Files.lines(Paths.get(filename)).skip(1);
        ArrayList<person> arr = new ArrayList();
        stream.forEach(s -> {
            String[] st = s.split("#;");
            arr.add(new person(st[0],st[1],st[2],Integer.parseInt(st[3])));
        });
        System.out.println(builder.toString());
        return arr;
    }

    @Override
    public String toString() {
        return  firstName + "#;" +
                lastName + "#;" +
                hairColor + "#;" +
                age;
    }
}
