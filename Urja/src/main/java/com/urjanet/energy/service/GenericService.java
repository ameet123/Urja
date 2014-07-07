package com.urjanet.energy.service;

import java.util.List;


/**
 * Declares methods used to obtain and modify entity information.
 * @param <T>
 */
public interface GenericService<T> {

    /**
     * Creates or updates a new entity.
     * @param created   The information of the created entity.
     */
    public T save(T created);

    /**
     * Deletes a entity. will set  FK to null
     * @param entityId  The id of the deleted entity.
     * if no entity is found with the given id, nothing is done
     */
    public void delete(Long entityId);
    
    /**
     * delete a entity by its name
     * @param name
     */
    public void deleteByName(String name);

    /**
     * Finds all entity.
     * @return  A list of entity.
     */
    public List<T> findAll();

    /**
     * Finds entity by id.
     * @param id    The id of the wanted entity.
     * @return  The found entity. If no entity is found, this method returns null.
     */
    public T findById(Long id);

    /**
     * find the entity objects based on a given name
     * @param entityName
     * @return List<T>
     */
    public T findByName(String name);
    
    public T findBySeriesId(String seriesId);

    /**
     * get total count of records in entity table
     * @return long count of records.
     */
    public long getCount();
}