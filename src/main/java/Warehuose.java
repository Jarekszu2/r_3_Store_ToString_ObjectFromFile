import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
class Warehuose {
    private List<Produkt> produkts = Arrays.asList(new Produkt("milk", 2.39, 0),
            new Produkt("bread", 3.80, 0),
            new Produkt("meat", 18.0, 0),
            new Produkt("apple", 3.49, 0));

    private List<Order> orderList = new ArrayList<>();

    void printListOfProdukts() {
        System.out.println("List of available products:");
        for (int i = 0; i < produkts.size(); i++) {
            System.out.println((char) (97 + i) + ") " + produkts.get(i).getName() + " " + produkts.get(i).getPrice());
        }
        System.out.println();
    }

    Map<Character, Produkt> getCharacterProduktMap() {
        Map<Character, Produkt> map = new HashMap<>();
        for (int i = 0; i < produkts.size(); i++) {
            map.put((char) (97 + i), produkts.get(i));
        }
        return map;
    }

    double getPriceOfAProduct(String productName, List<Produkt> listOfProductsInAWarehouse) {
        double priceOfAProduct = 0;
        for (Produkt produkt : listOfProductsInAWarehouse) {
            if (productName.equals(produkt.getName())) {
                priceOfAProduct = produkt.getPrice();
            } else {
                System.err.println("There is not such product in a warehouse.");
            }
        }
//        for (int i = 0; i < listOfProductsInAWarehouse.size(); i++) {
//            if (productName.equals(listOfProductsInAWarehouse.get(i).getName())) {
//                priceOfAProduct = listOfProductsInAWarehouse.get(i).getPrice();
//            } else {
//                System.err.println("There is not such product in a warehouse.");
//            }
//        }
        return priceOfAProduct;
    }

    String getOrdersNumber() {
        String ordersNumber;
        if (orderList.size() == 0) {
            ordersNumber = "Order-1";
            System.out.println(ordersNumber);
        } else {
            ordersNumber = "Order-" + (orderList.size() + 1);
            System.out.println(ordersNumber);
        }
        return ordersNumber;
    }
}
