/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import v.alternatif;
import v.tambahAlternatif;

/**
 *
 * @author ASUS
 */
public class c_alternatif {

    alternatif Alternatif;
    tambahAlternatif tambahAlternatif;

    public c_alternatif(String view) {

        switch (view) {
            case "alternatif":
                Alternatif = new alternatif();
                Alternatif.getTambah().addActionListener(new btnListener("tambah"));
                Alternatif.getUbah().addActionListener(new btnListener("ubah"));
                Alternatif.getHapus().addActionListener(new btnListener("hapus"));
                Alternatif.getKriteria().addActionListener(new btnListener("kriteria"));
                break;
            case "tambah alternatif":
                tambahAlternatif = new tambahAlternatif();
                tambahAlternatif.getBatal().addActionListener(new btnListener("ubah"));
                tambahAlternatif.getSimpan().addActionListener(new btnListener("simpan"));
                break;
            default:

                break;
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

                case "kriteria":

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
