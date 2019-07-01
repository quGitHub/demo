package cn.itcast.springboot.mybatis.vo.base;

/**
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:43
 * @JDK 1.8
 * @Description 功能模块：
 */
public enum ResultEnum {

    /**
     *
     */
    ERROR_VALUE("-301", "自定义异常返回错误码！"),
    ERROR_SERVER("500", "系统异常，稍后重试"),
    ERROR_Data("201", "查询数据不存在");


    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
