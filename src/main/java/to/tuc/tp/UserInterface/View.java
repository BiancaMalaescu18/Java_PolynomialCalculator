package to.tuc.tp.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class View {

    private JFrame jframe;
    private JLabel title = new JLabel("Calculator polinomial");

    private JLabel  p1 = new JLabel("Polinomul 1:");
    private JLabel  p2 = new JLabel("Polinomul 2:");
    private JTextField tp1 = new JTextField();
    private JTextField tp2 = new JTextField();

    private JButton add = new JButton("Adunare");
    private JButton sub = new JButton("Scadere");
    private JButton mul = new JButton("Inmultire");
    private JButton div = new JButton("Impartire");
    private JButton der = new JButton("Derivare p1");
    private JButton inte = new JButton("Integrare p1");

    private JLabel rez = new JLabel("Rezultat:");
    private JTextField trez = new JTextField();

    public JButton getAdd() {
        return add;
    }

    public JButton getSub() {
        return sub;
    }

    public JButton getMul() {
        return mul;
    }

    public JButton getDiv () {
        return div;
    }

    public JButton getInte() {
        return inte;
    }

    public JButton getDer() {
        return der;
    }
    public JTextField getPol1() {
        return tp1;
    }

    public JTextField getPol2() {
        return tp2;
    }

    public JTextField getRez() {
        return trez;
    }
    public void setRez(String str) {
        trez.setText(str);
    }

    public View()
    {
        jframe = new JFrame();
        jframe.setTitle("Calculator polinomial");
        jframe.setBounds(300, 90, 900, 600);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setResizable(false);

        Container c = jframe.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(229, 204, 255));

        title.setFont(new Font("Serif", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);


        p1.setFont(new Font("Serif", Font.PLAIN, 25));
        p1.setSize(200, 20);
        p1.setLocation(250, 100);
        c.add(p1);

        tp1.setFont(new Font("Serif", Font.PLAIN, 25));
        tp1.setSize(250, 30);
        tp1.setLocation(400, 100);
        c.add(tp1);

        p2.setFont(new Font("Serif", Font.PLAIN, 25));
        p2.setSize(200, 20);
        p2.setLocation(250, 150);
        c.add(p2);

        tp2.setFont(new Font("Serif", Font.PLAIN, 25));
        tp2.setSize(250, 30);
        tp2.setLocation(400, 150);
        c.add(tp2);

        add.setBackground(new Color(204, 153, 255));
        add.setFont(new Font("Serif", Font.PLAIN, 25));
        add.setSize(200, 50);
        add.setLocation(250, 200);
        c.add(add);

        sub.setBackground(new Color(204, 153, 255));
        sub.setFont(new Font("Serif", Font.PLAIN, 25));
        sub.setSize(200, 50);
        sub.setLocation(450, 200);
        c.add(sub);

        mul.setBackground(new Color(204, 153, 255));
        mul.setFont(new Font("Serif", Font.PLAIN, 25));
        mul.setSize(200, 50);
        mul.setLocation(250, 250);
        c.add(mul);

        div.setBackground(new Color(204, 153, 255));
        div.setFont(new Font("Serif", Font.PLAIN, 25));
        div.setSize(200, 50);
        div.setLocation(450, 250);
        c.add(div);

        der.setBackground(new Color(204, 153, 255));
        der.setFont(new Font("Serif", Font.PLAIN, 25));
        der.setSize(200, 50);
        der.setLocation(250, 300);
        c.add(der);

        inte.setBackground(new Color(204, 153, 255));
        inte.setFont(new Font("Serif", Font.PLAIN, 25));
        inte.setSize(200, 50);
        inte.setLocation(450, 300);
        c.add(inte);


        rez.setFont(new Font("Serif", Font.PLAIN, 25));
        rez.setSize(200, 20);
        rez.setLocation(250, 400);
        c.add(rez);

        trez.setFont(new Font("Serif", Font.PLAIN, 25));
        trez.setSize(450, 30);
        trez.setLocation(350, 400);
        c.add(trez);

        jframe.setVisible(true);
    }

    public void setP1(String p)
    {
        tp1.setText(p);
    }

    public void setP2(String p)
    {
        tp2.setText(p);
    }

    public String getTextP1(){
        return tp1.getText();
    }

    public String getTextP2(){
        return tp2.getText();
    }


}
