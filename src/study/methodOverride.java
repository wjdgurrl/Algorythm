package study;

class Animal {
    public void makeSound() {
        System.out.println("animals make noise.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("cat says mayo.");
    }
}

public class methodOverride {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        Cat cat = new Cat();
        cat.makeSound();
    }
}
