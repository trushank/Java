import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUIExample {
    public static void main(String args[]){
JFrame j1=new JFrame("ChemInfo");
JLabel number=new JLabel("Number");
JTextField num_text=new JTextField();
num_text.setEditable(false);
num_text.disable();
num_text.setText("Abc");
JButton b1= new JButton("Next");
j1.setLayout(new GridLayout(3,3));
j1.add(number);
j1.add(num_text);
j1.add(new JLabel(""));
j1.add(b1);
j1.setVisible(true);
j1.setSize(500,100);
j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
b1.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
	System.out.println("Clicked");
	
    }
});
}
}