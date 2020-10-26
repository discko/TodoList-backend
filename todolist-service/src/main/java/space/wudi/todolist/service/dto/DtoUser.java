package space.wudi.todolist.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DtoUser {

    private boolean notFound;
    private Long id;
    private String username;

    public DtoUser(boolean notFound) {
        this.notFound = notFound;
        this.id=null;
        this.username=null;
    }

    public DtoUser(Long id, String username) {
        this.notFound = false;
        this.id = id;
        this.username = username;
    }
}
