package com.yccztt.repository;

import com.yccztt.domain.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author hyz
 * @create 2021-06-19 下午11:21
 */
public interface ArticleRepository extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

    Article getArticleById(String id);

    List<Article> queryArticlesByReadable(String isReadable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE b_article SET readable = 'N' WHERE id =?1",nativeQuery = true)
    void deleteBlog(String bid);

}
