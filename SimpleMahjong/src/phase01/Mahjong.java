//321/2016190 ΣΠΥΡΙΔΩΝ ΣΤΟΓΙΟΥ
//321/2016087 ΕΥΑΓΓΕΛΟΣ ΙΩΑΝΝΗΣ ΛΑΜΠΡΟΥ

package phase01;

import java.util.ArrayList;
import java.util.Collections;

public class Mahjong extends Board{

   

    public boolean freeTiles(int r, int c) {//βρισκει αν ενα πλακιδιο ειναι ελευθερο 
        boolean isFree = false;
   
      
        try
        {
            if ((c == 0) || (c == getBoardList().get(r).size() - 1)) {//αν βρισκεται στην πρωτη ή τελευταια στηλη 
            isFree = true;//ειναι ελευθερο
        } else if ((getBoardList().get(r).get(c + 1).equals(" ")) || (getBoardList().get(r).get(c - 1).equals(" "))) //αν το πλακιδιο που βρίσκεται δεξια ή αριστερα του ειναι κενο
        {
            isFree = true;//ειναι ελευθερο
        } else if(c==14 || c==15)
        {
          isFree = true;//ειναι ελευθερο   
        }
        
        else {
            isFree = false;//αλλιως δεν ειναι ελευθερο
        }
        }
        catch(IndexOutOfBoundsException e)
        {
            
        }
        
        return isFree;

    }

    Stoiva stack = new Stoiva();//στοιβα για αποθηκευση ενεργειων του χρηστη

    public void deleteTiles(int r, int c, int r1, int c1) {//διαγραφη πλακιδιων δινοντας γραμμη και στηλη στην οποια βρισκεται καθε πλακιδιο

      
        if (this.freeTiles(r, c) == true && this.freeTiles(r1, c1) == true) //αν και τα δυο στοιχεια ειναι ελευθερα
        {
            String str1 = getBoardList().get(r).get(c);//αποθηκευση των πλακιδιων σε  string
            String str2 = getBoardList().get(r1).get(c1);
            char ar1[] = str1.toCharArray();//μετατροπη των string σε χαρακτηρες
            char ar2[] = str2.toCharArray();
            
            if ((ar1[0] == 'L' && ar2[0] == 'L') || (ar2[0] == 'E' && ar1[0] == 'E')) //αν το πλακιδιο ειναι λουλουδι ή εποχη συγκρινουμε μονο το γραμμα
            {
                stack.push(getBoardList().get(r).get(c) + getBoardList().get(r1).get(c1));//προσθηκη στη στοιβα
                getBoardList().get(r).set(c, " ");//αντικατασταση του πλακιδιου με κενα πανω στο ταμπλο για να βλεπουμε οτι το εχουμε διαγραψει
                getBoardList().get(r1).set(c1, " ");
                for (ArrayList<String> a : getBoardList()) { //εμφανιση της arraylist που περιλαμβανει ολα τα πλακιδια
                    System.out.println(a);
                }
            } 
            else if (str1.equals(str2)) //αλλιως αν ειναι χαρακτηρας ή κυκλος ή μπαμπου συγκρινουμε και το γραμμα και τον αριθμο
            {
                stack.push(getBoardList().get(r).get(c) + getBoardList().get(r1).get(c1));//οπως στο προηγουμενο
                getBoardList().get(r).set(c, " ");
                getBoardList().get(r1).set(c1, " ");
                for (ArrayList<String> a : getBoardList()) {
                    System.out.println(a);
                }
            }

        } else {//αν δεν ειναι ελευθερο
            System.out.println("Δε μπορεις να τα διαγραψεις");
            for (ArrayList<String> a : getBoardList()) {
                    System.out.println(a);}
        }

    }

