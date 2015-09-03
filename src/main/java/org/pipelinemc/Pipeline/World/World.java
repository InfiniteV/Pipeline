package org.pipelinemc.Pipeline.World;

public class World {
    Chunk[][] chunks;

    public static World fromString(String replace) {
        return null;
    }

    public Block getHighestBlockAt(Location location) {
        return null;
    }

    public Chunk getChunkAt(Location location) {
        return null;
    }

    public Object getName() {
        return null;
    }

    public void save() {
        for (Chunk[] chunkslist : chunks) {
            for (Chunk c : chunkslist) {
                c.save();
            }
        }
    }
}