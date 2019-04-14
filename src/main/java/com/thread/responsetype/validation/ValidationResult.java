package com.thread.responsetype.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ValidationResult {

    //校验结果属性
    private  boolean ishaserror=false;
    private Map<String,String> result = new HashMap<String, String>();

    public boolean isIshaserror() {
        return ishaserror;
    }

    public void setIshaserror(boolean ishaserror) {
        this.ishaserror = ishaserror;
    }

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }

    //实现一个通用的通过格式化字符串获取错误结果的方法
    public String geterrmsg(){
        return StringUtils.join(result.values().toArray(),",");
    }


}
