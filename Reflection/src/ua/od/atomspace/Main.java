package ua.od.atomspace;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        doWork1();
        doWork2();
    }

    private static void doWork1() throws ClassNotFoundException {
        Person person = new Person();
        Class classPerson0 = person.getClass();
        Class classPerson1 = Class.forName("ua.od.atomspace.Person");// выбрасывает ClassNotFoundException
        Class classPerson2 = Person.class;

        Method[] methodsPersons = classPerson1.getMethods();
        for (Method method : methodsPersons) {
            System.out.println("Method = " + method.getName() + ", return type = " + method.getReturnType() +
                    "Argument type = " + Arrays.toString(method.getParameterTypes()));
        }

        Field[] fieldPersons = classPerson0.getFields();// ничего не вернется, ибо все поля инкапсулированы (приватные)
        fieldPersons = classPerson0.getDeclaredFields();// получили доступ к задекларированным полям

        for (Field field : fieldPersons) {
            System.out.println("Field name = " + field.getName() + ", field type = " + field.getType());
        }
        // OUTPUT

        /*
        *   Method = getName, return type = class java.lang.StringArgument type = []
            Method = setName, return type = voidArgument type = [class java.lang.String]
            Method = getId, return type = intArgument type = []
            Method = sayHello, return type = voidArgument type = []
            Method = setId, return type = voidArgument type = [int]
            Method = wait, return type = voidArgument type = [long]
            Method = wait, return type = voidArgument type = [long, int]
            Method = wait, return type = voidArgument type = []
            Method = equals, return type = booleanArgument type = [class java.lang.Object]
            Method = toString, return type = class java.lang.StringArgument type = []
            Method = hashCode, return type = intArgument type = []
            Method = getClass, return type = class java.lang.ClassArgument type = []
            Method = notify, return type = voidArgument type = []
            Method = notifyAll, return type = voidArgument type = []
            Field name = name, field type = class java.lang.String
            Field name = id, field type = int
        * */
    }

    private static void doWork2() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);

        Class object1 = Class.forName(scanner.next());
        Class object2 = Class.forName(scanner.next());
        String methodName = scanner.next();

        Method method = object1.getMethod(methodName,object2);
        Object o1 = object1.newInstance();
        Object o2 = object2.getConstructor(String.class).newInstance("Some string valuse");

        method.invoke(o1,o2);
        System.out.println(o1);

//        java.lang.Thread java.lang.String setName - input
//        Thread[Some string valuse,5,main] - output
    }
}


@Author(author = "Dmitry Shulga")
class Person {
    private String name;
    private int id;

    public Person() {
        this.name = "Unknown";
        this.id = -1;
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void sayHello() {
        System.out.println("My name is " + name + ", my id is " + id + " and i'm saying hello!!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
