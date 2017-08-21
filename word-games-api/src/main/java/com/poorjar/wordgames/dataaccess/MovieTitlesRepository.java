package com.poorjar.wordgames.dataaccess;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Swaroop G
 */
public interface MovieTitlesRepository extends JpaRepository<MovieTitle, Long> {
    Long countByYear(int year);
    Collection<MovieTitle> findByYear(int year);
}
