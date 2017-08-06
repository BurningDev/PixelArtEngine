package pixelartengine.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	private DefaultListModel<String> dlmContributors = new DefaultListModel<String>();
	
	public void openDialog() {
		try {
			AboutDialog dialog = new AboutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AboutDialog() {
		this.dlmContributors.addElement("TheBattlepower");
		
		setTitle("About");
		setBounds(100, 100, 450, 360);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 434, 45);
			contentPanel.add(panel);
			{
				JLabel lblPixelartengine = new JLabel("PixelArtEngine");
				lblPixelartengine.setFont(new Font("Calibri", Font.PLAIN, 22));
				lblPixelartengine.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(lblPixelartengine);
			}
		}
		{
			JLabel lblAOpenSource = new JLabel("A open source game engine.");
			lblAOpenSource.setBounds(10, 56, 414, 14);
			contentPanel.add(lblAOpenSource);
		}
		{
			JLabel lblLicenseMit = new JLabel("License: MIT");
			lblLicenseMit.setBounds(10, 263, 66, 14);
			contentPanel.add(lblLicenseMit);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 414, 130);
		contentPanel.add(scrollPane);
		
		JList<String> list = new JList<String>(dlmContributors);
		scrollPane.setViewportView(list);
		{
			JLabel lblContributors = new JLabel("Contributors:");
			lblContributors.setBounds(10, 97, 78, 14);
			contentPanel.add(lblContributors);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
