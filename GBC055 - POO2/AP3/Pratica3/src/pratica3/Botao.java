package pratica3;

public class Botao extends javax.swing.JFrame {

    public Sanduiche sanduba;
    public Botao() {
        initComponents();
        Salsicha.setEnabled(false);
        Bacon.setEnabled(false);
        Ovo.setEnabled(false);
        Catupiry.setEnabled(false);
        Cheddar.setEnabled(false);
               
        Finalizar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Salsicha = new javax.swing.JButton();
        Bacon = new javax.swing.JButton();
        Cheddar = new javax.swing.JButton();
        Ovo = new javax.swing.JButton();
        Catupiry = new javax.swing.JButton();
        XTudo = new javax.swing.JButton();
        XFrango = new javax.swing.JButton();
        XFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mostra_preco = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Mostra_Nome = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Finalizar = new javax.swing.JButton();
        Reiniciar = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Salsicha.setText("Salsicha");
        Salsicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalsichaActionPerformed(evt);
            }
        });

        Bacon.setText("Bacon");
        Bacon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaconActionPerformed(evt);
            }
        });

        Cheddar.setText("Cheddar");
        Cheddar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheddarActionPerformed(evt);
            }
        });

        Ovo.setText("Ovo");
        Ovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OvoActionPerformed(evt);
            }
        });

        Catupiry.setText("Catupiry");
        Catupiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatupiryActionPerformed(evt);
            }
        });

        XTudo.setText("XTudo");
        XTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XTudoActionPerformed(evt);
            }
        });

        XFrango.setText("XFrango");
        XFrango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XFrangoActionPerformed(evt);
            }
        });

        XFile.setText("XFile");
        XFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XFileActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(Mostra_preco);

        jScrollPane2.setViewportView(Mostra_Nome);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sanduiche");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Adicionais");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Total :");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        Finalizar.setText("Finalizar");
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });

        Reiniciar.setText("Reiniciar");
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Farofa Lanches - Pedido");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Finalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(XFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(XTudo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(XFrango, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Catupiry, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(Salsicha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bacon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Ovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cheddar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Reiniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salsicha)
                    .addComponent(XTudo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bacon)
                    .addComponent(XFrango))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ovo)
                    .addComponent(XFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cheddar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Catupiry)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1)
                        .addComponent(Finalizar))
                    .addComponent(jScrollPane1))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XTudoActionPerformed
        sanduba = new Xtudo();
        
        XTudo.setEnabled(false);
        XFrango.setEnabled(false);
        XFile.setEnabled(false);
        
        Finalizar.setEnabled(true);
        
        Mostra_Nome.setText(sanduba.descricao);
        Mostra_preco.setText("" + sanduba.calcula_preco());
        
        Salsicha.setEnabled(true);
        Bacon.setEnabled(true);
        Ovo.setEnabled(true);
        Catupiry.setEnabled(true);
        Cheddar.setEnabled(true);
        
    }//GEN-LAST:event_XTudoActionPerformed

    private void XFrangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XFrangoActionPerformed
        sanduba = new Xfrango();
        
        XTudo.setEnabled(false);
        XFrango.setEnabled(false);
        XFile.setEnabled(false);
        
        Finalizar.setEnabled(true);
        
        Mostra_Nome.setText(sanduba.descricao);
        Mostra_preco.setText("" + sanduba.calcula_preco());        
        
        Salsicha.setEnabled(true);
        Bacon.setEnabled(true);
        Ovo.setEnabled(true);
        Catupiry.setEnabled(true);
        Cheddar.setEnabled(true);
        
    }//GEN-LAST:event_XFrangoActionPerformed

    private void XFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XFileActionPerformed
        sanduba = new Xfile();
        
        XTudo.setEnabled(false);
        XFrango.setEnabled(false);
        XFile.setEnabled(false);
        
        Finalizar.setEnabled(true);
        
        Mostra_Nome.setText(sanduba.descricao);
        Mostra_preco.setText("" + sanduba.calcula_preco());
        Salsicha.setEnabled(true);
        Bacon.setEnabled(true);
        Ovo.setEnabled(true);
        Catupiry.setEnabled(true);
        Cheddar.setEnabled(true);
        
    }//GEN-LAST:event_XFileActionPerformed

    private void SalsichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalsichaActionPerformed
        sanduba = new Salsicha(sanduba);
        
        Mostra_Nome.setText(sanduba.descricao);
        Mostra_preco.setText("" + sanduba.calcula_preco());   
        
        Salsicha.setEnabled(false);
    }//GEN-LAST:event_SalsichaActionPerformed

    private void BaconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaconActionPerformed
        sanduba = new Bacon(sanduba);
        
        Mostra_Nome.setText(sanduba.descricao);
        Mostra_preco.setText("" + sanduba.calcula_preco());
        
        Bacon.setEnabled(false);
    }//GEN-LAST:event_BaconActionPerformed

    private void OvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OvoActionPerformed
        sanduba = new Ovo(sanduba);
        
        Mostra_Nome.setText(sanduba.descricao);
        Mostra_preco.setText("" + sanduba.calcula_preco());
        
        Ovo.setEnabled(false);
    }//GEN-LAST:event_OvoActionPerformed

    private void CheddarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheddarActionPerformed
        sanduba = new Cheddar(sanduba);
        
        Mostra_Nome.setText(sanduba.descricao);
        Mostra_preco.setText("" + sanduba.calcula_preco());
        
        Cheddar.setEnabled(false);
    }//GEN-LAST:event_CheddarActionPerformed

    private void CatupiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatupiryActionPerformed
        sanduba = new Catupiry(sanduba);
        
        Mostra_Nome.setText(sanduba.descricao);
        Mostra_preco.setText("" + sanduba.calcula_preco());
        
        Catupiry.setEnabled(false);
    }//GEN-LAST:event_CatupiryActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed
        
        XTudo.setEnabled(true);
        XFrango.setEnabled(true);
        XFile.setEnabled(true);
        
        Salsicha.setEnabled(false);
        Bacon.setEnabled(false);
        Ovo.setEnabled(false);
        Catupiry.setEnabled(false);
        Cheddar.setEnabled(false);
        
        Finalizar.setEnabled(true);
  
        Mostra_Nome.setText("");
        Mostra_preco.setText("");

        sanduba=null;
        
    }//GEN-LAST:event_ReiniciarActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
        Salsicha.setEnabled(false);
        Bacon.setEnabled(false);
        Ovo.setEnabled(false);
        Catupiry.setEnabled(false);
        Cheddar.setEnabled(false);
        
        XTudo.setEnabled(false);
        XFrango.setEnabled(false);
        XFile.setEnabled(false);
        
        Finalizar.setEnabled(false);
    }//GEN-LAST:event_FinalizarActionPerformed

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
            java.util.logging.Logger.getLogger(Botao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Botao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Botao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Botao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Botao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bacon;
    private javax.swing.JButton Catupiry;
    private javax.swing.JButton Cheddar;
    private javax.swing.JButton Finalizar;
    private javax.swing.JTextPane Mostra_Nome;
    private javax.swing.JTextPane Mostra_preco;
    private javax.swing.JButton Ovo;
    private javax.swing.JButton Reiniciar;
    private javax.swing.JButton Salsicha;
    private javax.swing.JButton XFile;
    private javax.swing.JButton XFrango;
    private javax.swing.JButton XTudo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
