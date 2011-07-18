package br.com.furb.engenhariasoftware.gui;

import javax.swing.JOptionPane;

import br.com.furb.engenhariasoftware.gui.util.CurrentUser;
import br.com.furb.sistemasseguros.security.bussiness.BussinessAutentication;
import br.com.furb.sistemasseguros.security.dao.DAOUser;
import br.com.furb.sistemasseguros.security.database.DataBaseManager;

/**
 * @author andre almeida
 */
public class InitLogin extends javax.swing.JFrame {

	public InitLogin() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		setLocation(500,300);
		
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jPasswordField1 = new javax.swing.JPasswordField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Login:");

		jLabel2.setText("Senha:");

		jButton1.setText("Entrar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Cancelar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel3.setText("Efetue o login:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(42, 42,
																		42)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jLabel1))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jPasswordField1)
																				.addComponent(
																						jTextField1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						133,
																						Short.MAX_VALUE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(53, 53,
																		53)
																.addComponent(
																		jButton1)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton2))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(91, 91,
																		91)
																.addComponent(
																		jLabel3)))
								.addContainerGap(50, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(13, 13, 13)
								.addComponent(jLabel3)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														jPasswordField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addContainerGap(19, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		
		String login = jTextField1.getText();
		String password = jPasswordField1.getText();
		
		BussinessAutentication autentication = new BussinessAutentication();
		
		try {
			if(autentication.validateLogin(login, password) && autentication.validatePassword(login, password)){
				
				CurrentUser.setCurrentUser(new DAOUser(new DataBaseManager()).getUserById(login));
				
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Init().setVisible(true);
					}
				});
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "Login/Senha inválido.", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InitLogin().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JTextField jTextField1;
}
