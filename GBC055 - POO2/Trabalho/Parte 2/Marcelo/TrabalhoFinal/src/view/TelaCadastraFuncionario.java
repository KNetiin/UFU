
package view;

import controller.*;
import javax.swing.*;
import java.awt.event.*;

public class TelaCadastraFuncionario extends javax.swing.JFrame {
    
    ControllerTelaCadastraFuncionario controle;
    
    public TelaCadastraFuncionario() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.controle = new ControllerTelaCadastraFuncionario(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        NomeFuncionario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CPFFuncionario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CargoFuncionario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        CampoSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        CampoSalario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CampoRua = new javax.swing.JTextField();
        CampoNCasa = new javax.swing.JTextField();
        CampoCidade = new javax.swing.JTextField();
        CampoCep = new javax.swing.JTextField();
        CampoBairro = new javax.swing.JTextField();
        CampoTelefone = new javax.swing.JTextField();
        BotaoCadastrar = new javax.swing.JButton();
        BotaoSair = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome do Funcionário:");

        jLabel2.setText("CPF:");

        jLabel3.setText("Cargo:");

        CargoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Recepcionista", "Faxineiro", "Gerente Restaurante", "Garçom" }));
        CargoFuncionario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CargoFuncionarioItemStateChanged(evt);
            }
        });

        jLabel4.setText("Senha:");

        jLabel5.setText("Salário Base:");

        jLabel6.setText("Insira as infomações para o cadastro de um novo funcionário");

        jLabel7.setText("Rua:");

        jLabel8.setText("Número da Casa:");

        jLabel9.setText("Bairro:");

        jLabel10.setText("CEP:");

        jLabel11.setText("Cidade:");

        jLabel12.setText("Telefone:");

        BotaoCadastrar.setText("Cadastrar");
        BotaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NomeFuncionario)
                                    .addComponent(CPFFuncionario)
                                    .addComponent(CargoFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CampoSenha)
                                    .addComponent(CampoSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(BotaoCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CampoRua)
                            .addComponent(CampoNCasa)
                            .addComponent(CampoCidade)
                            .addComponent(CampoCep)
                            .addComponent(CampoBairro)
                            .addComponent(CampoTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(CampoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CPFFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(CampoNCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CargoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(CampoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(CampoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CampoSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(CampoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(CampoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCadastrar)
                    .addComponent(BotaoSair))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargoFuncionarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CargoFuncionarioItemStateChanged
        String item;
        item = (String) CargoFuncionario.getSelectedItem();
        if (item == "Faxineiro" || item == "Garçom")
        {
            CampoSenha.setEnabled(false);
            CampoSenha.setText("");
        }
        else
        {
            CampoSenha.setEnabled(true);
        }
    }//GEN-LAST:event_CargoFuncionarioItemStateChanged

    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
            this.dispose();
            TelaGerente telaGerente = new TelaGerente();
    }//GEN-LAST:event_BotaoSairActionPerformed

    private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarActionPerformed
       
    }//GEN-LAST:event_BotaoCadastrarActionPerformed

    public String getTextoNomeFuncionario()
    {
        return NomeFuncionario.getText();
    }
    
    public String getTextoCPFFuncionario()
    {
        return CPFFuncionario.getText();
    }
    
    public String getCargoFuncionario()
    {
        return ((String) CargoFuncionario.getSelectedItem());
    }
    
    public String getTextoCampoSenha()
    {
        return CampoSenha.getText();
    }
    
    public String getTextoCampoSalario()
    {
        return CampoSalario.getText();
    }
    
    public String getTextoCampoRua()
    {
        return CampoRua.getText();
    }
    
    public String getTextoCampoNCasa()
    {
        return CampoNCasa.getText();
    }
    
    public String getTextoCampoCidade()
    {
        return CampoCidade.getText();
    }
    
    public String getTextoCampoCep()
    {
        return CampoCep.getText();
    }
    
    public String getTextoCampoBairro()
    {
        return CampoBairro.getText();
    }
    
    public String getTextoCampoTelefone()
    {
        return CampoTelefone.getText();
    }
    
    public void addListenerBotaoCadastrar (ActionListener listener)
    {
        BotaoCadastrar.addActionListener(listener);
    }
    
    public void mostrarMensagem(String mensagem)
    {
        JOptionPane.showMessageDialog(this, mensagem);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastrar;
    private javax.swing.JButton BotaoSair;
    private javax.swing.JTextField CPFFuncionario;
    private javax.swing.JTextField CampoBairro;
    private javax.swing.JTextField CampoCep;
    private javax.swing.JTextField CampoCidade;
    private javax.swing.JTextField CampoNCasa;
    private javax.swing.JTextField CampoRua;
    private javax.swing.JTextField CampoSalario;
    private javax.swing.JPasswordField CampoSenha;
    private javax.swing.JTextField CampoTelefone;
    private javax.swing.JComboBox<String> CargoFuncionario;
    private javax.swing.JTextField NomeFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
