package org.example;

import org.example.utils.ResourcesFileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class World {
    private String cellChar = "*";
    private String emptyCellChar = ".";
    private List<List<String>> worldMatrix;

    public World() {
        var fileReader = new ResourcesFileReader();
        var view = fileReader.getFileFromResources("worlds/emptyWorld.txt");
        List<List<String>> worldMatrix = buildWorldMatrix(view);
        this.worldMatrix = worldMatrix;
    }

    public World(String path){
        var fileReader = new ResourcesFileReader();
        var view = fileReader.getFileFromResources(path);
        List<List<String>> worldMatrix = buildWorldMatrix(view);
        this.worldMatrix = worldMatrix;
    }

    public String displayView() {
        return this.worldMatrix.stream().map(
                lines -> {
                    var line = lines.stream().map((cell) -> cell.toString()).collect(Collectors.joining());
                    line+="\n";
                    return line;
                }
        ).collect(Collectors.joining()).trim();
    }

    public String getNextCycle() {
        List<List<String>> worldMatrix = this.buildWorldMatrix(this.displayView()) ;
        
        for(int i=0 ; i<this.worldMatrix.size(); i++){
            var line = this.worldMatrix.get(i);
            for(int j=0; j<line.size(); j++) {
                if(line.get(j).equals(cellChar)) {
                    var neighbors = getNeighbors(i,j).stream().filter(s -> s.equals(cellChar)).count();
                    if(neighbors < 2) {
                        worldMatrix.get(i).set(j, emptyCellChar);
                    }
                    if(neighbors > 3) {
                        worldMatrix.get(i).set(j, emptyCellChar);
                    }
                }else {
                    var neighbors = getNeighbors(i,j).stream().filter(s -> s.equals(cellChar)).count();
                    if(neighbors == 3) {
                        worldMatrix.get(i).set(j, cellChar);
                    }
                }
            }
        }

        this.worldMatrix = worldMatrix;
        return this.displayView();
    }
    
    private String getCell(int x, int y) {
        if(x < 0 || x >= this.worldMatrix.size()) {
            return "";
        }
        if(y<0 || y >= this.worldMatrix.get(0).size()) {
            return "";
        }
        return this.worldMatrix.get(x).get(y);
    }

    private List<String> getNeighbors(int x, int y) {
        var neighbors = new ArrayList<String>();
        for(int i=-1 ; i <= 1; i++){
            for(int j=-1; j <= 1; j++) {
                if(!(i == 0 && j == 0)) {
                    neighbors.add(getCell(x+i, y+j));
                }
            }
        }
        return neighbors;
    }

    private List<List<String>> buildWorldMatrix(String view) {
        List<List<String>> worldMatrix = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        for (String c : view.split("")) {
            if(!c.equals("\n")) {
                currentLine.add(c);
            }else {
                worldMatrix.add(currentLine);
                currentLine = new ArrayList<>();
            }
        }
        worldMatrix.add(currentLine);
        return worldMatrix;
    }
}
