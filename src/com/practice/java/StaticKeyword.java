package com.practice.java;


import com.practice.acrossclass.DifferentPackagetry;

import java.util.function.Consumer;

class StaticKeyword {
     int a=10;
     int b;
    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    static void staticMethod(){
        System.out.println(staticOuterField);
    }

    void InstanceMethod(){
        System.out.println(outerField+" , "+staticOuterField);
    }

    class inner{
        class inner1{
            //static void hello(){}
        }
        void accessMembers() {
            a=90;
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
         /*static void staticMethod() {

        }*/
     }

    static class StaticNestedClass {
        static void method1(){
            System.out.println("In StaticNestedClass's static method");
        }
        void accessMembers(StaticKeyword outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

  /*  static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }*/

    StaticKeyword(){}
    StaticKeyword(int a){
        this.a =a;
       // this.b = b;
     }

     StaticKeyword(int a, int b){
         this.a =a;
         this.b = b;
     }
    static{
        System.out.println("Without main");
    }

    public static void main(String[] args) {
        System.out.println("In Main method");
        String string = "abc";
        //public  int a; //public not allowed here since variable scope is only inside the method; could not visible outside of method.
        StaticKeyword staticKeyword = new StaticKeyword(1);
        System.out.printf("sum of a and b is " + (staticKeyword.a) + "%s", string);
        //StaticKeyword staticKeyword1 = new StaticKeyword();
        //  System.out.println(staticKeyword1);

        DifferentPackagetry differentPackagetry = new DifferentPackagetry();

        System.out.printf("\n\n\n\n");
        System.out.println("Inner class:");
        System.out.println("------------");
        StaticKeyword outerObject = new StaticKeyword();
        StaticKeyword.inner innerObject = outerObject.new inner();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);

        System.out.println("\nTop-level class:");
        System.out.println("--------------------");
        StaticNestedClass topLevelObject = new StaticNestedClass();
        topLevelObject.accessMembers(outerObject);

        System.out.println("Trying to access instance members in static main class ");
        StaticKeyword tryingInstanceMethodAccessing = new StaticKeyword();
       // System.out.println(tryingInstanceMethodAccessing.a+" "+ this.a);

    }
}

class TestNestedClass{
    public static void main(String[] args) {
        //StaticKeyword.StaticNestedClass.method1();
        StaticKeyword obj = new StaticKeyword();
        StaticKeyword.inner obj1 =  obj.new inner();
        obj1.accessMembers();
    }
}

class Subclass extends StaticKeyword{
    static String staticOuterField = "static subclass";

    public static void main(String[] args) {

        System.out.println(StaticKeyword.staticOuterField + " "+ Subclass.staticOuterField);
    }
}


class TopLevelClass {

    void accessMembers(StaticKeyword outer) {
        // Compiler error: Cannot make a static reference to the non-static
        //     field OuterClass.outerField
        // System.out.println(OuterClass.outerField);
        System.out.println(outer.outerField);
        System.out.println(StaticKeyword.staticOuterField);
        StaticKeyword instance =new StaticKeyword();
       // System.out.println(this.a);
    }
}

class PassByReference{
     int a, b;
     StaticKeyword staticKeyword;
     PassByReference(StaticKeyword staticKeyword,int a, int b){
         this.a = a;
         this.b = b;
     }
}


class Student {
    //public final String name;
    public Integer num;
    //final int age;
    public void display(){
        final int i;
        System.out.println("In sout ");
        System.out.println("Number of the Student: ");
        //System.out.println("Name of the Student: "+this.name);
        //System.out.println("Age of the Student: "+this.age);
    }

}

class Teacher{
    public static void main(String args[]) {

        Student student = new Student();
      //  student.age = 10;

        student.display();

    }
}



class A5{
    void m(){
        System.out.println("Printing this value in A5 class "+this);//prints same reference ID
    }
}

class A4{
    public static void main(String args[]){
        A4 obj=new A4();
        obj.method();
        //System.out.println("Printing reference obj value "+obj);//prints the reference ID
       //System.out.println("Printing this value in A5 class "+this);
        //obj.m();
    }
    public void method(){
        A5 objA4 = new A5();
        System.out.println("Printing A5 class reference obj value "+objA4);//prints the reference ID
        System.out.println("Printing this value in A3 class "+this);
        objA4.m();

    }
}
