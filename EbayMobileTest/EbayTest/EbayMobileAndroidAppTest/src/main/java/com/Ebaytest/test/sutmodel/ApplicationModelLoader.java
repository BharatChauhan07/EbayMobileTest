package com.cigniti.test.sutmodel;

import com.cigniti.test.exceptions.ScreenElementNotFoundException;

import java.io.*;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

public class ApplicationModelLoader {

    private Path modelBasePath;
    private Path screenListFile = FileSystems.getDefault().getPath("screen-list.properties");

    public ApplicationModelLoader(String basePath) {
        this.modelBasePath = FileSystems.getDefault().getPath(basePath);
    }

    public void loadModelFromFiles(ApplicationModel model) throws IOException {
        Properties screens = loadScreenDirsPaths();
        for (String screenName: screens.stringPropertyNames()) {
            BasicScreen screen = loadAllElements(screenName, screens.getProperty(screenName));
            model.loadScreen(screenName, screen);
        }
    }

    private Properties loadScreenDirsPaths() throws IOException {
        return loadFromFileInPath(modelBasePath.resolve(screenListFile));
    }

    private BasicScreen loadAllElements(String name, String screenDataDirName) throws IOException {
        BasicScreen screen = new BasicScreen(name);
        String relativeDirPath = modelBasePath.toString();
        String absoluteDirPath = Thread.currentThread().getContextClassLoader().getResource(relativeDirPath).getPath();
        File screenDir = new File(absoluteDirPath + System.getProperty("file.separator") + screenDataDirName);
        File[] directoryListing = screenDir.listFiles();
        if (directoryListing != null) {
            for (File elementData: directoryListing) {
                screen.withElement(loadElementFromFile(elementData, screen));
            }
        }
        else {
            throw new ScreenElementNotFoundException(String.format("No element files present in screen directory %s, screen directory %s", screenDir, screenDataDirName));
        }
        return screen;
    }

    private BasicElement loadElementFromFile(File elementData, BasicScreen screen) throws IOException {
        Properties props = loadFromFile(elementData);
        BasicElement element = new BasicElement(elementData.getName().substring(0, elementData.getName().lastIndexOf(".")), screen);
        return element.withProperties(props);
    }

    private Properties loadFromFile(File elementData) throws IOException {
        InputStream is = new FileInputStream(elementData);
        return loadFromInputStream(is);
    }

    private Properties loadFromInputStream(InputStream is) throws IOException {
        Properties props = new Properties();
        props.load(is);
        return props;
    }

    private Properties loadFromFileInPath(Path path) throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path.toString());
        return loadFromInputStream(is);
    }
}
