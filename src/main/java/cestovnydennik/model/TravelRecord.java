package cestovnydennik.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import static java.lang.Math.round;

@Entity(name="travelrecords")
public class TravelRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String vozidlo;
    @Temporal(TemporalType.DATE)
    private Date datum;
    private String cesta_start;
    private String cesta_ciel;
    private Time cas_start;
    private Time cas_ciel;
    private Time cas_praca_zaciatok;
    private Time cas_praca_koniec;
    private int vzdialenost;
    private double spotreba;
    private double palivo_cena;
    //private double nahrada;

    public TravelRecord() {}

    public TravelRecord(String vozidlo, Date datum, String cesta_start, String cesta_ciel, Time cas_start, Time cas_ciel, Time cas_praca_zaciatok, Time cas_praca_koniec,
                        int vzdialenost, double spotreba, double palivo_cena) {
        this.vozidlo = vozidlo;
        this.datum = datum;
        this.cesta_start = cesta_start;
        this.cesta_ciel = cesta_ciel;
        this.cas_start = cas_start;
        this.cas_ciel = cas_ciel;
        this.cas_praca_zaciatok = cas_praca_zaciatok;
        this.cas_praca_koniec = cas_praca_koniec;
        this.vzdialenost = vzdialenost;
        this.spotreba = spotreba;
        this.palivo_cena = palivo_cena;
        //this.nahrada = Math.round((getSpotreba()/100) * getVzdialenost())*getPalivo_cena();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVozidlo() {
        return vozidlo;
    }

    public void setVozidlo(String vozidlo) {
        this.vozidlo = vozidlo;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getCesta_start() {
        return cesta_start;
    }

    public void setCesta_start(String cesta_start) {
        this.cesta_start = cesta_start;
    }

    public String getCesta_ciel() {
        return cesta_ciel;
    }

    public void setCesta_ciel(String cesta_ciel) {
        this.cesta_ciel = cesta_ciel;
    }

    public Time getCas_start() {
        return cas_start;
    }

    public void setCas_start(Time cas_start) {
        this.cas_start = cas_start;
    }

    public Time getCas_ciel() {
        return cas_ciel;
    }

    public void setCas_ciel(Time cas_ciel) {
        this.cas_ciel = cas_ciel;
    }

    public Time getCas_praca_zaciatok() {
        return cas_praca_zaciatok;
    }

    public void setCas_praca_zaciatok(Time cas_praca_zaciatok) {
        this.cas_praca_zaciatok = cas_praca_zaciatok;
    }

    public Time getCas_praca_koniec() {
        return cas_praca_koniec;
    }

    public void setCas_praca_koniec(Time cas_praca_koniec) {
        this.cas_praca_koniec = cas_praca_koniec;
    }

    public int getVzdialenost() {
        return vzdialenost;
    }

    public void setVzdialenost(int vzdialenost) {
        this.vzdialenost = vzdialenost;
    }

    public double getSpotreba() {
        return spotreba;
    }

    public void setSpotreba(double spotreba) {
        this.spotreba = spotreba;
    }

    public double getPalivo_cena() {
        return palivo_cena;
    }

    public void setPalivo_cena(double palivo_cena) {
        this.palivo_cena = palivo_cena;
    }

    public double getNahrada()
    {
        return Math.round(((getSpotreba()/100) * getVzdialenost())*getPalivo_cena() + (getVzdialenost() * 0.183));
    }

    @Override
    public String toString() {
        return "TravelRecord{" +
                "id=" + id +
                ", vozidlo='" + vozidlo + '\'' +
                ", datum=" + datum +
                ", cesta_start='" + cesta_start + '\'' +
                ", cesta_ciel='" + cesta_ciel + '\'' +
                ", cas_start=" + cas_start +
                ", cas_ciel=" + cas_ciel +
                ", cas_praca_zaciatok=" + cas_praca_zaciatok +
                ", cas_praca_koniec=" + cas_praca_koniec +
                ", vzdialenost=" + vzdialenost +
                ", spotreba=" + spotreba +
                ", palivo_cena=" + palivo_cena +
                '}';
    }
}
