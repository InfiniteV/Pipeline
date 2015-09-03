package org.pipelinemc.Pipeline.blocks;

import java.util.HashMap;

public class MaterialType {


    private static HashMap<String, MaterialType> map = new HashMap<String, MaterialType>();
    String name;
    int id;
    BlockEventer e;

    public MaterialType(String name, int id, BlockEventer e) {
        this.name = name;
        this.id = id;
        this.e = e;
    }

    public static MaterialType get(String s) {
        return map.get(s);
    }

    public static MaterialType add(String s, MaterialType m) {
        return map.put(s, m);
    }

    public static MaterialType remove(String s) {
        return map.remove(s);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

}
