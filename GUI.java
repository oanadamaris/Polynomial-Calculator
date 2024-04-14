package org.example.GUI;
import jdk.swing.interop.SwingInterOpUtils;
import org.example.LOGIC.Operations;
import org.example.MODEL.Polynomial;

import java.awt.*;
import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI extends JFrame{
    private JTextField p1;
    private JLabel lP1;
    private JTextField p2;
    private JLabel lP2;
    private JTextPane result;
    private JLabel lResult;
    private JButton b_add;
    private JButton b_substract;
    private JButton b_multiply;
    private JButton b_divide;
    private JButton b_derivate;
    private JButton b_integrate;
    public GUI(){
        this.setTitle("Polynomial calculator");
        this.setSize(500,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(0,2));
        this.getContentPane().add(panel);
        panel.setBackground(new Color(237,166,193));

        lP1=new JLabel("First Polynomial:");
        lP1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lP1);

        p1=new JTextField();
        p1.setBackground(new Color(216,229,201));
        p1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(p1);

        lP2=new JLabel("Second Polynomial:");
        lP2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lP2);

        p2=new JTextField();
        p2.setBackground(new Color(216,229,201));
        p2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(p2);

        lResult=new JLabel("Result");
        lResult.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lResult);

        result=new JTextPane();
        result.setBackground(new Color(216,229,201));
        result.setEditable(false);
        panel.add(result);

        b_add=new JButton("+");
        b_add.setBackground(new Color(216,229,201));
        panel.add(b_add);
        b_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial poly1=Polynomial.stringToPoly(p1.getText());
                Polynomial poly2=Polynomial.stringToPoly(p2.getText());
                    Operations o=new Operations();
                    Polynomial pResult=o.add(poly1,poly2);
                    result.setText(pResult.toString());
            }
        });

        b_substract=new JButton("-");
        b_substract.setBackground(new Color(216,229,201));
        panel.add(b_substract);
        b_substract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial poly1=Polynomial.stringToPoly(p1.getText());
                Polynomial poly2=Polynomial.stringToPoly(p2.getText());
                    Operations o=new Operations();
                    Polynomial pResult=o.substract(poly1,poly2);
                    result.setText(pResult.toString());
            }
        });

        b_multiply=new JButton("*");
        b_multiply.setBackground(new Color(216,229,201));
        panel.add(b_multiply);
        b_multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial poly1=Polynomial.stringToPoly(p1.getText());
                Polynomial poly2=Polynomial.stringToPoly(p2.getText());
                    Operations o=new Operations();
                    Polynomial pResult=o.multiply(poly1,poly2);
                    result.setText(pResult.toString());
            }
        });

        b_divide=new JButton("/");
        b_divide.setBackground(new Color(216,229,201));
        panel.add(b_divide);
        b_divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial poly1=Polynomial.stringToPoly(p1.getText());
                Polynomial poly2=Polynomial.stringToPoly(p2.getText());
                    Operations o=new Operations();
                    result.setText(o.divide(poly1,poly2));
            }
        });

        b_derivate=new JButton("'");
        b_derivate.setBackground(new Color(216,229,201));
        panel.add(b_derivate);
        b_derivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial poly1=Polynomial.stringToPoly(p1.getText());
                    Operations o=new Operations();
                    Polynomial pResult=o.derivate(poly1);
                    result.setText(pResult.toString());
            }
        });

        b_integrate=new JButton("∫");
        b_integrate.setBackground(new Color(216,229,201));
        panel.add(b_integrate);
        b_integrate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial poly1=Polynomial.stringToPoly(p1.getText());
                    Operations o=new Operations();
                    Polynomial pResult=o.integrate(poly1);
                    result.setText(pResult.toString());

            }
        });
    }
}
