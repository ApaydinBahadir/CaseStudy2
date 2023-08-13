package src.view.layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class KodChangeView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField eskiKod = new JTextField();
	public JTextField yeniKod = new JTextField();
	public JButton okButton = new JButton("OK");
	public JButton cancelButton = new JButton("Cancel");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KodChangeView dialog = new KodChangeView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public KodChangeView() {
		setTitle("Kod Değiştir");
		setBounds(100, 100, 360, 164);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30 };
		gbl_contentPanel.rowHeights = new int[] { 30, 30, 30, 30 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Eski Kod");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			eskiKod.setEditable(true);
			GridBagConstraints gbc_EskiKod = new GridBagConstraints();
			gbc_EskiKod.insets = new Insets(0, 0, 5, 5);
			gbc_EskiKod.fill = GridBagConstraints.BOTH;
			gbc_EskiKod.gridx = 2;
			gbc_EskiKod.gridy = 1;
			gbc_EskiKod.gridwidth = 2;
			contentPanel.add(eskiKod, gbc_EskiKod);
		}
		{
			JLabel lblNewLabel = new JLabel("Yeni Kod");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 5;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 6;
			gbc_textField_1.gridy = 1;
			contentPanel.add(yeniKod, gbc_textField_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
