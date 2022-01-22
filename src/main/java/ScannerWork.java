import java.util.List;
import java.util.Scanner;


class ScannerWork {
    private Scanner scanner = new Scanner(System.in);

    char getChar() {
        return scanner.next().charAt(0);
    }

    int getPositiveNumberFrom1To_number(int number) {
        boolean flag = false;
        int i;
        do {
            while (!scanner.hasNextInt()) {
                System.err.println("It is not a number!");
                scanner.next();
            }
            i = scanner.nextInt();
            if (i > 0 && i <= number) {
                flag = true;
            } else {
                System.out.println("Quantity should be from the range: 1 - " + number + ".");

            }
        } while (!flag);
        return i;
    }

    char chooseChar(List<Character> characterList) {
        boolean flagChoose = false;
        char chooseOfProduct;
        do {
            chooseOfProduct = getChar();
            if (characterList.contains(chooseOfProduct)) {
                System.out.print("You have choosen: " + chooseOfProduct + ")");
                flagChoose = true;
            } else {
                System.err.println("Bad choice.");
            }
        } while (!flagChoose);
        return chooseOfProduct;
    }
}
