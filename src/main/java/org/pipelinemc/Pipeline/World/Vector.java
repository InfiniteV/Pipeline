package org.pipelinemc.Pipeline.World;

public class Vector implements Cloneable {
    private double x, y, z;

    /**
     * Constructs a vector with zeros as it's components.
     **/
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * Constructs a vector with provided integer components.
     *
     * @param x X component
     * @param y Y component
     * @param z Z component
     */
    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a vector with provided double components.
     *
     * @param x X component
     * @param y Y component
     * @param z Z component
     */
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a vector with provided float components.
     *
     * @param x X component
     * @param y Y component
     * @param z Z component
     */
    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Joins vectors together
     *
     * @param v The other vector
     * @return the same vector
     */
    public Vector add(Vector v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    /**
     * Removes a vector from this one.
     *
     * @param v The other vector
     * @return updated vector
     */
    public Vector subtract(Vector v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    /**
     * Multiplies the vector by given component
     *
     * @param v vector component
     * @return updated vector
     */
    public Vector multiply(Vector v) {
        x *= v.x;
        y *= v.y;
        z *= v.z;
        return this;
    }


    /**
     * Divides the vector by given component
     *
     * @param v vector component
     * @return updated vector
     */
    public Vector divide(Vector v) {
        x /= v.x;
        y /= v.y;
        z /= v.z;
        return this;
    }

    /**
     * Set's the vector to the given component
     *
     * @param v vector component
     * @return updated vector
     */
    public Vector set(Vector v) {
        x = v.x;
        y = v.y;
        z = v.z;
        return this;
    }

    /**
     * Sets this vector to the midpoint between this vector and another.
     *
     * @param other The other vector
     * @return this same vector (now a midpoint)
     */
    public Vector midpoint(Vector other) {
        x = (x + other.x) / 2;
        y = (y + other.y) / 2;
        z = (z + other.z) / 2;
        return this;
    }

    /**
     * Gets a new midpoint vector between this vector and another.
     *
     * @param other The other vector
     * @return a new midpoint vector
     */
    public Vector getMidpoint(Vector other) {
        double x = (this.x + other.x) / 2;
        double y = (this.y + other.y) / 2;
        double z = (this.z + other.z) / 2;
        return new Vector(x, y, z);
    }

    /**
     * Multiplies the vector with the given number
     *
     * @param m double component
     * @return updated vector
     */
    public Vector multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    /**
     * Resets the vector
     **/
    public Vector zero() {
        x = 0;
        y = 0;
        z = 0;
        return this;
    }

    /**
     * Gets the X component of the Vector
     **/
    public double getX() {
        return x;
    }

    /**
     * Sets the X component of the Vector
     **/
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the Y component of the Vector
     **/
    public double getY() {
        return y;
    }

    /**
     * Sets the Y component of the Vector
     **/
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets the Z component of the Vector
     **/
    public double getZ() {
        return z;
    }

    /**
     * Sets the Z component of the Vector
     **/
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Get a new vector.
     *
     * @return vector
     */
    @Override
    public Vector clone() {
        try {
            return (Vector) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    /**
     * @return String value of the vector(X,Y,Z)
     */
    @Override
    public String toString() {
        return x + "," + y + "," + z;
    }
}
