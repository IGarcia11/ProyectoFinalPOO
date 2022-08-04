package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JTextField txtConfirm;
	private JComboBox cbxTipo;
	private JButton btnOK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUser dialog = new RegUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUser() {
		setTitle("Registrar Usuario\r\n");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre Usuario:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(50, 32, 99, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPassword.setBounds(243, 32, 99, 13);
			contentPanel.add(lblPassword);
		}
		{
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipo.setBounds(50, 128, 99, 13);
			contentPanel.add(lblTipo);
		}
		{
			JLabel lblConfirmPassword = new JLabel("Confirm Password:");
			lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblConfirmPassword.setBounds(243, 128, 115, 13);
			contentPanel.add(lblConfirmPassword);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtUsuario.setBounds(50, 77, 143, 19);
			contentPanel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			txtPassword = new JTextField();
			txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPassword.setBounds(243, 77, 143, 19);
			contentPanel.add(txtPassword);
			txtPassword.setColumns(10);
		}
		{
			txtConfirm = new JTextField();
			txtConfirm.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtConfirm.setBounds(243, 173, 143, 19);
			contentPanel.add(txtConfirm);
			txtConfirm.setColumns(10);
		}
		{
			//JComboBox cbxTipo = new JComboBox();
			cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Comercial"}));
			cbxTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbxTipo.setBounds(50, 173, 143, 19);
			contentPanel.add(cbxTipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOK = new JButton("OK");
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user = new User(cbxTipo.getSelectedItem().toString(), txtUsuario.getText(), txtPassword.getText());
						Altice.getInstance().regUser(user);
					}
				});
				btnOK.setActionCommand("OK");
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
