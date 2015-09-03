package org.pipelinemc.Pipeline.World;


public class Block {

    String type;
    private final int x;
    private final int y;
    private final int z;
    private final World world;
    private final Chunk chunk;
    short meta;
    public Block(String type,Chunk chunk, int x, int y, int z,World world)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
        this.world = world;
        this.chunk = chunk;
      }
    public int getX(){
      return this.x;
    }
    
    public int getY(){
      return this.y;
    }
    
    public int getZ(){
      return this.z;
    }
    
	public Location getLocation() {
		return new Location(world,x,y,z);
	}
	public String getType() {
		return type;
	}
	public Chunk getChunk() {
		return chunk;
	}  
	

}
