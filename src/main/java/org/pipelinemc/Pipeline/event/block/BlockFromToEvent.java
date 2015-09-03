package org.pipelinemc.Pipeline.event.block;

import org.pipelinemc.Pipeline.World.Block;
import org.pipelinemc.Pipeline.event.Cancellable;

public class BlockFromToEvent extends BlockEvent implements Cancellable{

	public BlockFromToEvent(Block theBlock) {
		super(theBlock);
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		// TODO Auto-generated method stub
		
	}

}
