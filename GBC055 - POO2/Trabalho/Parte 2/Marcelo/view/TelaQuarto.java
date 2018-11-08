
package view;

import controller.*;
import javax.swing.*;
import java.awt.event.*;

public class TelaQuarto extends javax.swing.JFrame {

    String nquarto;
    ControllerTelaQuarto controle;

    public TelaQuarto(String nquarto) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.nquarto = nquarto;
        controle = new ControllerTelaQuarto(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SolicitaLimpeza = new javax.swing.JButton();
        SolicitaItemCardapio = new javax.swing.JButton();
        BotaoSair = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Bem Vindo!");

        jLabel2.setText("Selecione alguma das opções abaixo:");

        SolicitaLimpeza.setText("Solicitar Limpeza no Quarto");
        SolicitaLimpeza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitaLimpezaActionPerformed(evt);
            }
        });

        SolicitaItemCardapio.setText("Solicitar Item do Cardápio");
        SolicitaItemCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitaItemCardapioActionPerformed(evt);
            }
        });

        BotaoSair.setText("Sair");
        BotaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairActionPerformed(evt);
            }
        });

        jButton1.setText("Pedir Sorvete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotaoSair)
                        .addGap(170, 170, 170))))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SolicitaItemCardapio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SolicitaLimpeza, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(SolicitaLimpeza)
                .addGap(18, 18, 18)
                .addComponent(SolicitaItemCardapio)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(BotaoSair)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SolicitaLimpezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitaLimpezaActionPerformed
        
    }//GEN-LAST:event_SolicitaLimpezaActionPerformed
    
    public String getNumeroQuarto()
    {
        return nquarto;
    }
    
    public void addListenerSolicitaLimpeza (ActionListener listener)
    {
        SolicitaLimpeza.addActionListener(listener);
    }
    
    public void mostrarMensagem(String mensagem)
    {
        JOptionPane.showMessageDialog(this, mensagem);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        TelaSorveteria sorveteria = new TelaSorveteria(this.nquarto);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
        this.dispose();
        Principal telaprincipal = new Principal();
    }//GEN-LAST:event_BotaoSairActionPerformed

    private void SolicitaItemCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitaItemCardapioActionPerformed
        this.dispose();
        TelaSolicitaItem cardapio = new TelaSolicitaItem(this.nquarto);
    }//GEN-LAST:event_SolicitaItemCardapioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoSair;
    private javax.swing.JButton SolicitaItemCardapio;
    private javax.swing.JButton SolicitaLimpeza;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
