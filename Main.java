import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Main {
       // * to use Layout u need to go from pane and frame into Container
       // * Container is to set the nature of the Layout, Flow, Grid or even Border
       // * Having no Container means you have no Layout set for the whole frame */

       public static void main(String[] args) {

              GUI2 frame = new GUI2();
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setSize(400, 200);
              frame.setVisible(true);

       }
}

class GUI2 extends JFrame {
       JButton jBtn1 = new JButton("btn1");
       JButton jBtn2 = new JButton("btn2");
       JButton Btn3 = new JButton("Btn3");
       JButton Btn5 = new JButton("Btn5");
       JButton Btn6 = new JButton("Exit");

       public GUI2() {//Constructor
              super("GUI2");

              Container cntnr = getContentPane();
              cntnr.setLayout(new FlowLayout());
              //Layout

              //Buttons added to Container in GUI2 class
              cntnr.add(jBtn1);
              cntnr.add(jBtn2);
              cntnr.add(Btn3);

              cntnr.add(Btn5);
              cntnr.add(Btn6);

              //same action listenr down the class GUI2
              ActListnr actListnr = new ActListnr();

              jBtn1.addActionListener(actListnr);
              jBtn2.addActionListener(actListnr);
              Btn3.addActionListener(actListnr);
              Btn5.addActionListener(actListnr);
              Btn6.addActionListener(actListnr);
       }

       public class ActListnr implements ActionListener {
              public void actionPerformed(ActionEvent act) {
                     Object source = act.getSource();

                     if (source == Btn6) {
                            System.exit(0);
                     } else if (source == Btn5) {
                            JOptionPane.showMessageDialog(null, source, "Btn5", 0);
                     } else if (source == jBtn1) {
                            JOptionPane.showMessageDialog(null, source, "jBtn1", 1);
                     } else if (source == jBtn2) {
                            JOptionPane.showMessageDialog(null, source, "jBtn2", 2);
                     } else if (source == Btn3) {
                            JOptionPane.showMessageDialog(null, source, "Btn3", 3);
                     }

              }
       }
}