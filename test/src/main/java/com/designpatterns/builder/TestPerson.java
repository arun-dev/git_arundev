package com.designpatterns.builder;

public class TestPerson {
    public static void main(String[] args) throws Exception{
        Person person1 = new Person.Builder(31,"Arundev").build();
        System.out.println(person1.toString());

        Person person2 = new Person.Builder(29,"Divya").nationality("Indian").build();
        System.out.println(person2.toString());
        new Person.Builder().age(1);

    }


    private static void sss(String format){
       /* if(format.equals(SHORT)){

        }else if(format.equals(FULL)){

        }else {

        }*/
    }
}
