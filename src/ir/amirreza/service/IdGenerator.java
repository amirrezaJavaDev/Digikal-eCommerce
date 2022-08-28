package ir.amirreza.service;

import ir.amirreza.model.Entity;
import ir.amirreza.model.dao.Dao;

import java.util.Comparator;
import java.util.function.Function;

public class IdGenerator<T extends Entity> {

    private Dao<T> dao;

    public IdGenerator(Dao<T> dao) {this.dao = dao;}

    public long getNextId() {
         Long lastPersistedId = dao.getAll().stream()
                .map(Entity::getId)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(0L);

        return lastPersistedId++;
    }

}