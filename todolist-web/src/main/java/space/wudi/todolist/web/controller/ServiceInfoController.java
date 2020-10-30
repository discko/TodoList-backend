package space.wudi.todolist.web.controller;

import lombok.extern.slf4j.Slf4j;
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
import space.wudi.todolist.web.WebConfig;
import space.wudi.todolist.web.vo.VoModuleVersionInfo;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value="/ServiceInfo")
public class ServiceInfoController {

    private static Map<String, VoModuleVersionInfo> versionInfo;

    @PostConstruct
    void postConstruct(){
        versionInfo=new HashMap<>();
    }

    @Bean
    @DependsOn({"bindWebEnv",
            "bindServiceEnv",
            "bindSecurityEnv",
            "bindPersistenceEnv",
            "bindCommonEnv"})
    void bindVersionInfo(){
        versionInfo.put("web", new VoModuleVersionInfo(WebConfig.WEB_ENV, WebConfig.WEB_SERIAL));
        versionInfo.put("service", new VoModuleVersionInfo(ServiceConfig.SERVICE_ENV, ServiceConfig.SERVICE_SERIAL));
        versionInfo.put("security", new VoModuleVersionInfo(SecurityConfig.SECURITY_ENV, SecurityConfig.SECURITY_SERIAL));
        versionInfo.put("persistence", new VoModuleVersionInfo(PersistenceConfig.PERSISTENCE_ENV, PersistenceConfig.PERSISTENCE_SERIAL));
        versionInfo.put("common", new VoModuleVersionInfo(CommonConfig.COMMON_ENV, CommonConfig.COMMON_SERIAL));
        log.debug("create {}", versionInfo);
    }

    @GetMapping(value="/version/{module}")
    public VoModuleVersionInfo getModuleVersion(@PathVariable String module){
        VoModuleVersionInfo mvi=_getModuleVersion(module);
        return mvi;
    }

    private VoModuleVersionInfo _getModuleVersion(String module){
        VoModuleVersionInfo mvi=versionInfo.getOrDefault(module, null);
        log.debug("module {}: {}", module, mvi);
        return mvi;
    }

    @GetMapping(value="/version/{module}/{part}")
    public String getModuleVersionPart(
            @PathVariable String module,
            @PathVariable String part
    ){
        VoModuleVersionInfo mvi=_getModuleVersion(module);
        if(mvi==null){
            log.debug("module not found when get module.part");
            return null;
        }
        String val=null;
        switch(part.toLowerCase()){
            case "env":
                val=mvi.getEnv();
                break;
            case "serial":
                val=mvi.getSerial();
                break;
        }
        log.debug("version part: {}.{}: {}", module, part, val);
        return val;
    }

    @GetMapping(value="/version")
    public Map<String, VoModuleVersionInfo> getVersion(){
        log.debug("print version info: {}", versionInfo);
        return versionInfo;
    }

}
