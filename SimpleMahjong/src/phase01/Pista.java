
package phase01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;

public class Pista extends Board implements ActionListener {

    private String name;

    public Pista(String name) {
        this.name = name;
    }
    Mahjong m = new Mahjong();

    JMenu menu;
    JMenu menu1;
    JMenuItem i1;
    JMenuItem i2;
    JMenuItem i3;
    JMenuItem i4;
    JMenuItem i5;
    JMenuBar mb = new JMenuBar();

    ArrayList<ArrayList<JButton>> a1 = new ArrayList<>();// ArrayList για αποθηκευση των κουμπιων που θα μπουν στο frame
    ArrayList<ArrayList<String>> boardList2 = new ArrayList<>(m.list());//ArrayList για την αποθηκευση της boardList η οποια επιστρεφεται απο τη συναρτηση list
    protected static int count = 0;
    protected JButton jB;
    protected String ch1 = "";//χρησιμοποιειται για να συγκρινουμε και για να διαγραψουμε τα πλακιδια
    protected int pos1 = -1, pos2 = -1;//συντεταγμενες πλακιδιου
    protected int pos = -1, pos3 = -1;//συντεταγμενες πλακιδιου
    
    
    JFrame jF = new JFrame();
    GridLayout gl = new GridLayout(10, 5);
    JPanel panel = new JPanel(new FlowLayout());
    

