
package view;

import controller.*;
import javax.swing.*;
import java.awt.event.*;

public class TelaRecepcionista extends javax.swing.JFrame {

    public TelaRecepcionista() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CadastraHospede = new javax.swing.JButton();
        AbrirReserva = new javax.swing.JButton();
        FecharReserva = new javax.swing.JButton();
        EditarReserva = new javax.swing.JButton();
        BotaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Bem Vindo!");

        jLabel2.setText("Selecione alguma das opções abaixo:");

        CadastraHospede.setText("Cadastrar Hóspede");
        CadastraHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastraHospedeActionPerformed(evt);
            }
        });

        AbrirReserva.setText("Abrir Reserva");
        AbrirReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirReservaActionPerformed(evt);
            }
        });

        FecharReserva.setText("Fechar Reserva");
        FecharReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharReservaActionPerformed(evt);
            }
        });

        EditarReserva.setText("Editar Reserva");
        EditarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarReservaActionPerformed(evt);
            }
        });

        BotaoSair.setText("Sair");
        BotaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EditarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CadastraHospede, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AbrirReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FecharReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(BotaoSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CadastraHospede)
                    .addComponent(AbrirReserva))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarReserva)
                    .addComponent(FecharReserva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(BotaoSair)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastraHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastraHospedeActionPerformed
        this.dispose();
        TelaCadastraHospede cadastraHospede = new TelaCadastraHospede();
    }//GEN-LAST:event_CadastraHospedeActionPerformed

    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
        this.dispose();
        TelaLogin login = new TelaLogin();
    }//GEN-LAST:event_BotaoSairActionPerformed

    private void EditarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarReservaActionPerformed
       this.dispose();
       TelaEditarReserva editarReserva = new TelaEditarReserva();
    }//GEN-LAST:event_EditarReservaActionPerformed

    private void AbrirReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirReservaActionPerformed
        this.dispose();
        TelaAbrirReserva abrirReserva = new TelaAbrirReserva();
    }//GEN-LAST:event_AbrirReservaActionPerformed

    private void FecharReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharReservaActionPerformed
        this.dispose();
        TelaFecharReserva fecharReserva = new TelaFecharReserva();
    }//GEN-LAST:event_FecharReservaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbrirReserva;
    private javax.swing.JButton BotaoSair;
    private javax.swing.JButton CadastraHospede;
    private javax.swing.JButton EditarReserva;
    private javax.swing.JButton FecharReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
