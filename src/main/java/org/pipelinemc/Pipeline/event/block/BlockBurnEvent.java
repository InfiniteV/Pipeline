package org.pipelinemc.Pipeline.event.block;

import org.pipelinemc.Pipeline.World.Block;
import org.pipelinemc.Pipeline.event.Cancellable;

public class BlockBurnEvent extends BlockEvent implements Cancellable {

	public BlockBurnEvent(Block theBlock) {
		super(theBlock);
	}

	@Override
	public boolean isCancelled() {
		return false;
	}

	@Override
	public void setCancelled(boolean cancelled) {

	}

}
