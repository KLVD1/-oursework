public class EmployeeBook {

    private final Employee[] employees = new Employee[10];

    // 1. Список всех сотрудников.
    public void printAllEmployees() {
        for (Employee e : employees) {
            if (e == null) {
                continue;
            }
            System.out.println(e.toString());
        }
    }

    // 2. Средняя зарплата.
    public double averageSalary() {
        int sum = 0; //сумма зарплат.
        int count = 0; //количество сотрудников.
        for (Employee e : employees) {
            if (e == null) {
                break;
            }
            sum += e.getSalary();
            count++;
        }
        if (count == 0) {
            return 0;
        }
        return (double) sum / count;
    }

    // 3. Вывод налогов.
    public void printTaxes(String taxType) {
        for (Employee e : employees) {
            if (e == null) {
                continue;
            }
            int salary = e.getSalary();
            double tax = 0; //Для налога.

            switch (taxType) {
                case "PROPORTIONAL":
                    tax = salary * 0.13;
                    tax = Math.round(tax * 100.0) / 100.0;
                    break;
                case "PROGRESSIVE":
                    if (salary <= 150) {
                        tax = salary * 0.13;
                    } else if (salary <= 350) {
                        tax = salary * 0.17;
                    } else {
                        tax = salary * 0.21;
                    }
                    tax = Math.round(tax * 100.0) / 100.0;
                    break;
                default:
                    System.out.println("Неизвестный тип налога: " + taxType);
                    return;
            }
            System.out.println(e.getFullName() + " | зарплата: " + salary + " | налог (" + taxType + "): " + tax);
        }
    }

    // 4. Индексация зарплаты по отделу
    public void indexSalaryByDepartment(int department, double percent) {
        for (Employee e : employees) {
            if (e == null || e.getDepartment() != department) {
                continue;
            }
            int newSalary = (int) Math.round(e.getSalary() * (1 + percent / 100));
            e.setSalary(newSalary);
            System.out.println("Индексация: " + e.getFullName() +
                    " — новая зарплата: " + newSalary);
        }
    }

    // 5. Первый сотрудник отдела с зарплатой > заданной
    public void findFirstEmployeeWithSalaryAbove(int department, int newSalary) {
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            if (e == null || e.getDepartment() != department) {
                continue;
            }
            if (e.getSalary() > newSalary) {
                System.out.println("Порядковый номер в списке: " + i);
                e.printShortInfo();
                break;
            }
        }
    }

    // 6. Первые сотрудники с зарплатой < wage
    public void theSalaryIsLower(int wage, int employeeNumber) {
        int found = 0;
        int i = 0;
        while (i < employees.length) {
            Employee e = employees[i];
            if (e != null && e.getSalary() < wage) {
                e.printShortInfo();
                found++;
                if (found >= employeeNumber) {
                    break;
                }
            }
            i++;
        }
        if (found == 0) {
            System.out.println("Сотрудники с зарплатой меньше " + wage + " не найдены.");
        }
    }

    // 7. Проверка наличия сотрудника по зарплате
    public boolean containsEmployee(Employee target) {
        for (Employee e : employees) {
            if (e == null) {
                continue;
            }
            if (e.equals(target)) {
                return true;
            }
        }
        return false;
    }

    // 8 Поиск свободной ячейки - добавление сотрудника
    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    // 9. Подучение сотрудника по id
    public Employee getEmployeeById(int id) {
        for (Employee e : employees) {
            if (e == null) {
                continue;
            }
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}