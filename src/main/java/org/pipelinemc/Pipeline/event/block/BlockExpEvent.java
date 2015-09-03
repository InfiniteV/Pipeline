package org.pipelinemc.Pipeline.event.block;

import org.pipelinemc.Pipeline.World.Block;

public class BlockExpEvent extends BlockEvent {
	 private int exp;

	    public BlockExpEvent(Block block, int exp) {
	        super(block);

	        this.exp = exp;
	    }
	    public int getExpToDrop() {
	        return exp;
	    }
	    public void setExpToDrop(int exp) {
	        this.exp = exp;
	    }
}
