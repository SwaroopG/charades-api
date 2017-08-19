package com.poorjar.charades.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by sgaddameedhi on 8/23/2016.
 */
public interface MovieRepository extends MongoRepository<Movie, String> {
}
