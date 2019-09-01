package com.wzy.mapper;

import com.wzy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/*
**  以面向对象的方式对POJO类的操作映射称为永久的持久化操作
 */
public interface UserMapper {

    /*
    **  根据指定的username,password查询用户
     */
    @Select("select * from user_inf where uname = #{uname} and passwd = #{password}")
    public User findUserByUsernameAndPasswd(@Param("uname")String uname,
                                            @Param("password") String password);

    /*
    **  向数据库插入一条用户记录
     */
    @Insert("insert into user_inf(uname, passwd, gentle, email, city) values (#{uname},#{passwd},#{gentle},#{email},#{city})")
    @Options(useGeneratedKeys = true, keyProperty="id")
    public void saveUser(User user);

    /*
    **  根据指定的username查询用户
     */
    @Select("select * from user_inf where uname = #{uname}")
    public User findUserByUname(String s, @Param("uname") String uname);

    /*
     **  根据指定的username查询用户
     */
    @Select("select * from user_inf where id = #{id}")
    public User findUserByUid(@Param("id")int id);
}
