package org.pipelinemc.Pipeline.entity;

import java.util.HashMap;
import java.util.Map.Entry;

public class CustomEntityType {

    private static HashMap<String, CustomEntityType> map = new HashMap<String, CustomEntityType>();

    public static CustomEntityType get(String s) {
        return map.get(s);
    }
    public static CustomEntityType add(CustomEntityType m) throws Exception{
    	if(map.containsKey(m.getMinecraftName())){
    		throw new Exception("The name for this entity is already used!");
    	}
        return map.put(m.getMinecraftName(),m);
    }


    String minecraftName;
    String customName;
    int id;
    Class<? extends Entity> clazz;
    int i = 0;
    public CustomEntityType(String customName,int id, String name, Class<? extends Entity> class1) {
        this.minecraftName = name;
        this.id=id;
        this.clazz = class1;
        this.customName = customName;
    }
    public void override(Class<? extends Entity> entity){
    	if(i==0){
    		for(Entry<String, CustomEntityType> entry: map.entrySet()){
    			if(entry.getValue().getClass().equals(entity)){
    				map.remove(entry.getKey());
    			}
    		}
    		i++;
    	}
    }

    public String getMinecraftName() { return minecraftName;}
    public int getID() {return  id;}
    public static void a(){
		for(EntityType type:EntityType.values()){
			try {
				map.put("minecraft:" + type.toString(),new CustomEntityType(type.getName(),type.getID(),"minecraft:" + type.toString(),type.getEntityClass()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
}
