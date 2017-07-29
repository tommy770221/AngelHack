package com.angelhack.mapteam.repository;

import com.angelhack.mapteam.model.Country;
import com.angelhack.mapteam.model.MemberUser;
import org.springframework.data.repository.CrudRepository;

public interface MemberUserRepository extends CrudRepository<MemberUser,String> {


}
