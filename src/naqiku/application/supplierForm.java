/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naqiku.application;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Susa
 */
public class supplierForm extends javax.swing.JFrame {

    /**
     * Creates new form supplierForm
     */
    public supplierForm() {
        initComponents();
        Config.koneksi();
        tampilSupplier("");
    }


    private void tampilSupplier(String cari){
        DefaultTableModel model = (DefaultTableModel) tbl_supplier.getModel();
        model.setRowCount(0);
        try {
            String filter = "";

            
            
            if(!cari.equals("")){
                filter = " WHERE id_supplier LIKE '%"+cari+"%' OR nama_supplier LIKE '%"+cari+"%'";
            }            
            ResultSet row = Config.ambilData("SELECT * FROM supplier" + filter);
            while(row.next()){                
                Object data[] = new Object[]{
                    row.getString(1),
                    row.getString(2),
                    row.getString(3),
                    row.getString(4)
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error Ambil Data: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_barang = new javax.swing.JLabel();
        btn_supplier = new javax.swing.JLabel();
        btn_transaksi = new javax.swing.JLabel();
        btn_pengaturan = new javax.swing.JLabel();
        btn_datatoko = new javax.swing.JLabel();
        btn_logout = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_supplier = new rojeru_san.complementos.RSTableMetro();
        txt_cari = new javax.swing.JTextField();
        btn_refresh = new rojerusan.RSMaterialButtonRectangle();
        frameBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, 80));
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 200, 80));
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 90));
        getContentPane().add(btn_pengaturan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 200, 60));
        getContentPane().add(btn_datatoko, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 200, 70));
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, 70, 80));

        tbl_supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Supplier", "Nama Supplier", "Nomor HP", "Alamat"
            }
        ));
        tbl_supplier.setColorBackgoundHead(new java.awt.Color(232, 60, 60));
        tbl_supplier.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_supplier.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbl_supplier.setColorFilasBackgound1(new java.awt.Color(255, 71, 71));
        tbl_supplier.setColorFilasBackgound2(new java.awt.Color(255, 71, 71));
        tbl_supplier.setColorFilasForeground1(new java.awt.Color(255, 255, 255));
        tbl_supplier.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tbl_supplier.setGrosorBordeFilas(0);
        tbl_supplier.setGrosorBordeHead(0);
        tbl_supplier.setShowHorizontalLines(false);
        tbl_supplier.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tbl_supplier);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 1100, 580));

        txt_cari.setBorder(null);
        txt_cari.setOpaque(false);
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });
        getContentPane().add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 270, 30));

        btn_refresh.setBackground(new java.awt.Color(232, 60, 60));
        btn_refresh.setText("REFRESH");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 80, 40));

        frameBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/naqiku.frames/Tabel Supplier.png"))); // NOI18N
        getContentPane().add(frameBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
        // TODO add your handling code here:
        tampilSupplier(txt_cari.getText());
    }//GEN-LAST:event_txt_cariKeyPressed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        tampilSupplier(txt_cari.getText());

    }//GEN-LAST:event_txt_cariKeyReleased

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        txt_cari.setText("");
    }//GEN-LAST:event_btn_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(supplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplierForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_barang;
    private javax.swing.JLabel btn_datatoko;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_pengaturan;
    private rojerusan.RSMaterialButtonRectangle btn_refresh;
    private javax.swing.JLabel btn_supplier;
    private javax.swing.JLabel btn_transaksi;
    private javax.swing.JLabel frameBackground;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tbl_supplier;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
