//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.objects;

import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.sojournercntl.solarflare.util.IPAddress;
import org.sojournercntl.solarflare.util.Ports;

/**
 * SolarScanPortThread
 * @author sojournercntl
 * @version 1.0
 */
public class SolarScanPortThread extends Thread {
	    protected  int currentPort = 0;
	    protected  int foundPorts = 0;
	    protected  int countPorts = 0;      
	    private  ArrayList<Integer> ports;
	    private  ArrayList<Integer>[] list;
	    private SolarScan scan;
	    
	    public SolarScanPortThread (SolarScan scan)
	    {                           
	        this.scan = scan;
	        setPorts();
	        setAdrsList(this.scan.object);     
	    }
	     
	    @SuppressWarnings("unchecked")
		public void setAdrsList(String object)
	    {
	        list = new ArrayList[countPorts];
	        for (int i=0; i<countPorts; i++)
	            list[i] = IPAddress.getIPAddresses(object); 
	    }
	    
	    public void setPorts()
	    {
	        String _ports = scan.PORTS;
	        ports = Ports.getAllPort(_ports);        
	        countPorts = ports.size();
	    }
	    
	    public  void StopScan(){ 
	        currentPort = countPorts * scan.COUNT;
	    }
	    
	    public  boolean isDone(){ 
	        return currentPort == countPorts * scan.COUNT; 
	    } 
	    
	    public  void getNextListElement(int port)
	    {   
	        int index = 0, host = 0;
	        String IPAdr = "";      

	        synchronized (list[port]) 
	        {       
	            while (list[port].isEmpty())
	                try {
	                    list[port].wait();
	                } catch (InterruptedException ie) 
	                {System.out.println(ie.getMessage());}

	            try { 
	                index = list[port].size() - 1;
	                host = list[port].remove(index);  
	                IPAdr = scan.NetAdr + host;
	            } catch (UnsupportedOperationException usoe) 
	              {System.out.println(usoe.getMessage());}
	         
	            if (isDone()) return;
	 
	            if (isPortOpen(IPAdr, ports.get(port)))
	            {    
	                if (isDone()) return;
	                scan.of.AddPort(ports.get(port), scan.COUNT - index -1 , 4);
	                foundPorts++;                 
	            }
	           currentPort++;            
	        }
	    }
	    
	    @SuppressWarnings("rawtypes")
		@Override
	    public void run() {
	            int numWorkers = countPorts;
	              ExecutorService tpes = Executors.newCachedThreadPool();
	              
	            CallableWorker workers[] =
	                new CallableWorker[numWorkers * scan.COUNT];
	            Future futures[] = new Future[numWorkers * scan.COUNT];
	           
	           for (int i = 0; i < numWorkers ; i++)  
	            for (int j = 0; j < scan.COUNT; j++)
	            {
	                try {
	                    workers[i*j] = new CallableWorker(j,i);
	                    futures[i*j] = tpes.submit(workers[i*j]);
	                } catch (Exception e) {
	                    System.out.println(e.getMessage());
	                }
	           }
	         
	           for (int i = 0; i <  numWorkers ; i++)  
	            for (int j = 0; j <  scan.COUNT; j++)           
	            {
	                try {
	                    futures[i*j].get();
	                } catch (Exception e) {
	                    System.out.println(e.getMessage()); 
	                }
	            }     
	            
	            throw new UnsupportedOperationException("Not supported yet.");
	    }
	    
	    public static boolean isPortOpen(String IPAdr, int port)
	    {
	       Socket socket = null;
	       try {
	            socket = new Socket(IPAdr, port);   
	            socket.close();
	       } catch (Exception e) {
	          System.out.println(e.getMessage()); 
	          return false;
	       }    
	       return true;
	    }
	    
	    class CallableWorker implements Callable<Integer> {
	        private int workerNumber, portNumber; 

	        CallableWorker(int number, int port) {
	            workerNumber = number;
	            portNumber = port;
	        }

	        public Integer call() {                   
	            getNextListElement(portNumber);
	            return(workerNumber * portNumber);
	        }    
	    }    
	}
