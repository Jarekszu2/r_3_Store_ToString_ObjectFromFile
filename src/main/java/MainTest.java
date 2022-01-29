import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MainTest {
    public static void main(String[] args) {
        System.out.println();
        Warehuose warehuose = new Warehuose();

        int i = (int) 'a';
        System.out.println(i);

        char c = (char) (97 + 1);
        System.out.println(c);
        System.out.println(c + " string");

        ScannerWork scannerWork = new ScannerWork();
        System.out.println("Enter a number:");
        int inter = scannerWork.getPositiveNumberFrom1To_number(10);
        System.out.println(inter);

        List<Character> characters = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            characters.add((char) (97 + j));
        }
        characters.forEach(System.out::println);


        System.out.println();
        warehuose.writeProductsToAFile();
        System.out.println("Ok.");
        String s = warehuose.getStringProductsFromAFile();
        System.out.println(s);

        System.out.println();
        String[] strings = s.split("YYY;");
//        for (int j = 0; j < strings.length; j++) {
//            System.out.println(strings[j]);
//        }
        for (String s1 : strings) {
            System.out.println(s1);
        }
    }
}
