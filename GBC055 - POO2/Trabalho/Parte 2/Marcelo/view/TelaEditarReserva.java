
package view;

import controller.*;
import javax.swing.*;
import java.awt.event.*;

public class TelaEditarReserva extends javax.swing.JFrame {

    ControllerTelaEditarReserva controle;
    
    public TelaEditarReserva() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        controle = new ControllerTelaEditarReserva(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CampoCodReserva = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CampoProlongaReserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CampoAdiaReserva = new javax.swing.JTextField();
        BotaoConfirma = new javax.swing.JButton();
        BotaoSair = new javax.swing.JButton();
        BotaoCancelaReserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(null);

        jLabel1.setText("Insira o código da reserva:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 10, 190, 14);
        getContentPane().add(CampoCodReserva);
        CampoCodReserva.setBounds(220, 10, 120, 20);

        jLabel2.setText("Prolongar Reserva");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(159, 57, 140, 14);

        jLabel3.setText("Digite a nova data de saída:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(41, 92, 210, 14);
        getContentPane().add(CampoProlongaReserva);
        CampoProlongaReserva.setBounds(221, 89, 123, 20);

        jLabel4.setText("Adiar Reserva");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 130, 130, 14);

        jLabel5.setText("Digite a nova data de entrada:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 170, 230, 10);
        getContentPane().add(CampoAdiaReserva);
        CampoAdiaReserva.setBounds(220, 160, 120, 20);

        BotaoConfirma.setText("Confirmar");
        BotaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConfirmaActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoConfirma);
        BotaoConfirma.setBounds(30, 230, 120, 23);

        BotaoSair.setText("Sair");
        BotaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoSair);
        BotaoSair.setBounds(170, 230, 70, 23);

        BotaoCancelaReserva.setText("Cancelar Reserva");
        BotaoCancelaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelaReservaActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoCancelaReserva);
        BotaoCancelaReserva.setBounds(260, 230, 150, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConfirmaActionPerformed

    }//GEN-LAST:event_BotaoConfirmaActionPerformed

    public String getTextoCampoCodReserva()
    {
        return CampoCodReserva.getText();
    }
    
    public String getTextoCampoProlongaReserva()
    {
        return CampoProlongaReserva.getText();
    }
    
    public String getTextoCampoAdiaReserva()
    {
        return CampoAdiaReserva.getText();
    }
    
    public void addListenerBotaoConfirma (ActionListener listener)
    {
        BotaoConfirma.addActionListener(listener);
    }
    
    public void mostrarMensagem(String mensagem)
    {
        JOptionPane.showMessageDialog(this, mensagem);
    }
    
    
    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
        this.dispose();
        TelaRecepcionista telaRecepcionista = new TelaRecepcionista();
    }//GEN-LAST:event_BotaoSairActionPerformed

    private void BotaoCancelaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelaReservaActionPerformed
        
    }//GEN-LAST:event_BotaoCancelaReservaActionPerformed
    
    public void addListenerBotaoCancelaReserva (ActionListener listener)
    {
        BotaoCancelaReserva.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancelaReserva;
    private javax.swing.JButton BotaoConfirma;
    private javax.swing.JButton BotaoSair;
    private javax.swing.JTextField CampoAdiaReserva;
    private javax.swing.JTextField CampoCodReserva;
    private javax.swing.JTextField CampoProlongaReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
