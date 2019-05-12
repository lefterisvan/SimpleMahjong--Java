//321/2016190 ΣΠΥΡΙΔΩΝ ΣΤΟΓΙΟΥ
//321/2016087 ΕΥΑΓΓΕΛΟΣ ΙΩΑΝΝΗΣ ΛΑΜΠΡΟΥ

package phase01;

import java.util.ArrayList;

public class Tiles {

    protected ArrayList<String> cards = new ArrayList<>();//arraylist για αποθηκευση πλακιδιων
    protected String idCard;//ειδος πλακιδιου
    protected int numberOfCards;//αριθμος πλακιδιου

    public Tiles(String idCards, int numberOfCards) {
        this.idCard = idCards;
        this.numberOfCards = numberOfCards;
        this.setTiles(idCards, numberOfCards);

    }

    public ArrayList<String> setTiles(String k, int x) {//δημιουργια πλακιδιων
        for (int i = 0; i < x; i++) {
            String card = k + i;//το string αποτελειται απο το αρχικο γραμμα καθε κατηγοριας πλακιδιων και εναν αριθμο
            cards.add(card);//προσθηκη πλακιδιων στην arraylist
        }
        return cards;
    }

    public ArrayList<String> getCards() {
        return cards;
    }

}
