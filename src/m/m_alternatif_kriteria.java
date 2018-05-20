/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import promethee.koneksi;

/**
 *
 * @author ASUS
 */
public class m_alternatif_kriteria {

    Connection con;

    public m_alternatif_kriteria() {
        new koneksi().con();
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
