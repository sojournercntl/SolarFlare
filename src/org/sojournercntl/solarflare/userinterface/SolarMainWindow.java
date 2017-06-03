//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.userinterface;

import org.sojournercntl.solarflare.util.*;
import org.sojournercntl.image.Imagehelper;
import org.sojournercntl.solarflare.components.SolarMenuWindow;
import org.sojournercntl.solarflare.objects.*;
import java.util.Enumeration;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.border.TitledBorder;

/**
 * SolarMainWindow
 * @author sojournercntl
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SolarMainWindow extends javax.swing.JFrame {

    @SuppressWarnings("rawtypes")
	public static DefaultListModel objectModel;
    
    public SolarObjectFrame of;

    /** Creates new form MainFrame */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public SolarMainWindow() {
    	
    	try{
    		BufferedImage image=ImageIO.read(new File("ResFiles\\SolarFlareLogo.png"));
            BufferedImage resizedImage=Imagehelper.resize(image,100,100);
            this.setIconImage(resizedImage);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	
        initComponents();
        objectModel = new DefaultListModel();  
        jListObjects.setModel(objectModel); 
        
        ShowWelcome();
    }

	private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jMenuItemShow = new javax.swing.JMenuItem();
        jMenuItemHide = new javax.swing.JMenuItem();
        jMenuItemRemove = new javax.swing.JMenuItem();
        jToolBar = new javax.swing.JToolBar();
        jBtnLocalMachine = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jBtnAddObject = new javax.swing.JButton();
        jBtnRemoveObject = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSplitPane = new javax.swing.JSplitPane();
        jScrollPaneObjects = new javax.swing.JScrollPane();
        jListObjects = new javax.swing.JList();
        jScrollPaneRight = new javax.swing.JScrollPane();
        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar = new javax.swing.JMenuBar();
        jFileMenu = new javax.swing.JMenu();
        jExitMenuItem = new javax.swing.JMenuItem();
        jObjectsMenu = new javax.swing.JMenu();
        jLMMenuItem = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JSeparator();
        jAOMenuItem = new javax.swing.JMenuItem();
        jROMenuItem = new javax.swing.JMenuItem();
        jSOMenuItem = new javax.swing.JMenuItem();
        jHOMenuItem = new javax.swing.JMenuItem();
        jMenuIPAddress = new javax.swing.JMenu();
        jMenuItemPing = new javax.swing.JMenuItem();
        jMenuItemTrace = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuBrowse = new javax.swing.JMenu();
        jMenuItemExplore = new javax.swing.JMenuItem();
        jMenuItemHttp = new javax.swing.JMenuItem();
        jMenuItemFTP = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuItemMsg = new javax.swing.JMenuItem();
        jAboutMenu = new javax.swing.JMenu();
        jAboutMenuItem = new javax.swing.JMenuItem();

        jMenuItemShow.setText("Show");
        jMenuItemShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemShowActionPerformed1(evt);
            }
        });
        jPopupMenu.add(jMenuItemShow);

        jMenuItemHide.setText("Hide");
        jMenuItemHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHideActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemHide);

        jMenuItemRemove.setText("Remove");
        jMenuItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoveActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemRemove);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SolarFlare 1.0 Alpha");
        setBounds(new java.awt.Rectangle(100, 100, 0, 0));

        jToolBar.setRollover(true);

        jBtnLocalMachine.setText("Local Machine");
        jBtnLocalMachine.setFocusable(false);
        jBtnLocalMachine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnLocalMachine.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnLocalMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLocalMachineActionPerformed(evt);
            }
        });
        jToolBar.add(jBtnLocalMachine);
        jToolBar.add(jSeparator1);

        jBtnAddObject.setText("Start Scan");
        jBtnAddObject.setFocusable(false);
        jBtnAddObject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnAddObject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnAddObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddObjectActionPerformed(evt);
            }
        });
        jToolBar.add(jBtnAddObject);

        jBtnRemoveObject.setText("Remove Scan");
        jBtnRemoveObject.setFocusable(false);
        jBtnRemoveObject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnRemoveObject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnRemoveObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoveObjectActionPerformed(evt);
            }
        });
        jToolBar.add(jBtnRemoveObject);
        jToolBar.add(jSeparator2);

        jButton1.setText("About");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar.add(jButton1);

        jSplitPane.setDividerLocation(150);
        jSplitPane.setDividerSize(8);
        jSplitPane.setOneTouchExpandable(true);

        jScrollPaneObjects.setBorder(new TitledBorder(null, "Scans", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        jListObjects.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListObjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListObjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListObjectsMouseClicked(evt);
            }
        });
        jListObjects.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jListObjectsKeyPressed(evt);
            }
        });
        jScrollPaneObjects.setViewportView(jListObjects);

        jSplitPane.setLeftComponent(jScrollPaneObjects);

        jScrollPaneRight.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPaneRight.setMinimumSize(new java.awt.Dimension(80, 80));
        jScrollPaneRight.setPreferredSize(new java.awt.Dimension(40, 40));
        jScrollPaneRight.setViewportView(jDesktopPane);

        jSplitPane.setRightComponent(jScrollPaneRight);

        jFileMenu.setText("File");

        jExitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jExitMenuItem.setText("Exit");
        jExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        
        mntmShowWelcomeScreen = new JMenuItem("Welcome Screen\r\n");
        jFileMenu.add(mntmShowWelcomeScreen);
        jFileMenu.add(jExitMenuItem);

        jMenuBar.add(jFileMenu);

        jObjectsMenu.setText("Objects");

        jLMMenuItem.setText("Local Machine");
        jLMMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLMMenuItemActionPerformed(evt);
            }
        });
        jObjectsMenu.add(jLMMenuItem);
        jObjectsMenu.add(jSeparator);

        jAOMenuItem.setText("Add Object");
        jAOMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAOMenuItemActionPerformed(evt);
            }
        });
        jObjectsMenu.add(jAOMenuItem);

        jROMenuItem.setText("Remove Object");
        jROMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jROMenuItemActionPerformed(evt);
            }
        });
        jObjectsMenu.add(jROMenuItem);

        jSOMenuItem.setText("Show Object");
        jSOMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSOMenuItemActionPerformed(evt);
            }
        });
        jObjectsMenu.add(jSOMenuItem);

        jHOMenuItem.setText("Hide Object");
        jHOMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHOMenuItemActionPerformed(evt);
            }
        });
        jObjectsMenu.add(jHOMenuItem);

        jMenuBar.add(jObjectsMenu);

        jMenuIPAddress.setText("IP Address");
        jMenuIPAddress.setEnabled(false);

        jMenuItemPing.setText("Ping");
        jMenuItemPing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPingActionPerformed(evt);
            }
        });
        jMenuIPAddress.add(jMenuItemPing);

        jMenuItemTrace.setText("Trace route");
        jMenuItemTrace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTraceActionPerformed(evt);
            }
        });
        jMenuIPAddress.add(jMenuItemTrace);
        jMenuIPAddress.add(jSeparator3);

        jMenuBrowse.setText("Browse");

        jMenuItemExplore.setText("Shared Ressources");
        jMenuItemExplore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExploreActionPerformed(evt);
            }
        });
        jMenuBrowse.add(jMenuItemExplore);

        jMenuItemHttp.setText("as Http Server");
        jMenuItemHttp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHttpActionPerformed(evt);
            }
        });
        jMenuBrowse.add(jMenuItemHttp);

        jMenuItemFTP.setText("as FTP Server");
        jMenuItemFTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFTPActionPerformed(evt);
            }
        });
        jMenuBrowse.add(jMenuItemFTP);

        jMenuIPAddress.add(jMenuBrowse);
        jMenuIPAddress.add(jSeparator4);

        jMenuItemMsg.setText("Send Message");
        jMenuItemMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMsgActionPerformed(evt);
            }
        });
        jMenuIPAddress.add(jMenuItemMsg);

        jMenuBar.add(jMenuIPAddress);

        jAboutMenu.setText("About");

        jAboutMenuItem.setText("About SolarFlare");
        jAboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jAboutMenu.add(jAboutMenuItem);

        jMenuBar.add(new SolarMenuWindow(jDesktopPane));

        jMenuBar.add(jAboutMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addComponent(jSplitPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jBtnAddObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddObjectActionPerformed
        SolarAddScan.main(null);
}//GEN-LAST:event_jBtnAddObjectActionPerformed

    private void jBtnLocalMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLocalMachineActionPerformed
        ShowLocalMachineFrame();
}//GEN-LAST:event_jBtnLocalMachineActionPerformed

    private void jBtnRemoveObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoveObjectActionPerformed
        RemoveObject();
}//GEN-LAST:event_jBtnRemoveObjectActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        SolarAbout.main(null);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItemShowActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemShowActionPerformed1
        ShowObjectFrame();
}//GEN-LAST:event_jMenuItemShowActionPerformed1

    private void jMenuItemHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHideActionPerformed
        HideObjectFrame();
    }//GEN-LAST:event_jMenuItemHideActionPerformed

    private void jMenuItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoveActionPerformed
        RemoveObject();
    }//GEN-LAST:event_jMenuItemRemoveActionPerformed

    private void jLMMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLMMenuItemActionPerformed
        ShowLocalMachineFrame();
    }//GEN-LAST:event_jLMMenuItemActionPerformed

    private void jAOMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAOMenuItemActionPerformed
        SolarAddScan.main(null);
    }//GEN-LAST:event_jAOMenuItemActionPerformed

    private void jROMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jROMenuItemActionPerformed
        RemoveObject();
    }//GEN-LAST:event_jROMenuItemActionPerformed

    private void jSOMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSOMenuItemActionPerformed
        ShowObjectFrame();
    }//GEN-LAST:event_jSOMenuItemActionPerformed

    private void jHOMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHOMenuItemActionPerformed
        HideObjectFrame();
    }//GEN-LAST:event_jHOMenuItemActionPerformed

    private void jMenuItemPingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPingActionPerformed
        of.ExecuteCmd("Ping ", of.getSelectedAdr());
    }//GEN-LAST:event_jMenuItemPingActionPerformed

    private void jMenuItemTraceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTraceActionPerformed
        of.ExecuteCmd("Tracert ", of.getSelectedAdr());
    }//GEN-LAST:event_jMenuItemTraceActionPerformed

    private void jMenuItemExploreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExploreActionPerformed
        of.ExecuteProcess("explorer \\\\" + of.getSelectedAdr() + "\\");
    }//GEN-LAST:event_jMenuItemExploreActionPerformed

    private void jMenuItemHttpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHttpActionPerformed
        of.ExecuteProcess("explorer http://" + of.getSelectedAdr() + "/");
    }//GEN-LAST:event_jMenuItemHttpActionPerformed

    private void jMenuItemFTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFTPActionPerformed
        of.ExecuteProcess("explorer ftp://" + of.getSelectedAdr() + "/");
    }//GEN-LAST:event_jMenuItemFTPActionPerformed

    private void jMenuItemMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMsgActionPerformed
        String msg = JOptionPane.showInputDialog(SolarMainWindow.this,
                "Type the message you want to send ");
        if (msg == null) return;
        of.ExecuteProcess("net send " + of.getSelectedAdr() + " " + msg);
    }//GEN-LAST:event_jMenuItemMsgActionPerformed

    private void jListObjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListObjectsMouseClicked
       if (evt.getButton() == MouseEvent.BUTTON3)  // Right Mouse Click
            ShowObjectsPopupMenu(evt.getX(), evt.getY());
        if (evt.getClickCount() == 2)   // Double Mouse Click
            ShowObjectFrame();
}//GEN-LAST:event_jListObjectsMouseClicked

    private void jListObjectsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListObjectsKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_DELETE) // Pressing Del buttom
            RemoveObject();
        if (key == KeyEvent.VK_ENTER) // Pressing Enter buttom
            ShowObjectFrame();
}//GEN-LAST:event_jListObjectsKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SolarAbout.main(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void ShowWelcome(){
    	
    	Solar_Welcome welcome = new Solar_Welcome(this);
    	welcome.setVisible(true);
    	jDesktopPane.add(welcome);
    	try {
            welcome.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    
    public void AddObjectFrame(String title)
    {
        of = new SolarObjectFrame(title, this); 
        of.setTitle(title);
        of.setVisible(true);
        jDesktopPane.add(of);
        try {
            of.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}             
    }
    
    public void AddLocalMachineFrame()
    {
    	SolarLocalFrame lm = new SolarLocalFrame(); 
        lm.setVisible(true);
        jDesktopPane.add(lm);
        try {
            lm.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}      
    }
    
    public void ShowLocalMachineFrame()
    {  
        String object = "Local Machine";
        for (JInternalFrame frame : jDesktopPane.getAllFrames())
            if (frame.getTitle().equals(object))
            {
                try {
                    frame.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {return;}             
                return; 
            }
        AddLocalMachineFrame();
    }

    public void ShowObjectFrame()
    {
        String object = getSelectedElement(jListObjects);
        if (!IPAddress.validObject(object)) return;
        for (JInternalFrame frame : jDesktopPane.getAllFrames())
            if (frame.getTitle().equals(object))
            {
                try {
                    frame.setSelected(true);                 
                } catch (java.beans.PropertyVetoException e) {return;}    
                return;
            }
        AddObjectFrame(object);        
    }
    
    public void HideObjectFrame()
    {
        String object = getSelectedElement(jListObjects);
        for (JInternalFrame frame : jDesktopPane.getAllFrames())
            if (frame.getTitle().equals(object))
                try
                {
                    frame.setClosed(true);
                } catch (java.beans.PropertyVetoException e) {}        
    }
    
    public void RemoveObject()
    {
        String object = getSelectedElement(jListObjects);
        if (object == null) return;     
        if (!IPAddress.validObject(object)) return;
        
        int choise = JOptionPane.showConfirmDialog(SolarMainWindow.this, 
            "Are you sure you want to delete " + object + "?", "Delete Object", 
            JOptionPane.OK_CANCEL_OPTION );
        if (choise != JOptionPane.OK_OPTION) return;
        
        HideObjectFrame();
        
        objectModel.remove(jListObjects.getSelectedIndex());            
        SolarObjectList.removeObject(object);
    }
    
    public static Vector getElements(DefaultListModel model)
    {       
        Enumeration enumeration = model.elements();
        Vector<String> vector = new Vector<String>();
        while (enumeration.hasMoreElements())
            vector.add(enumeration.nextElement().toString());
        return vector;
    } 
 
    public static void AddNewElement(JList list, DefaultListModel model, String object)
    {
        model.addElement(object);
        list.requestFocus();
    }
    
    public void ShowObjectsPopupMenu(int x, int y)
    {
        // Get mouse posiiton
        jListObjects.getCellBounds(x, x);
            
        // Show Popup Menu at the selected item
        String object = getSelectedElement(jListObjects);
        if (!IPAddress.validObject(object)) return;
        jPopupMenu.show(jListObjects, x, y);        
    }              
    
    public static String getSelectedElement(JList list)
    {
        try {
            return list.getSelectedValue().toString();        
        }
        catch (Exception e)
        {
            return "";
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAOMenuItem;
    private javax.swing.JMenu jAboutMenu;
    private javax.swing.JMenuItem jAboutMenuItem;
    private javax.swing.JButton jBtnAddObject;
    private javax.swing.JButton jBtnLocalMachine;
    private javax.swing.JButton jBtnRemoveObject;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenuItem jExitMenuItem;
    private javax.swing.JMenu jFileMenu;
    private javax.swing.JMenuItem jHOMenuItem;
    private javax.swing.JMenuItem jLMMenuItem;
    public static javax.swing.JList jListObjects;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuBrowse;
    public javax.swing.JMenu jMenuIPAddress;
    private javax.swing.JMenuItem jMenuItemExplore;
    private javax.swing.JMenuItem jMenuItemFTP;
    private javax.swing.JMenuItem jMenuItemHide;
    private javax.swing.JMenuItem jMenuItemHttp;
    private javax.swing.JMenuItem jMenuItemMsg;
    private javax.swing.JMenuItem jMenuItemPing;
    private javax.swing.JMenuItem jMenuItemRemove;
    private javax.swing.JMenuItem jMenuItemShow;
    private javax.swing.JMenuItem jMenuItemTrace;
    private javax.swing.JMenu jObjectsMenu;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JMenuItem jROMenuItem;
    private javax.swing.JMenuItem jSOMenuItem;
    private javax.swing.JScrollPane jScrollPaneObjects;
    private javax.swing.JScrollPane jScrollPaneRight;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JToolBar jToolBar;
    private JMenuItem mntmShowWelcomeScreen;
    // End of variables declaration//GEN-END:variables
}
