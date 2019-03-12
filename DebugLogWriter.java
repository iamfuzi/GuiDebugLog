package com.hie.cloverleaf.util;

import java.io.File;
import java.io.IOException;

import com.hie.cloverleaf.install.ClientInstallPaths;
import com.hie.util.LogWriter;

public class DebugLogWriter {
    
    public static final String LOG_FILE_PATH = ClientInstallPaths.getInstallBaseDir() + File.separator + "debugLog.log";
    
    public static final String LOG_NAME = "debugLog";
    
    static LogWriter writer = null;
    
    static DebugLogWriter instance = null;
    
    public static DebugLogWriter getInstance()
    {
        if(instance != null)
            return instance;
        else
            return new DebugLogWriter();       
    }
    
    
    public static void log(String msg)
    {
        try {
            getInstance().getLogWriter().logWarningMessage(msg);
			System.out.println("test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public LogWriter getLogWriter() throws IOException
    {
        if(null == writer)
            writer = LogWriter.log(LOG_FILE_PATH, LOG_NAME);
        return writer;
    }
    
}
