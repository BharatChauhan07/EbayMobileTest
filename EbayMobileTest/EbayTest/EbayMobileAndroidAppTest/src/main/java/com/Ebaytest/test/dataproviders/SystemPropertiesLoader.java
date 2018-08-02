package com.cigniti.test.dataproviders;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SystemPropertiesLoader {
    protected Properties properties;
    protected String propertiesFileName;

    public SystemPropertiesLoader(String propertiesFileName) throws IOException {
        this.propertiesFileName = propertiesFileName;
        loadProperties();
    }

    public String getProperty(String key) throws IOException {

        return properties.getProperty(key);
    }

    private void loadProperties() throws IOException {

        properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName));
        properties = appendCustomProperties(properties);
    }

    private Properties appendCustomProperties(Properties properties) throws IOException {
        Properties userDefined = new Properties();
        String fullFilePath;
        for (String path: getClassPathDirs()) {
            if( containsPropertiesFile(path) ) {
                fullFilePath = path + System.getProperty("file.separator") + propertiesFileName;
                InputStream is = new FileInputStream(fullFilePath);
                userDefined.load(is);
                break;
            }
        }
        Properties merged = new Properties();
        merged.putAll(properties);
        merged.putAll(userDefined);
        return merged;
    }

    private boolean containsPropertiesFile(String path) {
        if ( path.contains("classes") ) {
            File f = new File(path, propertiesFileName);
            return f.exists();
        }
        else return false;
    }

    private List<String> getClassPathDirs() {
        return Arrays.asList(System.getProperty("java.class.path").split(System.getProperty("path.separator")));
    }

}
