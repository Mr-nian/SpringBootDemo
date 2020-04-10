package com.wego.common.base;


import com.wego.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author caoyn
 * Date   2020/4/9
 */
@Transactional(readOnly = true)
public abstract class BaseService<D extends BaseDao<T>, T> {

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public T get(String id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public T get(T entity) {
        return dao.get(entity);
    }

    /**
     * 查询列表数据
     *
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return dao.findList(entity);
    }

    /**
     * 查询列表数据
     *
     * @return
     */
    public List<T> findAllList() {
        return dao.findAllList();
    }

    /**
     * 保存数据
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public int save(T entity) {
        return dao.insert(entity);
    }

    /**
     * 修改数据
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public int update(T entity) {
        return dao.update(entity);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Transactional(readOnly = false)
    public int delete(String id) {
        return dao.delete(id);
    }

    /**
     * 删除数据
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public int delete(T entity) {
        return dao.delete(entity);
    }
}