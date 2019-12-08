package com.example.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.type.Type;

public interface CommonDAO<T> {
	List<T> findAllNativeQuery(EntityManager em, Class<T> clazz, String sql, Map<String, Type> scalars);
}
