package com.ggj16.days.gamegenerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Florian on 30/01/2016.
 */
public class FileHelper {

    public static List<String> loadFile(){

        FileHandle file = Gdx.files.internal("MapConf/map.txt");
        String text = file.readString();
        List<String> mapconf = Arrays.asList(text.split("\n"));
        return mapconf;
    }

}
