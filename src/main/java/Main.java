/*
Stwórz aplikację do zarządzania zamówieniami.
Produkt, klasa, pola:
- nazwa
- cena
- ilość
- czyDostarczony
Zamówienie, klasa, pola:
- numer
- produkty (lista obiektów klasy produkt)
- dataZamowienia
- dataDostarczenia
- numerFaktury
Stwórz klasę Magazyn, pola:
- kolekcje produktów
- kolekcje zamówień
Stwórz main'a w którym dostępna jest opcja:
->>> składania zamówień. Przebieg działania aplikacji:
        Podaj komendę:
        -> dodaj zamowienie
        Podaj ilość produktów na zamówieniu:
        -> 3
        Podaj nazwę produktu 1:
        -> chleb
        Podaj cenę produktu 1:
        -> 2.3
        Podaj ilość produktu 1:
        -> 5
        Podaj nazwę produktu 2:
        -> masło
        Podaj cenę produktu 2:
        -> 2.0
        Podaj ilość produktu 2:
        -> 2
        Podaj nazwę produktu 3:
        -> ser
        Podaj cenę produktu 3:
        -> 0.5
        Podaj ilość produktu 3:
        -> 23.0
        Zamówienie złożone. Numer zamówienia GD234/4
->>> realizowania zamówień(czyli rejestrowanie dostaw). Przebieg działania aplikacji:
        Podaj komendę:
        -> dodaj dostawę
        Podaj numer zamówienia:
        -> GD234/4
        Zamówienie zawiera 3 produkty.
        Czy w dostawie znajduje się produkt: chleb, cena 2.3, ilość 5?
        -> tak
        Czy w dostawie znajduje się produkt: masło, cena 2.0, ilość 2?
        -> tak
        Czy w dostawie znajduje się produkt: ser, cena 0.5, ilość 23.0?
        -> nie
        Oznaczam produkt jako niedostarczony, nie zwiększam stanu magazynowego.
        Zamówienie zrealizowane, podaj numer faktury:
        -> FV235 / 30
        Faktura dopisana do zamówienia.
        Czy chcesz wprowadzić datę dostawy ręcznie?
        -> nie
        Data dostawy zaktualizowana na obecną automatycznie.
        [na podstawie daty powinna być wyliczana długość spóźnienia, domyślnie każde zamówienie musi być dostarczone w ciągu 1 min.
        jeśli nie jest, to informacja o opóźnieniu powinna być dopisana]
->>> listowania zamówień. Użytkownik podaje komendę "listuj zamówienia", po czym na ekranie wyświetla się lista zamówień (czyli zamówienia aktualne - których nikt jeszcze nie dostarczył)
->>> listowania dostaw. Użytkownik podaje komendę "listuj dostawy", po czym na ekranie wyświetla się lista dostaw (czyli wypisujemy tylko informacje o zamówieniach które były dostarczone i wypisujemy tylko informacje o dostarczeniu (nr. faktury, data,..., ilość produktów dostarczonych, czy zamówienie jest opóźnione i o ile))
->>> listowania produktów. Użytkownik podaje komendę "listuj produkty", po czym na ekranie wyświetla się stan produktów w magazynie. Przemyśl to! Jeśli zamówiłem 2 razy chleb po 2 sztuki, to powinienem mieć 4 sztuki na magazynie.
->>> zapisywania do pliku. Użytkownik podaje komendę "zapisz" - do pliku zrzucają się wszystkie informacje o stanach magazynowych, zamówieniach i produktach.
->>> wczytywania z pliku. Użytkownik podaje komendę "wczytaj" - z pliku wczytują się wszystkie informacje. Dzięki temu przy kolejnych uruchomieniach aplikacji możemy wczytywać informacje z pliku.
->>>* sprzedaż. Do realizacji tej części trzeba w magazynie stworzyć kolekcję z informacjami o sprzedażach Scenariusz:
        Podaj komendę:
        -> sprzedaj
        Podaj ilość produktów:
        -> GD234/4
        Zamówienie zawiera 3 produkty.
        Czy w dostawie znajduje się produkt: chleb, cena 2.3, ilość 5?
        -> tak
        Czy w dostawie znajduje się produkt: masło, cena 2.0, ilość 2?
        -> tak
        Czy w dostawie znajduje się produkt: ser, cena 0.5, ilość 23.0?
        -> nie
        Oznaczam produkt jako niedostarczony, nie zwiększam stanu magazynowego.
        Zamówienie zrealizowane, podaj numer faktury:
        -> FV235 / 30
        Faktura dopisana do zamówienia.
        Czy chcesz wprowadzić datę dostawy ręcznie?
        -> nie
        Data dostawy zaktualizowana na obecną automatycznie.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        ScannerWork scannerWork = new ScannerWork();
        Warehuose warehuose = new Warehuose();
        Utilities utilities = new Utilities();

        char sign;
        do {
            System.out.println();
            System.out.println("Enter your choice:" +
                    " \na) Add an order." +
                    " \nb) project B" +
                    " \nc) project C" +
                    " \nd) project D" +
                    " \nq) quit");
            sign = scannerWork.getChar();
            switch (sign) {
                case 'a':
                    System.out.println();
                    System.out.println("Add an order.");
                    warehuose.printListOfProdukts();
                    Order order = new Order();
                    System.out.println("How many products will be in the order?");
                    int quantityOfProductsInTheOrder = scannerWork.getPositiveNumberFrom1To_number(warehuose.getProdukts().size());
                    for (int i = 0; i < quantityOfProductsInTheOrder; i++) {
                        System.out.println("Product: " + (i + 1) + ". \nChoose:");
                        for (int j = 0; j < quantityOfProductsInTheOrder; j++) {
                            System.out.print((char) (j + 97) + ") " + warehuose.getProdukts().get(j).getName() + ", ");
                        }
                        List<Character> characterListOfSymbolsOfProductsInTheOrder = utilities.getCharactersList(quantityOfProductsInTheOrder);
                        char choosenProduct = scannerWork.chooseProduct(quantityOfProductsInTheOrder, characterListOfSymbolsOfProductsInTheOrder);
                        System.out.println();
                    }
                    break;
                case 'b':
                    System.out.println("Project B.");
                    break;
                case 'c':
                    System.out.println("Project C.");
                    break;
                case 'd':
                    System.out.println("Project D.");
                    break;
                case 'e':
                    System.out.println("Project E.");
                    break;
            }
        } while (sign != 'q');
    }
}
