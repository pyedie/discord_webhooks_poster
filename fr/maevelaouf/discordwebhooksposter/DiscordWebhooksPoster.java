package fr.maevelaouf.discordwebhooksposter;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DiscordWebhooksPoster extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 920209622166125588L;
	
	Container container = getContentPane();
	JLabel webhookLabel = new JLabel("Webhook Link");
	JTextField webhookTextField = new JTextField();
	JLabel titleLabel = new JLabel("Message Title");
	JTextField titleTextField = new JTextField();
	JLabel descriptionLabel = new JLabel("Message");
	JTextField descriptionTextField = new JTextField();
	JLabel footerLabel = new JLabel("Footer");
	JTextField footerTextField = new JTextField();
	JLabel colorLabel = new JLabel("Decimal Color");
	JTextField colorTextField = new JTextField();
	JLabel supportLabel = new JLabel("By Maeve - Support on GitHub (https://github.com/MaeveLaOuf)");
	JButton sendButton = new JButton("SEND");
	
	DiscordWebhooksPoster() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		webhookLabel.setBounds(100, 75, 100, 30);
		webhookTextField.setBounds(200, 75, 475, 30);
		titleLabel.setBounds(100, 125, 100, 30);
		titleTextField.setBounds(200, 125, 475, 30);
		descriptionLabel.setBounds(100, 175, 100, 30);
		descriptionTextField.setBounds(200, 175, 475, 30);
		footerLabel.setBounds(100, 225, 100, 30);
		footerTextField.setBounds(200, 225, 475, 30);
		colorLabel.setBounds(100, 275, 100, 30);
		colorTextField.setBounds(200, 275, 475, 30);
		supportLabel.setBounds(225, 400, 500, 60);
		sendButton.setBounds(0, 510, 800, 50);
	}
	
	public void addComponentsToContainer() {
		container.add(webhookLabel);
		container.add(webhookTextField);
		container.add(titleLabel);
		container.add(titleTextField);
		container.add(descriptionLabel);
		container.add(descriptionTextField);
		container.add(footerLabel);
		container.add(footerTextField);
		container.add(colorLabel);
		container.add(colorTextField);
		container.add(supportLabel);
		container.add(sendButton);
	}
	
	public void addActionEvent() {
		sendButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
			String link = webhookTextField.getText();
			String title = titleTextField.getText();
			String description = descriptionTextField.getText();
			String footer = footerTextField.getText();
			String color = colorTextField.getText();
			
			titleTextField.setText("");
			descriptionTextField.setText("");
			footerTextField.setText("");
			
			System.out.println("Webhook Link : " + link);
			System.out.println("Message Title : " + title);
			System.out.println("Message : " + description);
			System.out.println("Footer : " + footer);
			System.out.println("Color : " + color);
			
			try {
				@SuppressWarnings("unused")
				HTTPRequest discordrequest = new HTTPRequest(link, title, description, footer, color);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(this, "Your message has been successfully sent !");
			
	}
	

	public static void main(String[] args) throws IOException {
		
		DiscordWebhooksPoster poster = new DiscordWebhooksPoster();
		poster.setTitle("DWP - Discord Webhooks Poster");
		poster.setVisible(true);
		poster.setBounds(500, 200, 800, 600);
		poster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		poster.setResizable(false);
		
	}
}
