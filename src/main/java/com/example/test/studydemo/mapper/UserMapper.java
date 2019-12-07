package com.example.test.studydemo.mapper;

import com.example.test.studydemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description
 * User :LT
 * Date : 2019-12.7-07  10:06
 */

@Mapper
public interface UserMapper {
   @Insert("insert  into user (account_id,name,token,gmt_create,gmt_modified) values ( #{accountId},#{name},#{token},#{gmtCreate},#{gmtModified} )")
   void insert (User user);

}
