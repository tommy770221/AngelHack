package com.angelhack.mapteam.repository;

import com.angelhack.mapteam.model.MemberMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMessageRepository extends CrudRepository<MemberMessage,String> {


    @Query("SELECT usr FROM MemberMessage usr  WHERE (usr.toEmail =:toEmail and usr.toEmail=:fromEmail) or " +
            "(usr.fromEmail =:toEmail and usr.fromEmail=:fromEmail) order by usr.createDate desc")
    public List<MemberMessage> searchByEmailAndDate(@Param(value ="toEmail" ) String toEmail,
                                                    @Param(value ="fromEmail" ) String fromEmail);


}
