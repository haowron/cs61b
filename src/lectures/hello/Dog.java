package lectures.hello;

public class Dog {
    public int weightInPounds;

    public Dog(int p) {
        weightInPounds = p;
    }

    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yip yip yip yip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark bark!");
        } else {
            System.out.println("woof!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Bark!");
    }
}
