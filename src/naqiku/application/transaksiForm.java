/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naqiku.application;

import java.awt.Color;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import naqiku.components.EventSwitchSelected;

/**
 *
 * @author Susa
 */
public class transaksiForm extends javax.swing.JFrame {

    /**
     * Creates new form transaksiPenjualan
     */
    
    public transaksiForm() {
        initComponents();
        switchButton1.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean selected) {
                if (selected) {
                    label_frame.setText("PENJUALAN");
                } else {
                    label_frame.setText("PEMBELIAN");
                }
            }
        });
        Config.koneksi();
        tampilTransaksi();
        tampilBarang("");
    }
    
    private void tampilTransaksi(){
        DefaultTableModel model = (DefaultTableModel) tbl_transaksi.getModel();
        model.setRowCount(0);
        try {
            ResultSet row = Config.ambilData("SELECT nama_barang, warna_barang, harga_jual, qty, harga_jual*qty AS total FROM transaksi_penjualan JOIN barang ON transaksi_penjualan.kd_barang = barang.kd_barang;");
            int baris = 0;
            while(row.next()){               
                baris++;
                Object data[] = new Object[]{
                    row.getString(1),
                    row.getString(2),
                    row.getString(3),
                    row.getString(4),
                    row.getString(5)
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            if (e.getMessage().equals("null")) {
                
            }
            System.out.println("Error : " + e.getMessage());
        }
        tampilTotal();
    }
    private void tampilTotal(){
        try {
            ResultSet row = Config.ambilData("SELECT SUM(qty*harga_jual) FROM transaksi_penjualan JOIN barang ON barang.kd_barang = transaksi_penjualan.kd_barang;");
            row.next();
//            txt_total.setText(row.getString(1));
            String Bayar = row.getString(1).replaceAll("\\,", "");
            double dblBayar = Double.parseDouble(Bayar);
            DecimalFormat df = new DecimalFormat("#,###,##0");
            if (dblBayar>999){
                txt_total.setText("Rp. " + df.format(dblBayar));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    private void tampilBarang(String cari){
        DefaultTableModel model = (DefaultTableModel) tbl_barang.getModel();
        model.setRowCount(0);
        try {
            String filter = "";
            if(!cari.equals("")){
                filter = " WHERE nama_barang LIKE '%"+cari+"%' OR warna_barang LIKE '%"+cari+"%'";
            }
            ResultSet row = Config.ambilData("SELECT kd_barang, nama_barang, warna_barang, harga_jual FROM barang " + filter);
            while(row.next()){                
                Object data[] = new Object[]{
                    row.getString(1),
                    row.getString(2),
                    row.getString(3)
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_cari = new javax.swing.JTextField();
        btn_pay = new javax.swing.JLabel();
        btn_edit = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JLabel();
        txt_total = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JLabel();
        btn_transaksi = new javax.swing.JLabel();
        btn_pengaturan = new javax.swing.JLabel();
        btn_barang = new javax.swing.JLabel();
        btn_supplier = new javax.swing.JLabel();
        btn_datatoko = new javax.swing.JLabel();
        btn_logout = new javax.swing.JLabel();
        label_frame = new javax.swing.JLabel();
        switchButton1 = new naqiku.components.SwitchButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_barang = new rojeru_san.complementos.RSTableMetro();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_transaksi = new rojeru_san.complementos.RSTableMetro();
        frameBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cari.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_cari.setBorder(null);
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });
        getContentPane().add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 100, 310, 20));
        getContentPane().add(btn_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 290, 90));
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 690, 140, 60));
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 690, 140, 60));

        txt_total.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        txt_total.setForeground(new java.awt.Color(255, 255, 255));
        txt_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_total.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 380, 80));

        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 660, 370, 40));
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 90));
        getContentPane().add(btn_pengaturan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 200, 60));
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, 80));
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 200, 80));
        getContentPane().add(btn_datatoko, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 200, 70));
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, 70, 80));

        label_frame.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label_frame.setForeground(new java.awt.Color(255, 255, 255));
        label_frame.setText("PENJUALAN");
        getContentPane().add(label_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 410, 70));
        getContentPane().add(switchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 70, 40));

        tbl_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Warna", "Harga"
            }
        ));
        tbl_barang.setColorBackgoundHead(new java.awt.Color(232, 60, 60));
        tbl_barang.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_barang.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbl_barang.setColorFilasBackgound1(new java.awt.Color(255, 71, 71));
        tbl_barang.setColorFilasBackgound2(new java.awt.Color(255, 71, 71));
        tbl_barang.setColorFilasForeground1(new java.awt.Color(255, 255, 255));
        tbl_barang.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tbl_barang.setFuenteFilas(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbl_barang.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbl_barang.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbl_barang.setGrosorBordeFilas(0);
        tbl_barang.setGrosorBordeHead(0);
        tbl_barang.setShowHorizontalLines(false);
        tbl_barang.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tbl_barang);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 160, 340, 480));

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Barang", "Warna", "Harga", "QTY", "Sub Total"
            }
        ));
        tbl_transaksi.setColorBackgoundHead(new java.awt.Color(232, 60, 60));
        tbl_transaksi.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_transaksi.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbl_transaksi.setColorFilasBackgound1(new java.awt.Color(255, 71, 71));
        tbl_transaksi.setColorFilasBackgound2(new java.awt.Color(255, 71, 71));
        tbl_transaksi.setColorFilasForeground1(new java.awt.Color(255, 255, 255));
        tbl_transaksi.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tbl_transaksi.setGrosorBordeFilas(0);
        tbl_transaksi.setGrosorBordeHead(0);
        tbl_transaksi.setShowHorizontalLines(false);
        tbl_transaksi.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tbl_transaksi);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 680, 470));

        frameBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/naqiku.frames/Transaksi Penjualan.png"))); // NOI18N
        getContentPane().add(frameBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
        tampilBarang(txt_cari.getText());
    }//GEN-LAST:event_txt_cariKeyPressed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        // TODO add your handling code here:
        tampilBarang(txt_cari.getText());

    }//GEN-LAST:event_txt_cariKeyReleased
public static String kd_barang;
    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        int tableRow = tbl_barang.getSelectedRow();
         kd_barang = tbl_barang.getValueAt(tableRow, 0).toString();
        new naqiku.applicationPopups.popupTransaksi().setVisible(true);
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        tampilTransaksi();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(transaksiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksiForm().setVisible(true);
            }

        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_barang;
    private javax.swing.JLabel btn_datatoko;
    private javax.swing.JLabel btn_edit;
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_pay;
    private javax.swing.JLabel btn_pengaturan;
    private javax.swing.JLabel btn_supplier;
    private javax.swing.JLabel btn_tambah;
    private javax.swing.JLabel btn_transaksi;
    private javax.swing.JLabel frameBackground;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_frame;
    private naqiku.components.SwitchButton switchButton1;
    private rojeru_san.complementos.RSTableMetro tbl_barang;
    private rojeru_san.complementos.RSTableMetro tbl_transaksi;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JLabel txt_total;
    // End of variables declaration//GEN-END:variables
}
