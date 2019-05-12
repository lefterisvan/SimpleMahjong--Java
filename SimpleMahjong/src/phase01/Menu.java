package phase01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu  implements ActionListener {
  
    
 //δημιουργία αντικειμένων για να πάρουμε τα στοιχεία του χρήστη
   protected  JPanel p1=new JPanel();
   protected  JFrame f1= new JFrame ();
   protected  FlowLayout fl1=new FlowLayout ();
   protected  JButton b1=new JButton ("Start");
   protected  JButton b2=new JButton ("Finish");
   protected  JButton b3=new JButton ("Help");
   protected  JButton b4=new JButton ("About");
    String name;
    
    
    
    public void menu()
    {
    
 name=JOptionPane.showInputDialog("Add Name");
    f1.setSize(400, 400);
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    f1.setLayout(fl1);
    
    b1.addActionListener(this);//προσθηκη actionlistener για να λειτουργει το κουμπι
    f1.add(b1);
    
    b2.addActionListener(this);
    f1.add(b2);
    
   
    
    b3.addActionListener(this);
    f1.add(b3);
    
    b4.addActionListener(this);
    f1.add(b4);
    
   
    f1.pack();//χρηση της pack για προσαρμογή του μεγέθους του παραθύρου
    f1.add(p1);
       
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource().equals(b1))//οταν ο χρηστης πατήσει το κουμπι
        {
            String[] options = {"None", "Map 1", "Map 2", "Map 3", "Map 4"};

            String n = (String) JOptionPane.showInputDialog(null, "Select Map",
                    "Select", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            System.out.println(n);

            try {
                if (n.equals("Map 1")) {
                    Pista01 a=new Pista01(name);//δημιουργία αντικειμένων για τις πίστες
                    a.board();//χρηση των συναρτησεων της πιστας για να ξεκινησει το παιχνιδι                
                    a.actionPerformed(e);
                   
                } else if (n.equals("Map 2")) {
                    Pista02 a=new Pista02(name);//δημιουργία αντικειμένων για τις πίστες
                    a.board();//χρηση των συναρτησεων της πιστας για να ξεκινησει το παιχνιδι                
                    a.actionPerformed(e);
                    
                } else if (n.equals("Map 3")) {
                    Pista03 a=new Pista03(name);//δημιουργία αντικειμένων για τις πίστες
                    a.board();//χρηση των συναρτησεων της πιστας για να ξεκινησει το παιχνιδι                
                    a.actionPerformed(e);
                  
                } else if (n.equals("Map 4")) {
                    Pista04 a=new Pista04(name);//δημιουργία αντικειμένων για τις πίστες
                    a.board();//χρηση των συναρτησεων της πιστας για να ξεκινησει το παιχνιδι                
                    a.actionPerformed(e);
                   
                }
            } catch (Exception ex) {

            }
  
           

        }
         
          
            if (e.getSource().equals(b2)) 
      {
          System.exit(0);
      }
            
    
              
                if (e.getSource().equals(b3)) 
      {
          JOptionPane.showMessageDialog(null,"search in google");
      }
                
                
        if (e.getSource().equals(b4)) 
      {
         JOptionPane.showMessageDialog(null, "mahjong 2018 made for java");
      }
        
        
    }

    
}   

   