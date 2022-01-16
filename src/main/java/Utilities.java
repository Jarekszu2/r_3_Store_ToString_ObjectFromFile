import java.util.ArrayList;
import java.util.List;

class Utilities {

    List<Character> getCharactersList(int quantityOfProductsInTheOrder) {
        List<Character> characterList = new ArrayList<>();
        for (int j = 0; j < quantityOfProductsInTheOrder; j++) {
            characterList.add((char) (97 + j));
        }
        return characterList;
    }
}
