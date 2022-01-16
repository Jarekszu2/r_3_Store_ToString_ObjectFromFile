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

}
