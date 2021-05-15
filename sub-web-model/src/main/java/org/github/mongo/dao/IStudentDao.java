package org.github.mongo.dao;

import org.github.mongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStudentDao extends MongoRepository<Student,String> {}
