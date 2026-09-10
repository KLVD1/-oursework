import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {

        EmployeeBook book = new EmployeeBook();

        // --- Добавление 11 сотрудников (10 успешно, 11-й вернёт false) ---
        System.out.println("  Добавление сотрудников (11 раз)  ");
        System.out.println("Добавление 1: " + book.addEmployee(new Employee("Иванов И.И.", 1, 200)));
        System.out.println("Добавление 2: " + book.addEmployee(new Employee("Петрова П.П.", 3, 350)));
        System.out.println("Добавление 3: " + book.addEmployee(new Employee("Сидоров С.С.", 5, 120)));
        System.out.println("Добавление 4: " + book.addEmployee(new Employee("Кузнецов К.К.", 1, 400)));
        System.out.println("Добавление 5: " + book.addEmployee(new Employee("Смирнова С.С.", 2, 80)));
        System.out.println("Добавление 6: " + book.addEmployee(new Employee("Попов П.П.", 3, 150)));
        System.out.println("Добавление 7: " + book.addEmployee(new Employee("Волков В.В.", 1, 300)));
        System.out.println("Добавление 8: " + book.addEmployee(new Employee("Зайцева З.З.", 4, 60)));
        System.out.println("Добавление 9: " + book.addEmployee(new Employee("Павлов П.П.", 2, 250)));
        System.out.println("Добавление 10: " + book.addEmployee(new Employee("Морозов М.М.", 5, 450)));
        System.out.println("Добавление 11: " + book.addEmployee(new Employee("Лебедев Л.Л.", 1, 100)));

        //  Класс EmploteeBook
        System.out.println(" \n\tТест задания с Классом  EmployeeBook \n");

        // --- 1. Список всех сотрудников ---
        System.out.println("\n  Все сотрудники   ");
        book.printAllEmployees();

        // --- 2. Средняя зарплата ---
        System.out.println("\n  Средняя зарплата  ");
        System.out.printf("Средняя зарплата: %.2f%n", book.averageSalary());

        // --- 3. Налоги ---
        System.out.println("\n Налоги PROPORTIONAL ");
        book.printTaxes("PROPORTIONAL");

        System.out.println("\n  Налоги PROGRESSIVE ");
        book.printTaxes("PROGRESSIVE");

        // --- 4. Индексация зарплаты отдела 1 ---
        System.out.println("\n  Индексация отдела 1 на 10%  ");
        book.indexSalaryByDepartment(1, 10);

        // --- 5. Первый сотрудник отдела 1 с зарплатой > 250 ---
        System.out.println("\n Первый сотрудник отдела 1 с зарплатой > 250  ");
        book.findFirstEmployeeWithSalaryAbove(1, 250);

        // --- 6. Первые 2 сотрудника с зарплатой < 150 ---
        System.out.println("\n  Первые 2 сотрудника с зарплатой < 150  ");
        book.theSalaryIsLower(150, 2);

        // --- 7. Проверка наличия сотрудника по зарплате ---
        System.out.println("\n  Проверка наличия сотрудника  ");
        Employee testEmp = new Employee("Тестовый Т.Т.", 1, 120); // зарплата 120 — есть у Сидорова
        System.out.println("Сотрудник с зарплатой 120 есть? " + book.containsEmployee(testEmp));
        Employee testEmp2 = new Employee("Тестовый2 Т.Т.", 1, 999); // зарплаты 999 нет
        System.out.println("Сотрудник с зарплатой 999 есть? " + book.containsEmployee(testEmp2));

        // --- 9. Получение сотрудника по id ---
        System.out.println("\n  Получение сотрудника по id  ");
        // id начинаются с 1
        Employee byId = book.getEmployeeById(3);
        if (byId != null) {
            System.out.println("Найден: " + byId);
        } else {
            System.out.println("Сотрудник не найден");
        }
        // проверка несуществующего id
        Employee notFound = book.getEmployeeById(999);
        System.out.println("По id=999: " + (notFound == null ? "не найден" : notFound.toString()));


        // 1 Класс Employee/
        System.out.println(" \n\tТест задания с Классом Employee\n");
        Employee e1 = new Employee("Иванов Иван Иванович", 1, 120);
        Employee e2 = new Employee("Петрова Анна Сергеевна", 3, 300);
        System.out.println(e1);
        System.out.println(e2);

        System.out.println("ID первого сотрудника: " + e1.getId()); // 11
        System.out.println("ID второго сотрудника: " + e2.getId()); // 12

        e1.printShortInfo();
        e2.printShortInfo();
    }
}

