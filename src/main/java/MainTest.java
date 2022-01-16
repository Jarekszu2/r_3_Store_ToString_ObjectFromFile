import java.util.ArrayList;
import java.util.List;

class MainTest {
    public static void main(String[] args) {
        System.out.println();

        int i = (int) 'a';
        System.out.println(i);

        char c = (char) (97 + 1);
        System.out.println(c);
        System.out.println(c + " string");

        ScannerWork scannerWork = new ScannerWork();
        int inter = scannerWork.getPositiveNumberFrom1To_number(10);
        System.out.println(inter);

        List<Character> characters = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            characters.add((char) (97 + j));
        }
        characters.forEach(System.out::println);
    }
}
