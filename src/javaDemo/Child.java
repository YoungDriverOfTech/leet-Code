package javaDemo;

public class Child implements Cloneable{
    public int age;
    public Person person;

    public Child(int age, Person person) {
        this.age = age;
        this.person = person;
    }

    public static void main(String[] args) {
        Person person = new Person("zhangsan");
        Child child = new Child(10, person);
        Child newChild = child.clone();

        // 属性改变之前
        System.out.println("child = " + child);
        System.out.println("newChild = " + newChild);

        // 属性改变之后
        child.age = 15;
        child.person.name = "lisi";
        System.out.println("child = " + child);
        System.out.println("newChild = " + newChild);
    }



    @Override
    public String toString() {
        return "Child{" +
                "age=" + age +
                ", person=" + person +
                '}';
    }

    @Override
    public Child clone() {
        try {
            Child clone = (Child) super.clone();
            clone.person = this.person.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
