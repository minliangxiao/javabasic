package club.huangliang.interview.java8.Stream_API.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Employee {
    private String name;
    private Integer age;
    private Status status;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee(String name, Integer age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }


    public enum Status{
        BUSY,FREE,VOCATION
    }

}
