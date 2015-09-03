package org.pipelinemc.Pipeline.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.pipelinemc.Pipeline.GameMode;
import org.pipelinemc.Pipeline.World.Location;
import org.pipelinemc.Pipeline.World.TeleportCause;
import org.pipelinemc.Pipeline.World.Vector;
import org.pipelinemc.Pipeline.World.World;
import org.pipelinemc.Pipeline.inventory.ItemStack;

public class Player extends HumanEntity {
	private long firstPlayed = 0L;
	  private long lastPlayed = 0L;
	  private boolean hasPlayedBefore = false;
	  private final Set<UUID> hiddenPlayers = new HashSet();
	  private int hash = 0;
	  private double health = 20.0D;
	  private boolean scaledHealth = false;
	  private double healthScale = 20.0D;
	@Override
	public void tick() {
		// what should i do?

	}

	@Override
	public Location getLocation() {
		// TODO: getLocation
		return null;
	}

	@Override
	public Location getLocation(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVelocity(Vector velocity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getVelocity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOnGround() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean teleport(Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(Location location, TeleportCause cause) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(Entity destination, TeleportCause cause) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Entity> getNearbyEntities(double x, double y, double z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEntityId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFireTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxFireTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFireTicks(int ticks) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entity getPassenger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setPassenger(Entity passenger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eject() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getFallDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFallDistance(float distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public UUID getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTicksLived() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTicksLived(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void teleport(Entity destination) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isInsideVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leaveVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entity getVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCustomName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCustomName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCustomNameVisible(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCustomNameVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getItemInHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setItemInHand(ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSleeping() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSneaking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GameMode getGameMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGameMode(GameMode mode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getExpToLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBlocking() {
		// TODO Auto-generated method stub
		return false;
	}

}
