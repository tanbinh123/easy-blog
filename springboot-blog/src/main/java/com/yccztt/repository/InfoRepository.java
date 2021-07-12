package com.yccztt.repository;

import com.yccztt.domain.info.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author hyz
 * @create 2021-06-14 下午5:41
 */
public interface InfoRepository extends JpaRepository<Info,String> , JpaSpecificationExecutor<Info> {

    @Transactional
    @Modifying
    @Query(value = "update Info set viewNum = viewNum+1 where id = 1 ")
    void addView();

}
