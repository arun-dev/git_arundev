package com.interview.passbyvalu;

public class TestPassByValue {

    public static void main(String[] args) {
        TestPassByValue passByValue = new TestPassByValue();
        int x = 10;
        passByValue.modify(x);
        System.out.println(x);

        Person person = new Person();
        person.setAge(1);
        passByValue.setAgeOfPerson(person);
        System.out.println(person.getAge());
    }

    private void modify(int x){
        x = 5;
    }


    private void setAgeOfPerson(final Person person){
        person.setAge(10);
    }
}
