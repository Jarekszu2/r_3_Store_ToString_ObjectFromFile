import java.util.Scanner;

class ScannerWork {
    private Scanner scanner = new Scanner(System.in);

    char getChar() {
        return scanner.next().charAt(0);
    }
}
