//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.userinterface;


import org.sojournercntl.solarflare.util.NetInterfaces;
import org.sojournercntl.solarflare.util.SolarUtility;

import javax.swing.SwingWorker;

/**
 * SolarLocalMachine Frame
 * @author sojournercntl
 * @version 1.0
 */
public class SolarLocalFrame extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7599422347261536824L;
	/** Creates new form LocalMachineFrame */
    public SolarLocalFrame() {
        initComponents();
        InitialNetInteslList();
        getData();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelBasic = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListNetInters = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListNetInterData = new javax.swing.JList();
        jPanelIP = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaIPConfig = new javax.swing.JTextArea();
        jPanelRoute = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaRouteTable = new javax.swing.JTextArea();
        jPanelTCP = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaTCP = new javax.swing.JTextArea();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Local Machine");

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Network Devices"));

        jListNetInters.setFont(new java.awt.Font("Tahoma", 0, 12));
        jListNetInters.setModel(new javax.swing.AbstractListModel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -184699687645909498L;
			String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListNetInters.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListNetIntersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListNetInters);

        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Additional Information"));

        jListNetInterData.setFont(new java.awt.Font("Tahoma", 0, 12));
        jListNetInterData.setModel(new javax.swing.AbstractListModel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 850429235663093319L;
			String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListNetInterData);

        javax.swing.GroupLayout jPanelBasicLayout = new javax.swing.GroupLayout(jPanelBasic);
        jPanelBasic.setLayout(jPanelBasicLayout);
        jPanelBasicLayout.setHorizontalGroup(
            jPanelBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBasicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelBasicLayout.setVerticalGroup(
            jPanelBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBasicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Basic", jPanelBasic);

        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("IP Configuration"));

        jTextAreaIPConfig.setColumns(20);
        jTextAreaIPConfig.setEditable(false);
        jTextAreaIPConfig.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextAreaIPConfig.setRows(5);
        jScrollPane3.setViewportView(jTextAreaIPConfig);

        javax.swing.GroupLayout jPanelIPLayout = new javax.swing.GroupLayout(jPanelIP);
        jPanelIP.setLayout(jPanelIPLayout);
        jPanelIPLayout.setHorizontalGroup(
            jPanelIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelIPLayout.setVerticalGroup(
            jPanelIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("IP Configuration", jPanelIP);

        jScrollPane4.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Routing Table"));

        jTextAreaRouteTable.setColumns(20);
        jTextAreaRouteTable.setEditable(false);
        jTextAreaRouteTable.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextAreaRouteTable.setRows(5);
        jScrollPane4.setViewportView(jTextAreaRouteTable);

        javax.swing.GroupLayout jPanelRouteLayout = new javax.swing.GroupLayout(jPanelRoute);
        jPanelRoute.setLayout(jPanelRouteLayout);
        jPanelRouteLayout.setHorizontalGroup(
            jPanelRouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRouteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelRouteLayout.setVerticalGroup(
            jPanelRouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRouteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Routing Table", jPanelRoute);

        jScrollPane5.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("TCP Infos & Stats"));

        jTextAreaTCP.setColumns(20);
        jTextAreaTCP.setEditable(false);
        jTextAreaTCP.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextAreaTCP.setRows(5);
        jTextAreaTCP.setBorder(null);
        jScrollPane5.setViewportView(jTextAreaTCP);

        javax.swing.GroupLayout jPanelTCPLayout = new javax.swing.GroupLayout(jPanelTCP);
        jPanelTCP.setLayout(jPanelTCPLayout);
        jPanelTCPLayout.setHorizontalGroup(
            jPanelTCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTCPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTCPLayout.setVerticalGroup(
            jPanelTCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTCPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("TCP Infos & Stats", jPanelTCP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListNetIntersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListNetIntersValueChanged
        ShowNetIntersData();
}//GEN-LAST:event_jListNetIntersValueChanged

    /** Find local network interface devices */
    @SuppressWarnings("unchecked")
	public void InitialNetInteslList()
    {
        try {
            jListNetInters.setListData(NetInterfaces.getListNetIntesNames());
        } catch (Exception e) {}        
    }
    
    /** Display data of selected network interface */
    @SuppressWarnings("unchecked")
	public void ShowNetIntersData()
    {
        try {
            int index = jListNetInters.getSelectedIndex();
            jListNetInterData.setListData(NetInterfaces.getNetInteDataByIndex(index));
        } catch (Exception e) {}           
    }
    
    /** Execute commands and get back output result to textarea components */
    public void getData()
    {  
        new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {  
                jTabbedPane1.setTitleAt(3, "TCP Infos & Stats [Loading ...]");
                SolarUtility.executeCmd(jTextAreaTCP, "netstat -a");    
                jTabbedPane1.setTitleAt(3, "TCP Infos & Stats");
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }.execute(); 
        
        new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {   
                jTabbedPane1.setTitleAt(1, "IP Configuration [Loading ...]");                
                SolarUtility.executeCmd(jTextAreaIPConfig, "ipconfig /all");    
                jTabbedPane1.setTitleAt(1, "IP Configuration");                
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }.execute(); 
        
        new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {  
                jTabbedPane1.setTitleAt(2, "Routing Table [Loading ...]");
                SolarUtility.executeCmd(jTextAreaRouteTable, "route print"); 
                jTabbedPane1.setTitleAt(2, "Routing Table");
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }.execute();     
    }  
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    @SuppressWarnings("rawtypes")
	private javax.swing.JList jListNetInterData;
    @SuppressWarnings("rawtypes")
	private javax.swing.JList jListNetInters;
    private javax.swing.JPanel jPanelBasic;
    private javax.swing.JPanel jPanelIP;
    private javax.swing.JPanel jPanelRoute;
    private javax.swing.JPanel jPanelTCP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaIPConfig;
    private javax.swing.JTextArea jTextAreaRouteTable;
    private javax.swing.JTextArea jTextAreaTCP;
    // End of variables declaration//GEN-END:variables
}
