package space.wudi.todolist.persisitance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    @Column(name="username", nullable = false, unique = true, length = 20)
    private String username;
    @Column(name="password", nullable = false, length = 32)
    private String password;
}
