package space.wudi.todolist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.wudi.todolist.service.service.UserService;
import space.wudi.todolist.service.dto.DtoUser;
import space.wudi.todolist.web.vo.VoUserQuery;

@RestController
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/user/{username}")
    public VoUserQuery userQuery(@PathVariable String username){

        DtoUser dtoUser=userService.queryUser(username);
        if(!dtoUser.isNotFound()){
            return VoUserQuery.createFromDto(dtoUser);
        }
        String plainPassword=userService.createUser(username);
        DtoUser dtoUser2=userService.queryUser(username);
        return VoUserQuery.createFromDto(dtoUser2, plainPassword);
    }


}
