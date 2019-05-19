package Lesson_1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component("JdbcTemplate")
public class JdbcTemplateDiskDao implements DiskDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateDiskDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Disk disk) {
        String sql = "INSERT INTO disks (title) VALUES (?)";
        jdbcTemplate.update(sql, disk.getTitle());
    }

    @Override
    public String findTitleById(Long id) {
        return jdbcTemplate.queryForObject("SELECT title FROM disks WHERE id = ?;", new Object[]{id}, String.class);
    }
}
