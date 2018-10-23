package general;

public class CloneTest implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest c1 = new CloneTest();
        Object c2 = (CloneTest)c1.clone();  // To use java object clone method, we have to implement the marker interface java.lang.Cloneable so that it won’t throw CloneNotSupportedException at runtime

    }
    // Also Object clone is a protected method, so we will have to override it to use with other classes.
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
