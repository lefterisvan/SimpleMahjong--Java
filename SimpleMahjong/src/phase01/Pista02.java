
package phase01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static phase01.Pista.count;


public class Pista02 extends Pista implements ActionListener {


    

    public Pista02(String name) {
        super(name);
    }
   


    @Override
    public void adder(Container pane) {
        super.adder(pane); 
    }

     @Override
   public void board() {//συναρτηση για δημιουργια πιστας

        count = 0;

        Container pane = jF.getContentPane();
        

        jF.setLayout(new GridLayout(10,5));//εφαρμοζουμε το GridLayout
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
                     jB = new JButton(boardList2.get(i).get(j), new ImageIcon("m8.png"));
                 
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
    
    
protected void theChanger() {
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
