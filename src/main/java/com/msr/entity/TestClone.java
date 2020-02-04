package com.msr.entity;

/**
 * @description: 测试通过序列化，深度克隆
 * @author: MaiShuRen
 * @date: 2019/12/13 15:59
 * @version: v1.0
 */

public class TestClone {

    public static void main(String[] args) {
        Student student = new Student(1, "zhangsan", 18, new Person("1", "zhangsan", 18));
        try {
            Student student1 = ObjectCloneUtil.clone(student);
            System.out.println(student==student1);
            System.out.println(student.getPerson()==student1.getPerson());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
