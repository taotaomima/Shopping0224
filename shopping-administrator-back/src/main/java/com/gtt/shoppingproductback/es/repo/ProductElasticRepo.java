package com.gtt.shoppingproductback.es.repo;

import com.gtt.shoppingproductback.es.doc.ProductDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductElasticRepo extends ElasticsearchRepository<ProductDoc,Integer> {
}
