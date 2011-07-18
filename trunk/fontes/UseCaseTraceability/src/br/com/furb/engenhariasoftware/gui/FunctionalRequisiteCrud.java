/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FunctionalRequisiteCrud.java
 *
 * Created on 05/12/2010, 15:56:51
 */

package br.com.furb.engenhariasoftware.gui;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.furb.engenhariasoftware.bussiness.BusinessFunctionalRequisite;
import br.com.furb.engenhariasoftware.bussiness.BusinessProject;
import br.com.furb.engenhariasoftware.entity.FunctionalRequisite;
import br.com.furb.engenhariasoftware.exception.CoreException;
import br.com.furb.engenhariasoftware.gui.constants.Constants;
import br.com.furb.engenhariasoftware.gui.util.CurrentProject;
import br.com.furb.engenhariasoftware.gui.util.CurrentUser;
import br.com.furb.engenhariasoftware.gui.util.ValidateField;
import br.com.furb.sistemasseguros.security.bussiness.BussinessAccessControl;


/**
 *
 * @author Marcos
 */
public class FunctionalRequisiteCrud extends javax.swing.JPanel {
	private FunctionalRequisite frSelected; 
	private boolean canUpdate;
	private boolean canDelete;
	
    /** Creates new form FunctionalRequisiteCrud */
    public FunctionalRequisiteCrud() {
    	BussinessAccessControl accessControl = new BussinessAccessControl();
    	try {
    		canUpdate = accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin(), 
    														Constants.FUNCTIONAL_REQUISITE_UPDATE);
    	
			canDelete = accessControl.validateAccessControl(CurrentUser.getCurrentUser().getLogin(), 
															Constants.FUNCTIONAL_REQUISITE_DELETE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro a validar permiss�o do usu�rio.", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
        initComponents();
        assignPermission();
    }
    
    private void assignPermission(){
    	jTextField2.setEditable(canUpdate);
    	jTextArea1.setEditable(canUpdate);
    	jButton2.setEnabled(canUpdate);
    	
    	jButton3.setEnabled(canDelete);
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
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Consultar Requisito Funcional");

        jLabel2.setText("Requisito Funcional: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Identificador:");

        jTextField1.setEditable(false);

        jLabel4.setText("Nome: ");

        jLabel5.setText("Descri��o:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(121, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, 0, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        FunctionalRequisite fr = (FunctionalRequisite)this.jComboBox1.getSelectedItem();
        this.frSelected = fr;
        this.jTextField1.setText(fr.getId());
        this.jTextField2.setText(fr.getName());
        this.jTextArea1.setText(fr.getDescription());
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	try{
    		ValidateField.validateStrings(new String[]{"Identificador", "Nome", "Descri��o"}, 
    				new String[]{this.jTextField1.getText(), this.jTextField2.getText(), this.jTextArea1.getText()});
 
    		BusinessFunctionalRequisite bfr = new BusinessFunctionalRequisite();
    		
    		this.frSelected.setName(this.jTextField2.getText());
    		this.frSelected.setDescription(this.jTextArea1.getText());
    		
    		bfr.update(CurrentProject.getCurrentProject(), this.frSelected);
    		
    		this.setDadosCombo(bfr.getAllFunctionalRequisite());
    		
    		BusinessProject bp = new BusinessProject();
    		CurrentProject.setCurrentProject(bp.getProjectById(CurrentProject.getCurrentProject().getId()));
    		
    		JOptionPane.showMessageDialog(null, "Requisito Funcional atualizado com sucesso!", "Info!", JOptionPane.INFORMATION_MESSAGE);
    	}catch (CoreException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	try{
    		ValidateField.validateString("Identificador", this.jTextField1.getText());
 
    		BusinessFunctionalRequisite bfr = new BusinessFunctionalRequisite();

    		bfr.remove(CurrentProject.getCurrentProject(), this.frSelected);
    		
    		this.setDadosCombo(bfr.getAllFunctionalRequisite());
    		
    		BusinessProject bp = new BusinessProject();
    		CurrentProject.setCurrentProject(bp.getProjectById(CurrentProject.getCurrentProject().getId()));
    		
    		this.jTextField1.setText("");
            this.jTextField2.setText("");
            this.jTextArea1.setText("");
    		
    		JOptionPane.showMessageDialog(null, "Requisito Funcional exclu�do com sucesso!", "Info!", JOptionPane.INFORMATION_MESSAGE);
    	}catch (CoreException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
    }

    public void setDadosCombo(List<FunctionalRequisite> functionalRequisites){
    	this.jComboBox1.removeAllItems();
    	for(FunctionalRequisite fr : functionalRequisites){
    		this.jComboBox1.addItem(fr);
    	}
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration

}