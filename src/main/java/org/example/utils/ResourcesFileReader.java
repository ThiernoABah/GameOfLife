package org.example.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourcesFileReader {
    private String RESOURCE_PATH = "src/main/resources/";

    private String basePath;

    public ResourcesFileReader() {
        this.basePath = RESOURCE_PATH;
    }

    public ResourcesFileReader(String basePath) {
        this.basePath = basePath;
    }


    public String getFileFromResources(String path) {
        try {
            return Files.readString(Path.of(this.basePath+path)).replace("\r\n", "\n");
        } catch (IOException e) {
            throw new RuntimeException("error while reading file : " + path,e);
        }
    }
}
