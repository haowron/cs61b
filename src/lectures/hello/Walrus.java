package lectures.hello;

public class Walrus {
    public int weight;
    public double size;

    public Walrus(int weight_, double size_) {
        weight = weight_;
        size = size_;
    }

    public String toString() {
        return "weight: " + weight + ", tusk size: " + size;
    }

    public static void main(String[] args) {
        Walrus a = new Walrus(1000, 8.3);
        Walrus b;
        b = a;
        b.weight = 5;
        /* answer is
        weight: 5, tusk size: 8.3
        weight: 5, tusk size: 8.3
         */
        System.out.println(a);
        System.out.println(b);
    }
}
