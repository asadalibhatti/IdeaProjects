import java.util.List;

class Person {


    String name;
    String address;
    float mobile;

    public Person(String name, String address, float mobile) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
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

    class Course {
        String code, name;
        //float gpa;//or Grade
        int creditHour;
        private List<Student> studentList;
        private List<Professor> profList = New;
        //String semester;


        public Course(String code, String name, int creditHour) {
            this.code = code;
            this.name = name;
            this.creditHour = creditHour;
        }

        public void addStudent() {
        }

        public void removeStudent() {
        }

        public void assignTeacher() {
        }
    }

    class Student extends Person {
        List<StudentCourse> coursesList = new ArrayList<>();
        float gpa;

        public Student(String name, String address, float mobile, float gpa) {
            super(name, address, mobile);
            this.coursesList = new ArrayList<>();
            this.gpa = gpa;
        }

        class Department {
            String name;
            List<Professor> professorsList = new ArrayList<Professor>();
            int depCode;

            public Department(int depCode, String name, List<Professor> professorsList) {
                this.professorsList = professorsList;
                this.depCode = depCode;
                this.name = name;
            }

            public void addProffesors(Professor p) {
                professorsList.add(p);
            }

            public void showAllProfessors() {
                System.out.println("\nShowing all Professors of Dept " + name + " : ");
                for (Professor p : professorsList
                ) {
                    System.out.println(p.name + " , " + p.salary + /*depName*/name);

                }
            }
        }

        class University {
            String name;

            List<Department> departmentList;

            public University(String name, List<Department> departmentList) {
                this.name = name;
                this.departmentList = departmentList;
            }

            public void addDepartment(int deptCode, String name, List<Professor> professorsList) {
                Department d = new Department(deptCode, name, professorsList);
                departmentList.add(d);

            }

            public void showAllProfessors() {
                for (Department d : departmentList
                ) {
                    d.showAllProfessors();

                }
            }
        }

        public class L2Q1a {
            public static void main(String arg[]) {
                Professor p1 = new Professor("Asad Bhatti", "Farooqabad", 034045, 10000);
                Professor p2 = new Professor("bAsad Bhatti", "lahor", 034045, 13000);
                Professor p3 = new Professor("cQAsad Bhatti", "skp", 034045, 14000);
                Professor p4 = new Professor("dSAsad Bhatti", "isb", 034045, 15000);
                Professor p5 = new Professor("elAsad Bhatti", "rwp", 034045, 16000);
                Professor p6 = new Professor("fKAsad Bhatti", "psw", 034045, 17000);
                Professor p7 = new Professor("gAAsad Bhatti", "fsb", 034045, 18000);
                Professor p8 = new Professor("kAssad Bhatti", "guj", 034045, 18000);
                Professor p9 = new Professor("larshad Bhatti", "fqd", 034045, 19000);
                List<Professor> pList1 = new ArrayList<Professor>();
                List<Professor> pList2 = new ArrayList<Professor>();
                List<Professor> pList3 = new ArrayList<Professor>();
                pList1.add(p1);
                pList1.add(p2);
                pList1.add(p3);

                pList2.add(p4);
                pList2.add(p5);
                pList2.add(p6);

                pList3.add(p7);
                pList3.add(p8);
                pList3.add(p9);
                pList3.add(p9);

                Department d1 = new Department(1, "CS", pList1);
                Department d2 = new Department(2, "EE", pList2);
                Department d3 = new Department(3, "BBA", pList3);

                List<Department> dList = new ArrayList<>();
                dList.add(d1);
                dList.add(d2);
                dList.add(d3);

                University university = new University("LUMS", dList);
                university.showAllProfessors();

            }
        }

        public class q2 {
        }
