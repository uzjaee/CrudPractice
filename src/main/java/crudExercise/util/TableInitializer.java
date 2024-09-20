package crudExercise.util;

import jakarta.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableInitializer {

  private final DataSource dataSource;

  @PostConstruct
  public void createTable(){
    try (Connection connection = dataSource.getConnection();
      Statement statement = connection.createStatement()){

      String sql = "CREATE TABLE IF NOT EXISTS users (" +
          "id INT AUTO_INCREMENT PRIMARY KEY," +
          "name VARCHAR(50)"  +
          ")";
      statement.executeUpdate(sql);
    }
    catch (Exception e){
      e.printStackTrace();
    }

  }

}
