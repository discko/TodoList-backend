package space.wudi.todolist.service.dto;

public class DtoUser {

    private boolean notFound;
    private Long id;
    private String username;

    public DtoUser() {
    }

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

    @Override
    public String toString() {
        return "DtoUser{" +
                "notFound=" + notFound +
                ", id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public boolean isNotFound() {
        return notFound;
    }

    public void setNotFound(boolean notFound) {
        this.notFound = notFound;
    }
}
