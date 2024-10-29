package praktikum.Core1.stackAndHeap;

public class HeapExample {

    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 4);
        // stack: {main: cat = [Cat@683]}
        soSmthInteresting(cat);
        System.out.println("Это " + cat.name + ", ему " + cat.age + " лет.");
    }

    static void soSmthInteresting(Cat cat) {
        // stack: {soSmthInteresting: [cat = [Cat@683], main: cat = [Cat@683]}
        cat.age++;
        cat = new Cat("Роджер", cat.age);
        // stack: {soSmthInteresting: [cat = [Cat@686], main: cat = [Cat@683]}
        System.out.println("Теперь кота зовут " + cat.name);
    }
}

class Cat {
    String name;
    int age;

    public Cat(String catName, int catAge) {
        name = catName;
        age = catAge;
    }
}
