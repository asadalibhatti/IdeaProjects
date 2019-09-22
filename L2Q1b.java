import java.util.ArrayList;
import java.util.List;

class Person {


    String name;
    String address;
    float mobile;

    public Person() {
        this.name = "";
        this.address = "";
        this.mobile = -1;
    }

    public Person(String name, String address, float mobile) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }
}
class Course {
    String  code, name;
    //float gpa;//or Grade
    int creditHour;
    //String semester;


    public Course(String code, String name, int creditHour) {
        this.code = code;
        this.name = name;
        this.creditHour = creditHour;
    }
}
class StudentCourse extends Course{
    String section;
    float gpa;

    public StudentCourse(String code, String name, int creditHour, String section, float gpa) {
        super(code, name, creditHour);
        this.section = section;
        this.gpa = gpa;
    }
}
class ProfCourse extends Course{
    String sections;
    int noOfSectionsTaught;

    public ProfCourse(String code, String name, int creditHour, String sections, int noOfSectionsTaught) {
        super(code, name, creditHour);
        this.sections = sections;
        this.noOfSectionsTaught = noOfSectionsTaught;
    }
}
class Student extends Person {
    List<StudentCourse> coursesList = new ArrayList<>();
    float gpa;
    public Student(String name, String address, float mobile,float gpa) {
        super(name, address, mobile);
        this.coursesList = new ArrayList<>();
        this.gpa=gpa;
    }

    //with avg gpa
    public void printAllCourses() {
        float sumGpa = 0;
        System.out.println("Showing Courses Taken : ");
        for (StudentCourse c : coursesList
        ) {
            sumGpa += c.gpa;
            System.out.println(c.name);
        }
        System.out.println("Avg Gpa : " + sumGpa / coursesList.size());
    }

    public void addCourses(StudentCourse c) {
        coursesList.add(c);
    }
}

class Professor extends Person {
    double salary;
    List<ProfCourse> coursesList = new ArrayList<>();
    List<ProfCourse> currentCourseList = new ArrayList<>();

    public Professor(String name, String address, float mobile, double salary) {
        super(name, address, mobile);
        this.salary = salary;
    }
    public void printAllCourses() {

        System.out.println("Showing Proffeser Current Courses: ");
        for (Course c : currentCourseList
        ) {

            System.out.println(c.name);
        }
        System.out.println("\nShowing Proffeser All Coursesd: ");
        for (Course c : coursesList
        ) {

            System.out.println(c.name);
        }

    }
    public void addCurrentCourse(ProfCourse c) {
        if (currentCourseList.size() < 5) {
            currentCourseList.add(c);
            System.out.println("Course added in Current Corses list");
        } else if (currentCourseList.size() < 5) {

            System.out.println("Current Courses CAnnot be more than 5");

        }
    }

    public void removeCourseFromHistory(Course c) {
        if(coursesList.remove(c)){
            System.out.println("Removed");
            return;

        }
        System.out.println("Not Removed, Not Found");
    }
    public void removeCourseFromCurrentList(Course c) {
        if(currentCourseList.remove(c)){
            System.out.println("Removed");
            return;

        }
        System.out.println("Not Removed, Not Found");
    }
}


class Department {
    String name;
    List<Professor> professorsList;// = new ArrayList<Professor>();
    List<Student> studentList;
    int depCode;

    public Department(int depCode, String name, List<Professor> professorsList,    List<Student> studentList
    ) {
        this.professorsList = professorsList;
        this.studentList=studentList;
        this.depCode = depCode;
        this.name = name;
    }

    public void addProffesors(Professor p) {
        professorsList.add(p);
    }
    public void addStudent(Student s1){
        studentList.add(s1);
    }

    public void showAllProfessors() {
        System.out.println("\nShowing all Professors of Dept " + name + " : ");
        for (Professor p : professorsList
        ) {
            System.out.println(p.name + " , " + p.salary + /*depName*/name);

        }
    }
    public void showAllStudents() {
        System.out.println("\n\nShowing all Students of Dept " + name + " : ");
        for (Student p : studentList
        ) {
            System.out.println(p.name + " , " + p.gpa +" , "+ /*depName*/name);

        }
    }
}

