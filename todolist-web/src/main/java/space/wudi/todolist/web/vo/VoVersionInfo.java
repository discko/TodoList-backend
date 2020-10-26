package space.wudi.todolist.web.vo;

public class VoVersionInfo {

    public static class ModuleVersionInfo{
        private String env;
        private String serial;

        public ModuleVersionInfo(String env, String serial) {
            this.env = env;
            this.serial = serial;
        }

        public String getEnv() {
            return env;
        }

        public void setEnv(String env) {
            this.env = env;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }
    }

    private ModuleVersionInfo webVersionInfo;
    private ModuleVersionInfo serviceVersionInfo;
    private ModuleVersionInfo securityVersionInfo;
    private ModuleVersionInfo persistenceVersionInfo;
    private ModuleVersionInfo commonVersionInfo;

    public VoVersionInfo() {}

    public VoVersionInfo(ModuleVersionInfo webVersionInfo, ModuleVersionInfo serviceVersionInfo, ModuleVersionInfo securityVersionInfo, ModuleVersionInfo persistenceVersionInfo, ModuleVersionInfo commonVersionInfo) {
        this.webVersionInfo = webVersionInfo;
        this.serviceVersionInfo = serviceVersionInfo;
        this.securityVersionInfo = securityVersionInfo;
        this.persistenceVersionInfo = persistenceVersionInfo;
        this.commonVersionInfo = commonVersionInfo;
    }

    public ModuleVersionInfo getWebVersionInfo() {
        return webVersionInfo;
    }

    public void setWebVersionInfo(ModuleVersionInfo webVersionInfo) {
        this.webVersionInfo = webVersionInfo;
    }

    public ModuleVersionInfo getServiceVersionInfo() {
        return serviceVersionInfo;
    }

    public void setServiceVersionInfo(ModuleVersionInfo serviceVersionInfo) {
        this.serviceVersionInfo = serviceVersionInfo;
    }

    public ModuleVersionInfo getSecurityVersionInfo() {
        return securityVersionInfo;
    }

    public void setSecurityVersionInfo(ModuleVersionInfo securityVersionInfo) {
        this.securityVersionInfo = securityVersionInfo;
    }

    public ModuleVersionInfo getPersistenceVersionInfo() {
        return persistenceVersionInfo;
    }

    public void setPersistenceVersionInfo(ModuleVersionInfo persistenceVersionInfo) {
        this.persistenceVersionInfo = persistenceVersionInfo;
    }

    public ModuleVersionInfo getCommonVersionInfo() {
        return commonVersionInfo;
    }

    public void setCommonVersionInfo(ModuleVersionInfo commonVersionInfo) {
        this.commonVersionInfo = commonVersionInfo;
    }


}
