package com.bootcoding.review.reviewsystem.repository;

import com.bootcoding.review.reviewsystem.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Repository
public class UserRepository {
    public UserRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void save(User user){
        try{
            String query ="INSERT into app_user(user_name,emailid,phonno) " +"values('"+user.getUsername()+"',"+
                    "'"+user.getEmailId()+"',"+user.getPhonno()+")";
            jdbcTemplate.update(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public User getUserById(int userId){
        try {
            String sql = "SELECT * FROM app_user WHERE id=?";

            return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setUsername(rs.getString("user_name"));
                    user.setEmailId(rs.getString("emailid"));
                    user.setPhonno(rs.getLong("phonno"));
                    return user;
                }
            });
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers(){
        try{
            String sql = "SELECT * FROM app_user";
            return jdbcTemplate.query(sql, new RowMapper<User>(){

                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setUsername(rs.getString("user_name"));
                    user.setEmailId(rs.getString("emailid"));
                    user.setPhonno(rs.getLong("phonno"));
                                        return user;
                }
            });
        }

        catch (Exception e){
            e.printStackTrace();
            return null;

        }
    }


    public int deleteUserById(int userId) {
        try {
            String sql = "DELETE FROM app_user WHERE ID=?)";
            return jdbcTemplate.update(sql, userId);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateUserById(User user,int id) {
        try {
            String sql = "UPDATE  app_user  SET user_name=? , emailid=? , phoneno=? WHERE id=?";
            return jdbcTemplate.update(sql, user.getUsername(), user.getEmailId(), user.getPhonno(),id);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1;
    }



}
