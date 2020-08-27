package com.designpatterns.builder;

import java.util.Locale;

public class Person {
    private int age;
    private String name;
    private String nationality;

    private Person (final Builder builder){
        this.age = builder.age;
        this.name = builder.name;
        this.nationality = builder.nationality;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public static class Builder{
        private int age;
        private String name;
        private String nationality;

        public Builder(){
        }

        public Builder(final int age, final String name){
            this.age = age;
            this.name = name;
        }

        public Builder age(final int age){
            this.age = age;
            return this;
        }

        public Builder name( final String name){
            this.name = name;
            return this;
        }

        public Builder nationality(final String nationality){
            this.nationality = nationality;
            return this;
        }

        public Person build(){
            Person person = new Person(this);
            //validateObject(person) // if you want you can create validate methods.
            return person;
        }
    }
}
