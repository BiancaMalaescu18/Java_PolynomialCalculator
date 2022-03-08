package to.tuc.tp.DataModels;

import java.util.ArrayList;

public class Polinom {

    ArrayList<Monom> monoame = new ArrayList<>(); //lista de monoame


    public Polinom(ArrayList<Monom> monoame) {
        this.monoame = monoame;
    }


    ///getters si setters
    public ArrayList<Monom> getPolinom() {
        return monoame;
    }

    public void setPolinom(ArrayList<Monom> monoame){
        this.monoame = monoame;

    }

    ///afisare polinom
    public String polinomString() {
        StringBuilder polStr = new StringBuilder();

        double exponentMaxim = -999999999;
        for (Monom m1 : monoame)
        {
            if(m1.getExponent() > exponentMaxim && m1.getCoeficient().doubleValue() != 0)
                exponentMaxim = m1.getExponent();
        }

        for(Monom m : monoame) {
            if(m.getCoeficient().doubleValue() != 0.0)
            {
                if(m.getCoeficient().doubleValue() < 0)
                    polStr.append(" - ");
                else
                    if(m.getExponent() != exponentMaxim)
                        polStr.append(" + ");
                polStr.append(m.monomString());

            }
        }
        return polStr.toString();
    }


}
