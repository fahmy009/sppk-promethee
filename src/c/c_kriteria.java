/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import m.Kriteria;
import m.m_kriteria;
import v.kriteria;
import v.tambahKriteria;

/**
 *
 * @author ASUS
 */
public class c_kriteria {

    private kriteria Kriteria;
    private tambahKriteria TambahKriteria;
    private m_kriteria model;
    private int baris;

    public c_kriteria(String view) {
        model = new m_kriteria();
        if (view.equals("kriteria")) {
            Kriteria = new kriteria();
            Kriteria.getTambah().addActionListener(new btnListener("tambah"));
            Kriteria.getHapus().addActionListener(new btnListener("hapus"));
            Kriteria.getAlternatif().addActionListener(new btnListener("alternatif"));
            Kriteria.getPerhitungan().addActionListener(new btnListener("perhitungan"));
            Kriteria.getTbKriteria().addMouseListener(new tabelListener());

            Kriteria.getHapus().setEnabled(false);

            Kriteria.getTbKriteria().setModel(model.bacaTabel());

            Kriteria.setVisible(true);
        } else if (view.equals("tambah_kriteria")) {
            TambahKriteria = new tambahKriteria();
            TambahKriteria.getTipePref().addActionListener(new btnListener("tipePref"));
            TambahKriteria.getBatal().addActionListener(new btnListener("batal"));
            TambahKriteria.getSimpan().addActionListener(new btnListener("simpan"));

            TambahKriteria.setVisible(true);
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
                case "perhitungan":
                    new perhitungan();
                    Kriteria.dispose();
                    break;
                case "tambah":
                    new c_kriteria("tambah_kriteria");
                    Kriteria.dispose();
                    break;
                case "ubah":
                    JOptionPane.showMessageDialog(Kriteria, "belum diimplementasi");
                    break;
                case "hapus":
                    int pilihan = JOptionPane.showConfirmDialog(Kriteria, "Yakin Dihapus?", "Hapus", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (pilihan == JOptionPane.YES_OPTION) {
                        int id = Integer.valueOf(Kriteria.getTbKriteria().getValueAt(baris, 0).toString());
                        if (model.hapus(id)) {
                            JOptionPane.showMessageDialog(Kriteria, "Berhasil");
                        } else {
                            JOptionPane.showMessageDialog(Kriteria, "Gagal", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        Kriteria.getHapus().setEnabled(false);
                    } else if (pilihan == JOptionPane.NO_OPTION) {
                        //ga ada
                    } else if (pilihan == JOptionPane.CANCEL_OPTION) {
                        //ga ada
                    }
                    Kriteria.getTbKriteria().setModel(model.bacaTabel());
                    break;

                case "alternatif":
                    new c_alternatif("alternatif");
                    Kriteria.dispose();
                    break;

                case "batal":
                    new c_kriteria("kriteria");
                    TambahKriteria.dispose();
                    break;

                case "simpan":
                    String nama = TambahKriteria.getNamaKriteria().getText();
                    int bobot = TambahKriteria.getBobot().getSelectedIndex() + 1;
                    String minmaks = TambahKriteria.getMinmaks().getSelectedItem().toString();
                    int tipePref = TambahKriteria.getTipePref().getSelectedIndex() + 1;
                    String P = TambahKriteria.getParameterP().getText();
                    String Q = TambahKriteria.getParameterQ().getText();
                    if (P.equalsIgnoreCase("")) {
                        P = "0";
                    }
                    if (Q.equalsIgnoreCase("")) {
                        Q = "0";
                    }
                    int paramP = Integer.valueOf(P);
                    int paramQ = Integer.valueOf(Q);
                    Kriteria k = new Kriteria(0, nama, minmaks, bobot, tipePref, paramP, paramQ);
                    if (model.tambah(k)) {
                        JOptionPane.showMessageDialog(TambahKriteria, "Berhasil");
                    } else {
                        JOptionPane.showMessageDialog(TambahKriteria, "Gagal", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    new c_kriteria("kriteria");
                    TambahKriteria.dispose();
                    break;

                case "tipePref":
                    int tipe = TambahKriteria.getTipePref().getSelectedIndex();
                    if (tipe == 1) {
                        TambahKriteria.getParameterP().setEnabled(false);
                        TambahKriteria.getParameterQ().setEnabled(false);
                    } else if (tipe == 2) {
                        TambahKriteria.getParameterP().setEnabled(false);
                        TambahKriteria.getParameterQ().setEnabled(true);
                    } else if (tipe == 3) {
                        TambahKriteria.getParameterP().setEnabled(true);
                        TambahKriteria.getParameterQ().setEnabled(false);
                    } else if (tipe == 4) {
                        TambahKriteria.getParameterP().setEnabled(true);
                        TambahKriteria.getParameterQ().setEnabled(true);
                    } else if (tipe == 5) {
                        TambahKriteria.getParameterP().setEnabled(true);
                        TambahKriteria.getParameterQ().setEnabled(true);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Belum Diimplementasikan!");
            }
        }
    }

    private class tabelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            baris = Kriteria.getTbKriteria().getSelectedRow();
            Kriteria.getHapus().setEnabled(true);
        }

        //<editor-fold defaultstate="collapsed" desc="tidak digunakan">
        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
        //</editor-fold>

    }

}
