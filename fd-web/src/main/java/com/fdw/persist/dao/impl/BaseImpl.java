package com.fdw.persist.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * 接口公共
 */
@Repository
public class BaseImpl {

    protected static final String NAME_SPACE_HEADER = "com.fdw.mybatis.mapper";

    @Resource
    protected SqlSessionTemplate sqlSessionTemplate;

}
