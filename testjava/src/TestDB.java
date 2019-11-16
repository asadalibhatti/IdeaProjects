import jdk.internal.util.xml.impl.Input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;
import java.util.Scanner;

class p {
    static void p(Object s) {
        System.out.println(s);
    }
}

class University {
	TestDB db=new TestDB();
    static int sId = 1, rId = 1, cId = 1;

    void addNewStudent() {
		try {

			String n, e, c;
			int y;
			Scanner input = new Scanner(System.in);
			p.p("Enter Student info");

			p.p("Name: ");
			n = input.nextLine();
			p.p("email: ");
			e = input.nextLine();
			p.p("cnic : ");
			c = input.nextLine();
			p.p("joiningYear: ");
			y = input.nextInt();
			//insert into student values (3,"arshsad","email","cnic",2012);
//			n="asad";
//			e="yasad@gmail.com";
//			c="35404";
//			y=2015;

			String q = "insert into student values (" + (sId++) + " ,'" + n + "','" + e + "','" + c + "'," + y + ")";
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(q);

//			stmt=conn.createStatement();
//			String sql = "SELECT * FROM taskdata";
//			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Student inserted . .");

		} catch (Exception e) {
			p.p(e.getMessage());
			p.p("eror in adding new student");
		}
	}
    void removeStudent() {
        try {


            Scanner input = new Scanner(System.in);
            p.p("Enter Student Id to Delete:");
            int id;
            id=input.nextInt();
            //id=1;
            String q = "delete from student where id ="+id;
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q);

//			stmt=conn.createStatement();
//			String sql = "SELECT * FROM taskdata";
//			ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Student deleted with given id . .");

        } catch (Exception e) {
            p.p(e.getMessage());
            p.p("eror in deleting student");
        }
    }
    void editStudent() {
        try {

            String n, e, c;
            int y;
            Scanner input = new Scanner(System.in);
            p.p("Enter Student info to edit:");
            p.p("Enter Id of student to edit: ");
            int id;//=input.nextInt();
            id=input.nextInt();

            p.p("Name: ");
            n = input.nextLine();
            p.p("email: ");
            e = input.nextLine();
            p.p("cnic : ");
            c = input.nextLine();
            p.p("joiningYear: ");
            y = input.nextInt();
            //insert into student values (3,"arshsad","email","cnic",2012);
            //id=1;
//            n="asad2";
//            e="yasad@gmail.com";
//            c="35404";
//            y=2015;

            String q = "update student set name= '" + n + "',email='" + e + "',cnic='" + c + "',joiningyear=" + y + " where id="+id;
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q);

//			stmt=conn.createStatement();
//			String sql = "SELECT * FROM taskdata";
//			ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Student eidted . .");

        } catch (Exception e) {
            p.p(e.getMessage());
            p.p("eror in editing student");
        }
    }
    void removeCourse() {
        try {


            Scanner input = new Scanner(System.in);
            p.p("Enter course Id to Delete:");
            int id;
            id=input.nextInt();
            //id=1;
            String q = "delete from course where id ="+id;
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q);

//			stmt=conn.createStatement();
//			String sql = "SELECT * FROM taskdata";
//			ResultSet rs = stmt.executeQuery(sql);
            System.out.println("course deleted with given id . .");

        } catch (Exception e) {
            p.p(e.getMessage());
            p.p("eror in deleting course");
        }
    }
	boolean addNewCourses() {
			try {

				String n, c,t;
				int credithrs;
				Scanner input = new Scanner(System.in);
				p.p("Enter Course info");

				p.p("Name: ");
				n = input.nextLine();
				p.p("Code: ");
				c = input.nextLine();
				p.p("Teacher : ");
				t = input.nextLine();
				p.p("joiningYear: ");
				credithrs = input.nextInt();
//                n="ali";
//                c="cs203";
//                t="javed";
//                credithrs=3;

				//insert into student values (3,"arshsad","email","cnic",2012);
				String q = "insert into Course values (" + (cId++) + ",'" + n + "','" + c + "','" + t + "'," + credithrs + ")";

				Connection conn = db.getConnection();
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(q);

//			stmt=conn.createStatement();
//			String sql = "SELECT * FROM taskdata";
//			ResultSet rs = stmt.executeQuery(sql);
				System.out.println("Course inserted . .");

			} catch (Exception e) {
				p.p(e.getMessage());
				p.p("eror in adding new course");
			}



			return true;
    }
    void removeRegistration() {
        try {


            Scanner input = new Scanner(System.in);
            p.p("Enter Registration Id to Delete:");
            int id;
            id=input.nextInt();
            //id=1;
            String q = "delete from registration where id ="+id;
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q);

//			stmt=conn.createStatement();
//			String sql = "SELECT * FROM taskdata";
//			ResultSet rs = stmt.executeQuery(sql);
            System.out.println("regitration deleted with given id . .");

        } catch (Exception e) {
            p.p(e.getMessage());
            p.p("eror in deleting registration");
        }
    }
    boolean editCourses() {
        try {

            String n, c,t;
            int credithrs;
            Scanner input = new Scanner(System.in);
            p.p("Enter Course info to edit:");

            p.p("Enter id of Coruse to edit:");
            int id;
            id=input.nextInt();
            p.p("Name: ");
            n = input.nextLine();
            p.p("Code: ");
            c = input.nextLine();
            p.p("Teacher : ");
            t = input.nextLine();
            p.p("joiningYear: ");
            credithrs = input.nextInt();
//            id=1;
//            n="ali2";
//            c="cs203";
//            t="javed";
//            credithrs=3;

            //insert into student values (3,"arshsad","email","cnic",2012);
            String q = "update Course set name=  '" + n + "',code='" + c + "',teacher='" + t + "',credithrs=" + credithrs +" where id="+id ;

            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q);

//			stmt=conn.createStatement();
//			String sql = "SELECT * FROM taskdata";
//			ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Course edited . .");

        } catch (Exception e) {
            p.p(e.getMessage());
            p.p("eror in eidting course");
        }



        return true;
    }
    boolean addNewStudentRegistration() {
        try {

            int month,year,studentId,courseId;
            Scanner input = new Scanner(System.in);
            p.p("Enter Registration info");

            p.p("Month: ");
            month = input.nextInt();
            p.p("Year: ");
            year = input.nextInt();
            p.p("StudentId : ");
            studentId = input.nextInt();
            p.p("coursId: ");
            courseId = input.nextInt();
//            month=12;
//            year=2001;
//            studentId=1;
//            courseId=1;

            //insert into student values (3,"arshsad","email","cnic",2012);
            String q = "insert into Registration values (" + (rId++) + "," + month + "," + year + "," + studentId + "," + courseId + ")";

            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q);

//			stmt=conn.createStatement();
//			String sql = "SELECT * FROM taskdata";
//			ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Registration  . .");

        } catch (Exception e) {
            p.p(e.getMessage());
            p.p("eror in adding new registration");
        }



        return true;
    }
    boolean editStudentRegistration() {
        try {

            int month,year,studentId,courseId;
            Scanner input = new Scanner(System.in);
            p.p("Enter Registration EDIT info: ");
            p.p("Enter Id of course to edit: ");
            courseId = input.nextInt();
            p.p("Month: ");
            month = input.nextInt();
            p.p("Year: ");
            year = input.nextInt();
            p.p("StudentId : ");
            studentId = input.nextInt();


//            month=12;
//            year=2001;
//            studentId=1;
//            courseId=1;

            //insert into student values (3,"arshsad","email","cnic",2012);
            String q = "update  Registration set month= " + month + ",year=" + year + ",studentid=" + studentId + ",courseid=" + courseId + " where courseId="+courseId;

            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q);

//			stmt=conn.createStatement();
//			String sql = "SELECT * FROM taskdata";
//			ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Registration edited  . .");

        } catch (Exception e) {
            p.p(e.getMessage());
            p.p("eror in adding editing registration");
        }



        return true;
    }
}

