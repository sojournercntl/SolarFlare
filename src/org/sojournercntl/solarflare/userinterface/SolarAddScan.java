//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.userinterface;

import javax.swing.JOptionPane;

import org.sojournercntl.solarflare.objects.SolarObjectList;
import org.sojournercntl.solarflare.util.IPAddress;
import org.sojournercntl.solarflare.util.Ports;
import org.sojournercntl.solarflare.util.SolarUtility;

/**
 * SolarAddScan Dialog
 * @author sojournercntl
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SolarAddScan extends javax.swing.JDialog {
    
    /** Creates new form AddObjectDialog */
    public SolarAddScan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private void initComponents() {

    	setIconImage(null);
    	
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldReachNetInter = new javax.swing.JTextField();
        jTextFieldPorts = new javax.swing.JTextField();
        jTextFieldtimeout = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldObject = new javax.swing.JTextField();
        jBtnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add new object");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Scan options"));

        jLabel1.setText("Scan throw this network interface:");

        jLabel2.setText("Check open ports:");

        jLabel3.setText("Ping timeout (ms):");

        jTextFieldReachNetInter.setText("192.168.1.3");

        jTextFieldPorts.setText("21 23 80 445");

        jTextFieldtimeout.setText("3000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(jTextFieldtimeout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jTextFieldPorts, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldReachNetInter, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldReachNetInter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldtimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPorts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Object to scan"));

        jTextFieldObject.setText("192.168.1.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jTextFieldObject, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTextFieldObject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnOk.setText("Add");
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        if (checkFeilds()) {
            SolarMainWindow.AddNewElement(
            		SolarMainWindow.jListObjects, 
            		SolarMainWindow.objectModel, 
                    jTextFieldObject.getText());
            SolarObjectList.AddNewObject(new String[] {
                    jTextFieldObject.getText(),
                    jTextFieldReachNetInter.getText(),
                    jTextFieldtimeout.getText(),
                    jTextFieldPorts.getText()});
            this.dispose();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SolarAddScan dialog = new SolarAddScan(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }
    
    public boolean checkFeilds()
    {
        // one instance of object is allowed in the list
         if (SolarMainWindow.getElements(SolarMainWindow.objectModel).indexOf(jTextFieldObject.getText()) != -1)
        {
            JOptionPane.showMessageDialog(null, "Object already  exists !!");
            jTextFieldObject.selectAll();
            jTextFieldObject.setFocusable(true);
            return false;
        }       
        
        // IP Validation check 
        if (!IPAddress.validObject(jTextFieldObject.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Invalid Object !!");
            jTextFieldObject.selectAll();
            jTextFieldObject.setFocusable(true);
            return false;
        }  
         
        // IP Validation check 
        if (!IPAddress.validIPAddress(jTextFieldReachNetInter.getText())) 
        {
            JOptionPane.showMessageDialog(null, "Invalid IP Adresse !!");
            jTextFieldReachNetInter.selectAll();
            jTextFieldReachNetInter.setFocusable(true);            
            return false;
        }           
        
         // valid time out
        int timeout = SolarUtility.StrToInt(jTextFieldtimeout.getText());
        if (timeout <= -1)
        {    
            JOptionPane.showMessageDialog(null, "Invalid Time out !!");
            jTextFieldtimeout.selectAll();
            jTextFieldtimeout.setFocusable(true);            
            return false;            
        }
        
        // valid port range
        if (!Ports.validPort(jTextFieldPorts.getText()))
        {    
            JOptionPane.showMessageDialog(null, "Invalid port range !!");
            jTextFieldPorts.selectAll();
            jTextFieldPorts.setFocusable(true);            
            return false;            
        }   
        return true;
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldObject;
    private javax.swing.JTextField jTextFieldPorts;
    private javax.swing.JTextField jTextFieldReachNetInter;
    private javax.swing.JTextField jTextFieldtimeout;
    // End of variables declaration//GEN-END:variables
    
}
