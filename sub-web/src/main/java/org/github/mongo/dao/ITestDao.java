package org.github.mongo.dao;

import org.github.mongo.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITestDao extends MongoRepository<Test, String> {
}
