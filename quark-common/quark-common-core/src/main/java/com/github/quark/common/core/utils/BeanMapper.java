package com.github.quark.common.core.utils;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2019-03-21
 **/
public class BeanMapper {
    private static Mapper dozerBeanMapper = DozerBeanMapperBuilder.buildDefault();

    /**
     * 转换对象列表
     *
     * @param fromList 来源对象列表
     * @param toClass  目标对象类类型
     * @return list of TO
     */
    public static <FROM, TO> List<TO> convert(List<FROM> fromList, final Class<TO> toClass) {
        return fromList
                .stream()
                .map(from -> dozerBeanMapper.map(from, toClass))
                .collect(Collectors.toList());
    }

    /**
     * @param from    来源对象
     * @param toClass 目标对象类类型
     * @return TO
     */
    public static <FROM, TO> TO convert(FROM from, Class<TO> toClass) {
        if (from == null) {
            return null;
        }
        return dozerBeanMapper.map(from, toClass);
    }

    public static <FROM, TO> TO convert(FROM from, TO to) {
        if (from == null || to == null) {
            return null;
        }
        dozerBeanMapper.map(from, to);
        return to;
    }
}
