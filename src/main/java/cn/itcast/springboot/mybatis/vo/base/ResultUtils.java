package cn.itcast.springboot.mybatis.vo.base;

/**
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:44
 * @JDK 1.8
 * @Description 功能模块：统一的json和jsonlist数据返回格式
 */
public class ResultUtils {
    /**
     * 功能描述：单数据返回
     *
     * @param object
     * @return
     */
    public static Json successJson(Object object) {
        Json result = new Json();
        result.setCode("200");
        result.setMessage("成功");
        result.setData(object);
        result.setSuccess(true);
        return result;
    }

    public static Json successJson() {
        return successJson(null);
    }

    public static Json successJson(String message) {
        Json result = new Json();
        result.setCode("200");
        result.setMessage(message);
        result.setSuccess(true);
        return result;
    }

    public static Json successJson(String message, Object data) {
        Json result = new Json();
        result.setCode("200");
        result.setMessage(message);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static Json errorJson(String code, String msg) {
        Json result = new Json();
        result.setCode(code);
        result.setMessage(msg);
        result.setSuccess(false);
        return result;
    }




    /**
     * 功能描述：多数据返回
     *
     * @param object
     * @return
     */
    public static JsonList successJsonList(Object object) {
        JsonList result = new JsonList();
        result.setSuccess(true);
        result.setCode("200");
        result.setMessage("成功");
        result.setDataRows(object);
        return result;
    }


    /**
     * 功能描述：多数据返回对象list带分页参数total
     *
     * @param object
     * @param total
     * @return
     */
    public static JsonList successJsonListTotal(Object object, Long total) {
        JsonList result = new JsonList();
        result.setSuccess(true);
        result.setCode("200");
        result.setMessage("成功");
        result.setDataRows(object);
        result.setTotal(total);
        return result;
    }

    /**
     * 功能描述：同时返回一个对象和一个对象list和分页total
     *
     * @param data
     * @param list
     * @param total
     * @return
     */
    public static JsonList successJson2JsonListTotal(Object data, Object list, Long total) {
        JsonList result = new JsonList();
        result.setSuccess(true);
        result.setCode("200");
        result.setMessage("成功");
        result.setData(data);
        result.setDataRows(list);
        result.setTotal(total);
        return result;
    }

    public static JsonList successJsonList() {
        return successJsonList(null);
    }

    public static JsonList errorJsonList(String code, String msg) {
        JsonList result = new JsonList();
        result.setCode(code);
        result.setMessage(msg);
        result.setSuccess(false);
        return result;
    }
}