package com.belle.bdc;


import cn.hutool.core.io.resource.ResourceUtil;
import com.belle.bdc.util.ConfRootBean;
import com.belle.bdc.util.ProjectConfig;


import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author : zhuhaohao
 * @date : 2022-12-7 14:37:54
 */
public class FlinkcdcApplication {
    public static void main(String[] args) throws Exception {
        //TODO 从外部读取配置文件，进行多库多表同步
        ParameterTool param = ParameterTool.fromArgs(args);
        String configPath = param.get("config_path");
        String confStr = ResourceUtil.readUtf8Str(configPath);
        ObjectMapper map = new ObjectMapper();
        ConfRootBean confRootBean = map.readValue(confStr, ConfRootBean.class);
        //保证覆盖写的时候，可以以命令行的为最高优先级
        ParameterTool finalParam = ParameterTool.fromPropertiesFile(configPath).mergeWith(param);
        // 将配置文件配置 设置为静态变量的方式 方便配置调用
        ProjectConfig.initConfig(finalParam);
        //传入参数，方便在下游解析的时候，可以添加额外配置
        new FlinkcdcApplication().run(finalParam);
    }

    public void run(ParameterTool param){

    }

    public static ConfRootBean setPara(ParameterTool param, ConfRootBean jParam){

        return jParam;
    }
}
