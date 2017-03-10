package eightbitsakabigbyte.Dao;

import eightbitsakabigbyte.Entity.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysql")
public class MySqlGameDaoImpl implements GameDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class GameBoardRowMapper implements RowMapper<GameBoard> {

        @Override
        public GameBoard mapRow(ResultSet resultSet, int i) throws SQLException {
            GameBoard gameBoard = new GameBoard();
            gameBoard.setId(resultSet.getInt("id"));
            gameBoard.setPlayer(resultSet.getString("player"));
            // gameBoard.setGameState(resultSet.getString("row1"));
            return gameBoard;

//            @Override
//            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
//                Student student = new Student();
//                student.setId(resultSet.getInt("id"));
//                student.setName(resultSet.getString("name"));
//                student.setCourse(resultSet.getString("course"));
//                return student;
        }
    }



    @Override
    public GameBoard getGameBoardById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT id, player FROM checkersGames where id = ?";
        GameBoard gameBoard = jdbcTemplate.queryForObject(sql, new GameBoardRowMapper(), id);
        System.out.println(gameBoard);
        return gameBoard;
    }

//    @Override
//    public Account getAccountById(int id) {
//        // SELECT column_name(s) FROM table_name where column = value
//        final String sql = "SELECT id, accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName FROM account where id = ?";
//        Account account = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
//        return account;
//    }



    @Override
    public void removeGameBoardById(int id) {

    }

    @Override
    public void updateGameBoard(GameBoard gameBoard) {

    }

    @Override
    public void insertGameBoardToDb(GameBoard gameBoard) {

    }

}
//    @Override
//    public Collection<Account> getAllAccounts() {
//        // SELECT column_name(s) FROM table_name
//        final String sql = "SELECT id, accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName FROM account";
//        List<Account> accounts = jdbcTemplate.query(sql, new StudentRowMapper());
//        return accounts;
//    }
//
//    @Override
//    public Account getAccountById(int id) {
//        // SELECT column_name(s) FROM table_name where column = value
//        final String sql = "SELECT id, accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName FROM account where id = ?";
//        Account account = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
//        return account;
//    }
//
//    @Override
//    public Account getAccountByIdAndName(int id, String firstName, String lastName) {
//        // SELECT column_name(s) FROM table_name where column = value
//        final String sql = "SELECT id, accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName FROM account where id = ?, firstName = ?, lastName = ?";
//        Account account = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
//        return account;
//    }
//
//    @Override
//    public void removeAccountById(int id) {
//        // DELETE FROM table_name
//        // WHERE some_column = some_value
//        final String sql = "DELETE FROM account WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    @Override
//    public void removeAccountByIdAndName(int id, String firstName, String lastName) {
//        // DELETE FROM table_name
//        // WHERE some_column = some_value
//        final String sql = "DELETE FROM account WHERE id = ?, firstName = ?, lastName = ?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    @Override
//    public void updateAccount(Account account) {
//        // UPDATE table_name
//        // SET column1=value, column2=value2,...
//        // WHERE some_column=some_value
//        final String sql = "UPDATE account SET name = ?, course = ? WHERE id = ?";
//        final int id = account.getId();
//        final String accountType = account.getAccountType();
//        final long balance = account.getBalance();
//        final double interestRate = account.getInterestRate();
//        final long overdraftPenalty = account.getOverdraftPenalty();
//        final long requiredMB = account.getRequiredMB();
//        jdbcTemplate.update(sql, new Object[]{accountType, balance, interestRate, overdraftPenalty, requiredMB, id});
//    }
//
//    @Override
//    public void insertAccountToDb(Account account) {
//        // INSERT INTO table_name (column1, column2, column3,...)
//        // VALUES (value1, value2, value3,...)
//        final String sql = "INSERT INTO account (accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        final String accountType = account.getAccountType();
//        final long balance = account.getBalance();
//        final double interestRate = account.getInterestRate();
//        final long overdraftPenalty = account.getOverdraftPenalty();
//        final long requiredMB = account.getRequiredMB();
//        final String firstName = account.getFirstName();
//        final String lastName = account.getLastName();
//        jdbcTemplate.update(sql, new Object[]{accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName});
//
//    }
//}