
class Animal extends  Object{
    int id = 10;
    String name = "홍길동";

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ToTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        System.out.println(a.toString());

        // getClass().getName() + "@" + Integer.toHexString(hashCode())
        String pre = a.getClass().getName();
        System.out.println(pre);
        int suffix = a.hashCode();
        System.out.println(suffix);
    }
}
