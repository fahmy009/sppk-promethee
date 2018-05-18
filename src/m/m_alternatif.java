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
import javax.swing.table.DefaultTableModel;
import promethee.koneksi;

/**
 *
 * @author ASUS
 */
public class m_alternatif {

    Connection con;

    public m_alternatif() {
        con = new koneksi().con();
    }

    public DefaultTableModel bacaTabel() {
        String kolom[] = {"ID", "Nama Alternatif"};
        DefaultTableModel model = new DefaultTableModel(null, kolom);
        String query = "SELECT * FROM alternatif;";
        double totalBobot = 0.0;

        try {
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Object data[] = new Object[kolom.length];
                data[0] = rs.getString("id");
                data[1] = rs.getString("nama");
                model.addRow(data);
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean tambah(String nama) {
        String query = "INSERT INTO alternatif(id, nama) VALUES ('', ?);";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, nama);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ubah(String nama, int id) {
        String query = "UPDATE alternatif SET nama=? WHERE id=?;";

        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, nama);
            st.setInt(2, id);
            
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
}
