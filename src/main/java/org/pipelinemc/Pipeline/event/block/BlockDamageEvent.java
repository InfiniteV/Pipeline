package org.pipelinemc.Pipeline.event.block;

import org.pipelinemc.Pipeline.World.Block;
import org.pipelinemc.Pipeline.entity.Player;
import org.pipelinemc.Pipeline.event.Cancellable;
import org.pipelinemc.Pipeline.inventory.ItemStack;

public class BlockDamageEvent extends BlockEvent implements Cancellable {
	private final Player player;
    private boolean instaBreak;
    private boolean cancel = false;
    private int damage;
	public BlockDamageEvent(Block theBlock,int damage,Player player,boolean instabreak) {
		super(theBlock);
		this.player = player;
		this.setInstaBreak(instabreak);
		this.damage = damage;
	}
	
	@Override
	public boolean isCancelled() {
		return cancel;
	}
	public ItemStack getItemInHand(){
		return getPlayer().getItemInHand();
	}
	@Override
	public void setCancelled(boolean cancelled) {
		this.cancel = cancelled;
	}

	public boolean isInstaBreak() {
		return instaBreak;
	}

	public void setInstaBreak(boolean instaBreak) {
		this.instaBreak = instaBreak;
	}

	public int getDamage() {
		return damage;
	}

	public Player getPlayer() {
		return player;
	}

}
