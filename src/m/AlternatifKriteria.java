/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

/**
 *
 * @author ASUS
 */
public class AlternatifKriteria {
    
    private int ID;
    private int IDAlternatif;
    private int IDKriteria;
    private String NamaAlternatif;
    private String NamaKriteria;
    private int Nilai;

    public AlternatifKriteria(int ID, int IDAlternatif, int IDKriteria, String NamaAlternatif, String NamaKriteria, int Nilai) {
        this.ID = ID;
        this.IDAlternatif = IDAlternatif;
        this.IDKriteria = IDKriteria;
        this.NamaAlternatif = NamaAlternatif;
        this.NamaKriteria = NamaKriteria;
        this.Nilai = Nilai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDAlternatif() {
        return IDAlternatif;
    }

    public void setIDAlternatif(int IDAlternatif) {
        this.IDAlternatif = IDAlternatif;
    }

    public int getIDKriteria() {
        return IDKriteria;
    }

    public void setIDKriteria(int IDKriteria) {
        this.IDKriteria = IDKriteria;
    }

    public String getNamaAlternatif() {
        return NamaAlternatif;
    }

    public void setNamaAlternatif(String NamaAlternatif) {
        this.NamaAlternatif = NamaAlternatif;
    }

    public String getNamaKriteria() {
        return NamaKriteria;
    }

    public void setNamaKriteria(String NamaKriteria) {
        this.NamaKriteria = NamaKriteria;
    }

    public int getNilai() {
        return Nilai;
    }

    public void setNilai(int Nilai) {
        this.Nilai = Nilai;
    }
    
}
