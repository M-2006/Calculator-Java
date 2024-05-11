
//Import the swing, awt & awt-event classes as ' * ' (* = everything from that class)
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{ //add / implement Actionlistener, to events

    //Declare the frames, text-fields, buttons, functions for the butons, and the panej (JPanel), and the values: double / char
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton [10];
    JButton[] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font ("Ink Free", Font.BOLD,30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;


    Calculator(){ // Create a Constructor: and then make the frames, textfields, button,...

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButton[0] = addButton; // +
        functionButton[1] = subButton; // -
        functionButton[2] = mulButton; // *
        functionButton[3] = divButton; // /
        functionButton[4] = decButton; // . (decimal)
        functionButton[5] = equButton; // =
        functionButton[6] = delButton; // Del (Delete a value (number))
        functionButton[7] = clrButton; // Clr (Clear (clear the numbers in the given field by the user))
        functionButton[8] = negButton; // - (Negative button, ex. ( -5))

        for(int i = 0; i < 9; i++) { //add a for-loop to add a ActionLister & Font
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }
        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        //set the bounds for: NegButton, delButton, clrButton:
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel(); //set the JPanel
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        //	panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);

        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true); //Make the Panel visible (true = you can see it / false = you cant see it)

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calculator calc = new Calculator(); //Call the constructor to be able to run-it

    }

    @Override
    public void actionPerformed(ActionEvent e) { // Add the event to take the user-input from the buttons:
        // TODO Auto-generated method stub
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1  = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subButton){
            num1  = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mulButton){
            num1  = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divButton){
            num1  = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource() == equButton) { // When clicked on (' = ') what actions are to be performed:
            num2 = Double.parseDouble(textfield.getText());
            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case'*':
                    result = num1 * num2;
                    break;

                case'/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == clrButton){
            textfield.setText(""); // Clear everything:
        }
        if(e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText(""); // Delete function

            for(int i = 0; i < string.length(); i++) {
                textfield.setText(textfield.getText() + string.charAt(i)); //Get String (Text)
            }
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1; // Negative button funciton
            textfield.setText(String.valueOf(temp));
        }
    }

}
