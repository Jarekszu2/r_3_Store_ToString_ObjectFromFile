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

    private String toStringWrite() {
        Utilities utilities = new Utilities();
        return  "orderNumber=" + orderNumber + "\n" +
                "orderDate=" + orderDate.format(utilities.getDateTimeFormatter()) + "\n" +
                "invoiceNumber=" + invoiceNumber + "\n";
//                "productsCount=" + produktList.size() + "\n";
    }

    String getStringDeliveryDate() {
        Utilities utilities = new Utilities();
        String stringDeliveryDate;
        if (deliveryDate == null) {
            stringDeliveryDate = "deliveryDate=null\n";
        } else {
            stringDeliveryDate = "deliveryDate=" + deliveryDate.format(utilities.getDateTimeFormatter()) + "\n";
        }
        return stringDeliveryDate;
    }

    private String toStringProducts() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Produkt p : produktList) {
            stringBuilder.append(p.toStringWrite_2());
        }
        return stringBuilder.toString();
    }

    String getStringOrderToFile() {
        String s = toStringWrite();
        String sod = s.concat(getStringDeliveryDate());
        String s1 = sod.concat(toStringProducts());
        return s1.concat("TTT=ORDER");
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(toStringWrite());
//        stringBuilder.append(toStringProducts());
//        stringBuilder.append("TTT=ORDER");
//        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        Utilities u = new Utilities();
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", produktList=" + produktList +
                ", orderDate=" + orderDate.format(u.getDateTimeFormatter()) + ", " +
                getStringDeliveryDate().replace("\n", "") +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                '}';
    }
}
