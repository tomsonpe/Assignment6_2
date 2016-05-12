package com.assignment_6_2.repositories;

import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Phinda Encore Tomson on 4/18/2016.
 */
public interface  Repository<E,ID> {
    E findById(ID id);

    E save(E entity) throws SQLException;

    E update(E entity) throws SQLException;

    E delete(E entity) throws SQLException;

    Set<E> findAll() throws SQLException;

    int deleteAll() throws SQLException;
}
