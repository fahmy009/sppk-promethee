/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author ASUS
 */
public class totalIP extends javax.swing.JFrame {

    /**
     * Creates new form totalIP
     */
    public totalIP() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    public JButton getAlternatif() {
        return alternatif;
    }

    public JButton getHasilAkhir() {
        return hasilAkhir;
    }

    public JButton getHasilPerhitungan() {
        return hasilPerhitungan;
    }

    public JTable getTbEnterLeave() {
        return tbEnterLeave;
    }

    public JTable getTbTotalIndeksPref() {
        return tbTotalIndeksPref;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbTotalIndeksPref = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbEnterLeave = new javax.swing.JTable();
        hasilPerhitungan = new javax.swing.JButton();
        hasilAkhir = new javax.swing.JButton();
        alternatif = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        tbTotalIndeksPref.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbTotalIndeksPref.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTotalIndeksPref.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbTotalIndeksPref);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 149, -1, 370));

        jScrollPane2.setBorder(null);

        tbEnterLeave.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbEnterLeave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEnterLeave.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(tbEnterLeave);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 149, 753, 370));

        hasilPerhitungan.setBorder(null);
        hasilPerhitungan.setBorderPainted(false);
        hasilPerhitungan.setContentAreaFilled(false);
        getContentPane().add(hasilPerhitungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 340, 50));

        hasilAkhir.setBorder(null);
        hasilAkhir.setBorderPainted(false);
        hasilAkhir.setContentAreaFilled(false);
        getContentPane().add(hasilAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 210, 60));

        alternatif.setBorder(null);
        alternatif.setBorderPainted(false);
        alternatif.setContentAreaFilled(false);
        getContentPane().add(alternatif, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 210, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/totalIP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(totalIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(totalIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(totalIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(totalIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new totalIP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alternatif;
    private javax.swing.JButton hasilAkhir;
    private javax.swing.JButton hasilPerhitungan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbEnterLeave;
    private javax.swing.JTable tbTotalIndeksPref;
    // End of variables declaration//GEN-END:variables
}
