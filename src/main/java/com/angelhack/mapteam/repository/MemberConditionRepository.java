package com.angelhack.mapteam.repository;

import com.angelhack.mapteam.model.MemberCondition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MemberConditionRepository  extends CrudRepository<MemberCondition,String> {
    @Query("SELECT usr FROM MemberCondition usr  WHERE usr.email =:email ")
    public MemberCondition searchByEmail(@Param(value ="email" ) String email);
}
