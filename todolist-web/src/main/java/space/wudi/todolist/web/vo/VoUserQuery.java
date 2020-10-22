package space.wudi.todolist.web.vo;

import org.springframework.lang.Nullable;
import space.wudi.todolist.service.dto.DtoUser;

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

    @Override
    public String toString() {
        return "VoUserQuery{" +
                "username='" + username + '\'' +
                ", newCreate=" + newCreate +
                ", generatedPassword='" + generatedPassword + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isNewCreate() {
        return newCreate;
    }

    public void setNewCreate(boolean newCreate) {
        this.newCreate = newCreate;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }

    public static VoUserQuery createFromDto(DtoUser dtoUser){
        return new VoUserQuery(dtoUser.getId(), dtoUser.getUsername());
    }

    public static VoUserQuery createFromDto(DtoUser dtoUser, String plainPassword){
        return new VoUserQuery(dtoUser.getId(), dtoUser.getUsername(), true, plainPassword);
    }


}
