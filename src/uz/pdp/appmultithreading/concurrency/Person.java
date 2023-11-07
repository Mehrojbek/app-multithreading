package uz.pdp.appmultithreading.concurrency;

public final class Person {

    private final int age;
    private final String name;

    private final Address address;

    public Person(int age, String name, Address address) {
        this.age = age;
        this.name = name;
        this.address = address.clone();
        this.address.setRegion(address.getRegion().clone());
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {
        //1-shart class final bo'lsihi kerak
        //2-shart field larga acces bo'lmasligi uchun private qilinishi kerak
        //3-field lar final bo'lishi kerak
        //4-parametrli kontruktordan kelgan primitive va immutable bo'lmagan fieldlarni deep copy olish
        //5-getterda deep copy qaytarish kerak

        Region region = new Region("Tashkent");
        Address address = new Address("Navoiy ko'cha 16A","Tashkent",region);
        String name = "John";
        Person person = new Person(20, name,address);
        System.out.println(person);

        address.setCity("Navoiy");
        person.getAddress().setCity("Navoiy");
        region.setName("Yangi");

        System.out.println(person);

    }

}
