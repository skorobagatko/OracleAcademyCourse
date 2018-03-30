package com.skorobahatko.lectures.lecture8.web.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class BeanMapper {

    private static BeanMapper instance;
    private static Mapper mapper;

    private BeanMapper() {
        mapper = new DozerBeanMapper();
    }

    public static synchronized BeanMapper getInstance() {
        if (instance == null) {
            instance = new BeanMapper();
        }
        return instance;
    }

    public static <T> T singleMapper(Object from, Class<T> toClass) {
        return mapper.map(from, toClass);
    }

    public static <T, U> List<U> mapListToList(Iterable<T> iterable, Class<U> toClass) {
        List<U> list = new ArrayList<>();
        for (T t : iterable) {
            list.add(mapper.map(t, toClass));
        }
        return list;
    }
}
