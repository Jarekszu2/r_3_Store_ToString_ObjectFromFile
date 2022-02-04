import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class MainTest {
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        System.out.println();
        System.out.println(ANSI_YELLOW + "This text is yellow" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "The background color is red" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + ANSI_RED_BACKGROUND + "TEST" + ANSI_RESET);

        System.out.println();
        Warehuose warehuose = new Warehuose();
        Utilities utilities = new Utilities();

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
        String s = utilities.getStringFromAFile("fileProducts.txt");
        System.out.println(s);

        System.out.println();
        String[] strings = s.split("YYY;");
//        for (int j = 0; j < strings.length; j++) {
//            System.out.println(strings[j]);
//        }
        for (String s1 : strings) {
            System.out.println(s1);
        }

        System.out.println();
        System.out.println("Example order:");
        Order order = new Order();
        order.setOrderNumber("OR-1111");
        order.setProduktList(warehuose.getProdukts());
        order.setOrderDate(LocalDateTime.now());
        order.setDeliveryDate(LocalDateTime.now());
        System.out.println(order.getStringDeliveryDate());
        System.out.println(order.getStringOrderToFile().trim());
        System.out.println();
        System.out.println(order);
    }
}
