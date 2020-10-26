package space.wudi.todolist.web.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.wudi.todolist.common.CommonConfig;
import space.wudi.todolist.persisitance.PersistenceConfig;
import space.wudi.todolist.security.SecurityConfig;
import space.wudi.todolist.service.ServiceConfig;
import space.wudi.todolist.web.TodolistWebApplication;
import space.wudi.todolist.web.vo.VoVersionInfo;

@RestController
@RequestMapping(value="/ServiceInfo")
public class ServiceInfoController {

    private static VoVersionInfo versionInfo;

    @Bean
    @DependsOn({"bindWebEnv",
            "bindServiceEnv",
            "bindSecurityEnv",
            "bindPersistenceEnv",
            "bindCommonEnv"})
    void bindVersionInfo(){
        versionInfo=new VoVersionInfo();
        versionInfo.setWebVersionInfo(new VoVersionInfo.ModuleVersionInfo(TodolistWebApplication.WEB_ENV, TodolistWebApplication.WEB_SERIAL));
        versionInfo.setServiceVersionInfo(new VoVersionInfo.ModuleVersionInfo(ServiceConfig.SERVICE_ENV, ServiceConfig.SERVICE_SERIAL));
        versionInfo.setSecurityVersionInfo(new VoVersionInfo.ModuleVersionInfo(SecurityConfig.SECURITY_ENV, SecurityConfig.SECURITY_SERIAL));
        versionInfo.setPersistenceVersionInfo(new VoVersionInfo.ModuleVersionInfo(PersistenceConfig.PERSISTENCE_ENV, PersistenceConfig.PERSISTENCE_SERIAL));
        versionInfo.setCommonVersionInfo(new VoVersionInfo.ModuleVersionInfo(CommonConfig.COMMON_ENV, CommonConfig.COMMON_SERIAL));

    }

    @GetMapping(value="/version/{module}")
    public VoVersionInfo.ModuleVersionInfo getModuleVersion(@PathVariable String module){
        switch(module.toLowerCase()){
            case "web":
                return versionInfo.getWebVersionInfo();
            case "service":
                return versionInfo.getServiceVersionInfo();
            case "security":
                return versionInfo.getSecurityVersionInfo();
            case "persistence":
                return versionInfo.getPersistenceVersionInfo();
            case "common":
                return versionInfo.getCommonVersionInfo();
            default:
                return null;
        }
    }

    @GetMapping(value="/version/{module}/{part}")
    public String getModuleVersionPart(
            @PathVariable String module,
            @PathVariable String part
    ){
        VoVersionInfo.ModuleVersionInfo mvi=getModuleVersion(module);
        switch(part.toLowerCase()){
            case "env":
                return mvi.getEnv();
            case "serial":
                return mvi.getSerial();
            default:
                return null;
        }
    }

    @GetMapping(value="/version")
    public VoVersionInfo getVersion(){
        return versionInfo;
    }


}
