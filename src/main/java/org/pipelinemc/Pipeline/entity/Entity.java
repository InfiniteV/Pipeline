package org.pipelinemc.Pipeline.entity;

import java.util.List;
import java.util.UUID;

import org.pipelinemc.Pipeline.World.Location;
import org.pipelinemc.Pipeline.World.TeleportCause;
import org.pipelinemc.Pipeline.World.Vector;
import org.pipelinemc.Pipeline.World.World;

public abstract class Entity {
	private EntityType type;
	
	private EntityType originalType;
	public void setType(EntityType type){
		this.type = type;
	}
	
	public EntityType getType(){
		return type;
	}
	
	public EntityType getOriginalType(){
		return originalType;
	}
	
	public abstract void tick();

    public  abstract Location getLocation();

    public  abstract Location getLocation(Location loc);

    public  abstract void setVelocity(Vector velocity);

    public abstract  Vector getVelocity();

    public abstract  boolean isOnGround();

    public abstract  World getWorld();

    public abstract  boolean teleport(Location location);

    public abstract  boolean teleport(Location location, TeleportCause cause);

    public  abstract boolean teleport(Entity destination, TeleportCause cause);

    public abstract  List<Entity> getNearbyEntities(double x, double y, double z);

    public abstract  int getEntityId();

    public abstract  int getFireTicks();

    public abstract  int getMaxFireTicks();

    public abstract  void setFireTicks(int ticks);

    public abstract  void remove();

    public abstract  boolean isDead();

    public  abstract boolean isValid();

    public abstract Entity getPassenger();

    public abstract boolean setPassenger(Entity passenger);

    public abstract boolean isEmpty();


    public abstract boolean eject();

    public  abstract float getFallDistance();

    public abstract  void setFallDistance(float distance);

    public abstract  UUID getUniqueId();

    public abstract  int getTicksLived();

    public abstract  void setTicksLived(int value);
    
    public abstract void teleport(Entity destination);

    public  abstract boolean isInsideVehicle();

    public abstract  boolean leaveVehicle();

    public abstract  Entity getVehicle();

    public abstract  void setCustomName(String name);

    public abstract  String getCustomName();

    public  abstract void setCustomNameVisible(boolean flag);

    public  abstract boolean isCustomNameVisible();
	
	
}
