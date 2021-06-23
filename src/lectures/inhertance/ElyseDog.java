package lectures.inhertance;

public class ElyseDog extends Dog {
    public ElyseDog(String n, int s) {
        super(n, s);
    }

    @Override
    public void bark() {
        System.out.println("2");
    }
}

