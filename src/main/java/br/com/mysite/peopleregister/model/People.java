package br.com.mysite.peopleregister.model;


import jakarta.persistence.*;

@Entity
@Table(name = "people")
public class People {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private Integer age;
    private String cpf;
    private String gender;

    public People(PeopleRC people){
        this.email = people.email();
        this.name = people.name();
        this.age = people.age();
        this.cpf = people.cpf();
        this.gender = people.gender();
    }

    public People(){}

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public String getGender() {
        return gender;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "People{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cpf='" + cpf + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void update(PeopleEditRC peopleEditRC) {
        this.email = peopleEditRC.email();
        this.name = peopleEditRC.name();
        this.age = peopleEditRC.age();
        this.cpf = peopleEditRC.cpf();
        this.gender = peopleEditRC.gender();
    }
}
