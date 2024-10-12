import java.sql.*;
 
public class SetupDatabase {
 
    public static void main(String[] args) throws Exception {
        String url = "jdbc:hsqldb:file:zoo";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
 
            dropExisting(conn);
            createTables(conn);
            createStoredProcedures(conn);
 
            printCount(conn, "SELECT count(*) FROM names");
        }
    }
 
    private static void dropExisting(Connection conn) throws SQLException {
        run(conn, "DROP PROCEDURE read_e_names IF EXISTS");
        run(conn, "DROP PROCEDURE read_names_by_letter IF EXISTS");
        run(conn, "DROP PROCEDURE magic_number IF EXISTS");
        run(conn, "DROP PROCEDURE double_number IF EXISTS");
        run(conn, "DROP TABLE names IF EXISTS");
        run(conn, "DROP TABLE exhibits IF EXISTS");
    }
 
    private static void createTables(Connection conn) throws SQLException {
        run(conn, """
                CREATE TABLE exhibits (
                  id INTEGER PRIMARY KEY,
                  name VARCHAR(255),
                  num_acres DECIMAL(4,1))""");
 
        run(conn, """
                CREATE TABLE names (
                   id INTEGER PRIMARY KEY,
                   species_id integer REFERENCES exhibits (id),
                   name VARCHAR(255))""");
 
        run(conn, "INSERT INTO exhibits VALUES (1, 'African Elephant', 7.5)");
        run(conn, "INSERT INTO exhibits VALUES (2, 'Zebra', 1.2)");
 
        run(conn, "INSERT INTO names VALUES (1, 1, 'Elsa')");
        run(conn, "INSERT INTO names VALUES (2, 2, 'Zelda')");
        run(conn, "INSERT INTO names VALUES (3, 1, 'Ester')");
        run(conn, "INSERT INTO names VALUES (4, 1, 'Eddie')");
        run(conn, "INSERT INTO names VALUES (5, 2, 'Zoe')");
    }
 
    private static void createStoredProcedures(Connection conn) throws SQLException {
        String noParams = """
                CREATE PROCEDURE read_e_names()
                READS SQL DATA DYNAMIC RESULT SETS 1
                BEGIN ATOMIC
                DECLARE result CURSOR WITH RETURN FOR SELECT * FROM names WHERE LOWER(name) LIKE 'e%';
                OPEN result;
                END""";
 
        String inParam = """
                CREATE PROCEDURE read_names_by_letter(IN prefix VARCHAR(10))
                READS SQL DATA DYNAMIC RESULT SETS 1
                BEGIN ATOMIC
                DECLARE result CURSOR WITH RETURN FOR
                SELECT * FROM names WHERE LOWER(name) LIKE CONCAT(LOWER(prefix), '%');
                OPEN result;
                END""";
 
        String inOutParam = """
                CREATE PROCEDURE double_number(INOUT num INT) READS SQL DATA
                  DYNAMIC RESULT SETS 1
                  BEGIN ATOMIC 
                  SET num = num * 2; 
                  END""";
 
        String outParam = """
                CREATE PROCEDURE magic_number(OUT num INT) READS SQL DATA
                      BEGIN ATOMIC
                     SET num = 42;
                      END""";
 
        run(conn, noParams);
        run(conn, inParam);
        run(conn, outParam);
        run(conn, inOutParam);
    }
 
    private static void run(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }
 
    private static void printCount(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            rs.next();
            System.out.println(rs.getInt(1));
        }
    }

    private static void register(Connection conn, int key, int type, 
        String name) throws SQLException {
        var sql = "INSERT INTO names VALUES(?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, key);
            ps.setString(3, name);
            ps.setInt(2, type);
            ps.executeUpdate();
        }
    }

    /** 
     * JDBC 2.0 allows you to use ResultSet object to update an existing row 
     * and even insert new row in the database. For both the cases, 
     * the ResultSet must be updatable, which can be achieved by passing 
     * ResultSet.CONCUR_UPDATABLE while creating a Statement 
     * object: stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_UPDATABLE); 
     * or stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);  
     * 
     * The general usage pattern for this functionality is as follows -  
     * To update an existing row:  
     * 1. First, go to the row you want to update. 
     * You can either iterate through a ResultSet to reach a particular row or just call rs.absolute(int rowNumber). 
     * 2. Now update the columns of the ResultSet with required values 
     * using rs.updateXXX(columnNumber, value) or rs.updateXXX(columnName, value) methods. 
     * 3. Call rs.updateRow(); If you call rs.refreshRow() without calling updateRow(), 
     * the updates will be lost.  
     * To insert a new Row: 
     * 1. Call rs.moveToInsertRow(); first. You can't insert a row without calling this method first. 
     * 2. Use rs.updateXXX methods to update all column values. You must set values for all the columns. 
     * 3. Call rs.insertRow();  
     * 4. Call rs.moveToCurrentRow(); to go back to the row where you were before calling moveToInsertRow.  
     * IMPORTANT: The exam will test you on implications of calling various methods out 
     * of sequence. For example, what happens when you call insertRow without first 
     * calling moveToInsertRow? (An SQLException will be thrown.) or what happens when
     * you call refreshRow without first calling updateRow? 
     * (No exception but updates will be lost.). 
     * You should go through the JavaDoc API description for all the methods involved 
     * in update/inserting rows in the database using a ResultSet.
     * */ 
}