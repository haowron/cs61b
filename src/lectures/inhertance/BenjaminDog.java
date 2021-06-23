package lectures.inhertance;

public class BenjaminDog extends Dog {
    public BenjaminDog(String n, int s) {
        super(n, s);
    }

    @Override
    public void bark() {
        System.out.println("3");
    }
}
