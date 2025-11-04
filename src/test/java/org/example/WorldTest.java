package org.example;

import org.example.utils.ResourcesFileReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class WorldTest {
    private String TEST_RESOURCE_PATH = "src/test/resources/";

    @Test
    @DisplayName("Should display grid with no life")
    void testEmptyWorld() {
        // Given
        var fileReader = new ResourcesFileReader(TEST_RESOURCE_PATH);
        var expectedView = fileReader.getFileFromResources("worlds/emptyWorld.txt");

        var world = new World();

        // When
        var worldView = world.displayView();

        // Then
        assertEquals(expectedView, worldView);
    }

    @Test
    @DisplayName("Should display grid with one life")
    void testSoloWorld() {
        // Given
        var soloWorldPath = "worlds/soloWorld.txt";
        var fileReader = new ResourcesFileReader(TEST_RESOURCE_PATH);
        var expectedView = fileReader.getFileFromResources(soloWorldPath);

        var world = new World(soloWorldPath);

        // When
        var worldView = world.displayView();

        // Then
        assertEquals(expectedView, worldView);
    }

    @Test
    @DisplayName("Should update empty world view for next cycle")
    void testWorldCycle() {
        // Given
        var emptyWorldPath = "worlds/emptyWorld.txt";
        var fileReader = new ResourcesFileReader(TEST_RESOURCE_PATH);
        var expectedView = fileReader.getFileFromResources(emptyWorldPath);

        var world = new World();

        // When
        var worldView = world.getNextCycle();

        // Then
        assertEquals(expectedView, worldView);
    }

    @Test
    @DisplayName("Should kill cell with no neighbor or fewer than two for next cycle")
    void testSoloWorldCycle() {
        // Given
        var soloWorldPath = "worlds/soloWorld.txt";

        var emptyWorldPath = "worlds/emptyWorld.txt";
        var fileReader = new ResourcesFileReader(TEST_RESOURCE_PATH);
        var expectedView = fileReader.getFileFromResources(emptyWorldPath);

        var world = new World(soloWorldPath);

        // When
        var worldView = world.getNextCycle();

        // Then
        assertEquals(expectedView, worldView);
    }
}
