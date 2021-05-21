package org.github.web.mongo.dao;

import org.github.web.mongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStudentDao extends MongoRepository<Student,String> {}
