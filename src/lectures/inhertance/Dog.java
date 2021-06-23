package lectures.inhertance;

public class Dog implements iDog{
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public void bark() {

    }

    public int compare(Object o) {
        Dog d = (Dog) o;
        return size - d.size;
    }
}
