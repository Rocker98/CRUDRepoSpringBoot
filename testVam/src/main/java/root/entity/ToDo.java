package root.entity;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "todo")
    private String todo;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_user")
    private User user;

    public ToDo(){
    }

    public ToDo(String toDo) {
        this.todo = toDo;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", todo='" + todo + '\'' +
                '}';
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
