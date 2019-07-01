/**
 *
 */
package cn.itcast.springboot.mybatis.vo.base;

/**
 * @author guod
 * @version 3.0
 * @date 日期:2018年4月20日 时间:上午11:02:17
 * @JDK 1.8
 * @Description 功能模块：
 */
public class JsonList extends Json {
    private Object dataRows;

    private Long total;

    public Object getDataRows() {
        return dataRows;
    }

    public void setDataRows(Object dataRows) {
        this.dataRows = dataRows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "JsonList{" +
                super.toString().replaceAll("Json\\{", "").replaceAll("}", "") +
                ", dataRows=" + dataRows +
                ", total=" + total +
                '}';
    }
}