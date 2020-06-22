package at.cc.jku.task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {


    private String url;

    public TaskDAO() {
        this.url = "jdbc:mysql://localhost:3306/tasks?user=root"; /* &password=123 */

    }

    public void addTask(TaskVO taskVO) {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.url);
            //System.out.println("Verbindung zu MySQL aufgebaut");

            // SQL: INSERT INTO `task` (`id`, `name`, `done`) VALUES (NULL, 'schwimmen', '');
            String sql = "INSERT INTO `task` (`id`, `name`, `done`) VALUES (NULL, '" + taskVO.getName() + "', '0')";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

            System.out.println("Daten wurden in die Datenbank geschrieben");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }

    }

    public void changeTaskVO(TaskVO taskVO) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.url);
            //System.out.println("Verbindung zu MySQL aufgebaut");

            // SQL: INSERT INTO `task` (`id`, `name`, `done`) VALUES (NULL, 'schwimmen', '');
            String sql = "UPDATE `task` SET `name`='" + taskVO.getName() + "' WHERE id = " + taskVO.getId();

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

            System.out.println("Daten wurden in der Datenbank geändert");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }


    }

    public void deleteTask(int id) {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.url);
            //System.out.println("Verbindung zu MySQL aufgebaut");

            // SQL: INSERT INTO `task` (`id`, `name`, `done`) VALUES (NULL, 'schwimmen', '');
            String sql = "DELETE FROM `task` WHERE id = " + id;

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

            System.out.println("Datensatz wurde aus der Datenbank entfernt");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }

    }

    public List<TaskVO> getAllTasks() {

        List<TaskVO> tasks = new ArrayList<>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.url);
            //System.out.println("Verbindung zu MySQL aufgebaut");

            String sql = "select * from task";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                boolean done = rs.getBoolean("done");
                TaskVO task = new TaskVO(id, name, done);

                tasks.add(task);


                // System.out.println("Id: " + id + " - Task: " + name + " - Done: " + done );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }

        return tasks;

    }

    public void changeStatus (int id,  boolean done){

        String sql = "";
        if (done){
            sql = "UPDATE `task` SET `done`= '1' WHERE id = " + id;
        } else {
            sql = "UPDATE `task` SET `done`= '0' WHERE id = " + id;
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.url);
            //System.out.println("Verbindung zu MySQL aufgebaut");

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

            System.out.println("Datensatz wurde der Status Datenbank geändert");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }


    }
}
