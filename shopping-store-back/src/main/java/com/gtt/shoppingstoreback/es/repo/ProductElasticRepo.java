package com.gtt.shoppingstoreback.es.repo;

import com.gtt.shoppingstoreback.es.doc.ProductDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductElasticRepo extends ElasticsearchRepository<ProductDoc,Integer> {
    List<ProductDoc> findByProductNameLikeOrProductAbstractLike(String productName,String productAbstract);

}
