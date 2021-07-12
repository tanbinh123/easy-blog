package com.yccztt.repository;

import com.yccztt.domain.label.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author hyz
 * @create 2021-07-04 下午3:56
 */
public interface LabelRepository extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {

    Label findByLabel(String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM b_label WHERE id =?1",nativeQuery = true)
    void deleteLabel(String labelId);
}
