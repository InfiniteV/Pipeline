/**
 * 
 */
package org.pipelinemc.Pipeline.event.block;

import org.pipelinemc.Pipeline.World.Block;
import org.pipelinemc.Pipeline.event.Cancellable;

/**
 * @author Infinite
 *
 */
public class BlockExplodeEvent extends BlockEvent implements Cancellable {

	public BlockExplodeEvent(Block theBlock) {
		super(theBlock);
		// TODO Auto-generated constructor stub
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
