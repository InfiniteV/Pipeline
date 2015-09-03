package org.pipelinemc.Pipeline.event.block;

import org.pipelinemc.Pipeline.World.Block;
import org.pipelinemc.Pipeline.entity.Player;
import org.pipelinemc.Pipeline.event.Cancellable;

public class BlockBreakEvent extends BlockEvent implements Cancellable{
	private Player player;
	public BlockBreakEvent(Block theBlock,Player player) {
		super(theBlock);
		this.player  = player;
	}
	public Player getPlayer(){
		return player;
	}
	private boolean isCancelled = false;
	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.isCancelled = cancelled;
	}

}
