package com.example.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.type.Type;
import org.springframework.data.domain.Pageable;

public interface CommonDAO<T> {
	List<T> findAllNativeQuery(EntityManager em, Class<T> clazz, String sql, Map<String, Type> scalars, Map<String, Object> params, Pageable pageable);
	List<T> findByIdNativeQuery(Integer id, EntityManager em, Class<T> clazz, String sql, Map<String, Type> scalars, Map<String, Object> params);
}
