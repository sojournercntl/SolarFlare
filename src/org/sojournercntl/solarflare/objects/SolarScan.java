//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.objects;

import org.sojournercntl.solarflare.userinterface.SolarObjectFrame;
import org.sojournercntl.solarflare.util.IPAddress;

/**
 * SolarScan
 * @author sojournercntl
 * @version 1.0
 */
public class SolarScan {
    
    public SolarScanThread so;
    public SolarScanPortThread sp; 
    public SolarScanUpdateThread su;

    public int TIMEOUT = 3000; 
    public int COUNT = 0;
    public String PORTS = "21 23 80 445"; 
    public String ReachNetInter = "127.0.0.1";
    public String object = "127.0.0.1";
    public String NetAdr = "127.0.0.";   
    
    //Frame (object frame)
    public SolarObjectFrame of;
    
    private Boolean running = false;

    public SolarScan(SolarObjectFrame of, String[] args)
    {
        this.of = of;
        IntitialScan(
            String.valueOf(args[0]),
            String.valueOf(args[1]),
            String.valueOf(args[2]),
            String.valueOf(args[3]));  
    }
    
    public void IntitialScan(String object, String ReachAdr, String timeout, String ports)
    {
        this.object = object;
        this.ReachNetInter = ReachAdr;
        this.TIMEOUT = Integer.valueOf(timeout);
        this.PORTS = ports;
        this.NetAdr = IPAddress.getNetAdrPart(object);        
        this.COUNT = 1 + IPAddress.getLastAdrHost(object) - 
                IPAddress.getFirstAdrHost(object);   
        sp = new SolarScanPortThread(this);       
        so = new SolarScanThread(this);       
        su = new SolarScanUpdateThread(this); 
        of.InitialTableData(this.NetAdr, so.list, this.COUNT);           
    } 
    
    public  void Stop()
    {
        so.StopScan();   
        sp.StopScan();  
    }
    
    public  boolean isDone()
    {
        running = !(so.isDone() && sp.isDone());
        return so.isDone() && sp.isDone();
    }
    
    public  boolean isRunning()
    {
        return running;
    }    
}
