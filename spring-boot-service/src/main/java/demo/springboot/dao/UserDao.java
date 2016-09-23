package demo.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import demo.springboot.model.Users;

public interface UserDao {

    @Select(value = { "select * from users where username = #{username}" })
    public Users getUserInfo(String username);

    @Select(value = { "select * from users" })
    @Results({ @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"), @Result(column = "enabled", property = "enabled") })
    public List<Users> getAllUserInfo();

    @Select(value = "insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
    public int addUser(@Param("username") String id, @Param("password") String age, @Param("enabled") int name);

}
