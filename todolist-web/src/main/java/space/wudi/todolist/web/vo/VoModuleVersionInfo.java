package space.wudi.todolist.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoModuleVersionInfo {

    private String env;
    private String serial;

}
