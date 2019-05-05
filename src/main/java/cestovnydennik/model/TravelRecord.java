package cestovnydennik.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Date cas_start;
    private Date cas_ciel;
    private Date cas_praca_zaciatok;
    private Date cas_praca_koniec;

    public TravelRecord() {}

    public TravelRecord(String vozidlo, Date datum, String cesta_start, String cesta_ciel, Date cas_start, Date cas_ciel, Date cas_praca_zaciatok, Date cas_praca_koniec) {
        this.vozidlo = vozidlo;
        this.datum = datum;
        this.cesta_start = cesta_start;
        this.cesta_ciel = cesta_ciel;
        this.cas_start = cas_start;
        this.cas_ciel = cas_ciel;
        this.cas_praca_zaciatok = cas_praca_zaciatok;
        this.cas_praca_koniec = cas_praca_koniec;
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

    public Date getCas_start() {
        return cas_start;
    }

    public void setCas_start(Date cas_start) {
        this.cas_start = cas_start;
    }

    public Date getCas_ciel() {
        return cas_ciel;
    }

    public void setCas_ciel(Date cas_ciel) {
        this.cas_ciel = cas_ciel;
    }

    public Date getCas_praca_zaciatok() {
        return cas_praca_zaciatok;
    }

    public void setCas_praca_zaciatok(Date cas_praca_zaciatok) {
        this.cas_praca_zaciatok = cas_praca_zaciatok;
    }

    public Date getCas_praca_koniec() {
        return cas_praca_koniec;
    }

    public void setCas_praca_koniec(Date cas_praca_koniec) {
        this.cas_praca_koniec = cas_praca_koniec;
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
                '}';
    }
}
