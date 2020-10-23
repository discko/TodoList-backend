package space.wudi.todolist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import space.wudi.todolist.persisitance.entity.User;
import space.wudi.todolist.persisitance.repository.UserRepository;
import space.wudi.todolist.service.service.UserService;
import space.wudi.todolist.service.dto.DtoUser;
import space.wudi.todolist.common.string.StringUtil;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DtoUser queryUser(String username) {
        User exampleUser=new User();
        exampleUser.setUsername(username);
        Example<User> userExample=Example.of(exampleUser);
        Optional<User> oUser=userRepository.findOne(userExample);
        if(oUser.isPresent()){
            User user=oUser.get();
            DtoUser dtoUser=new DtoUser(user.getId(), user.getUsername());
            System.out.println("find the user::"+user);
            return dtoUser;
        }else{
            System.out.println("user not found with username :"+username);
            return new DtoUser(true);
        }
    }

    @Override
    public String createUser(String username) {
        String randomPassword= StringUtil.randmoString(10, true, true, true, true);
        String md5Password=StringUtil.stringToMd5String(randomPassword);
        User newUser=new User();
        newUser.setUsername(username);
        newUser.setPassword(md5Password);
        userRepository.save(newUser);
        System.out.println("Create a User:"+newUser);
        return randomPassword;
    }
}
