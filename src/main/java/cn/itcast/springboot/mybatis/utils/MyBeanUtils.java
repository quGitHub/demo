package cn.itcast.springboot.mybatis.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 功能:把源对象的不为空的属性复制到目标对象中
 * 版本: 1.0
 * 开发人员: lyf
 * 创建日期: 2017年9月6日
 * 修改日期: 2017年9月6日
 * 修改列表:
 */
public class MyBeanUtils extends BeanUtils {
    /**
     * 功能：把源对象的不为空的属性复制到目标对象中
     *
     * @throws BeansException
     */
    public static void copyNotNullProperties(Object source, Object target, String... properties) throws BeansException {
        Assert.notNull(source, "被复制的对象不能为空");
        Assert.notNull(target, "目标对象不能为空");

        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> ignoreList = (properties != null ? Arrays.asList(properties) : null);
        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreList == null || ignoreList.size() == 0 || ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            Object value = readMethod.invoke(source);
                            //只拷贝不为null的属性
                            if (value != null) {
                                if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                    writeMethod.setAccessible(true);
                                }
                                writeMethod.invoke(target, value);
                            }
                        } catch (Throwable ex) {
                            throw new FatalBeanException("不能复制属性 '" + targetPd.getName() + "' 到目标对象", ex);
                        }
                    }
                }
            }
        }
    }

    public static void copyWithNullStringToEmpty(Object source, Object target) {
        Class<?> aClass = source.getClass();
        Class<?> targetClass = target.getClass();
        try {
            PropertyDescriptor[] sourcePds = getPropertyDescriptors(aClass);
            for (PropertyDescriptor pd : sourcePds) {
                String key = pd.getName();
                Method getter = pd.getReadMethod();
                Object value = getter.invoke(source);

                PropertyDescriptor propertyDescriptor = getPropertyDescriptor(targetClass, key);
                if (null != propertyDescriptor) {
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (writeMethod != null) {
                        writeMethod.setAccessible(true);
                        String name = propertyDescriptor.getPropertyType().getName();
                        if (null == value) {
                            if (name.equals("java.lang.String")) {
                                writeMethod.invoke(target, "");
                            }
                        } else {
                            if (value instanceof Date) {
                                if (name.equals("java.lang.String")) {
                                    Date date = (Date) value;
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    String format = sdf.format(date);
                                    writeMethod.invoke(target, format);
                                } else {
                                    writeMethod.invoke(target, value);
                                }
                            } else {
                                writeMethod.invoke(target, value);
                            }

                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        ClientInfoEntity clientInfoEntity = new ClientInfoEntity();
        clientInfoEntity.setUserType("1");
        clientInfoEntity.setAge(10);

        ClientInfoVo clientInfoVo = new ClientInfoVo();
        copyWithNullStringToEmpty(clientInfoEntity, clientInfoVo);
        System.out.println(clientInfoEntity);
        System.out.println(clientInfoVo);

    }*/
}
