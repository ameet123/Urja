package com.urjanet.energy.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.transaction.annotation.Transactional;

import com.urjanet.energy.repository.GenericRepository;


/**
 * implementation of the source service. This is used internally to communicate
 * with the database using JPA external clients still access data via the
 * interface - The Type parameter in this case is a little tricky. Interface
 * actually has a type parameter T extends IGenericEntity But we can't use it
 * here instead we bound the class type parameter itself. Otherwise compiler
 * will complain The other parameter is an interface which is extending from 2
 * interfaces - 1. JpaRepository , 2. GenericRepository
 * 
 * @author ac2211
 * @param <T>
 * @param <J>
 *
 */
public abstract class GenericImpl<T, J extends JpaRepository<T, Long> & GenericRepository<T>>
		implements GenericService<T> {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private Class<T> type;
	private J genericRepository;

	protected JpaRepository<T, Long> getRepository() {
		return this.genericRepository;
	}

	protected Logger getLogger() {
		return LOGGER;
	}

	@SuppressWarnings("unchecked")
	public GenericImpl(J genericRepository) {

		this.genericRepository = genericRepository;
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Transactional
	@Override
	public T save(T created) {
		T t = genericRepository.save(created);
		LOGGER.debug("new entity =>" + type.getSimpleName());
		return t;
	}

	@Transactional
	@Override
	public void delete(Long id) {
		try {
			genericRepository.delete(id);
		} catch (EmptyResultDataAccessException er) {
			LOGGER.debug(type.getSimpleName() + "=>" + "No such Id exists:" + id);
		}
	}

	@Transactional
	@Override
	public void deleteByName(String name) {
		LOGGER.debug("deleting " + name + " :" + type.getSimpleName());
		try {
			genericRepository.delete(genericRepository.findByName(name));
		} catch (InvalidDataAccessApiUsageException er) {
			LOGGER.error("No such entity name exists, null entity:" + name + "=>" + type.getSimpleName());
		} catch (JpaObjectRetrievalFailureException er) {
			LOGGER.error("No such entity name exists:" + name + "=>" + type.getSimpleName());
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		return genericRepository.findAll();
	}

	@Override
	public T findByName(String name) {
		return genericRepository.findByName(name);
	}

	@Override
	public T findBySeriesId(String seriesId) {
		return genericRepository.findBySeriesId(seriesId);
	}
	
	@Transactional(readOnly = true)
	@Override
	public T findById(Long id) {
		return genericRepository.findOne(id);
	}

	@Override
	public long getCount() {
		return genericRepository.count();
	}
}