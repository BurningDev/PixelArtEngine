package pixelartengine.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author TheBattlepower
 *
 */
public class AddObjectDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtTexture;

	public void openDialog() {
		try {
			AddObjectDialog dialog = new AddObjectDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AddObjectDialog() {
		setTitle("Add Object");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 444, 45);
			contentPanel.add(panel);
			{
				JLabel lblAddObject = new JLabel("Add Object");
				lblAddObject.setFont(new Font("Calibri", Font.PLAIN, 22));
				lblAddObject.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(lblAddObject);
			}
		}
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblName.setBounds(10, 56, 46, 14);
			contentPanel.add(lblName);
		}
		{
			txtName = new JTextField();
			txtName.setBounds(66, 53, 368, 20);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			JLabel lblTexture = new JLabel("Texture:");
			lblTexture.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTexture.setBounds(10, 87, 46, 14);
			contentPanel.add(lblTexture);
		}
		{
			txtTexture = new JTextField();
			txtTexture.setBounds(66, 84, 368, 20);
			contentPanel.add(txtTexture);
			txtTexture.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