public class TestDB {


    /**
     * The name of the MySQL account to use (or empty for anonymous)
     */
    private final String userName = "root";

    /**
     * The password for the MySQL account (or empty for anonymous)
     */
    private final String password = "asadbhatti";

    /**
     * The name of the computer running MySQL
     */
    private final String serverName = "localhost";

    /**
     * The port of the MySQL server (default is 3306)
     */
    private final int portNumber = 3306;

    /**
     * The name of the database we are testing with (this default is installed with MySQL)
     */
    private final String dbName = "University";

    /**
     * The name of the table we are testing with
     */
    private final String tableName = "taskdata";

    private Statement stmt;

    /**
     * Get a new database connection
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);
        System.out.println("trying to get connection!! ");
        conn = DriverManager.getConnection("jdbc:mysql://"
                + this.serverName + ":" + this.portNumber + "/"
                + this.dbName, connectionProps);
        System.out.println(" Connection achieved!! ");
        return conn;
    }


    public boolean executeUpdate(Connection conn, String command) throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(command); // This will throw a SQLException if it fails
            return true;
        } finally {

            // This will run whether we throw an exception or not
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void MakeDB(Connection conn) {
        stmt = null;
        String sql = "CREATE DATABASE STUDENTS";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteAll(Connection conn) {
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String sql = "delete  FROM Sometable";
            int a = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void SelectAll(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM taskdata";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("hello");
            while (rs.next()) {
                int id = rs.getInt("serialNo");

                String name = rs.getString("firstName");
                String food = rs.getString("lastName");
                System.out.print("ID: " + id);
                System.out.print(", fname: " + name);
                System.out.println(", lName: " + food);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void run() {

        // Connect to MySQL
        Connection conn = null;
        try {
            conn = this.getConnection();
            System.out.println("connection name is :: " + conn.getClass().getName());
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("ERROR: Could not connect to the database");
            e.printStackTrace();
            return;
        }


        // Create a table
//		try {
//		    String createString =
//			        "CREATE TABLE " + this.tableName + " ( " +
//			        "ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
//			        "NAME varchar(40) NOT NULL, " +
//			        "food VARCHAR(30), " +
//			        "confirmed CHAR(1), " +
//			        "signup_date DATE)";
//
//			this.executeUpdate(conn, createString);
//
//			String input="INSERT INTO sometable "
//			+"VALUES ("+null+",'John', 'Casserole','Y', '2012-04-11')";
//			this.executeUpdate(conn, input);
//			stmt= conn.createStatement();
//			//stmt.executeUpdate(createString);
//			input="INSERT INTO sometable "
//			+ "VALUES ("+null+", 'Tom', 'BBQ','Y', '2012-04-18')";
//			this.executeUpdate(conn, input);
//			input="INSERT INTO sometable "
//			+ "VALUES ("+null+", 'Tina', 'Salad','Y', '2012-04-10')";
//			this.executeUpdate(conn, input);
//			System.out.println("Created a table");
        this.SelectAll(conn);
//	    } catch (Exception e) {
//			System.out.println("ERROR: Could not create the table");
//			e.printStackTrace();
//			return;
//		}


        //deleteAll(conn);


        // Drop the table
		/*		try {
				    String dropString = "DROP TABLE " + this.tableName;
					this.executeUpdate(conn, dropString);
					System.out.println("Dropped the table");
			    } catch (Exception e) {
					System.out.println("ERROR: Could not drop the table");
					e.printStackTrace();
					return;
				} */
    }


    public static void main(String[] args) {
        TestDB app = new TestDB();

        University u=new University();

        u.addNewCourses();
        u.addNewStudent();
        u.addNewStudentRegistration();

        u.editStudentRegistration();
        u.editStudent();
        u.editCourses();

        u.removeRegistration();
        u.removeStudent();
        u.removeCourse();


    }
}
