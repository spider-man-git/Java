package com.cmyzzf.mapper;

import com.cmyzzf.model.Money;
import com.cmyzzf.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMoneyMapper {

    @Insert("INSERT INTO money(user_id,money) VALUES(#{money.userId},#{money.money})")
    int insert(@Param("money") Money money);


}
