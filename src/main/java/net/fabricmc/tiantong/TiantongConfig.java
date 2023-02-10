package net.fabricmc.tiantong;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.mojang.authlib.yggdrasil.response.BlockListResponse;
import com.sun.jna.StringArray;
import net.minecraft.entity.player.PlayerEntity;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
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

import static com.ibm.icu.text.PluralRules.Operand.e;

public class TiantongConfig {
    private static final String PATH = System.getProperty("user.dir") + "/config/" + "tiantongclient.json";
    protected static Logger LOGGER = TiantongMain.LOGGER;
    public static class Objectives {
        public JsonArray banned_items = new JsonArray();

        public Objectives() {
            banned_items.add("");
        }

    }
    private static String[] Banned_Items = {""};

    public static void initClass() {
        if(!Files.exists(Paths.get(PATH))) {
            Objectives obj = new Objectives();
            try {
                Files.write(Paths.get(PATH), Collections.singleton(new GsonBuilder().setPrettyPrinting().create().toJson(obj)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        String ConfigJson;
        try {
            ConfigJson = Files.readAllLines(Paths.get(PATH)).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonArray jsonArray = JsonParser.parseString(ConfigJson).getAsJsonArray();
        int i = 0;
        for(var v : jsonArray) {
            Banned_Items[i] = v.toString();
        }
    }

    public static void generateJson() {

    }
}
