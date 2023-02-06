package net.fabricmc.tiantong;

import org.slf4j.LoggerFactory;

import java.nio.file.Paths;
import java.util.Properties;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.nio.file.Path;
import org.slf4j.Logger;

public class TiantongConfig {
    protected static Properties properties;
    protected static Path path;
    protected static File file;
    protected static Logger LOGGER = TiantongMain.LOGGER;

    //String Sets
    protected static String[] Banned_Items;


    public static void initClass() {
        path = getPath();
        file = getDirectory();
        LOGGER.warn(path.toString());
    }

    public static Path getPath() {
        return Paths.get(".");
    }
    public static final File getDirectory() {
        return path.toFile();
    }
}
