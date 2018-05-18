/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import v.kriteria;
import v.tambahKriteria;

/**
 *
 * @author ASUS
 */
public class c_kriteria {

    kriteria Kriteria;
    tambahKriteria TambahKriteria;
    
    public c_kriteria(String view) {

        switch (view) {
            case "kriteria":
                Kriteria = new kriteria();
                Kriteria.getTambah().addActionListener(new btnListener("tambah"));
                Kriteria.getUbah().addActionListener(new btnListener("ubah"));
                Kriteria.getHapus().addActionListener(new btnListener("hapus"));
                Kriteria.getAlternatif().addActionListener(new btnListener("kriteria"));
                break;
            case "tambah kriteria":
                TambahKriteria = new tambahKriteria();
                TambahKriteria.getBatal().addActionListener(new btnListener("ubah"));
                TambahKriteria.getSimpan().addActionListener(new btnListener("simpan"));
                break;
            default:
                Kriteria = new kriteria();
        }
    }
    
    private class btnListener implements ActionListener {
        private String button;
        
        public btnListener(String btn) {
            button = btn;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (button) {
                case "tambah":
                    
                    break;
                case "ubah":
                    
                    break;
                    
                case "hapus":
                    
                    break;
                    
                case "alternatif":
                    
                    break;
                    
                case "batal":
                    
                    break;
                    
                case "simpan":
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Belum Diimplementasikan!");
            }
        }
    }

}
