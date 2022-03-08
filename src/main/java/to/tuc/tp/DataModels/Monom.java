package to.tuc.tp.DataModels;

public class Monom implements Comparable<Monom>{
    private Number coeficient;
    private Integer exponent; //doar coeficientul se poate schimba (sau sa devina 0); exponentul nu

    public Monom(Number coeficient, Integer exponent) {
        this.coeficient = coeficient;
        this.exponent = exponent;
    }

    //getters and setters
    public Number getCoeficient() {
        return this.coeficient;
    }

    public Integer getExponent() {
        return this.exponent;
    }

    public void setCoeficient(Number coeficient) {
        this.coeficient = coeficient;
    }

    //o folosesc pt operatii, cand compar monoamele din 2 polinoame
    @Override
    public int compareTo(Monom m) {
        return m.exponent.compareTo(this.exponent);
    }

    ///functia de afisat ca string un monom - fara semnul coeficientului !!
    public String monomString(){

        StringBuilder monStr = new StringBuilder();

        if(coeficient.doubleValue() != 0.0){
            if(coeficient.doubleValue() < 0.0 )
            {
                double aux = - (coeficient.doubleValue());
                    monStr.append(aux);
            }
            else
                monStr.append(coeficient.doubleValue());
                monStr.append("X^");
                monStr.append(exponent);

        }
        return monStr.toString();

    }


}