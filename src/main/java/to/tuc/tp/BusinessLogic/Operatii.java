package to.tuc.tp.BusinessLogic;

import to.tuc.tp.DataModels.Monom;
import to.tuc.tp.DataModels.Polinom;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Operatii {

    public static Monom adunareMonom(Monom m1, Monom m2){
        return new Monom(m1.getCoeficient().doubleValue() + m2.getCoeficient().doubleValue(), m2.getExponent() ); //exponentul ramane la fel
    }

    public static Monom scadereMonom(Monom m1, Monom m2){
        return new Monom(m1.getCoeficient().doubleValue() - m2.getCoeficient().doubleValue(), m2.getExponent() );
    }

    public static Monom inmultireMonom(Monom m1, Monom m2){
        return new Monom(m1.getCoeficient().doubleValue() * m2.getCoeficient().doubleValue(), m1.getExponent() + m2.getExponent() );
    }

    public static Monom impartireMonom(Monom m1, Monom m2){
        return new Monom(m1.getCoeficient().doubleValue() / m2.getCoeficient().doubleValue(), m1.getExponent() - m2.getExponent() );
    }


    public static Polinom adunarePolinom(Polinom p1, Polinom p2){

        ArrayList<Monom> lista_rezultat = new ArrayList<Monom>();

        ///foreach 2 monoame cu exponent egal => adunare
        for(Monom m1: p1.getPolinom())
            for (Monom m2 : p2.getPolinom())
                if(m1.getExponent().equals(m2.getExponent())){
                    Monom nou = adunareMonom(m1, m2);
                    lista_rezultat.add(nou);
                }


        for(Monom m1: p1.getPolinom())
        {
            boolean found = false;
            for(Monom i : lista_rezultat)
            {
                if(m1.getExponent() == i.getExponent())
                    found = true;
            }
            if(found == false)
                lista_rezultat.add(m1);

        }

        for(Monom m2: p2.getPolinom())
        {
            boolean found = false;
            for(Monom i : lista_rezultat)
            {
                if(m2.getExponent() == i.getExponent())
                    found = true;
            }
            if(found == false)
                lista_rezultat.add(m2);

        }

        //sortez in functie de exponent
        Collections.sort(lista_rezultat);

        return new Polinom(lista_rezultat);
    }

    public static Polinom scaderePolinom(Polinom p1, Polinom p2){

        ArrayList<Monom> lista_rezultat = new ArrayList<Monom>();

        ///foreach 2 monoame cu exponent egal => adunare
        for(Monom m1: p1.getPolinom())
            for (Monom m2 : p2.getPolinom())
                if(m1.getExponent().equals(m2.getExponent()))
                {
                    Monom nou = scadereMonom(m1, m2);
                    lista_rezultat.add(nou);
                }

        for(Monom m1: p1.getPolinom())
        {
            boolean found = false;
            for(Monom i : lista_rezultat)
            {
                if(m1.getExponent() == i.getExponent())
                    found = true;
            }
            if(found == false)
                lista_rezultat.add(m1);

        }

        for(Monom m2: p2.getPolinom())
        {
            boolean found = false;
            for(Monom i : lista_rezultat)
            {
                if(m2.getExponent() == i.getExponent())
                    found = true;
            }
            if(found == false)
                lista_rezultat.add( new Monom ((-1)*m2.getCoeficient().doubleValue(), m2.getExponent()));

        }

        //sortez in functie de exponent
        Collections.sort(lista_rezultat);

        return new Polinom(lista_rezultat);
    }

    public static Polinom inmultirePolinom(Polinom p1, Polinom p2){

        ArrayList<Monom> lista_finala = new ArrayList<Monom>();

        boolean adaugat;

        for(Monom m1: p1.getPolinom())
            for(Monom m2: p2.getPolinom()) {

                Monom inm = inmultireMonom(m1, m2);

                adaugat = false;
                //parcurg lista finala, iar daca exista deja un monom cu acelasi exponent doar ii modificm coeficientul
                for (Monom m : lista_finala) {
                    int exm = m.getExponent();
                    int exinm = inm.getExponent();
                    if (exm == exinm ) {
                        adaugat = true;
                        double cm = m.getCoeficient().doubleValue();
                        double cinm = inm.getCoeficient().doubleValue();
                        m.setCoeficient(cm+cinm);
                    }
                }
                //daca nu am gasit un monom cu acelasi coeficient, adaugam monomul rezultat din inmultire in lista
                if(adaugat == false)
                    lista_finala.add(inm);
            }

        //sortez in functie de exponent
        Collections.sort(lista_finala);
        return new Polinom(lista_finala);


    }

    public static Polinom derivarePolinom(Polinom p)
    {

        ArrayList<Monom> lista = new ArrayList<Monom>();
        for(Monom m: p.getPolinom())
        {
            double c = m.getCoeficient().doubleValue() * m.getExponent().intValue();
            int e = m.getExponent().intValue() - 1;
            lista.add(new Monom(c, e));

        }
        Collections.sort(lista);
        return new Polinom(lista);
    }

    public static Polinom integrarePolinom(Polinom p)
    {

        ArrayList<Monom> lista = new ArrayList<Monom>();
        for(Monom m: p.getPolinom())
        {
            int e = m.getExponent().intValue() + 1;
            double c = m.getCoeficient().doubleValue() / e;
            lista.add(new Monom(c, e));

        }
        Collections.sort(lista);
        return new Polinom(lista);
    }
}
