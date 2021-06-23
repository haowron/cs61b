package lectures.inhertance;

public class StureDog extends Dog {
    public StureDog(String n, int s) {
        super(n, s);
    }

    @Override
    public void bark() {
        System.out.println("1");
    }
}
