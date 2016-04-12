package br.com.academyflash.GUI;

import br.com.academyflash.entidades.Login;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        cadastroMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        funcionarioMenuItem = new javax.swing.JMenuItem();
        loginMenuItem = new javax.swing.JMenuItem();
        consultasMenu = new javax.swing.JMenu();
        alunosMenuItem = new javax.swing.JMenuItem();
        funcionariosMenuItem = new javax.swing.JMenuItem();
        loginsMenuItem = new javax.swing.JMenuItem();
        financeiroMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        sairMenu = new javax.swing.JMenu();
        deslogarMenuItem = new javax.swing.JMenuItem();
        sairMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AcademyFlash - Deslogado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        deslogado();

        cadastroMenu.setMnemonic('f');
        cadastroMenu.setText("Cadastros");
        cadastroMenu.setEnabled(false);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Aluno");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(saveMenuItem);

        funcionarioMenuItem.setMnemonic('o');
        funcionarioMenuItem.setText("Funcionário");
        funcionarioMenuItem.setEnabled(false);
        funcionarioMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionarioMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(funcionarioMenuItem);

        loginMenuItem.setMnemonic('a');
        loginMenuItem.setText("Login");
        loginMenuItem.setEnabled(false);
        loginMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(loginMenuItem);

        menuBar.add(cadastroMenu);

        consultasMenu.setMnemonic('e');
        consultasMenu.setText("Consultas");
        consultasMenu.setEnabled(false);

        alunosMenuItem.setMnemonic('t');
        alunosMenuItem.setText("Alunos");
        alunosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alunosMenuItemActionPerformed(evt);
            }
        });
        consultasMenu.add(alunosMenuItem);

        funcionariosMenuItem.setMnemonic('y');
        funcionariosMenuItem.setText("Funcinários");
        funcionariosMenuItem.setEnabled(false);
        funcionariosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionariosMenuItemActionPerformed(evt);
            }
        });
        consultasMenu.add(funcionariosMenuItem);

        loginsMenuItem.setMnemonic('p');
        loginsMenuItem.setText("Logins");
        loginsMenuItem.setEnabled(false);
        loginsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginsMenuItemActionPerformed(evt);
            }
        });
        consultasMenu.add(loginsMenuItem);

        menuBar.add(consultasMenu);

        financeiroMenu.setText("Financeiro");
        financeiroMenu.setEnabled(false);

        jMenuItem1.setText("Mensalidades");
        financeiroMenu.add(jMenuItem1);

        jMenuItem2.setText("Pagamentos");
        financeiroMenu.add(jMenuItem2);

        menuBar.add(financeiroMenu);

        sairMenu.setText("Sair");

        deslogarMenuItem.setText("Deslogar");
        deslogarMenuItem.setEnabled(false);
        deslogarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deslogarMenuItemActionPerformed(evt);
            }
        });
        sairMenu.add(deslogarMenuItem);

        sairMenuItem.setText("Sair");
        sairMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairMenuItemActionPerformed(evt);
            }
        });
        sairMenu.add(sairMenuItem);

        menuBar.add(sairMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ajuda");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setCentro ( JInternalFrame com, int menosX, int menosY){
        Dimension dx = getSize();  
        Dimension ds = com.getSize ( );  
        com.setLocation((dx.width - ds.width) / 2 -  menosX,(dx.height - ds.height) / 2 - menosY);
    }
            
    private void deslogarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deslogarMenuItemActionPerformed
        deslogado();
    }//GEN-LAST:event_deslogarMenuItemActionPerformed

    private void funcionariosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionariosMenuItemActionPerformed
        Consultas consulta = new Consultas(new FuncionarioTableModel());
        consulta.setVisible(true);
        setCentro(consulta, 0, 50);
        desktopPane.add(consulta);
    }//GEN-LAST:event_funcionariosMenuItemActionPerformed

    private void alunosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alunosMenuItemActionPerformed
        Consultas consulta = new Consultas(new AlunoTableModel());
        consulta.setVisible(true);
        setCentro(consulta, 0, 50);
        desktopPane.removeAll();
        desktopPane.updateUI();
        desktopPane.add(consulta);
        
    }//GEN-LAST:event_alunosMenuItemActionPerformed

    private void loginsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginsMenuItemActionPerformed
        // TODO add your handling code here:
        Consultas consulta = new Consultas(new LoginTableModel());
        consulta.setVisible(true);
        setCentro(consulta, 0, 50);
        desktopPane.add(consulta);
    }//GEN-LAST:event_loginsMenuItemActionPerformed

    private void sairMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairMenuItemActionPerformed
        System.exit(0);
        
    }//GEN-LAST:event_sairMenuItemActionPerformed

    private void loginMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuItemActionPerformed
        LoginCadastroGUI loginCadastroGUI = new LoginCadastroGUI();
        loginCadastroGUI.setVisible(true);
        setCentro(loginCadastroGUI, 0, 50);
        desktopPane.add(loginCadastroGUI);
    }//GEN-LAST:event_loginMenuItemActionPerformed

    private void funcionarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionarioMenuItemActionPerformed
        FuncionarioGUI funcionarioGUI = new FuncionarioGUI();
        funcionarioGUI.setVisible(true);
        setCentro(funcionarioGUI, 0, 50);
        desktopPane.add(funcionarioGUI);
    }//GEN-LAST:event_funcionarioMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        // TODO add your handling code here:
        AlunoGUI alunoGUI = new AlunoGUI();
        alunoGUI.setVisible(true);
        setCentro(alunoGUI, 0, 50);
        desktopPane.add(alunoGUI);
    }//GEN-LAST:event_saveMenuItemActionPerformed
    public void deslogado(){
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
        setTitle("AcademyFlash - Deslogado.");
        desktopPane.removeAll();
        desktopPane.updateUI();
        desktopPane.add(login);
        cadastroMenu.setEnabled(false);
        consultasMenu.setEnabled(false);
        deslogarMenuItem.setEnabled(false);
        funcionarioMenuItem.setEnabled(false);
        funcionariosMenuItem.setEnabled(false);
        loginMenuItem.setEnabled(false);
        loginsMenuItem.setEnabled(false);
        financeiroMenu.setEnabled(false);
    }
    public static void logado(Login login){
        cadastroMenu.setEnabled(true);
        consultasMenu.setEnabled(true);
        deslogarMenuItem.setEnabled(true);
        if(login.getNivel() == 1){
            funcionarioMenuItem.setEnabled(true);
            funcionariosMenuItem.setEnabled(true);
            loginMenuItem.setEnabled(true);
            loginsMenuItem.setEnabled(true);
            financeiroMenu.setEnabled(true);
        }
    }
    
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem alunosMenuItem;
    private static javax.swing.JMenu cadastroMenu;
    private static javax.swing.JMenu consultasMenu;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private static javax.swing.JMenuItem deslogarMenuItem;
    private static javax.swing.JMenu financeiroMenu;
    private static javax.swing.JMenuItem funcionarioMenuItem;
    private static javax.swing.JMenuItem funcionariosMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private static javax.swing.JMenuItem loginMenuItem;
    private static javax.swing.JMenuItem loginsMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu sairMenu;
    private javax.swing.JMenuItem sairMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
