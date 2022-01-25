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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        ScannerWork scannerWork = new ScannerWork();
        Warehuose warehuose = new Warehuose();
        Utilities utilities = new Utilities();

        List<Order> orderList = warehuose.getOrderList();
        List<Produkt> produkts = warehuose.getProdukts();

        char sign;
        do {
            System.out.println();
            System.out.println("Enter your choice:" +
                    " \na) Adding an order." +
                    " \nb) Registration the delivery" +
                    " \nc) Order listing." +
                    " \nd) project D" +
                    " \nq) quit");
            sign = scannerWork.getChar();
            switch (sign) {
                case 'a':
                    System.out.println();
                    System.out.println("Adding an order.");
                    warehuose.printListOfProdukts();
                    Order order = new Order();
                    List<Produkt> produktsInTheOrder = new ArrayList<>();
                    System.out.println("How many products will be in the order?");
                    int quantityOfProductsInTheOrder = scannerWork.getPositiveNumberFrom1To_number(warehuose.getProdukts().size());
                    System.out.println();
                    for (int i = 0; i < quantityOfProductsInTheOrder; i++) {
                        Produkt produktFromAnOrder = new Produkt();
                        System.out.println("Product: " + (i + 1) + ". \nChoose:");
                        for (int j = 0; j < warehuose.getProdukts().size(); j++) {
                            System.out.print((char) (j + 97) + ") " + warehuose.getProdukts().get(j).getName() + ", ");
                        }
                        List<Character> characterListOfSymbolsOfProductsInTheWarehouse = utilities.getCharactersList(warehuose.getProdukts().size());
                        char charOfChoosenProduct = scannerWork.chooseChar(characterListOfSymbolsOfProductsInTheWarehouse);
                        Map<Character, Produkt> characterProduktMap = warehuose.getCharacterProduktMap();
                        Produkt productTemp = characterProduktMap.get(charOfChoosenProduct);
                        System.out.print(" (" + productTemp.getName() + ").");
                        System.out.println();
                        System.out.print("Enter quantity of the product: ");
                        int quantityOfTheProduct = scannerWork.getPositiveNumberFrom1To_number(1000);
                        produktFromAnOrder.setName(productTemp.getName());
                        produktFromAnOrder.setPrice(productTemp.getPrice());
                        produktFromAnOrder.setQuantity(quantityOfTheProduct);
                        System.out.println(produktFromAnOrder);
                        produktsInTheOrder.add(produktFromAnOrder);
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("List of products in the order:");
                    produktsInTheOrder.forEach(System.out::println);

                    System.out.println();
                    String ordersNumber = warehuose.getOrdersNumber();

                    System.out.println();
                    LocalDateTime localDateTime = LocalDateTime.now();
                    DateTimeFormatter dateTimeFormatterA = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm");
                    System.out.println(localDateTime.format(dateTimeFormatterA));

                    order.setProduktList(produktsInTheOrder);
                    order.setOrderNumber(ordersNumber);
                    order.setOrderDate(localDateTime);

                    System.out.println();
                    System.out.println(order);
                    orderList.add(order);
                    break;
                case 'b':
                    System.out.println();
                    System.out.println("Registration the delivery.");
                    List<Order> unrealizedOrderList = new ArrayList<>();
                    for (Order o : orderList) {
                        if (o.getInvoiceNumber() == null) {
                            unrealizedOrderList.add(o);
                        }
                    }
                    if (unrealizedOrderList.size() > 0) {
                        System.out.println();
                        System.out.println("Choose an order to registration:");
                        System.out.println("   number,  date of the order");
                        DateTimeFormatter dateTimeFormatterB = DateTimeFormatter.ofPattern("dd-MM-yyy");
                        for (int i = 0; i < unrealizedOrderList.size(); i++) {
                            System.out.println((char) (i + 97) + ") " + unrealizedOrderList.get(i).getOrderNumber() + " " + unrealizedOrderList.get(i).getOrderDate().format(dateTimeFormatterB));
                        }
                        List<Character> orderListCharacterB = new ArrayList<>();
                        for (int i = 0; i < unrealizedOrderList.size(); i++) {
                            orderListCharacterB.add((char) (i + 97));
                        }
                        char charB = scannerWork.chooseChar(orderListCharacterB);

//                    System.out.println();
//                    System.out.println();
//                    orderList.forEach(System.out::println);
                        Map<Character, Order> characterOrderMapB = new HashMap<>();
                        for (int i = 0; i < unrealizedOrderList.size(); i++) {
                            characterOrderMapB.put((char) (i + 97), unrealizedOrderList.get(i));
                        }

                        System.out.println();
//                    characterOrderMapB.forEach((k, v) -> System.out.println(k + ") " + v.getOrderNumber()));
                        System.out.println("The choosen order:");
                        Order orderB = characterOrderMapB.get(charB);
                        System.out.println(orderB);

                        System.out.println();
                        System.out.println("Stock status before delivery:");
                        for (int i = 0; i < produkts.size(); i++) {
                            System.out.println((i + 1) + ". " + produkts.get(i).getName() + " " + produkts.get(i).getQuantity());
                        }

                        System.out.println();
                        int ifDeliveredProduct = 0;
                        for (int i = 0; i < orderB.getProduktList().size(); i++) {
                            if (!orderB.getProduktList().get(i).isIfDelivered()) {
                                System.out.printf("Is in delivery the product: %s, quantity: %d (y/n)?", orderB.getProduktList().get(i).getName(), orderB.getProduktList().get(i).getQuantity());
                                System.out.println();
                                List<Character> characterListAB = Arrays.asList('y', 'n');
                                char charB2 = scannerWork.chooseChar(characterListAB);
                                if (charB2 == 'y') {
                                    for (int j = 0; j < produkts.size(); j++) {
                                        if (produkts.get(j).getName().equals(orderB.getProduktList().get(i).getName())) {
                                            produkts.get(j).setQuantity(produkts.get(j).getQuantity() + orderB.getProduktList().get(i).getQuantity());
                                            orderB.getProduktList().get(i).setIfDelivered(true);
                                            System.out.println();
                                        }
                                    }
                                } else {
                                    ifDeliveredProduct++;
                                }
                            }
                        }

                        System.out.println();
                        System.out.println("Stock status after delivery:");
                        for (int i = 0; i < produkts.size(); i++) {
                            System.out.println((i + 1) + ". " + produkts.get(i).getName() + " " + produkts.get(i).getQuantity());
                        }

                        System.out.println();
                        System.out.println("Delivery have registered.");

                        System.out.println();
                        if (ifDeliveredProduct == 0) {
                            String number = orderB.getOrderNumber();
                            String changedNumber = number.replace("Order-", "Invoice-");
                            for (Order o : orderList) {
                                if (o.getOrderNumber().equals(number)) {
                                    o.setInvoiceNumber(changedNumber);
                                }
                            }
                        }

                        System.out.println();
                        orderList.forEach(System.out::println);
                    } else {
                        System.err.println("There are no orders to register.");
                    }
                    break;
                case 'c':
                    System.out.println();
                    System.out.println("Order listing.");
                    int intC = 0;
                    int printC = 1;
                    for (Order oC : orderList) {
                        if (oC.getInvoiceNumber() == null) {
                            System.out.println(printC + ". " + oC);
                            printC++;
                            intC++;
                        }
                    }
                    if (intC == 0) {
                        System.err.println("There are no orders.");
                    }
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
