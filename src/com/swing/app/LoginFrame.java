package com.swing.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginFrame {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(155, 42, 128, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserName.setBounds(29, 95, 93, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(29, 153, 93, 14);
		frame.getContentPane().add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(132, 92, 137, 20);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(132, 150, 137, 20);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUserName.getText();
				String password = txtPassword.getText();
				if(username.contains("admin") && password.contains("admin")){
					
					JOptionPane.showMessageDialog(null, "Login Success");
					VLCMediaPlayer vlcMediaPlayer = new VLCMediaPlayer();
					vlcMediaPlayer.main(null);
					/*Dashboard dashboard = new Dashboard();
					dashboard.main(null);*/
				}else{
					JOptionPane.showMessageDialog(null, "Invalid Login", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(76, 208, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserName.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(176, 208, 89, 23);
		frame.getContentPane().add(btnReset);
	}
}
