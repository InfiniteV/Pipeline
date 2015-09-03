package org.pipelinemc.Pipeline.World;

import java.io.File;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.pipelinemc.Pipeline.World.Location;

/**
 * Created by JessiePeek on 9/1/2015.
 */
public class Chunk {

    Block[][][] blocks = new Block[16][255][16];
    World world;

    public Block[][][] getBlocks(){
    	return blocks;
    }
    
    public void setBlock(Block b, Location l){
        setBlock(b,((int) l.getX())%16,((int) l.getY()),((int)l.getZ())%16);
    }
    public Block getBlock(Location l){
        return getBlock(((int) l.getX())%16,((int) l.getY()),((int)l.getZ())%16);
    }

    public void setBlock(Block b,int x, int y, int z) {
        blocks[x][y][z] = b;
    }
    public Block getBlock(int x, int y, int z) {
        return blocks[x][y][z];
    }
    @SuppressWarnings("unchecked")
	public void save(){
    	JSONArray array = new JSONArray();
    	for(Block[][] biocks1 :blocks){
    		for(Block[] blocks: biocks1){
    			for(Block block: blocks){
    					JSONObject jsobj = new JSONObject();
    					jsobj.put("location", block.getLocation().toString());
    					jsobj.put("type", block.getType());
    					jsobj.put("meta", block.meta);
    					array.add(jsobj);
    			}
    		}
    	}
    	File f = new File(File.separator + "Worlds" + File.separator + world.getName() + File.separator + ".chunk");
    	if(!f.exists()){
    		f.mkdirs();
    	}
    	 
         try {
        	 FileWriter file = new FileWriter(File.separator + "Worlds" + File.separator + world.getName() + File.separator + ".chunk",false);
             file.write(array.toJSONString());
             file.close();
         }catch(Exception e){
        	 e.printStackTrace();
         }
    }

}
