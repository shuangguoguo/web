package com.sgg.web.mapper;

import java.util.List;

public interface BaseMapper<E>  {

    int insert(E model);
    void insertSelective(E model);
    List<E> getRawLimit(int offset,int pageSize);
    E getRawById(int id);
    void deleteRaw(int id);
    void updateRaw(E model);

}
