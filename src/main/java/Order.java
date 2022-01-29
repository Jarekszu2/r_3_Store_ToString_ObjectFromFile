import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
class Order {
    private String orderNumber;
    private List<Produkt> produktList;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private String invoiceNumber;

    String toStringWrite() {
        return  "orderNumber='" + orderNumber + "\n" +
                ", produktList=" + produktList + "\n" +
                ", orderDate=" + orderDate + "\n" +
                ", deliveryDate=" + deliveryDate + "\n" +
                ", invoiceNumber='" + invoiceNumber;
    }
}
