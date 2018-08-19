package com.lynk.system.bip;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lynk
 * @since 2017/11/10
 */
public class BipResult {
    public static String INPUT_EXTERNAL_DOMAIN = "externalDomain";
    public static String INPUT_MEDIUM = "medium";
    public static String INPUT_SERIAL_NUMBER = "serialNumber";
    public static String INPUT_TELLER_CODE = "tellerCode";
    public static String INPUT_ORG_CODE = "orgCode";

    private Map<String, Object> input;
    private String type;
    private String returnCode;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public Object getInputData(String key) {
        return input.get(key);
    }

    public void setInput(Map<String, Object> input) {
        this.input = input;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public boolean isSuccess() {
        return "S".endsWith(type);
    }

    public void putData(Object key, Object value) {
        this.data.put(key.toString(), value == null? "": value.toString());
    }

    public Object getData(String key) {
        if (data != null) {
            return data.get(key) == null? "": data.get(key);
        } else {
            return "";
        }
    }
}
