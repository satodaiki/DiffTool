package com.company;

import java.io.*;
import java.util.Properties;

public class IniFileLoader {

    private static final String ORIG_FILE = "orig_file";
    private static final String DEST_FILE = "dest_file";
    private static final String INCLUDE_COMMENTS = "include_comments";

    private String origFile;
    private String destFile;
    private String includeComments;

    public String getOrigFile() {
        return origFile;
    }

    public void setOrigFile(String origFile) {
        this.origFile = origFile;
    }

    public String getDestFile() {
        return destFile;
    }

    public void setDestFile(String destFile) {
        this.destFile = destFile;
    }

    public String getIncludeComments() {
        return includeComments;
    }

    public void setIncludeComments(String includeComments) {
        this.includeComments = includeComments;
    }

    public IniFileLoader(String iniFilePath) throws IOException {

        Properties properties = new Properties();

        InputStream istream = new FileInputStream(iniFilePath);
        properties.load(istream);

        origFile = properties.getProperty(ORIG_FILE);
        destFile = properties.getProperty(DEST_FILE);
        includeComments = properties.getProperty(INCLUDE_COMMENTS);
    }
}