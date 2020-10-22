package space.wudi.todolist.service.service;

import space.wudi.todolist.service.dto.DtoUser;

public interface UserService {

    /**
     * query the user
     * @param username user.username
     * @return query result
     */
    DtoUser queryUser(String username);

    /**
     * create a user with random password
     * @param username user.username
     * @return plain password
     */
    String createUser(String username);
}
