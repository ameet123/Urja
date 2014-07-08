package com.urjanet.energy.repository;

/**
 * generic interface. This gives us boilerplate methods
 * which will actually be instrumented automatically by
 * Spring JPA Repositories. That's where the magic happens
 * so by simply creating our custom interface 
 * and adding to implementation classes ALONG with 
 * JPARepository interface, we are able to augment 
 * Database query methods
 * @author ac2211
 * @param <T>
 * @param <T>
 *
 */
public interface GenericCategoryRepository<T>{
	T findByName(String name);
}