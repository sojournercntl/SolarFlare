//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.main;

import java.util.Properties;

import javax.swing.UIManager;

import org.sojournercntl.solarflare.userinterface.SolarMainWindow;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

/**
 * Executable Class of the SolarFlare Network Scanner
 * > run the main inside to start the software.
 * @author sojournercntl
 * @version 1.0
 */
public class SolarFlareExecutable {

	public static void main(String args[]) {
		try{
			Properties props = new Properties();
            
            props.put("logoString", "");
			
            HiFiLookAndFeel.setTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}catch(Exception ex){
			ex.printStackTrace();
		}
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolarMainWindow().setVisible(true);
            }
        });
    }
	
}
