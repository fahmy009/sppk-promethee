/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import m.Alternatif;
import m.AlternatifKriteria;
import m.Kriteria;
import m.m_alternatif;
import m.m_alternatif_kriteria;
import m.m_kriteria;
import v.hasilAkhir;
import v.hasilPerhitungan;
import v.totalIP;

/**
 *
 * @author ASUS
 */
public class perhitungan {

    private m_kriteria model_kriteria;
    private m_alternatif model_alternatif;
    private m_alternatif_kriteria model_alternatif_kriteria;

    private hasilPerhitungan perhitungan;
    private totalIP total;
    private hasilAkhir akhir;

    private DefaultTableModel tabelPerhitungan[];
    private DefaultTableModel tabelTotalIndeksPreferensi1;
    private DefaultTableModel tabelTotalIndeksPreferensi2;
    private DefaultTableModel tabelHasilAkhir;

    private int jumlahKriteria;
    private int indeksKriteria;

    ArrayList<Kriteria> kriteria;
    ArrayList<Alternatif> alternatif;
    ArrayList<AlternatifKriteria> alternatifKriteria;

    public perhitungan() {

        model_kriteria = new m_kriteria();
        model_alternatif = new m_alternatif();
        model_alternatif_kriteria = new m_alternatif_kriteria();

        perhitungan = new hasilPerhitungan();
        total = new totalIP();
        akhir = new hasilAkhir();

        jumlahKriteria = model_kriteria.getJumlahKriteria();
        tabelPerhitungan = new DefaultTableModel[jumlahKriteria];

        kriteria = model_kriteria.bacaKriteria();
        alternatif = model_alternatif.bacaAlternatif();
        alternatifKriteria = model_alternatif_kriteria.bacaAlterKrit();

        hitungPerKriteria();
        hitungTotalIndeksPreferensi();
        hitungAkhir();

        indeksKriteria = 0;
        perhitungan.setVisible(true);
        total.setVisible(false);
        akhir.setVisible(false);

        perhitungan.getAlternatif().addActionListener(new btnListener("alternatif"));
        perhitungan.getTotalIP().addActionListener(new btnListener("total_ip"));
        perhitungan.getNext().addActionListener(new btnListener("next"));
        perhitungan.getPrev().addActionListener(new btnListener("prev"));

        total.getAlternatif().addActionListener(new btnListener("alternatif"));
        total.getHasilAkhir().addActionListener(new btnListener("hasil_akhir"));
        total.getHasilPerhitungan().addActionListener(new btnListener("hasil_perhitungan"));

        akhir.getAlternatif().addActionListener(new btnListener("alternatif"));
        akhir.getKembali().addActionListener(new btnListener("total_ip"));

        perhitungan.getPrev().setEnabled(false);
        perhitungan.getNoKriteria().setText("" + (indeksKriteria + 1));
        perhitungan.getKriteria().setText(kriteria.get(indeksKriteria).getNamaKriteria());
        perhitungan.getTipeKriteria().setText("" + kriteria.get(indeksKriteria).getTipePreferensi());
        perhitungan.getTabelKriteria().setModel(tabelPerhitungan[indeksKriteria]);
    }

    private void hitungPerKriteria() {
        String namaKolom[] = {"A", "B", "Nilai A", "Nilai B", "Selisih(d)", "|d|", "P", "IP"};
        int i = 0;

        for (Kriteria perKriteria : kriteria) {

            tabelPerhitungan[i] = new DefaultTableModel(null, namaKolom);

            for (AlternatifKriteria a : alternatifKriteria) {
                for (AlternatifKriteria b : alternatifKriteria) {
                    if (a.getID() != b.getID()) {
                        if (a.getIDKriteria() == perKriteria.getID() && b.getIDKriteria() == perKriteria.getID()) {
                            int selisihAbsolut = Math.abs(a.getNilai() - b.getNilai());
                            int selisih = a.getNilai() - b.getNilai();

                            double P = tipePreferensi(perKriteria.getMinMaks(), perKriteria.getTipePreferensi(), perKriteria.getParamP(), perKriteria.getParamQ(), selisih, a.getNilai(), b.getNilai());

                            double IP = P * perKriteria.getBobot();
                            IP = round(IP, 2);
                            Object perBaris[] = {
                                a.getNamaAlternatif(),
                                b.getNamaAlternatif(),
                                a.getNilai(),
                                b.getNilai(),
                                selisih,
                                selisihAbsolut,
                                P,
                                IP
                            };
                            tabelPerhitungan[i].addRow(perBaris);
                        }
                    }
                }
            }
            i++;
        }
    }

