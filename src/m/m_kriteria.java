/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import promethee.koneksi;

/**
 *
 * @author ASUS
 */
public class m_kriteria {

    Connection con;

    public m_kriteria() {
        con = new koneksi().con();
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public ArrayList<Kriteria> bacaKriteria() {
        ArrayList<Kriteria> data = new ArrayList<>();
        String query = "SELECT * FROM kriteria;";
        double totalBobot = 0.0;

        try {
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                totalBobot += rs.getDouble("bobot");
            }
            rs.beforeFirst();

            while (rs.next()) {
                int id = rs.getInt("id");
                String namaKriteria = rs.getString("namaKriteria");
                String minMaks = rs.getString("minmaks");
                double bobot1 = rs.getDouble("bobot") / totalBobot;
                double bobot = round(bobot1, 2);
                int tipePreferensi = rs.getInt("tipePreferensi");
                int parameterP = rs.getInt("parameterP");
                int parameterQ = rs.getInt("parameterQ");

                Kriteria perBaris = new Kriteria(id, namaKriteria, minMaks, bobot, tipePreferensi, parameterP, parameterQ);
                data.add(perBaris);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DefaultTableModel bacaTabel() {
        String kolom[] = {"Kriteria", "Min Maks", "Bobot", "Tipe Preferensi", "Parameter P", "Parameter Q"};
        DefaultTableModel model = new DefaultTableModel(null, kolom);
        String query = "SELECT * FROM alternatif;";
        double totalBobot = 0.0;

        try {
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                totalBobot += rs.getDouble("bobot");
            }
            rs.beforeFirst();

            while (rs.next()) {
                Object data[] = new Object[kolom.length];
                data[0] = rs.getString("namaKriteria");
                data[1] = rs.getString("minmaks");
                double bobot = rs.getDouble("bobot") / totalBobot;
                data[2] = round(bobot, 2);
                data[3] = rs.getInt("tipePreferensi");
                data[4] = rs.getInt("parameterP");
                data[5] = rs.getInt("parameterQ");

                model.addRow(data);
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean tambah(Kriteria k) {
        String query = "INSERT INTO alternatif(id, namaKriteria, minmaks, bobot, tipePreferensi, parameterA, parameterB) VALUES ('', ?, ?, ?, ?,?, ?, ?);";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, k.getNamaKriteria());
            st.setString(2, k.getMinMaks());
            st.setDouble(3, k.getBobot());
            st.setInt(4, k.getTipePreferensi());
            st.setInt(5, k.getParamP());
            st.setInt(6, k.getParamQ());

            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ubah(Kriteria k) {
        String query = "UPDATE alternatif SET namaKriteria=?, minmaks=?, bobot=?, tipePreferensi=?, parameterA=?, parameterB=? WHERE id=?;";

        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, k.getNamaKriteria());
            st.setString(2, k.getMinMaks());
            st.setDouble(3, k.getBobot());
            st.setInt(4, k.getTipePreferensi());
            st.setInt(5, k.getParamP());
            st.setInt(6, k.getParamQ());
            st.setInt(7, k.getID());

            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean hapus(int id) {
        String query = "DELETE FROM alternatif WHERE id=?;";

        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getJumlahKriteria() {
        try {
            PreparedStatement st = con.prepareStatement("SELECT COUNT(*) as jumlah FROM alternatif;");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("jumlah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
