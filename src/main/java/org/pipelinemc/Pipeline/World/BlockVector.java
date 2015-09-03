package org.pipelinemc.Pipeline.World;

public class BlockVector implements Cloneable {
    private int x, y, z;

    public BlockVector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public BlockVector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public BlockVector add(BlockVector v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    public BlockVector subtract(BlockVector v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    public BlockVector multiply(BlockVector v) {
        x *= v.x;
        y *= v.y;
        z *= v.z;
        return this;
    }


    public BlockVector divide(BlockVector v) {
        x /= v.x;
        y /= v.y;
        z /= v.z;
        return this;
    }

    public BlockVector set(BlockVector v) {
        x = v.x;
        y = v.y;
        z = v.z;
        return this;
    }

    public BlockVector midpoint(BlockVector other) {
        x = (x + other.x) / 2;
        y = (y + other.y) / 2;
        z = (z + other.z) / 2;
        return this;
    }

    public BlockVector getMidpoint(BlockVector other) {
        int x = (this.x + other.x) / 2;
        int y = (this.y + other.y) / 2;
        int z = (this.z + other.z) / 2;
        return new BlockVector(x, y, z);
    }

    public BlockVector multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    public BlockVector zero() {
        x = 0;
        y = 0;
        z = 0;
        return this;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public BlockVector clone() {
        try {
            return (BlockVector) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    @Override
    public String toString() {
        return x + "," + y + "," + z;
    }
}
