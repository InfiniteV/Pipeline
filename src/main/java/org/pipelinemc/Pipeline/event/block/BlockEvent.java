package org.pipelinemc.Pipeline.event.block;

import org.pipelinemc.Pipeline.World.Block;

public class BlockEvent {
	protected Block block;
    public BlockEvent(final Block theBlock) {
        block = theBlock;
    }
    public final Block getBlock() {
        return block;
    }
}