    public void Undo() {//αναιρεση κινησης

        char undoArray[] = stack.pop().toCharArray();//πινακας χαρακτηρων στον οποιο αποθηκευονται τα πλακιδια που αφαιρουνται απο τη στοιβα
        String plak1 = (undoArray[0] + "" + undoArray[1]);//πλακιδιο που αποτελειται απο δυο χαρακτηρες, γραμμα και μονοψηφιο αριθμο
        String plak2 = (undoArray[2] + "" + undoArray[3]);
        int flag1 = 0, flag2 = 0;
        
        for (int i = 0; i < getBoardList().size(); i++) //τοποθετει το πρωτο πλακιδιο σε σημειο του ταμπλο οπου υπαρχει κενο
        {
            for (int j = 0; j < getBoardList().get(i).size(); j++) {
                if (getBoardList().get(i).get(j).equals(" ")) //οταν βρει κενο
                {
                    getBoardList().get(i).set(j, plak1);//τοποθετει το πλακιδιο
                    flag1 = 1;
                    break;
                }
                if (flag1 == 1) {
                    break;
                }
            }

        }
        for (int i = 0; i < getBoardList().size(); i++) //ομοιως με το προηγουμενο
        {
            for (int j = 0; j < getBoardList().get(i).size(); j++) {
                if (getBoardList().get(i).get(j).equals(" ")) { 
                    getBoardList().get(i).set(j, plak2); 
                    flag2 = 1;
                    break;
                }
            }
            if (flag2 == 1) {
                break;
            }

        }

        for (ArrayList<String> a : getBoardList()) { 
            System.out.println(a);
        }

    }

    public void Shuffler() {//ανακατεμα πλακιδιων

        for (int i = 0; i < getBoardList().size(); i++) 
        {
            Collections.shuffle(getBoardList().get(i)); //ανακατευει τα στοιχεια καθε γραμμης της arraylist
        }
        Collections.shuffle(getBoardList()); //ανακατευει τις γραμμες της arraylist μεταξυ τους 

        for (ArrayList<String> a : getBoardList()) {
            System.out.println(a);
        }
    }

   public ArrayList<Integer> displayFreeTiles() {//εμφανιση ελευθερων πλακιδιων 
       ArrayList<String> freeTiles = new ArrayList<>();//Δημιουργια arrayList για τα ελευθερα πλακιδια
        ArrayList<Integer> a=new ArrayList<>();
        
        for (int i = 0; i < getBoardList().size(); i++) //για καθε γραμμη της arraylist
        {

            if (!getBoardList().get(i).get(0).equals(" "))//αν η πρωτη θεση καθε γραμμης εχει καποιο πλακιδιο και δεν ειναι κενη
            {
                freeTiles.add(getBoardList().get(i).get(0));//το πλακιδιο ειναι ελευθερο αρα προστιθεται στην arraylist
               //-- a.add(i);
        
            }
            
            else if (!getBoardList().get(i).get(getBoardList().get(i).size() - 1).equals(" ")) //αν η τελευταια θεση καθε γραμμης εχει καποιο πλακιδιο και δεν ειναι κενη
            {
                freeTiles.add(getBoardList().get(i).get(getBoardList().get(i).size() - 1));//το πλακιδιο ειναι ελευθερο αρα προστιθεται στην arraylist
                a.add(i);
               
                
            }

            for (int j = 1; j < getBoardList().get(i).size() - 1; j++) {//για τις θεσεις καθε γραμμης εκτος απο την πρωτη και την τελευταια

                String str1 = getBoardList().get(i).get(j);// αν η θεση που θελουμε να ελεγξουμε εχει ελευθερο πλακιδιο
                String str2 = getBoardList().get(i).get(j + 1);//η θεση που βρισκεται δεξια απο αυτη που ελεγχουμε
                String str3 = getBoardList().get(i).get(j - 1);//η θεση που βρισκεται αριστερα απο αυτη που ελεγχουμε
                
                

                if (!str1.equals(" ")) {//Αν στη θεση που ελεγχουμε υπαρχει πλακιδιο
                    if ((str2.equals(" ")) || (str3.equals(" "))) {//Αν η επόμενη ή προηγουμενη θέση ειναι κενή
                        freeTiles.add(str1);//Προσθηκη του πλακιδιου στην arraylist
                        a.add(i);
                        a.add(j);
                }
   
            }
               

        }
       

    }
         return a;
    }
    public ArrayList<ArrayList<String>> list()
    {
        return getBoardList();
    }
}
