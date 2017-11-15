package com.rdyang.hibernate.test;

import org.springframework.stereotype.Repository;

import com.rdyang.hibernate.dao.impl.BaseDaoImpl;
import com.rdyang.hibernate.test.entity.TestEntity;

@Repository
public class TestDaoImpl extends BaseDaoImpl<TestEntity, Integer> implements TestDao {

}
