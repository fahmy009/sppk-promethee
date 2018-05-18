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
public class Kriteria {
    private String NamaKriteria;
    private String MinMaks;
    private double Bobot;
    private int TipePreferensi;
    private int ParamP;
    private int ParamQ;
    private int ID;

    public Kriteria(int ID, String NamaKriteria, String MinMaks, double Bobot, int TipePreferensi, int ParamP, int ParamQ) {
        this.ID = ID;
        this.NamaKriteria = NamaKriteria;
        this.MinMaks = MinMaks;
        this.Bobot = Bobot;
        this.TipePreferensi = TipePreferensi;
        this.ParamP = ParamP;
        this.ParamQ = ParamQ;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNamaKriteria() {
        return NamaKriteria;
    }

    public void setNamaKriteria(String NamaKriteria) {
        this.NamaKriteria = NamaKriteria;
    }

    public String getMinMaks() {
        return MinMaks;
    }

    public void setMinMaks(String MinMaks) {
        this.MinMaks = MinMaks;
    }

    public double getBobot() {
        return Bobot;
    }

    public void setBobot(double Bobot) {
        this.Bobot = Bobot;
    }

    public int getTipePreferensi() {
        return TipePreferensi;
    }

    public void setTipePreferensi(int TipePreferensi) {
        this.TipePreferensi = TipePreferensi;
    }

    public int getParamP() {
        return ParamP;
    }

    public void setParamP(int ParamP) {
        this.ParamP = ParamP;
    }

    public int getParamQ() {
        return ParamQ;
    }

    public void setParamQ(int ParamQ) {
        this.ParamQ = ParamQ;
    }

    public int getID() {
        return this.ID;
    }
    
    
}