    public void board() {//συναρτηση για δημιουργια πιστας

        count = 0;

        Container pane = jF.getContentPane();

        jF.setLayout(gl);//εφαρμοζουμε το GridLayout
        menu1=new JMenu ("Score");
        menu = new JMenu("Helps");
        i1 = new JMenuItem("show free");
        i2 = new JMenuItem("shuffle");
        i3 = new JMenuItem("show move");
        i4 = new JMenuItem("delete");
        i5 = new JMenuItem("Score");
      
        
        menu1.addActionListener(this);
        menu.add(i1);//προσθηκη των αντικειμενων στο μενου
        menu.add(i2);
        menu.add(i3);
        menu.add(i4);
        menu1.add(i5);
        mb.add(menu);
        mb.add(menu1);
        jF.setJMenuBar(mb);
        i1.addActionListener(this);//προσθηκη actionlistener για να λειτουργει το κουμπι
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        jF.setSize(300, 300);
        jF.setVisible(true);
        jF.setLocationRelativeTo(null);
        jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < boardList2.size(); i++) {//για τις γραμμες της ArrayList
            ArrayList<JButton> ARB = new ArrayList<>();//δημιουργια βοηθητικης ArrayList
            for (int j = 0; j < boardList2.get(i).size(); j++) {//για το στοιχειο καθε γραμμης
                //Γεμισμα των JButton με ονομασία και εικόνα ανάλογα το είδος τους:
                if(boardList2.get(i).get(j).equals("M0") ){
                jB = new JButton(boardList2.get(i).get(j), new ImageIcon("m1.png"));//δημιουγια ενος κουμπιου με τις συντεταγμενες του στοιχειου
                   
                }else if(boardList2.get(i).get(j).equals("M1")){
                    jB = new JButton(boardList2.get(i).get(j), new ImageIcon("m2.png"));
             
                }else if(boardList2.get(i).get(j).equals("Μ2")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("m3.png"));
                  
                } else if(boardList2.get(i).get(j).equals("Μ3")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("m4.png"));
                    
                }else if(boardList2.get(i).get(j).equals("Μ4")){
                         jB = new JButton(boardList2.get(i).get(j), new ImageIcon("m5.png"));
                  
                }else if(boardList2.get(i).get(j).equals("Μ5")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("m6.png"));
                  
                }else if(boardList2.get(i).get(j).equals("Μ6")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("m7.png"));
                  
                }else if(boardList2.get(i).get(j).equals("Μ7")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("C:\\Users\\lefte\\Desktop\\icsd16087_Phase01\\Phase01\\m8.png"));
                 
                }else if(boardList2.get(i).get(j).equals("Μ8")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("m9.png"));
                  
               }else if(boardList2.get(i).get(j).equals("K0") ){
                jB = new JButton(boardList2.get(i).get(j), new ImageIcon("k1.png"));//δημιουγια ενος κουμπιου με τις συντεταγμενες του στοιχειου
                   
                }else if(boardList2.get(i).get(j).equals("K1")){
                    jB = new JButton(boardList2.get(i).get(j), new ImageIcon("k2.png"));
                    
                }else if(boardList2.get(i).get(j).equals("K2")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("k3.png"));
                    
                }else if(boardList2.get(i).get(j).equals("K3")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("k4.png"));
                    
                }else if(boardList2.get(i).get(j).equals("K4")){
                         jB = new JButton(boardList2.get(i).get(j), new ImageIcon("k5.png"));
                
                }else if(boardList2.get(i).get(j).equals("K5")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("k6.png"));
                
                }else if(boardList2.get(i).get(j).equals("K6")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("k7.png"));
                  
                }else if(boardList2.get(i).get(j).equals("K7")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("k8.png"));
                  
                }else if(boardList2.get(i).get(j).equals("K8")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("k9.png"));
                   
               }else if(boardList2.get(i).get(j).equals("L0") ){
                jB = new JButton(boardList2.get(i).get(j), new ImageIcon("l1.png"));//δημιουγια ενος κουμπιου με τις συντεταγμενες του στοιχειου
                  
                }else if(boardList2.get(i).get(j).equals("L1")){
                    jB = new JButton(boardList2.get(i).get(j), new ImageIcon("l2.png"));
                   
                }else if(boardList2.get(i).get(j).equals("L2")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("l3.png"));
                    
                }else if(boardList2.get(i).get(j).equals("L3")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("l4.png"));
                    
                }else if(boardList2.get(i).get(j).equals("E0") ){
                jB = new JButton(boardList2.get(i).get(j), new ImageIcon("E1.png"));//δημιουγια ενος κουμπιου με τις συντεταγμενες του στοιχειου
                   
                }else if(boardList2.get(i).get(j).equals("E1")){
                    jB = new JButton(boardList2.get(i).get(j), new ImageIcon("E2.png"));
                    
                }else if(boardList2.get(i).get(j).equals("E2")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("E3.png"));
                   
                } 
                else if(boardList2.get(i).get(j).equals("E3")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("E4.png"));
                    
                } else if(boardList2.get(i).get(j).equals("X0")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("x1.png"));
               
                }else if(boardList2.get(i).get(j).equals("X1")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("x2.png"));
               
                }else if(boardList2.get(i).get(j).equals("X2")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("x3.png"));
                
                }else if(boardList2.get(i).get(j).equals("X3")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("x4.png"));
                
                }else if(boardList2.get(i).get(j).equals("X4")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("x5.png"));
                
                }else if(boardList2.get(i).get(j).equals("X5")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("x6.png"));
                
                }else if(boardList2.get(i).get(j).equals("X6")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("x7.png"));
                
                }else if(boardList2.get(i).get(j).equals("X7")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("x8.png"));
               
                }else if(boardList2.get(i).get(j).equals("X8")){
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("x9.png"));
                }else{
                    jB = new JButton(boardList2.get(i).get(j));
                    //ARB.add(jB);
                }
                ARB.add(jB);//προσθηκη του κουμπιου στην ARB
            }
            a1.add(ARB); //προσθηκη της arraylist στην αλλη arraylist
        }
       
          
        
       
        adder(pane);
        pane.repaint();

    }

    public void adder(Container pane) { //συναρτηση για προσθηκη αντικειμενων στον container
        pane = jF.getContentPane();//προσθηκη του pane στο frame
        for (int i = 0; i < a1.size(); i++) {//για καθε γραμμη της a1
            for (int j = 0; j < a1.get(i).size(); j++) {//για καθε στοιχειο της γραμμης

                a1.get(i).get(j).addActionListener(this);//προσθηκη ActionListener στα κουμπια της a1
                a1.get(i).get(j).setBackground(null);
                pane.add(a1.get(i).get(j));//προσθηκη των κουμπιων στον container
            }
        }
        jF.pack();
        pane.repaint();
    }
    //static int flag = -1, flag2 = -1;

    @Override
    public void actionPerformed(ActionEvent e) { //ενεργοποιηση των κουμπιων

        for (int i = 0; i < a1.size(); i++) { //για καθε γραμμη της a1

            for (int k = 0; k < a1.get(i).size(); k++) {//για καθε στοιχειο της γραμμης
                JButton j = a1.get(i).get(k);//δημιουργια του κουμπιου j
                if (e.getSource().equals(j)) {//οταν ο χρηστης πατα το κουμπι
                    char ar1 = 'A';
                    char ar2;
                    if (!Deleter()) {//αν δεν υπαρχουν ελευθερα πλακιδια
                        JOptionPane.showConfirmDialog(new JFrame(), "No more free tiles");
                    }

                    if (ch1.length() == 0 && m.freeTiles(i, k)) {//αν ενα πλακιδιο ειναι ελευθερο και δεν εχει πατηθει αλλη φορα

                        j.setBackground(Color.red);//γινεται κοκκινο
                        ch1 = j.getText();//το ch1 παιρνει το περιεχομενο του κουμπιου
                        pos1 = i;//γραμμη του πρωτου πλακιδιου
                        pos2 = k;//στηλη του πρωτου πλακιδιου
                        jB = j;// αποθηκευεται το περιεχομενο του πρωτου κουμπιου

                        ar1 = ch1.charAt(0);//παιρνει μονο τον πρωτο χαρακτηρα του πλακιδιου για την περιπτωση που το πλακιδιο ειναι χαρακτηρας ή εποχη

                    } else if (i != pos1 || k != pos2) {

                        ar2 = j.getText().charAt(0);//παιρνει μονο τον πρωτο χαρακτηρα του πλακιδιου για την περιπτωση που το πλακιδιο ειναι χαρακτηρας ή εποχη
                        if (m.freeTiles(i, k) && (i != pos1 || k != pos2) && ar1 == ar2) //αν το δευτερο πλακιδιο ειναι ελευθερο και εχει το ιδιο περιεχομενο με το προηγουμενο και ειναι κατηγοριας λουλουδι ή εποχη
                        {

                            pos = i;//γραμμη του δευτερου πλακιδιου
                            pos3 = k;//στηλη του δευτερου πλακιδιου
                            jB.setBackground(null);//τα δυο κουμπια γινονται κοκκινα
                            j.setBackground(null);
                            count = count + 10;//αυξηση σκορ
                           
                            if (!Deleter()) {
                                JOptionPane.showConfirmDialog(new JFrame(), "No more free tiles");
                                files(name, count);//προσθηκη σκορ στο αρχειο
                            }

                            j.setText(" ");//το περιεχομενο των κουμπιων γινεται κενο ωστε να αφαιρεθουν απ το ταμπλο
                            jB.setText(" ");
                            ch1 = "";

                            m.deleteTiles(pos, pos3, pos1, pos2);//τα κουμπια διαγραφονται
                            pos = -1;//οι συντεταγμενες γινονται -1 ωστε να χρησιμοποιηθουν ξανα
                            pos3 = -1;
                            pos1 = -1;
                            pos2 = -1;
                        }
                        if (ch1.equals(j.getText()) && m.freeTiles(i, k) && (i != pos1 || k != pos2)) {

                            pos = i;//γραμμη του δευτερου πλακιδιου
                            pos3 = k;//στηλη του δευτερου πλακιδιου
                            jB.setBackground(null);
                            j.setBackground(null);
                            count = count + 20;
                         
                            if (!Deleter()) {
                                JOptionPane.showMessageDialog(new JFrame(), "No more free tiles");
                                files(name, count);
                            }

                            j.setText(" ");//το περιεχομενο των κουμπιων γινεται κενο ωστε να αφαιρεθουν απ το ταμπλο
                            jB.setText(" ");
                            j.setIcon(null);
                            jB.setIcon(null);
                            ch1 = "";

                            m.deleteTiles(pos, pos3, pos1, pos2);//τα κουμπια διαγραφονται
                            pos = -1;//οι συντεταγμενες γινονται -1 ωστε να χρησιμοποιηθουν ξανα
                            pos3 = -1;
                            pos1 = -1;
                            pos2 = -1;

                        } else {//αν δεν ικανοποιουν τις συνθηκες διαγραφης
                            JOptionPane.showMessageDialog(new JFrame(), "Den mporeis na ta diagrapseis");
                            j.setBackground(null);
                            jB.setBackground(null);
                            ch1 = "";//γινεται κενο για να χρησιμοποιηθει στον επομενο ελεγχο
                            pos = -1;//οι συντεταγμενες γινονται -1 ωστε να χρησιμοποιηθουν ξανα
                            pos3 = -1;
                            pos1 = -1;
                            pos2 = -1;
                        }

                    }
                }
            }
        }

        if (e.getSource() == i1) {//οταν ο χρηστης επιλεγει να εμφανιστουν τα ελευθερα πλακιδια

            theChanger();

        }
        if (e.getSource() == i2) {//οταν ο χρηστης επιλεγει να ανακατεψει τα πλακιδια

            m.list().clear();//αδειασμα της boardlist
            for (int i = 0; i < a1.size(); i++) {
                Collections.shuffle(a1.get(i)); //ανακατευει τα στοιχεια καθε γραμμης της arraylist
            }
            Collections.shuffle(a1); //ανακατευει τις γραμμες της arraylist μεταξυ τους 

            for (int i = 0; i < a1.size(); i++) {
                for (int j = 0; j < a1.get(i).size(); j++) {
                    System.out.print(a1.get(i).get(j).getText());
                }
                System.out.println("");
            }

            for (int i = 0; i < a1.size(); i++) {
                ArrayList<String> lsi = new ArrayList<>();//νεα λιστα για την αποθηκευση της ανακατεμενης λιστας
                for (int j = 0; j < a1.get(i).size(); j++) {
                    lsi.add(a1.get(i).get(j).getText());
                }
                m.list().add(lsi);//ενημερωση της boardlist με χρηση της lsi
            }

            Container pane2 = new Container();//δημιουργια νεου container
            ch1 = "";
            jF.revalidate();
            jF.repaint();

            adder(pane2);

        }
        if (e.getSource() == i3) {//οταν ο χρηστης επιλεγει μια τυχαια κινηση
            ArrayList<Free> Freelist = new ArrayList<>();//arraylist για αποθηκευεση ελευθερων πλακιδιων
            for (int r = 0; r < a1.size(); r++) {//για καθε γραμμη της a1

                for (int c = 0; c < a1.get(r).size(); c++) {//για καθε στοιχειο της γραμμης

                    if (!(a1.get(r).get(c).getText().equals(" "))) {//αν τα πλακιδια δεν ειναι κενα
                        if ((c == 0) || (c == getBoardList().get(r).size()) || (c == 14) || (c == 15) || (c == 29)) {//θεσεις που τα πλακιδια παντα ειναι ελευθερα

                            Freelist.add(new Free(r, c));//προσθηκη πλακιδιου στη λιστα
                        } else if ((a1.get(r).get(c + 1).getText().equals(" ")) || (a1.get(r).get(c - 1).getText().equals(" "))) //αν το πλακιδιο ειναι ελευθερο
                        {
                            Freelist.add(new Free(r, c));
                        }
                    }
                }
            }
            Random n = new Random();//δημιουργια τυχαιου αριθμου 
            int k ;
            int ik ;
            int jk ;
            JButton po;
            JButton po1;
            int k1;
            do {
                 k = n.nextInt(Freelist.size());//επιλογη τυχαιου στοιχειου απο την arraylist 
                ik = Freelist.get(k).getI();//γραμμη του στοιχειου
                jk = Freelist.get(k).getJ();//στηλη του στοιχειο
                po = a1.get(ik).get(jk);//κουμπι για το στοιχειο της arraylist 
                do {
                    k1 = n.nextInt(Freelist.size());//οπως το k
                } while (k == k1);//οσο οι δυο αριθμοι ειναι ιδιοι

                int ik1 = Freelist.get(k1).getI();//οπως το k
                int jk1 = Freelist.get(k1).getJ();
                po1 = a1.get(ik1).get(jk1);

            } while (!po.getText().equals(po1.getText()));//οσο τα κουμπια εχουν το ιδιο περιεχομενο
            po1.setBackground(Color.GREEN);//γινεται πρασινο
            po.setBackground(Color.GREEN);
            Freelist.clear();

        }
        if (e.getSource() == i4) {
            ArrayList<Free> Freelist = new ArrayList<>();//arraylist για αποθηκευεση ελευθερων πλακιδιων
            for (int r = 0; r < a1.size(); r++) {//για καθε γραμμη της a1

                for (int c = 0; c < a1.get(r).size(); c++) {//για καθε στοιχειο της γραμμης

                    if (!(a1.get(r).get(c).getText().equals(" "))) {//αν τα πλακιδια δεν ειναι κενα
                        if ((c == 0) || (c == getBoardList().get(r).size()) || (c == 14) || (c == 15) || (c == 29)) {//θεσεις που τα πλακιδια παντα ειναι ελευθερα

                            Freelist.add(new Free(r, c));//προσθηκη πλακιδιου στην arraylist 
                        } else if ((a1.get(r).get(c + 1).getText().equals(" ")) || (a1.get(r).get(c - 1).getText().equals(" "))) //αν το πλακιδιο ειναι ελευθερο
                        {
                            Freelist.add(new Free(r, c));
                        }
                    }
                }
            }
            Random n = new Random();//δημιουργια τυχαιου αριθμου 
            int k ;
            int ik ;
            int jk ;
            JButton po;
            JButton po1;
            int k1;
         
            do {
                 k = n.nextInt(Freelist.size());//επιλογη τυχαιου στοιχειου απο την arraylist 
                 ik = Freelist.get(k).getI();//γραμμη του στοιχειου
                 jk = Freelist.get(k).getJ();//στηλη του στοιχειο
                do { 
                    k1 = n.nextInt(Freelist.size());//οπως το k
                } while (k == k1);//οσο οι δυο αριθμοι ειναι ιδιοι

                int ik1 = Freelist.get(k1).getI();//οπως το k
                int jk1 = Freelist.get(k1).getJ();
                 po = a1.get(ik).get(jk);//κουμπι για το στοιχειο της arraylist 
                po1 = a1.get(ik1).get(jk1);
            } while (!po.getText().equals(po1.getText()));//οσο τα κουμπια εχουν το ιδιο περιεχομενο
            po1.setBackground(Color.BLACK);//γινεται μαυρο
            po.setBackground(Color.BLACK);
            po1.setText(" ");
            po.setText(" ");
            po1.setIcon(null);
            po.setIcon(null);
            Freelist.clear();

        }
        if(e.getSource().equals(i5)){
            JOptionPane.showMessageDialog(null,"The score is "+count);
        }
    }

    protected boolean Deleter() {//συναρτηση που ελεγχει αν ενα πλακιδιο ειναι ελευθερο
        for (int r = 0; r < a1.size(); r++) {//για καθε γραμμη της a1

            for (int c = 0; c < a1.get(r).size(); c++) {//για καθε στοιχειο της γραμμης

                if (!(a1.get(r).get(c).getText().equals(" "))) {//αν τα πλακιδια δεν ειναι κενα
                    if ((c == 0) || (c == getBoardList().get(r).size()) || (c == 14) || (c == 15) || (c == 29)) {//θεσεις που τα πλακιδια παντα ειναι ελευθερα

                        return true;
                    } else if ((a1.get(r).get(c + 1).getText().equals(" ")) || (a1.get(r).get(c - 1).getText().equals(" "))) //αν το πλακιδιο ειναι ελευθερο
                    {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    protected void files(String name, int n) {//συναρτηση για καταχωρηση του σκορ σε αρχειο
        FileOutputStream out;//δημιουργια ροης εξοδου
        ObjectOutputStream oout;
        try {
            out = new FileOutputStream("text.txt");//δημιουργια αρχειου
            oout = new ObjectOutputStream(out);
            Person p = new Person(name, n);

            // write something in the file
            oout.writeObject(p);//η ροη εξοδου παιρνει το αντικειμενου τυπου person

            // close the stream
            oout.close();

        } catch (Exception e) {

        }
    }

    protected void theChanger() {//συναρτηση για εμφανιση ελευθερων πλακιδιων
        for (int r = 0; r < a1.size(); r++) {//για καθε γραμμη της a1

            for (int c = 0; c < a1.get(r).size(); c++) {//για καθε στοιχειο της γραμμης

                if (!(a1.get(r).get(c).getText().equals(" "))) {//αν τα πλακιδια δεν ειναι κενα
                    if ((c == 0) || (c == getBoardList().get(r).size()) || (c == 14) || (c == 15) || (c == 29)) {//θεσεις που τα πλακιδια παντα ειναι ελευθερα

                        a1.get(r).get(c).setBackground(Color.yellow);//γινονται κιτρινα
                    } else if ((a1.get(r).get(c + 1).getText().equals(" ")) || (a1.get(r).get(c - 1).getText().equals(" "))) //αν το πλακιδιο ειναι ελευθερο
                    {
                        a1.get(r).get(c).setBackground(Color.yellow);
                    }
                }
            }
        }

    }

}
