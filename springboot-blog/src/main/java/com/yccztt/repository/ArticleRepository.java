package com.yccztt.repository;

import com.yccztt.domain.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hyz
 * @create 2021-06-19 下午11:21
 */
public interface ArticleRepository extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {
}
