package com.example.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.query.QueryUtils;

import com.example.controller.StudentAndScoreController;
import com.example.dao.CommonDAO;

public class CommonDAOImpl<T> implements CommonDAO<T> {
	private static final Logger LOG = LogManager.getLogger(CommonDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllNativeQuery(EntityManager em, Class<T> clazz, String sql, Map<String, Type> scalars,
			Map<String, Object> params, Pageable pageable) {
		// TODO Auto-generated method stub
		String sortedQueryString=sql;
		if(pageable!=null) {
			if(pageable.getSort()!=null) {
				sortedQueryString = QueryUtils.applySorting(sql, pageable.getSort());
			}
		}
		Query query = em.createNativeQuery(sortedQueryString);
		if(pageable!=null) {
			if(pageable.isPaged()) {
				query.setFirstResult((int) pageable.getOffset());
				query.setMaxResults(pageable.getPageSize());
			}
		}
//		query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(clazz)).addScalar("id",
//				StandardBasicTypes.LONG);
		NativeQueryImpl<?> impl = query.unwrap(NativeQueryImpl.class);
		if (params != null) {
			params.forEach((name, value) -> {
				impl.setParameter(name, value);
			});
		}
		if (scalars != null) {
			scalars.forEach((str, type) -> {
				impl.addScalar(str, type);
			});
		}
		impl.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.getResultList();
	}

	@Override
	public List<T> findByIdNativeQuery(Integer id, EntityManager em, Class<T> clazz, String sql,
			Map<String, Type> scalars, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, id);
//		query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(clazz)).addScalar("id",
//				StandardBasicTypes.LONG);
		NativeQueryImpl<?> impl = query.unwrap(NativeQueryImpl.class);
		if (params != null) {
			params.forEach((name, value) -> {
				impl.setParameter(name, value);
			});
		}
		if (scalars != null) {
			scalars.forEach((str, type) -> {
				impl.addScalar(str, type);
			});
		}
		impl.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.getResultList();
	}

}
