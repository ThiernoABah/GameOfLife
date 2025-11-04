package org.example;

import org.example.utils.ResourcesFileReader;

public class World {
    private String view;

    public World() {
        var fileReader = new ResourcesFileReader();
        this.view = fileReader.getFileFromResources("worlds/emptyWorld.txt");
    }

    public World(String path){
        var fileReader = new ResourcesFileReader();
        this.view = fileReader.getFileFromResources(path);
    }

    public String displayView() {
        return view;
    }

    public String getNextCycle() {

        return view;
    }
}
