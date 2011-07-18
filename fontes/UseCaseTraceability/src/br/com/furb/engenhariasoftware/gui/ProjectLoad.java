/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProjectLoad.java
 *
 * Created on 05/12/2010, 15:05:13
 */

package br.com.furb.engenhariasoftware.gui;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.gui.constants.Constants;
import br.com.furb.engenhariasoftware.gui.util.CurrentProject;
import br.com.furb.engenhariasoftware.gui.util.CurrentUser;
import br.com.furb.sistemasseguros.security.bussiness.BussinessAccessControl;

/**
 *
 * @author Marcos
 */
public class ProjectLoad extends javax.swing.JPanel {
	private Init init;
    /** Creates new form ProjectLoad */
    public ProjectLoad(Init init) {
    	this.init = init;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Carregar Projeto");

        jLabel2.setText("Projetos:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Carregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(238, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, 0, 205, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(222, Short.MAX_VALUE))
        );
    }// </editor-fold>

    public void setDadosComboboxProjetos(List<Project> projects){
    	this.jComboBox1.removeAllItems();
    	for(Project project : projects){
    		this.jComboBox1.addItem(project);
    	}
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
        	Project project = (Project)this.jComboBox1.getSelectedItem();
            CurrentProject.setCurrentProject(project);
            
            BussinessAccessControl accessControl = new BussinessAccessControl();
	        try{
		        if(!accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin()
		        									   ,Constants.FUNCTIONAL_REQUISITE_SAVE)){
		        	init.jMenuItem3.setEnabled(false);
		        }else{
		        	init.jMenuItem3.setEnabled(true);
		        }
		        if(!accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin()
						   							   ,Constants.USE_CASE_SAVE)){
		        	init.jMenuItem4.setEnabled(false);
				}else{
					init.jMenuItem4.setEnabled(true);
				}
		        if(!accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin()
						   							   ,Constants.BUSINESS_RULE_SAVE)){
		        	init.jMenuItem5.setEnabled(false);
				}else{
					init.jMenuItem5.setEnabled(true);
				}
		        if(!accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin()
						   							   ,Constants.IMPLEMENTATION_RULE_SAVE)){
		        	init.jMenuItem6.setEnabled(false);
				}else{
					init.jMenuItem6.setEnabled(true);
				}
		        if(!accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin()
						   ,Constants.FUNCTIONAL_REQUISITE_VIEW)){
		        	init.jMenuItem7.setEnabled(false);
				}else{
					init.jMenuItem7.setEnabled(true);
				}
				if(!accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin()
									   ,Constants.USE_CASE_VIEW)){
					init.jMenuItem8.setEnabled(false);
				}else{
					init.jMenuItem8.setEnabled(true);
				}
				if(!accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin()
									   ,Constants.BUSINESS_RULE_VIEW)){
					init.jMenuItem9.setEnabled(false);
				}else{
					init.jMenuItem9.setEnabled(true);
				}
				if(!accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin()
									   ,Constants.IMPLEMENTATION_RULE_VIEW)){
					init.jMenuItem10.setEnabled(false);
				}else{
					init.jMenuItem10.setEnabled(true);
				}
				if(!accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin()
						,Constants.TRACEABILITY_REPORT_GENERATE)){
					init.jMenuItem11.setEnabled(false);
				}else{
					init.jMenuItem11.setEnabled(true);
				}
	        }catch(Exception ex){
	        	JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
	        }
            
    		JOptionPane.showMessageDialog(null, "Projeto "+project.getName()+" carregado com sucesso!", "Info!", JOptionPane.INFORMATION_MESSAGE);
    	}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration

}
