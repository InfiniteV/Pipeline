package org.pipelinemc.Pipeline.entity;

import org.pipelinemc.Pipeline.World.Location;
import org.pipelinemc.Pipeline.World.World;
import org.pipelinemc.Pipeline.entity.boss.EnderDragon;
import org.pipelinemc.Pipeline.entity.boss.Wither;
import org.pipelinemc.Pipeline.entity.minecart.Boat;
import org.pipelinemc.Pipeline.entity.minecart.CommandMinecart;
import org.pipelinemc.Pipeline.entity.minecart.HopperMinecart;
import org.pipelinemc.Pipeline.entity.minecart.PoweredMinecart;
import org.pipelinemc.Pipeline.entity.minecart.RideableMinecart;
import org.pipelinemc.Pipeline.entity.minecart.SpawnerMinecart;
import org.pipelinemc.Pipeline.entity.minecart.StorageMinecart;
import org.pipelinemc.Pipeline.entity.minecart.TNTMinecraft;
import org.pipelinemc.Pipeline.entity.projectile.Arrow;
import org.pipelinemc.Pipeline.entity.projectile.BigFireball;
import org.pipelinemc.Pipeline.entity.projectile.EnderEye;
import org.pipelinemc.Pipeline.entity.projectile.EnderPearl;
import org.pipelinemc.Pipeline.entity.projectile.ExpBottle;
import org.pipelinemc.Pipeline.entity.projectile.Fireball;
import org.pipelinemc.Pipeline.entity.projectile.Snowball;
import org.pipelinemc.Pipeline.entity.projectile.SplashPotion;
import org.pipelinemc.Pipeline.entity.projectile.WitherSkull;

public enum EntityType {
	/**
	 * 
	 * An item on the ground.
	 * <p>
	 * Spawn with {@link World#dropItem(Location, ItemStack)} or {@link
     * World#dropItemNaturally(Location, ItemStack)}
	 * 
	 */
	DROPPED_ITEM("Item",1,DroppedItem.class),
	 /**
     * An experience orb.
     */
	EXP_ORB("XPOrb",2,ExpOrb.class),
    /**
     * A leash attached to a fencepost.
     */
	LEASH_KNOT("LeashKnot",8,LeashKnot.class),
    /**
     * A painting on a wall.
     */
	PATING("Painting",9,Painting.class),
    /**
     * An arrow projectile; may get stuck in the ground.
     */
	ARROW("Arrow",10,Arrow.class),
    /**
     * A flying snowball.
     */
	SNOWBALL("Snowball",11,Snowball.class),
    /**
     * A flying large fireball, as thrown by a Ghasts.
     */
	BIG_FIREBALL("Fireball",12,BigFireball.class),
	/**
     * A flying small fireball, as thrown by a Blaze or player.
     */
	FIREBALL("SmallFireball",13,Fireball.class),
    /**
     * A flying ender pearl.
     */
	ENDER_PEARL("ThrownEnderpearl",14,EnderPearl.class),
    /**
     * An ender eye signal.
     */
	ENDER_EYE("EyeOfEnderSignal",15,EnderEye.class),
    /**
     * A splash potion thrown by a witch or player.
     */
	SPLASH_POTION("ThrownPotion",16,SplashPotion.class),
    /**
     * A flying experience bottle.
     */
	EXP_BOTTLE("ThrownExpBottle",17,ExpBottle.class),
    /**
     * An item frame on a wall.
     */
	ITEM_FRAME("ItemFrame",18,ItemFrame.class),
    /**
     * A flying wither skull projectile.
     */
	WITHER_SKULL("WitherSkull",19,WitherSkull.class),
    /**
     * Primed TNT that is about to explode.
     */
	PRIMED_TNT("PrimedTnt",20,PrimedTnt.class),
    /**
     * A block that is going to or is about to fall.
     */
	FALLING_BLOCK("FallingSand",21,PrimedTnt.class),
	
	FIREWORK("FireworksRocketEntity",22,Firework.class),
	
	ARMOR_STAND("ArmorStand",30,ArmorStand.class),
	
	MINECART_COMMANDBLOCK("MinecartCommandBlock",40,CommandMinecart.class),
	
	BOAT("Boat",41,Boat.class),
	
	MINECART("Minecart",42,RideableMinecart.class),
	
	STORAGE_MINECART("MinecartChest",43,StorageMinecart.class),
	
	POWERED_MINECART("MinecartFurnace",44,PoweredMinecart.class),
	
	TNT_MINECART("MinecartTNT",45,TNTMinecraft.class),
	
	MINECART_HOPPER("MinecartHopper",46,HopperMinecart.class),
	
	MINECART_SPAWNER("MinecartSpawner",47,SpawnerMinecart.class),
	
	CREEPER("Creeper",50,Creeper.class),
	
	SKELETON("Skeleton",51,Skeleton.class),
	
	SPIDER("Spider",52,Spider.class),
	
	GIANT("Giant",53,Giant.class),
	
	ZOMBIE("Zombie",54,Zombie.class),
	
	SLIME("Slime",55, Slime.class),
	
	GHAST("Ghast",56, Ghast.class),
	
	ZOMBIE_PIGMAN("PigZombie",57, ZombiePigman.class),
	
	ENDERMAN("Enderman",58,Enderman.class),
	
	CAVE_SPIDER("CaveSpider",59,CaveSpider.class),
	
	SILVERFISH("Silverfish",60,Silverfish.class),
	
	BLAZE("Blaze",61, Blaze.class),
	
	MAGMA_CUBE("LavaSlime",62, MagmaCube.class),
	
	ENDER_DRAGON("EnderDragon",63,EnderDragon.class),
	
	WITHER("WitherBoss",64,Wither.class),
	
	BAT("Bat",65,Bat.class),
	
	WITCH("Witch",66,Witch.class),
	
	ENDERMITE("Endermite",67,Endermite.class),
	
	GUARDIAN("Guardian",68,Guardian.class),
	
	PIG("Pig",90,Pig.class),
	
	SHEEP("Sheep",91,Sheep.class),
	
	COW("Cow",92,Cow.class),
	
	CHICKEN("Chicken",93,Chicken.class),
	
	SQUID("Squid",94,Squid.class),
	
	WOLF("Wolf",95,Wolf.class),
	
	MOOSHROOM("MushroomCow",96,Mooshroom.class),
	
	SNOW_GOLEM("SnowMan",97,Snowman.class),
	
	OCELOT("Ozelot",98,Ocelot.class),
	
	IRON_GOLEM("VillagerGolem",99,IronGolem.class),
	
	HORSE("EntityHorse",100,Horse.class),
	
	RABBIT("Rabbit",101,Rabbit.class),
	
	VILLAGER("Villager",120,Villager.class),
	
	ENDER_CRYSTAL("EnderCrystal",200,EnderCrystal.class);
	Class<? extends Entity> clazz;
	String name;
	int entityId;
	EntityType(String name, int entityId, Class<? extends Entity> clazz){
		this.clazz = clazz;
		this.name = name;
		this.entityId = entityId;
	}
	public String getName(){
		return name;
		
	}
	public int getID(){
		return entityId;
	}
	public Class<? extends Entity> getEntityClass(){
		return clazz;
	}
}
