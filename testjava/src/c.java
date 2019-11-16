import java.util.Stack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;
import java.util.Vector;

public class c extends JFrame {
    Stack s = new Stack();
    private JFrame f;
    private JPanel p1, p2;
    private final int ADD = 1;
    private final int SUBTRACT = 2; // declare class constants
    private final int MULTIPLY = 3;
     int operation;
    private JTextField jtfMain;
    private JButton dot, zero, one, two, three, four, five, six, seven, eight, nine, minus, plus, multiply, divide, equal;
    String value, A;
    private dotButtonHandler dotHandler;
    private zeroButtonHandler zeroHandler;
    private oneButtonHandler oneHandler;
    private twoButtonHandler twoHandler;
    private threeButtonHandler threeHandler;
    private fourButtonHandler fourHandler;
    private fiveButtonHandler fiveHandler;
    private sixButtonHandler sixHandler;
    private sevenButtonHandler sevenHandler;
    private eightButtonHandler eightHandler;
    private nineButtonHandler nineHandler;
    private minusButtonHandler minusHandler;
    private plusButtonHandler plusHandler;
    private multiplyButtonHandler multiplyHandler;
    private divideButtonHandler divideHandler;
    private equalButtonHandler equalHandler;
    char ch;
    Stack<String> cStack = new Stack<String>();

    public c() {
        setSize(400, 190);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        jtfMain = new JTextField("");
        seven = new JButton("7");
        sevenHandler = new sevenButtonHandler();
        seven.addActionListener(sevenHandler);
        eight = new JButton("8");
        eightHandler = new eightButtonHandler();
        eight.addActionListener(eightHandler);
        nine = new JButton("9");
        nineHandler = new nineButtonHandler();
        nine.addActionListener(nineHandler);
        zero = new JButton("0");
        zeroHandler = new zeroButtonHandler();
        zero.addActionListener(zeroHandler);
        one = new JButton("1");
        oneHandler = new oneButtonHandler();
        one.addActionListener(oneHandler);
        two = new JButton("2");
        twoHandler = new twoButtonHandler();
        two.addActionListener(twoHandler);
        three = new JButton("3");
        threeHandler = new threeButtonHandler();
        three.addActionListener(threeHandler);
        four = new JButton("4");
        fourHandler = new fourButtonHandler();
        four.addActionListener(fourHandler);
        five = new JButton("5");
        fiveHandler = new fiveButtonHandler();
        five.addActionListener(fiveHandler);
        six = new JButton("6");
        sixHandler = new sixButtonHandler();
        six.addActionListener(sixHandler);
        minus = new JButton("-");
        minusHandler = new minusButtonHandler();
        minus.addActionListener(minusHandler);
        plus = new JButton("+");
        plusHandler = new plusButtonHandler();
        plus.addActionListener(plusHandler);
        multiply = new JButton("X");
        multiplyHandler = new multiplyButtonHandler();
        multiply.addActionListener(multiplyHandler);
        divide = new JButton("/");
        divideHandler = new divideButtonHandler();
        divide.addActionListener(divideHandler);
        equal = new JButton("=");
        equalHandler = new equalButtonHandler();
        equal.addActionListener(equalHandler);
        dot = new JButton(".");
        dotHandler = new dotButtonHandler();
        dot.addActionListener(dotHandler);
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 5));
        p1.add(jtfMain);
        p2.add(divide);
        p2.add(seven);
        p2.add(eight);
        p2.add(nine);
        p2.add(multiply);
        p2.add(four);
        p2.add(five);
        p2.add(six);
        p2.add(minus);
        p2.add(one);
        p2.add(two);
        p2.add(three);
        p2.add(plus);
        p2.add(zero);
        p2.add(dot);
        p2.add(equal);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        setVisible(true);
    }

    private class zeroButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "0";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class oneButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "1";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class twoButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "2";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class threeButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "3";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class fourButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "4";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class fiveButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "5";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class sixButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "6";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class sevenButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "7";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class eightButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "8";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class nineButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "9";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class dotButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value += ".";
            jtfMain.setText(jtfMain.getText() + value);
        }
    }

    private class plusButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String plus = "+";
            jtfMain.setText(jtfMain.getText() + plus);
        }
    }

    private class minusButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String minus = "-";
            jtfMain.setText(minus);
        }
    }

    private class multiplyButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String times = "*";
            jtfMain.setText(jtfMain.getText() + times);
        }
    }

    private class divideButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String div = "/";
            jtfMain.setText(jtfMain.getText() + div);
        }
    }

    private class equalButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int operation;
            double x, z, a = 0.0;
            String y;
            x = Double.parseDouble(jtfMain.getText());
            y = jtfMain.getText();
            z = Double.parseDouble(jtfMain.getText());
            switch ('c') {
                case 1:
                    a = x + z;
                    break;
                case 2:
                    a = x - z;
                    break;
                case 3:
                    a = x * z;
                    break;
            }
            jtfMain.setText("= " + a);
        }
    }

    public static void main(String[] args) {
        c main = new c();
        {
        }
    }
}