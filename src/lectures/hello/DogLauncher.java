package lectures.hello;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog(15);
        d.makeNoise();
        Dog d2 = new Dog(5);
        d2.makeNoise();
        Dog d3 = new Dog(35);
        d3.makeNoise();
    }
}
