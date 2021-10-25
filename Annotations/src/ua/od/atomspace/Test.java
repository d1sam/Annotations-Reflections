package ua.od.atomspace;

// @MethodInfo(purpose = "saying hello") - нельзя так как не позволяет Target
public class Test {
    @MethodInfo(purpose = "saying hello", author = "Dmitry Shulga")// хоть и по дэфолту d1sam, но изменили на другое значение,
    // а dateOfCreation осталась нетронутой
    public static void sayHello() {
        System.out.println("Helooooooo!");
    }
}
