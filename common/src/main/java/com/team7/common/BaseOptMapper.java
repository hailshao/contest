package com.team7.common;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.delete.DeleteMapper;
import tk.mybatis.mapper.common.base.insert.InsertMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;
import tk.mybatis.mapper.common.base.select.SelectCountMapper;
import tk.mybatis.mapper.common.base.select.SelectMapper;
import tk.mybatis.mapper.common.base.select.SelectOneMapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeyMapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;

/**
 * @param <T>
 * @author zhangsan
 */
@RegisterMapper
public interface BaseOptMapper<T>
        extends SelectOneMapper<T>, SelectMapper<T>, SelectCountMapper<T>, InsertMapper<T>, InsertSelectiveMapper<T>,
        UpdateByPrimaryKeyMapper<T>, UpdateByPrimaryKeySelectiveMapper<T>, DeleteMapper<T>, Marker {

}
