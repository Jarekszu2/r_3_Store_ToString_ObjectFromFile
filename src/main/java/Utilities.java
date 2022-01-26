import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Utilities {

    List<Character> getCharactersList(int quantityOfProductsInTheWarehouse) {
        List<Character> characterList = new ArrayList<>();
        for (int j = 0; j < quantityOfProductsInTheWarehouse; j++) {
            characterList.add((char) (97 + j));
        }
        return characterList;
    }

    DateTimeFormatter getDateTimeFormatter() {
        return  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    }

    long getDelayInSeconds(Order order) {
        Duration duration = Duration.between(order.getOrderDate(), order.getDeliveryDate());
        return duration.getSeconds();
    }
}
