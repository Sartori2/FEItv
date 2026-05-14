package com.mycompany.feitv.view;

import com.mycompany.feitv.controller.ControleHome;
import com.mycompany.feitv.model.Usuario;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class Home extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Home.class.getName());

    /**
     * Creates new form Home
     */
    
    private ControleHome c;
    private Usuario usuarioLogado;
    
    public Home(Usuario usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        c = new ControleHome(this, usuarioLogado);
        c.carregarVideos();
        adicionarCliquePainel(pnVideo1, 0);
        adicionarCliquePainel(pnVideo2, 1);
        adicionarCliquePainel(pnVideo3, 2);
        adicionarCliquePainel(pnVideo4, 3);
        adicionarCliquePainel(pnVideo5, 4);
        adicionarCliquePainel(pnVideo6, 5);
    }

    public JButton getBtnFavoritos() {
        return btnFavoritos;
    }

    public void setBtnFavoritos(JButton btnFavoritos) {
        this.btnFavoritos = btnFavoritos;
    }

    public JButton getBtnPesquisar() {
        return btnPesquisar;
    }

    public void setBtnPesquisar(JButton btnPesquisar) {
        this.btnPesquisar = btnPesquisar;
    }

    public JLabel getLblCanal1() {
        return lblCanal1;
    }

    public void setLblCanal1(JLabel lblTempo1) {
        this.lblCanal1 = lblCanal1;
    }

    public JLabel getLblCanal2() {
        return lblCanal2;
    }

    public void setLblCanal2(JLabel lblTempo2) {
        this.lblCanal2 = lblCanal2;
    }

    public JLabel getLblCanal3() {
        return lblCanal3;
    }

    public void setLblCanal3(JLabel lblTempo3) {
        this.lblCanal3 = lblCanal3;
    }

    public JLabel getLblCanal4() {
        return lblCanal4;
    }

    public void setLblCanal4(JLabel lblCanal4) {
        this.lblCanal4 = lblCanal4;
    }

    public JLabel getLblCanal5() {
        return lblCanal5;
    }

    public void setLblCanal5(JLabel lblCanal5) {
        this.lblCanal5 = lblCanal5;
    }

    public JLabel getLblCanal6() {
        return lblCanal6;
    }

    public void setLblCanal6(JLabel lblCanal6) {
        this.lblCanal6 = lblCanal6;
    }

    public JLabel getLblTitulo1() {
        return lblTitulo1;
    }

    public void setLblTitulo1(JLabel lblTitulo1) {
        this.lblTitulo1 = lblTitulo1;
    }

    public JLabel getLblTitulo2() {
        return lblTitulo2;
    }

    public void setLblTitulo2(JLabel lblTitulo2) {
        this.lblTitulo2 = lblTitulo2;
    }

    public JLabel getLblTitulo3() {
        return lblTitulo3;
    }

    public void setLblTitulo3(JLabel lblTitulo3) {
        this.lblTitulo3 = lblTitulo3;
    }

    public JLabel getLblTitulo4() {
        return lblTitulo4;
    }

    public void setLblTitulo4(JLabel lblTitulo4) {
        this.lblTitulo4 = lblTitulo4;
    }

    public JLabel getLblTitulo5() {
        return lblTitulo5;
    }

    public void setLblTitulo5(JLabel lblTitulo5) {
        this.lblTitulo5 = lblTitulo5;
    }

    public JLabel getLblTitulo6() {
        return lblTitulo6;
    }

    public void setLblTitulo6(JLabel lblTitulo6) {
        this.lblTitulo6 = lblTitulo6;
    }

    public JPanel getPnVideo1() {
        return pnVideo1;
    }

    public void setPnVideo1(JPanel pnVideo1) {
        this.pnVideo1 = pnVideo1;
    }

    public JPanel getPnVideo2() {
        return pnVideo2;
    }

    public void setPnVideo2(JPanel pnVideo2) {
        this.pnVideo2 = pnVideo2;
    }

    public JPanel getPnVideo3() {
        return pnVideo3;
    }

    public void setPnVideo3(JPanel pnVideo3) {
        this.pnVideo3 = pnVideo3;
    }

    public JPanel getPnVideo4() {
        return pnVideo4;
    }

    public void setPnVideo4(JPanel pnVideo4) {
        this.pnVideo4 = pnVideo4;
    }

    public JPanel getPnVideo5() {
        return pnVideo5;
    }

    public void setPnVideo5(JPanel pnVideo5) {
        this.pnVideo5 = pnVideo5;
    }

    public JPanel getPnVideo6() {
        return pnVideo6;
    }

    public void setPnVideo6(JPanel pnVideo6) {
        this.pnVideo6 = pnVideo6;
    }

    public JTextField getTxtBusca() {
        return txtBusca;
    }

    public void setTxtBusca(JTextField txtBusca) {
        this.txtBusca = txtBusca;
    }

    public JLabel getLblThumb1() {
        return lblThumb1;
    }

    public void setLblThumb1(JLabel lblThumb1) {
        this.lblThumb1 = lblThumb1;
    }

    public JLabel getLblThumb2() {
        return lblThumb2;
    }

    public void setLblThumb2(JLabel lblThumb2) {
        this.lblThumb2 = lblThumb2;
    }

    public JLabel getLblThumb3() {
        return lblThumb3;
    }

    public void setLblThumb3(JLabel lblThumb3) {
        this.lblThumb3 = lblThumb3;
    }

    public JLabel getLblThumb4() {
        return lblThumb4;
    }

    public void setLblThumb4(JLabel lblThumb4) {
        this.lblThumb4 = lblThumb4;
    }

    public JLabel getLblThumb5() {
        return lblThumb5;
    }

    public void setLblThumb5(JLabel lblThumb5) {
        this.lblThumb5 = lblThumb5;
    }

    public JLabel getLblThumb6() {
        return lblThumb6;
    }

    public void setLblThumb6(JLabel lblThumb6) {
        this.lblThumb6 = lblThumb6;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnFavoritos = new javax.swing.JButton();
        pnVideo1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblCanal1 = new javax.swing.JLabel();
        lblThumb1 = new javax.swing.JLabel();
        pnVideo4 = new javax.swing.JPanel();
        lblTitulo4 = new javax.swing.JLabel();
        lblCanal4 = new javax.swing.JLabel();
        lblThumb4 = new javax.swing.JLabel();
        pnVideo5 = new javax.swing.JPanel();
        lblTitulo6 = new javax.swing.JLabel();
        lblCanal6 = new javax.swing.JLabel();
        lblThumb6 = new javax.swing.JLabel();
        pnVideo6 = new javax.swing.JPanel();
        lblTitulo5 = new javax.swing.JLabel();
        lblCanal5 = new javax.swing.JLabel();
        lblThumb5 = new javax.swing.JLabel();
        pnVideo2 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        lblCanal2 = new javax.swing.JLabel();
        lblThumb2 = new javax.swing.JLabel();
        pnVideo3 = new javax.swing.JPanel();
        lblTitulo3 = new javax.swing.JLabel();
        lblCanal3 = new javax.swing.JLabel();
        lblThumb3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(this::btnPesquisarActionPerformed);

        btnFavoritos.setText("Favoritos");

        pnVideo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTitulo1.setText("Titulo");

        lblCanal1.setText("Canal");

        javax.swing.GroupLayout pnVideo1Layout = new javax.swing.GroupLayout(pnVideo1);
        pnVideo1.setLayout(pnVideo1Layout);
        pnVideo1Layout.setHorizontalGroup(
            pnVideo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVideo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVideo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThumb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnVideo1Layout.createSequentialGroup()
                        .addGroup(pnVideo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCanal1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitulo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnVideo1Layout.setVerticalGroup(
            pnVideo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnVideo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThumb1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCanal1)
                .addContainerGap())
        );

        pnVideo4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnVideo4.setPreferredSize(new java.awt.Dimension(165, 170));

        lblTitulo4.setText("Titulo");

        lblCanal4.setText("Canal");

        javax.swing.GroupLayout pnVideo4Layout = new javax.swing.GroupLayout(pnVideo4);
        pnVideo4.setLayout(pnVideo4Layout);
        pnVideo4Layout.setHorizontalGroup(
            pnVideo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVideo4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVideo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThumb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addGroup(pnVideo4Layout.createSequentialGroup()
                        .addComponent(lblCanal4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnVideo4Layout.setVerticalGroup(
            pnVideo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnVideo4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThumb4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(lblTitulo4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCanal4)
                .addContainerGap())
        );

        pnVideo5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnVideo5.setPreferredSize(new java.awt.Dimension(165, 170));

        lblTitulo6.setText("Titulo");

        lblCanal6.setText("Canal");

        javax.swing.GroupLayout pnVideo5Layout = new javax.swing.GroupLayout(pnVideo5);
        pnVideo5.setLayout(pnVideo5Layout);
        pnVideo5Layout.setHorizontalGroup(
            pnVideo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVideo5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVideo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThumb6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnVideo5Layout.createSequentialGroup()
                        .addGroup(pnVideo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCanal6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitulo6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnVideo5Layout.setVerticalGroup(
            pnVideo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnVideo5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThumb6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(lblTitulo6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCanal6)
                .addContainerGap())
        );

        pnVideo6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnVideo6.setPreferredSize(new java.awt.Dimension(165, 170));

        lblTitulo5.setText("Titulo");

        lblCanal5.setText("Canal");

        javax.swing.GroupLayout pnVideo6Layout = new javax.swing.GroupLayout(pnVideo6);
        pnVideo6.setLayout(pnVideo6Layout);
        pnVideo6Layout.setHorizontalGroup(
            pnVideo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVideo6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVideo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThumb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addGroup(pnVideo6Layout.createSequentialGroup()
                        .addComponent(lblCanal5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnVideo6Layout.setVerticalGroup(
            pnVideo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVideo6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThumb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(lblTitulo5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCanal5)
                .addContainerGap())
        );

        pnVideo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnVideo2.setPreferredSize(new java.awt.Dimension(165, 170));

        lblTitulo2.setText("Titulo");

        lblCanal2.setText("Canal");

        javax.swing.GroupLayout pnVideo2Layout = new javax.swing.GroupLayout(pnVideo2);
        pnVideo2.setLayout(pnVideo2Layout);
        pnVideo2Layout.setHorizontalGroup(
            pnVideo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVideo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVideo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThumb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnVideo2Layout.createSequentialGroup()
                        .addGroup(pnVideo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCanal2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnVideo2Layout.setVerticalGroup(
            pnVideo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnVideo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThumb2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblTitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCanal2)
                .addContainerGap())
        );

        pnVideo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnVideo3.setPreferredSize(new java.awt.Dimension(165, 170));

        lblTitulo3.setText("Titulo");

        lblCanal3.setText("Canal");

        javax.swing.GroupLayout pnVideo3Layout = new javax.swing.GroupLayout(pnVideo3);
        pnVideo3.setLayout(pnVideo3Layout);
        pnVideo3Layout.setHorizontalGroup(
            pnVideo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVideo3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVideo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThumb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnVideo3Layout.createSequentialGroup()
                        .addGroup(pnVideo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCanal3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnVideo3Layout.setVerticalGroup(
            pnVideo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnVideo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThumb3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCanal3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnFavoritos)
                        .addGap(102, 102, 102)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnVideo4, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addGap(62, 62, 62)
                                .addComponent(pnVideo6, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addGap(48, 48, 48)
                                .addComponent(pnVideo5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnVideo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(pnVideo2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addGap(48, 48, 48)
                                .addComponent(pnVideo3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnVideo2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(pnVideo3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(pnVideo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnVideo4, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(pnVideo6, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(pnVideo5, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        c.buscarVideo();
    }//GEN-LAST:event_btnPesquisarActionPerformed
    
    private void adicionarCliquePainel(javax.swing.JPanel painel, int posicao) {
        painel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c.abrirVideo(posicao);
            }
        });
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new Home(usuarioLogado).setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFavoritos;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel lblCanal1;
    private javax.swing.JLabel lblCanal2;
    private javax.swing.JLabel lblCanal3;
    private javax.swing.JLabel lblCanal4;
    private javax.swing.JLabel lblCanal5;
    private javax.swing.JLabel lblCanal6;
    private javax.swing.JLabel lblThumb1;
    private javax.swing.JLabel lblThumb2;
    private javax.swing.JLabel lblThumb3;
    private javax.swing.JLabel lblThumb4;
    private javax.swing.JLabel lblThumb5;
    private javax.swing.JLabel lblThumb6;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JPanel pnVideo1;
    private javax.swing.JPanel pnVideo2;
    private javax.swing.JPanel pnVideo3;
    private javax.swing.JPanel pnVideo4;
    private javax.swing.JPanel pnVideo5;
    private javax.swing.JPanel pnVideo6;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
