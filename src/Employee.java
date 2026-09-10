public class Employee {
    private static int idCounter = 1;

    private int id;
    private String fullName;
    private int department;
    private int salary;

    public Employee(String fullName, int department, int salary) {
        this.id = idCounter++;

        this.fullName = fullName;

        if (department < 1 || department > 5) {
        }
        this.department = department;

        if (salary < 50 || salary > 450) {
        }
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
        }
        this.department = department;
    }

    public void setSalary(int salary) {
        if (salary < 50 || salary > 450) {

        }
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public String toString() {
        return "Работник [id=" + id + ", Ф.И.О.='" + fullName + "', отдел=" + department + ", зарплата=" + salary + "]";
    }

    public void printShortInfo() {
        System.out.println("Ф. И. О.: " + fullName + ", зарплата: " + salary);
    }
}