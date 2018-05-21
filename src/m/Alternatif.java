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
public class Alternatif {
    
    private int ID;
    private String Nama;
    private String Deskripsi;

    public Alternatif(int ID, String Nama, String Deskripsi) {
        this.ID = ID;
        this.Nama = Nama;
        this.Deskripsi = Deskripsi;
    }

    public int getID() {
        return this.ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String Deskripsi) {
        this.Deskripsi = Deskripsi;
    }
    
    
}
