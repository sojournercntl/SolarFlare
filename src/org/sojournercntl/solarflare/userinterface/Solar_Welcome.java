//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.userinterface;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;

import org.sojournercntl.image.Imagehelper;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Solar_Welcome Frame
 * @author sojournercntl
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Solar_Welcome extends JInternalFrame {

	private SolarMainWindow window;
	/**
	 * Create the frame.
	 */
	public Solar_Welcome(SolarMainWindow xwin) {
		
		this.window = xwin;
		setTitle("Welcome "+System.getProperty("user.name"));
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 331);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][]"));
		setFrameIcon(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 24));
		getContentPane().add(lblWelcome, "cell 0 0,alignx center");
		
		JLabel lbl_icon = new JLabel("");
		
		try{
    		BufferedImage image=ImageIO.read(new File("ResFiles\\SolarFlareLogo.png"));
            BufferedImage resizedImage=Imagehelper.resize(image,100,100);
            lbl_icon.setIcon(new ImageIcon(resizedImage));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
		
		
		getContentPane().add(lbl_icon, "cell 0 1,alignx center");
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(400, 250));
		panel_4.setMaximumSize(new Dimension(9999, 250));
		getContentPane().add(panel_4, "cell 0 2,grow");
		panel_4.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JPanel panel = new JPanel();
		panel_4.add(panel, "cell 0 0,grow");
		//panel.setMaximumSize(new Dimension(600, 500));
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Select operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JButton btn_showLocal = new JButton("Show local host information");
		btn_showLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				window.ShowLocalMachineFrame();
			}
		});
		panel_1.add(btn_showLocal, "name_174478770347285");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JButton btnScanATarget = new JButton("Scan a target");
		btnScanATarget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolarAddScan.main(null);
			}
		});
		panel_2.add(btnScanATarget, "name_174473036433003");
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JButton btnAboutSolarFlare = new JButton("About Solar Flare");
		btnAboutSolarFlare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolarAbout.main(null);
			}
		});
		panel_3.add(btnAboutSolarFlare, "name_174484714096136");
		
		JLabel lblSolarFlareDevloped = new JLabel("Solar Flare devloped by Sojournercntl. All rights reserved!");
		lblSolarFlareDevloped.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblSolarFlareDevloped.setForeground(new Color(0, 191, 255));
		getContentPane().add(lblSolarFlareDevloped, "cell 0 3,alignx center");

	}

}
