//
// Copyright (c) Sojournercntl 2016/17. All rights reserved.  
// See LICENSE file in the project root for full license information.
//
package org.sojournercntl.solarflare.objects;

import java.util.ArrayList;

/**
 * SolarObjectList
 * Contains the scans.
 * @author sojournercntl
 * @version 1.0
 */
public class SolarObjectList {
    
    private static ArrayList<String[]> objectsList = new ArrayList<String[]>();
    
    public static void AddNewObject(String[] args)
    {
        objectsList.add(new String[]{args[0], args[1], args[2], args[3]});
    }
    
    public static String[] getObject(String object)
    {
        for (int i=0; i< objectsList.size(); i++)
            if (objectsList.get(i)[0].equals(object))
                return objectsList.get(i);
        return null;
    }
    
    public static void removeObject(String object)
    {
        for (int i=0; i< objectsList.size(); i++)
            if (objectsList.get(i)[0].equals(object))
                objectsList.remove(i);        
    }
};
