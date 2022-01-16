import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
class Warehuose {
    private List<Produkt> produkts = Arrays.asList(new Produkt("milk", 2.39, 0),
            new Produkt("bread", 3.80, 0),
            new Produkt("meat", 18.0, 0),
            new Produkt("apple", 3.49, 0));

    void printListOfProdukts() {
        System.out.println("List of available products:");
        for (int i = 0; i < produkts.size(); i++) {
            System.out.println((char) (97 + i) + ") " + produkts.get(i).getName() + " " + produkts.get(i).getPrice());
        }
    }
}
