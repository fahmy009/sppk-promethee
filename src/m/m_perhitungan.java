/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhammad Fahmy
 */
public class m_perhitungan {

    public koneksi2 kon;

    public m_perhitungan() throws SQLException {
        this.kon = new koneksi2("root", "", "prom");
    }

    public void save(String query) throws SQLException {
        String queries = "INSERT INTO perhitungan VALUES(" + query + ")";
        kon.execute(queries);
    }

    public DefaultTableModel getTable() throws SQLException {
        String header[] = {"Nama Alternatif", "Leaving Flow", "Entering Flow", "Net Flow", "Ranking"};
        DefaultTableModel tabelModel = new DefaultTableModel(null, header);
        kon.execute("SET@rank=0;");
        ResultSet rs = kon.getResult("SELECT nama_alternatif, leaving_flow, entering_flow, net_flow, @rank:=@rank+1 FROM perhitungan ORDER BY net_flow DESC");
        for (int i = tabelModel.getRowCount() - 1; i >= 0; i--) {
            tabelModel.removeRow(i);
        }
        while (rs.next()) {
            String kolom[] = new String[5];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

            tabelModel.addRow(kolom);
        }
        return tabelModel;
    }

}
