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
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import m.Kriteria;
import m.m_alternatif;
import m.m_kriteria;
import v.alternatif;
import v.tambahAlternatif;
import v.tambahNilaiKriteria;

/**
 *
 * @author ASUS
 */
public class c_alternatif {

    private alternatif Alternatif;
    private tambahAlternatif tambahAlternatif;
    private tambahNilaiKriteria tambahNilai;
    private m_alternatif model;
    private m_kriteria modelKrit;
    private int baris;
    private int urutan;

    public c_alternatif(String view) {
        model = new m_alternatif();
        if (view.equals("alternatif")) {
            Alternatif = new alternatif();
            Alternatif.getTambah().addActionListener(new btnListener("tambah"));
            Alternatif.getUbah().addActionListener(new btnListener("ubah"));
            Alternatif.getHapus().addActionListener(new btnListener("hapus"));
            Alternatif.getKriteria().addActionListener(new btnListener("kriteria"));
            Alternatif.getTbAlternatif().addMouseListener(new tabelListener());

            Alternatif.getUbah().setEnabled(false);
            Alternatif.getHapus().setEnabled(false);

            Alternatif.getTbAlternatif().setModel(model.bacaTabel());

            Alternatif.setVisible(true);
        } else if (view.equals("tambah_alternatif")) {
            tambahAlternatif = new tambahAlternatif();
            tambahAlternatif.getBatal().addActionListener(new btnListener("batal"));
            tambahAlternatif.getSimpan().addActionListener(new btnListener("simpan"));

            tambahAlternatif.setVisible(true);
        } else if (view.equals("tambah_nilai")) {
            urutan = 0;
            tambahNilai = new tambahNilaiKriteria();
            tambahNilai.getKonfirmasi().addActionListener(new btnListener("konfirmasi"));
            
            modelKrit = new m_kriteria();
            int jumlahKrit = modelKrit.getJumlahKriteria();
            ArrayList<Kriteria> kriteria = modelKrit.bacaKriteria();
            for (int i = 0; i < 10; i++) {
                
            }
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
                    new c_alternatif("tambah_alternatif");
                    Alternatif.dispose();
                    break;
                case "ubah":
                    JOptionPane.showMessageDialog(Alternatif, "belum diimplementasi");
                    break;
                case "hapus":
                    int pilihan = JOptionPane.showConfirmDialog(Alternatif, "Yakin Dihapus?", "Hapus", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (pilihan == JOptionPane.YES_OPTION) {
                        int id = Integer.valueOf(Alternatif.getTbAlternatif().getValueAt(baris, 0).toString());
                        if (model.hapus(id)) {
                            JOptionPane.showMessageDialog(Alternatif, "Berhasil");
                        } else {
                            JOptionPane.showMessageDialog(Alternatif, "Gagal", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else if (pilihan == JOptionPane.NO_OPTION) {
                        //ga ada
                    } else if (pilihan == JOptionPane.CANCEL_OPTION) {
                        //ga ada
                    }
                    Alternatif.getTbAlternatif().setModel(model.bacaTabel());
                    break;
                case "kriteria":
                    new c_kriteria("kriteria");
                    Alternatif.dispose();
                    break;
                case "batal":
                    new c_alternatif("alternatif");
                    tambahAlternatif.dispose();
                    break;
                case "simpan":
                    String nama = tambahAlternatif.getNama().getText();
                    int nilai = Integer.valueOf(tambahAlternatif.getNilai().getText());
                    if (model.tambah(nama, nilai)) {
                        JOptionPane.showMessageDialog(tambahAlternatif, "Berhasil");
                    } else {
                        JOptionPane.showMessageDialog(tambahAlternatif, "Gagal", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    new c_alternatif("alternatif");
                    tambahAlternatif.dispose();
                    break;
                case "konfirmasi":
                    urutan++;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Belum Diimplementasikan!");
            }
        }

    }

    private class tabelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            baris = Alternatif.getTbAlternatif().getSelectedRow();
            Alternatif.getUbah().setEnabled(true);
            Alternatif.getHapus().setEnabled(true);
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
