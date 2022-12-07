package com.belle.bdc.util;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.kafka.common.protocol.types.Field;

import java.util.Properties;

/**
 * @author : zhuhaohao
 * @date :
 */
public class ProjectConfig {

    public static String SINK_BROKERS;
    public static String SINK_TOPIC;
    public static String ERROR_SINK_BROKERS;
    public static String ERROR_SINK_TOPIC;

    public static Source SOURCELIST;

    public static void initConfig(ParameterTool parameterTool){

        Properties props = parameterTool.getProperties();
        for (String propertyName : props.stringPropertyNames()) {
            if (propertyName.startsWith("source")){
                System.out.println(propertyName);
            }
        }


        SINK_TOPIC = parameterTool.get("sink.kafka.topic");
        SINK_BROKERS = parameterTool.get("sink.kafka.brokers");
        ERROR_SINK_TOPIC = parameterTool.get("error.sink.kafka.topic");
        ERROR_SINK_BROKERS = parameterTool.get("error.sink.kafka.brokers");
    }
}
