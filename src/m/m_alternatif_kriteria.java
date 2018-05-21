/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import promethee.koneksi;

/**
 *
 * @author ASUS
 */
public class m_alternatif_kriteria {

    Connection con;

    public m_alternatif_kriteria() {
        con = new koneksi().con();
    }
    
    public ArrayList<AlternatifKriteria> bacaAlterKrit() {
        ArrayList<AlternatifKriteria> ak = new ArrayList<>();
        String query = "SELECT ak.id, ak.idAlternatif, ak.idKriteria, a.nama, k.namaKriteria, ak.nilai FROM alternatif_kriteria ak JOIN alternatif a ON ak.idAlternatif = a.id JOIN kriteria k ON ak.idKriteria = k.id;";
        
        try {
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idAlternatif = rs.getInt("idAlternatif");
                int idKriteria = rs.getInt("idKriteria");
                String namaAlternatif = rs.getString("nama");
                String namaKriteria = rs.getString("namaKriteria");
                int nilai = rs.getInt("nilai");
                AlternatifKriteria baris = new AlternatifKriteria(id, idAlternatif, idKriteria, namaAlternatif, namaKriteria, nilai);
                ak.add(baris);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        
        return ak;
    }

    public boolean tambah(int idKriteria, int idAlternatif, int nilai) {
        String query = "INSERT INTO alternatif_kriteria(idKriteria, idAlternatif, nilai) VALUES (?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, idKriteria);
            st.setInt(2, idAlternatif);
            st.setInt(3, nilai);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ubah() {
        String query = "UPDATE alternatif_kriteria WHERE id=?;";

        try {
            PreparedStatement st = con.prepareStatement(query);

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
        String query = "DELETE FROM alternatif_kriteria WHERE id=?;";

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

}
