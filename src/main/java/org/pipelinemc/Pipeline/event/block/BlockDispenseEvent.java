package org.pipelinemc.Pipeline.event.block;

import org.pipelinemc.Pipeline.World.Block;
import org.pipelinemc.Pipeline.World.Vector;
import org.pipelinemc.Pipeline.event.Cancellable;
import org.pipelinemc.Pipeline.inventory.ItemStack;

public class BlockDispenseEvent extends BlockEvent implements Cancellable {
	 private boolean cancelled = false;
	    private ItemStack item;
	    private Vector velocity;

	    public BlockDispenseEvent(final Block block, final ItemStack dispensed, final Vector velocity) {
	        super(block);
	        this.item = dispensed;
	        this.velocity = velocity;
	    }
	    public ItemStack getItem() {
	        return item.clone();
	    }
	    public void setItem(ItemStack item) {
	        this.item = item;
	    }
	    public Vector getVelocity() {
	        return velocity.clone();
	    }
	    public void setVelocity(Vector vel) {
	        velocity = vel;
	    }

	    public boolean isCancelled() {
	        return cancelled;
	    }

	    public void setCancelled(boolean cancel) {
	        cancelled = cancel;
	    }


}
