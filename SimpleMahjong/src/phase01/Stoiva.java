

package phase01;

public class Stoiva {

    static final int Max = 1000;//μεγεθος στοιβας
    private int top;//η κορυφη της στοιβας
    String pinakas[] = new String[Max];// αρχικοποίηση στοίβας

    public boolean isEmpty() {// έλεγχει αν η στοίβα είναι άδεια
        return (top < 0);
    }

    Stoiva() {
        top = -1;
    }

    
    public boolean push(String x) {  //τοποθετεί το στοιχείο x στην κορυφή της στοίβας
        if (top >= (Max - 1)) //οταν η στοιβα ειναι γεματη
        {
            System.out.println("Η στοιβα γεμισε");
            return false;
        } else {
            pinakas[++top] = x; //το στοιχειο μπαινει στη στοιβα
            System.out.println(x + " μπηκε στη στοιβα");
            return true;
        }
    }

   public String pop() { //επιστρέφει το στοιχείο που βρίσκεται στην κορυφή της στοίβας 
        System.out.println("pop : " + top);
        if (top < 0) {
            System.out.println("η στοιβα ειναι αδεια");
            return " ";
        } else {
            String x = pinakas[top--]; //το στοιχειο βγαινει απο τη στοιβα
            return x;
        }
    }

}
