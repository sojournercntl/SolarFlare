//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Solar Ports
 * @author sojournercntl
 * @version 1.0
 */
public class Ports {

    /** Get list of ports from given string */  
    public static ArrayList<Integer> getAllPort(String object) {
        ArrayList<Integer> _ports = new ArrayList<Integer>();
        String value = "";
        int FirstPort = 0, LastPort = 0, count = 0;
        StringTokenizer st = new StringTokenizer(object, " ");
        while (st.hasMoreTokens()){
            value = st.nextToken();
            FirstPort = getFirstPort(value); 
            LastPort = getLastPort(value);
            count = LastPort - FirstPort + 1;                 
            for(int i=count; i>0; i--)
                _ports.add(i+FirstPort-1);         
        }
        return _ports;
    }
    
    /** Return true if the specifit text contain valid ports*/
    public static boolean validPort(String object) {
        if (object == null) return false;
        StringTokenizer st = new StringTokenizer(object, " ");
        while (st.hasMoreTokens()){
                String value = st.nextToken();
                if (!validPortRang(value)) break;
        }
        return true;
    }
    
    /** Return true if the specific text contain valid port range*/
    public static boolean validPortRang(String object) {
        if (object == null) return false;
        int FirstPort, LastPort;
      
        int sprpos = object.indexOf("-");
        if (sprpos != -1) {
            FirstPort = SolarUtility.StrToInt(object.substring(0, sprpos)); 
            LastPort = SolarUtility.StrToInt(object.substring(sprpos + 1));               
        }
        else 
            FirstPort = LastPort =  SolarUtility.StrToInt(object);     

        return (FirstPort != -1) && (LastPort != -1) && (LastPort >= FirstPort); 
    }  
    
    /** Get first port number from port range */
    public static int getFirstPort(String object){
        if (object == null) return -1;
        int FirstInt = 0;
      
        int sprpos = object.indexOf("-");
        if (sprpos != -1)
            FirstInt = SolarUtility.StrToInt(object.substring(0, sprpos));               
        else 
            FirstInt = SolarUtility.StrToInt(object);           
        return FirstInt;
    }

    /** Get last port number from port range */
    public static int getLastPort(String object){
        if (object == null) return -1;
        int LastInt = 0;
      
        int sprpos = object.indexOf("-");
        if (sprpos != -1)
            LastInt = SolarUtility.StrToInt(object.substring(sprpos + 1));               
        else 
                LastInt = SolarUtility.StrToInt(object);         
        return LastInt;        
    }        
}
