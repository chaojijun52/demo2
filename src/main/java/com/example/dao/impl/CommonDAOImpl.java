package com.example.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.example.dao.CommonDAO;

public class CommonDAOImpl<T> implements CommonDAO<T> {

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllNativeQuery(EntityManager em, Class<T> clazz, String sql, Map<String, Type> scalars) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery(sql);
//		query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(clazz)).addScalar("id",
//				StandardBasicTypes.LONG);
		NativeQueryImpl<?> impl = query.unwrap(NativeQueryImpl.class);
		scalars.forEach((str, type) -> {
			impl.addScalar(str, type);
		});
		impl.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.getResultList();
	}

	@Override
	public List<T> findByIdNativeQuery(Integer id, EntityManager em, Class<T> clazz, String sql, Map<String, Type> scalars) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, id);
//		query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(clazz)).addScalar("id",
//				StandardBasicTypes.LONG);
		NativeQueryImpl<?> impl = query.unwrap(NativeQueryImpl.class);
		scalars.forEach((str, type) -> {
			impl.addScalar(str, type);
		});
		impl.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.getResultList();
	}

}
