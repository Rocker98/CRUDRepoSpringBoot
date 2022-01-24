package root.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usertodos")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "user")
    private List<ToDo> toDoList;

    public User(){
    }

    public User(String username, String surname) {
        this.user_name = username;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public void addTodoToUser(ToDo toDo){
        if(toDoList == null){
            toDoList = new ArrayList<>();
        }
        toDoList.add(toDo);
        toDo.setUser(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
