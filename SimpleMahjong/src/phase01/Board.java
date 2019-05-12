
package phase01;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private ArrayList<Tiles> myTiles;// arraylist για αποθηκευση καθε κατηγοριας πλακιδιων
    protected ArrayList<ArrayList<String>> boardList;// arraylist για αποθηκευση ολων των πλακιδιων
    private Xaraktiras x; //δημιουργια πλακιδιου τυπου χαρακτηρα
    private Kiklos k;
    private Mpampou m;
    Epoxi e;
    private Louloudi l;

    public Board() {
        this.creatingBoard();

    }

    public ArrayList<Tiles> creatingTilesSets() {//συναρτηση δημιουργιας σετ πλακιδιων
        myTiles = new ArrayList<>();
        x = new Xaraktiras();
        k = new Kiklos();
        m = new Mpampou();
        e = new Epoxi();
        l = new Louloudi();

        for (int i = 0; i < 4; i++) {//προσθηκη στην arraylist τεσσαρων σετ για χαρακτηρα,κυκλο,μπαμπου
            myTiles.add(x);
            myTiles.add(k);
            myTiles.add(m);
        }
        for (int i = 0; i < 2; i++) {//προσθηκη στην arraylist dyo σετ για εποχη,λουλουδι
            myTiles.add(e);
            myTiles.add(l);

        }
        Collections.shuffle(myTiles);//ανακατεμα της arraylist

        return myTiles;
    }

    public void creatingBoard() {//δημιουργια ταμπλο

        ArrayList<String> list = new ArrayList<>();  //arraylist για αποθηκευση των πλακιδιων    
        for (Tiles t : creatingTilesSets()) {//για καθε σετ
            for (int i = 0; i < t.getCards().size(); i++) {
                list.add(t.cards.get(i));//προσθετει καθε πλακιδιο στην arraylist
            }

        }
        for (int i = 0; i < 26; i++) {//δημιουργια κενων αναμεσα στα πλακιδια
            list.add(" ");
        }

        Collections.shuffle(list);

        boardList = new ArrayList<>();
        ArrayList<String> row0 = new ArrayList<>();//δημιουργια arraylist για καθε γραμμη του ταμπλο
        ArrayList<String> row1 = new ArrayList<>();
        ArrayList<String> row2 = new ArrayList<>();
        ArrayList<String> row3 = new ArrayList<>();
        ArrayList<String> row4 = new ArrayList<>();
        int counter = 0;//μετρητης για τα στοιχεια καθε γραμμης

        for (int i = 0; i < 30; i++) {//προσθηκη στοιχειων στην πρωτη γραμμη
            row0.add(list.get(i));
            counter++;
        }

        for (int j = counter; j < 60; j++) {
            row1.add(list.get(j));
            counter++;
        }

        for (int q = counter; q < 90; q++) {
            row2.add(list.get(q));
            counter++;
        }
        for (int q = counter; q < 120; q++) {
            row3.add(list.get(q));
            counter++;
        }
        for (int q = counter; q < 150; q++) {
            row4.add(list.get(q));
            counter++;
        }

        boardList.add(row0);//προσθηκη γραμμων στην arraylist
        boardList.add(row1);
        boardList.add(row2);
        boardList.add(row3);
        boardList.add(row4);

        for (ArrayList<String> a : boardList) {
            System.out.println(a);
        }
        

    }

    protected ArrayList<ArrayList<String>> getBoardList() {
        return boardList;
    }

}
