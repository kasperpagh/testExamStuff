import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class fileMaker {
    public static void main(String[] args) throws IOException {
        implementation imp = new implementation();
        person.readFile("src/data.txt");
        generateData();

    }

    public static void generateData() throws FileNotFoundException, UnsupportedEncodingException {
        String[] firstN = {"david","marco","alex","kasper","Daniel","Joseph","Lasse","Martin","michael","edmond","florent","mikkel","philip","zygimantas"};
        String[] lastN = {"blum","pagh","lind","kebab","falk","borum","hauge","nielsen","lundberg","noga","larsen","mouer"};
        String[] hairColor = {"black","white","brown","coloured","chingchong","eskimo","african-american"};

        PrintWriter writer = new PrintWriter("src/data.txt", "UTF-8");
        Random ran = new Random();
        writer.println("First Name#;Last Name#;Hair Color#;Age");
        for (int i1= 0;i1<500;i1++){
            writer.println(firstN[ran.nextInt(firstN.length)]+"#;"+
                    lastN[ran.nextInt(lastN.length)]+"#;"+
                    hairColor[ran.nextInt(hairColor.length)]+"#;"+
                    Math.abs(ran.nextInt(firstN.length)*2+ran.nextInt(lastN.length)*3-15));
        }
        writer.close();
    }
}
