package com.devsu.banking.client.util;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

public final class ProjectUtil {

    private ProjectUtil(){
    }

    /**
     * Convert VO to Entity
     * @param source
     * @param targetType
     * @return
     * @param <T>
     */
    public static <T> T convert(Object source, Class<T> targetType) {
        try {
            T entity = targetType.getDeclaredConstructor().newInstance();
            PropertyUtils.copyProperties(entity, source);
            return entity;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                 | InstantiationException e) {
            throw new RuntimeException("Error convert", e);
        }
    }

}
