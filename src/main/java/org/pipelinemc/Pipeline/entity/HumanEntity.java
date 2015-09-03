package org.pipelinemc.Pipeline.entity;

import org.pipelinemc.Pipeline.GameMode;
import org.pipelinemc.Pipeline.inventory.ItemStack;

public abstract class HumanEntity extends LivingEntity{
	public abstract ItemStack getItemInHand();
	public abstract String getName();
	public abstract void closeInventory();
	public abstract void setItemInHand(ItemStack item);
	public abstract boolean isSleeping();
	public abstract boolean isSneaking();
	public abstract GameMode getGameMode();
	public abstract void setGameMode(GameMode mode);
	public abstract int getExpToLevel();
	public abstract boolean isBlocking();
}
