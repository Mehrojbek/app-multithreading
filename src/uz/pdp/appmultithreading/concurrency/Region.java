package uz.pdp.appmultithreading.concurrency;

public class Region implements Cloneable {
    private String name;

    public Region(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Region clone() {
        try {
            Region clone = (Region) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
