package com.infy.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.infy.model.Library;


public interface LibrarySearchRepository extends ElasticsearchRepository<Library, Integer> {

}
