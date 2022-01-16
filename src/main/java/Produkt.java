import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
class Produkt {
    private String name;
    private double price;
    private int quantity;
    private boolean ifDelivered;

    Produkt(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ifDelivered = false;
    }
}
