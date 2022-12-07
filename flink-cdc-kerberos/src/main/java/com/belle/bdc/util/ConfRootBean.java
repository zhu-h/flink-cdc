package com.belle.bdc.util;

import lombok.Data;

import java.util.List;

/**
 * @author : zhuhaohao
 * @date :
 */
@Data
public class ConfRootBean {
    private List<Source> source;
    private Sink sink;
}
