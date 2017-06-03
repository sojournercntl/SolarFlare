//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.objects;

/**
 * SolarUpdaterThread
 * @author sojournercntl
 * @version 1.0
 */
public class SolarScanUpdateThread extends Thread{
	
    private long timeInMillisnow, timeHostEstim, timePortEstim, timeDiff;
    private boolean ScanPortsRunning = true, ScanHostsRunning = true;
    private SolarScan scan;
    
    public SolarScanUpdateThread(SolarScan scan)
    {
        this.scan = scan;
    }
    
    @Override
    public void run(){
        
            long timeInMillis = System.currentTimeMillis();

            while (!scan.isDone())
            {    
                try {Thread.sleep(500);} catch (InterruptedException ie)  
                        {System.out.println(ie.getMessage());}  
                
                timeInMillisnow = System.currentTimeMillis();
                timeDiff = (timeInMillisnow - timeInMillis);

                if (ScanPortsRunning) UpdatePorts();
                if (ScanHostsRunning) UpdateHosts();  
            }  
            
            scan.of.done();
            throw new UnsupportedOperationException("Not supported yet.");
   }     
        
        public void UpdatePorts()
        {
           timePortEstim = scan.sp.countPorts * 
                scan.COUNT * timeDiff / (scan.sp.currentPort + 1);  
                
            scan.of.UpdatePortsInofs((int) timeDiff, (int) timePortEstim, 
                scan.sp.currentPort,
                scan.sp.foundPorts,
                scan.sp.countPorts * scan.COUNT);  
            ScanPortsRunning = !scan.sp.isDone(); 
        }
        
        public void UpdateHosts()
        {
            timeHostEstim = scan.COUNT * timeDiff / (scan.so.currentHost + 1);             
            
            scan.of.UpdateHostsInofs((int) timeDiff, (int) timeHostEstim, 
                scan.so.currentHost, 
                scan.so.foundHosts, 
                scan.COUNT);  
            ScanHostsRunning = !scan.so.isDone();
        }
}
