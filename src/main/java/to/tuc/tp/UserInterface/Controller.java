package to.tuc.tp.UserInterface;

import to.tuc.tp.DataModels.Monom;
import to.tuc.tp.DataModels.Polinom;
import to.tuc.tp.UserInterface.View;
import to.tuc.tp.BusinessLogic.Operatii;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {
    private View v1;
    private Polinom polinom1;
    private Polinom polinom2;

    public Polinom getPoli1(){
        return polinom1;
    }

    public Polinom getPoli2(){
        return polinom2;
    }

    public Controller(View view){

        v1 = view;

        v1.getAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String primulPolinom = v1.getTextP1().replace(" ", ""); ///setam sa nu avem spatii
                String alDoileaPolinom = v1.getTextP2().replace(" ", "");
                Polinom poli1 = trasnformarePolinom(primulPolinom);
                Polinom poli2 = trasnformarePolinom(alDoileaPolinom);
                Polinom rez = Operatii.adunarePolinom(poli1, poli2);
                v1.setRez(rez.polinomString());

            }
        });

        v1.getSub().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String primulPolinom = v1.getTextP1().replace(" ", ""); ///setam sa nu avem spatii
                String alDoileaPolinom = v1.getTextP2().replace(" ", "");
                Polinom poli1 = trasnformarePolinom(primulPolinom);
                Polinom poli2 = trasnformarePolinom(alDoileaPolinom);
                Polinom rez = Operatii.scaderePolinom(poli1, poli2);
                v1.setRez(rez.polinomString());

            }
        });

        v1.getMul().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String primulPolinom = v1.getTextP1().replace(" ", ""); ///setam sa nu avem spatii
                String alDoileaPolinom = v1.getTextP2().replace(" ", "");
                Polinom poli1 = trasnformarePolinom(primulPolinom);
                Polinom poli2 = trasnformarePolinom(alDoileaPolinom);
                Polinom rez = Operatii.inmultirePolinom(poli1, poli2);
                v1.setRez(rez.polinomString());

            }
        });

        v1.getDer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String primulPolinom = v1.getTextP1().replace(" ", ""); ///setam sa nu avem spatii
                String alDoileaPolinom = v1.getTextP2().replace(" ", "");
                Polinom poli1 = trasnformarePolinom(primulPolinom);
                Polinom rez = Operatii.derivarePolinom(poli1);
                v1.setRez(rez.polinomString());

            }
        });

        v1.getInte().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String primulPolinom = v1.getTextP1().replace(" ", ""); ///setam sa nu avem spatii
                String alDoileaPolinom = v1.getTextP2().replace(" ", "");
                Polinom poli1 = trasnformarePolinom(primulPolinom);
                Polinom rez = Operatii.integrarePolinom(poli1);
                v1.setRez(rez.polinomString());

            }
        });


    }

    private static Polinom trasnformarePolinom(String s){

        ArrayList<Monom> lista_rezultat = new ArrayList<Monom>();

        //int coef = 0, exponent = 0;

        Pattern pattern = Pattern.compile("([+-]?\\d+|-)?[xX]\\^?(\\d+)?|([+-]?\\d+)[xX]?|(-[xX])");
        Pattern invalid = Pattern.compile("[^xX0123456789^+-]");
        Matcher matcher = pattern.matcher(s);
        Matcher inv = invalid.matcher(s);
        if(!inv.find())
        {

            int coef, exponent;
            while(matcher.find()) {
                if (matcher.group(1) == null && matcher.group(2) == null) {
                    if (matcher.group(3) == null) {
                        if (matcher.group(4) != null) {
                            coef = -1;

                            exponent = 1;
                        } else {
                            coef = 1;
                            exponent = 1;
                        }

                    } else {
                        if (matcher.group(4) != null) {
                            coef = -1;
                            exponent = Integer.parseInt(matcher.group(3));
                        } else {
                            coef = Integer.parseInt(matcher.group(3));
                            exponent = 0;

                        }
                    }
                } else if (matcher.group(1) == null && matcher.group(2) != null) {
                    coef = 1;
                    exponent = Integer.parseInt(matcher.group(2));
                } else if (matcher.group(2) == null && matcher.group(1) != null) {
                    if(matcher.group(1).equals("-")){
                        coef = -1;
                        exponent = 1;
                    } else {
                        coef = Integer.parseInt(matcher.group(1));
                        exponent = 1;
                    }
                } else {
                    if(matcher.group(1).equals("-")){
                        coef = -1;
                        exponent = Integer.parseInt(matcher.group(2));

                    }
                    else{
                        coef = Integer.parseInt(matcher.group(1));
                        exponent = Integer.parseInt(matcher.group(2));

                    }

                }
                lista_rezultat.add(new Monom((Number) coef, exponent));

            }
        }
        else
            System.out.println("Datele introduse nu sunt valide!");

        return new Polinom(lista_rezultat);
    }
}
