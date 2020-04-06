package com.puboot.common.util;

import lombok.experimental.UtilityClass;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * AOP工具类
 *
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
@UtilityClass
public class AspectUtil {

    /**
     * 获取以类路径为前缀的键
     *
     * @param point 当前切面执行的方法
     */
    public static String getKeyOfClassPrefix(ProceedingJoinPoint point, String prefix) {
        String keyPrefix = "";
        if (!StringUtils.isEmpty(prefix)) {
            keyPrefix += prefix;
        }
        keyPrefix += getClassName(point);
        return keyPrefix;
    }

    /**
     * 获取当前切面执行的方法所在的class
     *
     * @param point 当前切面执行的方法
     */
    public static String getClassName(ProceedingJoinPoint point) {
        return point.getTarget().getClass().getName().replaceAll("\\.", "_");
    }

    /**
     * 获取当前切面执行的方法的方法名
     *
     * @param point 当前切面执行的方法
     * @throws NoSuchMethodException
     */
    public static Method getMethod(ProceedingJoinPoint point) throws NoSuchMethodException {
        Signature sig = point.getSignature();
        MethodSignature msig = (MethodSignature) sig;
        Object target = point.getTarget();
        return target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
    }

    /**
     * 获取切面缓存的key
     *
     * @param point  当前切面执行的方法
     * @param extra  额外的参数 （非必选）
     * @param prefix key前缀 （非必选）
     * @throws NoSuchMethodException
     */
    public static String getKey(ProceedingJoinPoint point, String extra, String prefix) throws NoSuchMethodException {
        Method currentMethod = getMethod(point);
        String methodName = currentMethod.getName();
        StringBuilder key = new StringBuilder();
        key.append(getKeyOfClassPrefix(point, prefix));
        key.append('_');
        key.append(methodName);
        key.append(CacheKeyUtil.getMethodParamsKey(point.getArgs()));
        key.append(extra == null ? "" : extra);
        return key.toString();
    }
}
