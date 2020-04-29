package com.infy.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.infy.model.Book;

public interface BookSearchRepository extends ElasticsearchRepository<Book, Integer> {

}
