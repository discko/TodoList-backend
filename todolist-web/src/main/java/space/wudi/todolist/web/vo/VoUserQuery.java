package space.wudi.todolist.web.vo;

import lombok.Data;
import org.springframework.lang.Nullable;
import space.wudi.todolist.service.dto.DtoUser;

@Data
public class VoUserQuery {
    private Long id;
    private String username;
    private boolean newCreate;
    private String generatedPassword;

    public VoUserQuery() {
    }

    public VoUserQuery(Long id, String username, boolean newCreate, @Nullable String generatedPassword) {
        this.id = id;
        this.username = username;
        this.newCreate = newCreate;
        this.generatedPassword = generatedPassword;
    }

    public VoUserQuery(Long id, String username) {
        this.id = id;
        this.username = username;
        this.newCreate = false;
        this.generatedPassword = null;
    }

    public static VoUserQuery createFromDto(DtoUser dtoUser){
        return new VoUserQuery(dtoUser.getId(), dtoUser.getUsername());
    }

    public static VoUserQuery createFromDto(DtoUser dtoUser, String plainPassword){
        return new VoUserQuery(dtoUser.getId(), dtoUser.getUsername(), true, plainPassword);
    }


}
