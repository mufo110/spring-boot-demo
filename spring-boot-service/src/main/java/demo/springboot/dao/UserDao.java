package demo.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import demo.springboot.model.Users;

/**
 * 使用Mapper方式操纵数据库 <br/>
 * 类UserDao.java的实现描述：TODO 类实现描述
 * 
 * @author macma 2016年9月23日 下午5:13:19
 */
public interface UserDao {

    @Select(value = { "select * from users where username = #{username}" })
    public Users getUserInfo(String username);

    @Select(value = { "select * from users" })
    @Results({ @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"), @Result(column = "enabled", property = "enabled") })
    public List<Users> getAllUserInfo();

    @Select(value = "insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
    public void addUser(@Param("username") String id, @Param("password") String age, @Param("enabled") int name);

    @Select(value = "update users set username=#{user.username},password=#{user.password} where username=#{user.username}")
    public void updateUser(@Param("user") Users user);

}
