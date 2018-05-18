/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import m.Kriteria;
import m.m_kriteria;
import m.m_perhitungan;

/**
 *
 * @author ASUS
 */
public class perhitungan {

    private DefaultTableModel tabelPerhitungan[];
    private m_kriteria model_kriteria;
    private m_perhitungan model_perhitungan;
    private int jumlahKriteria;

    public perhitungan() {
        model_kriteria = new m_kriteria();
        model_perhitungan = new m_perhitungan();
        jumlahKriteria = model_kriteria.getJumlahKriteria();
        tabelPerhitungan = new DefaultTableModel[jumlahKriteria];
    }

    private void hitungPerKriteria() {
        ArrayList<Kriteria> data1 = model_kriteria.bacaKriteria();
        ArrayList<Kriteria> data2 = model_kriteria.bacaKriteria();
        
        for (Kriteria kriteria : data1) {
            for (Kriteria kriteria1 : data2) {
                if (kriteria.getID() != kriteria1.getID()) {
                    
                }
            }
        }
    }

    private double tipePreferensi(int tipe, int p, int q, int a, int b) {
        double hasil = 0.0;
        int selisih = Math.abs(a - b);

        /**
         * 1 usual (umum, jarang digunakan) 2 linear (segi kualitatif) 3 quasi
         * (segi kuantitatif) 4 level (segi kualitatif) 5 linear indiference
         * (segi kuantitatif)
         *
         * p / m / preference q / n / indiference
         */
        switch (tipe) {
            case 1:
                if (selisih <= 0) {
                    hasil = 0.0;
                } else if (selisih > 0) {
                    hasil = 1.0;
                }
                break;
            case 2:
                if (selisih <= q) {
                    hasil = 0.0;
                } else if (selisih > q) {
                    hasil = 1.0;
                }
                break;
            case 3:
                if (selisih < 0) {
                    hasil = 0.0;
                } else if (selisih >= 0 && selisih <= p) {
                    hasil = selisih / p;
                } else if (selisih > p) {
                    hasil = 0.0;
                }
                break;
            case 4:
                if (selisih <= q) {
                    hasil = 0.0;
                } else if (selisih > q && selisih <= p) {
                    hasil = 0.5;
                } else if (selisih > p) {
                    hasil = 1.0;
                }
                break;
            case 5:
                if (selisih <= q) {
                    hasil = 0.0;
                } else if (selisih > q && selisih <= p) {
                    hasil = (selisih - q) / (p - q);
                } else if (selisih > p) {
                    hasil = 1.0;
                }
                break;
            default:
                return -0.0;
        }
        return hasil;
    }

}
