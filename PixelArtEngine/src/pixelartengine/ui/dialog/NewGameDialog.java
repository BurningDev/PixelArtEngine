package pixelartengine.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import pixelartengine.misc.Status;

/**
 * 
 * @author TheBattlepower
 *
 */
public class NewGameDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtTitle;
	private JTextField txtLocationDir;
	
	private Status status;
	
	private String location;
	private String title;
	
	public void openDialog() {
		try {
			NewGameDialog dialog = new NewGameDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NewGameDialog() {
		setTitle("New Game");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 444, 45);
		contentPanel.add(panel);
		
		JLabel lblNewGame = new JLabel("New Game");
		lblNewGame.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblNewGame.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewGame);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(10, 56, 46, 14);
		contentPanel.add(lblTitle);
		
		JLabel lblSaveDir = new JLabel("Location:");
		lblSaveDir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaveDir.setBounds(10, 87, 46, 14);
		contentPanel.add(lblSaveDir);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(66, 53, 336, 20);
		contentPanel.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtLocationDir = new JTextField();
		txtLocationDir.setBounds(66, 84, 336, 20);
		contentPanel.add(txtLocationDir);
		txtLocationDir.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						location = txtLocationDir.getText();
						title = txtTitle.getText();
						
						status = Status.OK;
						
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						status = Status.CANCEL;
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public String getTitleProject() {
		return this.title;
	}
	
	public String getLocationProject() {
		return this.location;
	}
	
	public Status getStatus() {
		return this.status;
	}
}
