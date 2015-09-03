package org.pipelinemc.Pipeline.World;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private World world;
    private double x,y,z;
    private float pitch,yaw;

    public Location(final World world, final double x, final double y, final double z) {
        this(world, x, y, z, 0, 0);
    }

    public Location(final World world, final double x, final double y, final double z, final float yaw, final float pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public static Location fromString(String location) {
        String[] values = location.replace("Location{", "").replace("}", "").split(",");
        World world = null;
        double x = 0;
        double y = 0;
        double z = 0;
        float pitch = 0;
        float yaw = 0;
        for (String s : values) {
            if (s.contains("world:")) {
                world = World.fromString(s.replace("world:", ""));
            } else if (s.contains("x:")) {
                x = Double.valueOf(s.replace("x:", ""));
            } else if (s.contains("y:")) {
                y = Double.valueOf(s.replace("y:", ""));
            } else if (s.contains("z:")) {
                z = Double.valueOf(s.replace("z:", ""));
            } else if (s.contains("pitch:")) {
                pitch = Float.valueOf(s.replace("pitch:", ""));
            } else if (s.contains("yaw:")) {
                yaw = Float.valueOf(s.replace("yaw:", ""));
            }
        }
        return new Location(world, x, y, z, pitch, yaw);
    }

    public static Location deserialize(Map<String, Object> args) {
        World world = World.fromString(args.get("world").toString());
        if (world == null) {
            throw new IllegalArgumentException("unknown world");
        }

        return new Location(world, Double.valueOf(args.get("x").toString()), Double.valueOf(args.get("y").toString()), Double.valueOf(args.get("z").toString()), Float.valueOf(args.get("yaw").toString()), Float.valueOf(args.get("pitch").toString()));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Chunk getChunk() {
        return world.getChunkAt(this);
    }

    public Block getHighestBlock() {
        return world.getHighestBlockAt(this);
    }

    public double getHighestBlockY() {
        return this.getHighestBlock().getLocation().getY();
    }

    @Override
    public String toString() {
        return "Location{" + "world:" + world.toString() + ",x:" + x + ",y:" + y + ",z:" + z + ",pitch:" + pitch + ",yaw:" + yaw + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;

        return !(this.world != other.world && (this.world == null || !this.world.equals(other.world))) && Math.floor(this.x) == Math.floor(other.x) && Math.floor(this.y) == Math.floor(other.y) && Math.floor(this.z) == Math.floor(other.z);
    }

    public Location multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    public Location divide(double d) {
        x /= d;
        y /= d;
        z /= d;
        return this;
    }

    public Location add(double x, double y, double z) {
        x += x;
        y += y;
        z += z;
        return this;
    }

    public Location subtract(double x, double y, double z) {
        x -= x;
        y -= y;
        z -= z;
        return this;
    }

    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("world", this.world.toString());

        data.put("x", this.x);
        data.put("y", this.y);
        data.put("z", this.z);

        data.put("yaw", this.yaw);
        data.put("pitch", this.pitch);

        return data;
    }
}
