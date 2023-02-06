package net.fabricmc.tiantong;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.sun.jna.StringArray;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
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
import com.google.gson.JsonObject;

public class TiantongConfig {
    private static final String PATH = System.getProperty("usr.dir") + "/config/" + "tiantongclient.json";
    protected static Logger LOGGER = TiantongMain.LOGGER;
    public static final JsonArray jsonObject = new JsonArray();

    private static String[] Banned_Items;

    public static void initClass() {
        if(!Files.exists(Paths.get(PATH))) {

        }
    }

    public static void generateJson() {

    }
}
