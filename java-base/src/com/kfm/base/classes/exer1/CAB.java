package com.kfm.base.classes.exer1;

public class CAB {
//    Person person1 = new Person("张三",'男',23,true);
//    Person person2 = new Person("李四",'女',23,true);
    private Boolean canMarry(Person person1,Person person2){
        if (person1.getGender().equals(person2.getGender())){
            return false;
        } else if (person1.getGender() == '男') {
            if (person1.getAge()<= 22 || person2.getAge() <= 20){
                return false;
            }else if ((person1.getMarry() & person2.getMarry()) == false){
                return false;
            }else {
                return true;
            }
        } else if (person2.getGender() == '男') {
            if (person2.getAge()<= 22 || person1.getAge() <= 20){
                return false;
            }else if ((person1.getMarry() & person2.getMarry()) == false){
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
    public void canMary(Person person1,Person person2){
        boolean flag = canMarry(person1,person2);
        if (flag){
            System.out.println(person1.getName()+"和"+ person2.getName()+"可以结婚");
        }else {
            System.out.println(person1.getName()+"和"+ person2.getName()+"不可以结婚");
        }

    }
}
