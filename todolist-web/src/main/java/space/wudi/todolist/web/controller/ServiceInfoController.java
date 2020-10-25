package space.wudi.todolist.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ServiceInfo")
public class ServiceInfoController {
    @Value("${my-variables.version.profile}")
    public String profile;

    @Value("${my-variables.version.serial}")
    public String serial;

    @GetMapping(value="/version/profile")
    public String getVersionProfile(){
        return profile;
    }

    @GetMapping(value="/version/serial")
    public String getVersionSerial(){
        return serial;
    }

    @GetMapping(value="/version")
    public String getVersion(){
        return String.format("%s.%s", profile, serial);
    }


}
