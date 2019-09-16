public class HelloWorld {
    public static void main(String[] args) {
        Student student = new Student();
        student.age = 42;
        student.name = "Tim";
        student.isAlive = false;

        System.out.println(student);
    }
}

class Student {
    public String name;
    public int age;
    public boolean isAlive;


    public String toString() {
        return this.name + ", " + this.age + ", " + this.isAlive;
    }
}