class University {
    String name;

    List<Department> departmentList;


    public University(String name, List<Department> departmentList) {
        this.name = name;
        this.departmentList = departmentList;
        //this.studentList=studentList;
    }

    public void addDepartment(int deptCode, String name, List<Professor> professorsList,List<Student>studentList) {
        Department d = new Department(deptCode, name, professorsList,studentList);
        departmentList.add(d);

    }


    public void showAllProfessors() {
        for (Department d : departmentList
        ) {
            d.showAllProfessors();

        }
    }
    public void showAllStudents() {
        for (Department d : departmentList
        ) {
            d.showAllStudents();

        }
    }
}

public class L2Q1b {
    public static void main(String arg[]) {
        //creating proffesors
        Professor p1 = new Professor("Asad Bhatti", "Farooqabad", 034045, 10000);
        Professor p2 = new Professor("bAsad Bhatti", "lahor", 034045, 13000);
        Professor p3 = new Professor("cQAsad Bhatti", "skp", 034045, 14000);
        Professor p4 = new Professor("dSAsad Bhatti", "isb", 034045, 15000);
        Professor p5 = new Professor("elAsad Bhatti", "rwp", 034045, 16000);
        Professor p6 = new Professor("fKAsad Bhatti", "psw", 034045, 17000);
        Professor p7 = new Professor("gAAsad Bhatti", "fsb", 034045, 18000);
        Professor p8 = new Professor("kAssad Bhatti", "guj", 034045, 18000);
        Professor p9 = new Professor("larshad Bhatti", "fqd", 034045, 19000);

        //creating Courses
        ProfCourse c1=new ProfCourse("CS 201","ITC",3,"ABC",3);
        ProfCourse c2=new ProfCourse("CS 202","cp",3,"CDE",3);
        ProfCourse c3=new ProfCourse("CS 203","ds",3,"A",1);
        ProfCourse c4=new ProfCourse("CS 204","ca",3,"ABC",3);
        ProfCourse c5=new ProfCourse("CS 205","coal",3,"ABC",3);
        ProfCourse c6=new ProfCourse("CS 206","ooad",3,"ABC",3);


        //Studnet course
        StudentCourse sc1=new StudentCourse("cs201","itc",3,"A",0);
        StudentCourse sc2=new StudentCourse("cs202","cp",3,"B",0);
        StudentCourse sc3=new StudentCourse("cs203","ca",3,"C",0);

        //giving courses to proffesers
        p1.addCurrentCourse(c1);
        p1.addCurrentCourse(c2);
        p1.addCurrentCourse(c3);
        p2.addCurrentCourse(c4);
        p2.addCurrentCourse(c5);
        p2.addCurrentCourse(c2);


        //creating student
        Student s1=new Student("Asad","fqd",03343,3);
        Student s2=new Student("rAsad","fqd",03343,4);
        Student s3=new Student("Arsad","fqd",03343,2);
        Student s4=new Student("rashad","fqd",03343,2);

        s1.addCourses(sc1);
        s1.addCourses(sc2);
        s2.addCourses(sc1);
        s2.addCourses(sc2);


        //Prof list
        List<Professor> pList1 = new ArrayList<Professor>();
        List<Professor> pList2 = new ArrayList<Professor>();
        List<Professor> pList3 = new ArrayList<Professor>();

        //student list
        List<Student> sList1=new ArrayList<>();
        List<Student> sList2=new ArrayList<>();

        pList1.add(p1);
        pList1.add(p2);
        pList1.add(p3);

        //
        pList2.add(p4);
        pList2.add(p5);
        pList2.add(p6);

        pList3.add(p7);
        pList3.add(p8);
        pList3.add(p9);
        pList3.add(p9);

        Department d1 = new Department(1, "CS", pList1,sList1);
        Department d2 = new Department(2, "EE", pList2,sList2);
        Department d3 = new Department(3, "BBA", pList3,sList1);

        List<Department> dList = new ArrayList<>();
        dList.add(d1);
        dList.add(d2);
        dList.add(d3);


        University university = new University("LUMS", dList);
        university.showAllProfessors();
        university.showAllStudents();

    }
}
