import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Utilities {

    List<Character> getCharactersList(int quantityOfProductsInTheWarehouse) {
        List<Character> characterList = new ArrayList<>();
        for (int j = 0; j < quantityOfProductsInTheWarehouse; j++) {
            characterList.add((char) (97 + j));
        }
        return characterList;
    }

    DateTimeFormatter getDateTimeFormatter() {
        return  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }

    long getDelayInSeconds(Order order) {
        Duration duration = Duration.between(order.getOrderDate(), order.getDeliveryDate());
        return duration.getSeconds();
    }

    String getStringFromAFile(String fileName) {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] tab = line.split("=");
                stringBuilder.append(tab[1]);
                stringBuilder.append(";");
            }
        } catch (IOException e) {
            System.err.println("There is no data on the disk.");
        }
        return stringBuilder.toString();
    }

    String[] getTabStringFromFile(String stringFromFile, String split) {
        return stringFromFile.split(split);
    }

    List<String> getListStringFromTabString(String[] tabString) {
        return Arrays.asList(tabString);
    }

    List<Produkt> getProductsListFromFile(List<String> listFromFile) {
        List<Produkt> produkts = new ArrayList<>();
        for (String s : listFromFile) {
            Produkt produkt = new Produkt();
            String[] strings = s.split(";");
            double price = 0.0;
            int quantity = 0;
            try {
                price = Double.parseDouble(strings[1]);
                quantity = Integer.parseInt(strings[2]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            boolean ifDelivered = Boolean.parseBoolean(strings[3]);
            produkt.setName(strings[0]);
            produkt.setPrice(price);
            produkt.setQuantity(quantity);
            produkt.setIfDelivered(ifDelivered);
            produkts.add(produkt);
        }
        return produkts;
    }

    List<Order> getOrdersListFromFile(List<String> listStringOrdersFromFile) {
        List<Order> orderList = new ArrayList<>();
        for (String s : listStringOrdersFromFile) {
            Order order = new Order();
            String[] tab = s.split(";");
            order.setOrderNumber(tab[0]);
            try {
                order.setOrderDate(LocalDateTime.parse(tab[1], getDateTimeFormatter()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            // delivery date
            if (!tab[2].equals("null")) {
                try {
                    order.setDeliveryDate(LocalDateTime.parse(tab[2], getDateTimeFormatter()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                order.setDeliveryDate(null);
            }

            orderList.add(order);
        }
        return orderList;
    }
}