    private void hitungTotalIndeksPreferensi() {
        String kolom1[] = {"A", "B", "Total Indeks Preferensi"};
        tabelTotalIndeksPreferensi1 = new DefaultTableModel(null, kolom1);
        double IP[] = new double[tabelPerhitungan[0].getRowCount()];

        for (int i = 0; i < tabelPerhitungan.length; i++) {
            for (int j = 0; j < tabelPerhitungan[i].getRowCount(); j++) {
                IP[j] += Double.valueOf(tabelPerhitungan[i].getValueAt(j, 7).toString());
            }
        }
        for (int i = 0; i < IP.length; i++) {
            Object perBaris[] = new Object[3];
            perBaris[0] = tabelPerhitungan[0].getValueAt(i, 0);
            perBaris[1] = tabelPerhitungan[0].getValueAt(i, 1);
            perBaris[2] = IP[i];
            tabelTotalIndeksPreferensi1.addRow(perBaris);
        }

        ArrayList<String> kolom = new ArrayList<>();
        kolom.add("Alternatif");
        for (Alternatif alternatif : alternatif) {
            String perKolom = alternatif.getNama();
            kolom.add(perKolom);
        }
        kolom.add("Jumlah");
        kolom.add("Leaving");
        tabelTotalIndeksPreferensi2 = new DefaultTableModel(null, kolom.toArray());

        for (int i = 0; i < alternatif.size(); i++) {
            Object perBaris[] = new Object[1 + alternatif.size() + 2];
            String namaBaris = alternatif.get(i).getNama();
            perBaris[0] = namaBaris;
            double jumlah = 0.0;
            for (int j = 0; j < alternatif.size(); j++) {
                String namaKolom = alternatif.get(j).getNama();
                for (int k = 0; k < tabelTotalIndeksPreferensi1.getRowCount(); k++) {
                    String a = tabelTotalIndeksPreferensi1.getValueAt(k, 0).toString();
                    String b = tabelTotalIndeksPreferensi1.getValueAt(k, 1).toString();
                    if (a.equalsIgnoreCase(namaBaris) && b.equalsIgnoreCase(namaKolom)) {
                        perBaris[j + 1] = tabelTotalIndeksPreferensi1.getValueAt(k, 2).toString();
                        jumlah += Double.valueOf(tabelTotalIndeksPreferensi1.getValueAt(k, 2).toString());
                    } else if (namaBaris.equalsIgnoreCase(namaKolom)) {
                        perBaris[j + 1] = 0;
                    }
                }
                perBaris[alternatif.size() + 1] = jumlah;
                perBaris[alternatif.size() + 2] = jumlah / (alternatif.size() - 1);
            }
            tabelTotalIndeksPreferensi2.addRow(perBaris);
        }

        /**
         * menghitung jumlah dan entering flow
         */
        Object barisJumlah[] = new Object[1 + alternatif.size() + 2];
        Object barisEnteringFlow[] = new Object[1 + alternatif.size() + 2];

        barisJumlah[0] = "jumlah";
        double jumlah2[] = new double[alternatif.size()];
        for (int i = 0; i < tabelTotalIndeksPreferensi2.getRowCount(); i++) {
            for (int j = 0; j < alternatif.size(); j++) {
                jumlah2[j] += Double.valueOf(tabelTotalIndeksPreferensi2.getValueAt(i, j + 1).toString());
            }
        }
        for (int i = 0; i < alternatif.size(); i++) {
            barisJumlah[i + 1] = jumlah2[i];
            double entering = jumlah2[i] / (alternatif.size() - 1);
            barisEnteringFlow[i + 1] = entering;
        }
        tabelTotalIndeksPreferensi2.addRow(barisJumlah);
        tabelTotalIndeksPreferensi2.addRow(barisEnteringFlow);
    }

    private void hitungAkhir() {
        String namaKolom[] = {"Alternatif", "Leaving Flow", "Entering Flow", "Net Flow", "Urutan"};
        tabelHasilAkhir = new DefaultTableModel(null, namaKolom);
        double leavingFlow[] = new double[alternatif.size()];
        double enteringFlow[] = new double[alternatif.size()];
        double netFlow[] = new double[alternatif.size()];
        String urutan[] = new String[alternatif.size()];
        for (int i = 0; i < alternatif.size(); i++) {
            leavingFlow[i] = Double.valueOf(tabelTotalIndeksPreferensi2.getValueAt(i, alternatif.size() + 2).toString());
            enteringFlow[i] = Double.valueOf(tabelTotalIndeksPreferensi2.getValueAt(alternatif.size() + 1, i + 1).toString());
            netFlow[i] = leavingFlow[i] - enteringFlow[i];
        }

        /**
         * mengurutkan
         */
        double netFlow2[] = netFlow;
        for (int i = 0; i < netFlow2.length; i++) {
            for (int j = 1; j < netFlow2.length - 1; j++) {
                if (netFlow2[j - 1] < netFlow2[j]) {
                    double temp = netFlow2[j - 1];
                    netFlow2[j - 1] = netFlow2[j];
                    netFlow2[j] = temp;
                }
            }
        }
        /**
         * memasukan urutan
         */
        for (int i = 0; i < netFlow.length; i++) {
            for (int j = 0; j < netFlow.length; j++) {
                if (netFlow[i] == netFlow2[j]) {
                    urutan[i] = "" + (j + 1);
                }
            }
        }

        for (int i = 0; i < alternatif.size(); i++) {
            Object perBaris[] = new Object[5];
            perBaris[0] = alternatif.get(i).getNama();
            perBaris[1] = leavingFlow[i];
            perBaris[2] = enteringFlow[i];
            perBaris[3] = netFlow[i];
            perBaris[4] = urutan[i];
            tabelHasilAkhir.addRow(perBaris);
        }
    }

