
package view;

import controller.*;
import javax.swing.*;
import java.awt.event.*;

public class TelaFecharReserva extends javax.swing.JFrame {

    ControllerTelaFecharReserva controle;
    
    public TelaFecharReserva() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        controle = new ControllerTelaFecharReserva(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CampoCodigoReserva = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LabelPreco = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BotaoPesquisaReserva = new javax.swing.JButton();
        BotaoFecharReserva = new javax.swing.JButton();
        BotaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Digite o código da reserva a ser fechada:");

        jLabel2.setText("Preço total:");

        LabelPreco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelPreco.setText("0,00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("R$");

        BotaoPesquisaReserva.setText("Pesquisar Reserva");
        BotaoPesquisaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPesquisaReservaActionPerformed(evt);
            }
        });

        BotaoFecharReserva.setText("Fechar Reserva");
        BotaoFecharReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFecharReservaActionPerformed(evt);
            }
        });

        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(CampoCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(BotaoFecharReserva)
                        .addGap(73, 73, 73)
                        .addComponent(BotaoCancelar)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(BotaoPesquisaReserva))
                .addGap(129, 129, 129))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelPreco)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CampoCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoPesquisaReserva)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPreco)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoFecharReserva)
                    .addComponent(BotaoCancelar))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoPesquisaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPesquisaReservaActionPerformed

    }//GEN-LAST:event_BotaoPesquisaReservaActionPerformed

    public String getTextoCampoCodigoReserva()
    {
        return CampoCodigoReserva.getText();
    }
    
    public void addListenerBotaoPesquisaReserva (ActionListener listener)
    {
        BotaoPesquisaReserva.addActionListener(listener);
    }
    
    public void atualizaValorTela(String valor)
    {
        LabelPreco.setText(valor);
    }
    
    public void mostrarMensagem(String mensagem)
    {
        JOptionPane.showMessageDialog(this, mensagem);
    }
    
    private void BotaoFecharReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFecharReservaActionPerformed

    }//GEN-LAST:event_BotaoFecharReservaActionPerformed
    
    public void addListenerBotaoFecharReserva (ActionListener listener)
    {
        BotaoFecharReserva.addActionListener(listener);
    }
    
    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        this.dispose();
        TelaRecepcionista telaRecepcionista = new TelaRecepcionista();
    }//GEN-LAST:event_BotaoCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancelar;
    private javax.swing.JButton BotaoFecharReserva;
    private javax.swing.JButton BotaoPesquisaReserva;
    private javax.swing.JTextField CampoCodigoReserva;
    private javax.swing.JLabel LabelPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