    private double tipePreferensi(String minmaks, int tipe, int p, int q, int selisih, int a, int b) {
        double hasil = 0.0;
        if (minmaks.equalsIgnoreCase("minimasi")) {
            if (a < b) {
                //lanjut ke pengecekan tipe
            } else if (a >= b) {
                return 0.0;
            }
        } else if (minmaks.equalsIgnoreCase("maksimasi")) {
            if (a > b) {
                //lanjut ke pengecekan tipe
            } else if (a <= b) {
                return 0.0;
            }
        }
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

    /**
     * method untuk menjadikan nilai double menjadi 2 desimal di belakang koma
     * 
     */
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private class btnListener implements ActionListener {

        String btn;

        public btnListener(String btn) {
            this.btn = btn;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (btn) {
                case "alternatif":
                    new c_alternatif("alternatif");
                    perhitungan.dispose();
                    total.dispose();
                    akhir.dispose();
                    break;
                case "total_ip":
                    perhitungan.setVisible(false);
                    total.setVisible(true);
                    total.getTbTotalIndeksPref().setModel(tabelTotalIndeksPreferensi1);
                    total.getTbEnterLeave().setModel(tabelTotalIndeksPreferensi2);
                    break;
                case "next":
                    next();
                    break;
                case "prev":
                    prev();
                    break;
                case "hasil_perhitungan":
                    perhitungan.setVisible(true);
                    total.setVisible(false);
                    akhir.setVisible(false);
                    break;
                case "hasil_akhir":
                    perhitungan.setVisible(false);
                    total.setVisible(false);
                    akhir.setVisible(true);
                    akhir.getTbAkhir().setModel(tabelHasilAkhir);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Belum Diimplementasikan!");
            }
        }

    }

    public void next() {
        indeksKriteria++;
        if (indeksKriteria == 0) {
            perhitungan.getPrev().setEnabled(false);
            indeksKriteria = 0;
        }
        if (indeksKriteria > 0 && indeksKriteria < jumlahKriteria) {
            perhitungan.getPrev().setEnabled(true);
        }
        if (indeksKriteria == jumlahKriteria - 1) {
            perhitungan.getNext().setEnabled(false);
            indeksKriteria = jumlahKriteria - 1;
        }
        if (indeksKriteria > 0 && indeksKriteria < jumlahKriteria -1) {
            perhitungan.getNext().setEnabled(true);
        }
        perhitungan.getNoKriteria().setText("" + (indeksKriteria + 1));
        perhitungan.getKriteria().setText(kriteria.get(indeksKriteria).getNamaKriteria());
        perhitungan.getTipeKriteria().setText("" + kriteria.get(indeksKriteria).getTipePreferensi());
        perhitungan.getTabelKriteria().setModel(tabelPerhitungan[indeksKriteria]);
    }

    public void prev() {
        indeksKriteria--;
        if (indeksKriteria == 0) {
            perhitungan.getPrev().setEnabled(false);
            indeksKriteria = 0;
        }
        if (indeksKriteria > 0 && indeksKriteria < jumlahKriteria) {
            perhitungan.getPrev().setEnabled(true);
        }
        if (indeksKriteria == jumlahKriteria - 1) {
            perhitungan.getNext().setEnabled(false);
            indeksKriteria = jumlahKriteria - 1;
        }
        if (indeksKriteria > 0 && indeksKriteria < jumlahKriteria - 1) {
            perhitungan.getNext().setEnabled(true);
        }
        perhitungan.getNoKriteria().setText("" + (indeksKriteria + 1));
        perhitungan.getKriteria().setText(kriteria.get(indeksKriteria).getNamaKriteria());
        perhitungan.getTipeKriteria().setText("" + kriteria.get(indeksKriteria).getTipePreferensi());
        perhitungan.getTabelKriteria().setModel(tabelPerhitungan[indeksKriteria]);
    }
}
