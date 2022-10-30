package com.company.streamapi.groupingby;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Leo", 25, 5200, "IT");
        Worker worker2 = new Worker("Donnie", 22, 5500, "IT");
        Worker worker3 = new Worker("Mikey", 32, 4700, "IT");
        Worker worker4 = new Worker("Raph", 27, 5000, "IT");
        
        Worker worker5 = new Worker("Mjay", 22, 2200, "Sales");
        Worker worker6 = new Worker("Katara", 21, 3000, "Sales");
        Worker worker7 = new Worker("Mulan", 19, 5000, "Sales");
        
        Worker worker8 = new Worker("Eve", 18, 2700, "HR");
        Worker worker9 = new Worker("Aurora", 18, 3200, "HR");
        
        Worker worker10 = new Worker("Jasmine", 21, 4200, "Finance");
        Worker worker11 = new Worker("Aladdin", 26, 4800, "Finance");

        List<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(worker4);
        workers.add(worker5);
        workers.add(worker6);
        workers.add(worker7);
        workers.add(worker8);
        workers.add(worker9);
        workers.add(worker10);
        workers.add(worker11);

//        1. Групування списку робітників за їх відділом (розподіл на списки = List)
        Map<String, List<Worker>> map1 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition));

        System.out.println("map1 = " + map1);
/*        map1 = {
            Sales=[Worker{name='Mjay', age=22, salary=2200, position='Sales'}, 
                   Worker{name='Katara', age=21, salary=3000, position='Sales'}, 
                   Worker{name='Mulan', age=19, salary=5000, position='Sales'}], 

            Finance=[Worker{name='Jasmine', age=21, salary=4200, position='Finance'}, 
                     Worker{name='Aladdin', age=26, salary=4800, position='Finance'}], 
            
            HR=[Worker{name='Eve', age=18, salary=2700, position='HR'}, 
                Worker{name='Aurora', age=18, salary=3200, position='HR'}], 
            
            IT=[Worker{name='Leo', age=25, salary=5200, position='IT'}, 
                Worker{name='Donnie', age=22, salary=5500, position='IT'}, 
                Worker{name='Mikey', age=32, salary=4700, position='IT'}, 
                Worker{name='Raph', age=27, salary=5000, position='IT'}]
        }
        
 */
        System.out.println("----------------------------------------------------------------------------------------\n");

//        2. Групування списку робітників за їх відділом (розподіл на Set)
        Map<String, Set<Worker>> map2 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));

        System.out.println("map2 = " + map2);
        /*
        map2 = {
            Sales=[Worker{name='Mulan', age=19, salary=5000, position='Sales'}, 
                   Worker{name='Katara', age=21, salary=3000, position='Sales'}, 
                   Worker{name='Mjay', age=22, salary=2200, position='Sales'}], 
            
            Finance=[Worker{name='Jasmine', age=21, salary=4200, position='Finance'}, 
                    Worker{name='Aladdin', age=26, salary=4800, position='Finance'}], 
            
            HR=[Worker{name='Aurora', age=18, salary=3200, position='HR'}, 
                Worker{name='Eve', age=18, salary=2700, position='HR'}], 
            
            IT=[Worker{name='Donnie', age=22, salary=5500, position='IT'}, 
                Worker{name='Raph', age=27, salary=5000, position='IT'}, 
                Worker{name='Mikey', age=32, salary=4700, position='IT'}, 
                Worker{name='Leo', age=25, salary=5200, position='IT'}]
        }

         */
        System.out.println("----------------------------------------------------------------------------------------\n");
        
//        3. Підрахунок кількості робітників, які працюють у конкретному відділі
        Map<String, Long> map3 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));
        System.out.println("map3 = " + map3);
//        map3 = {Sales=3, Finance=2, HR=2, IT=4}

        System.out.println("----------------------------------------------------------------------------------------\n");
        
//        4. Групування списку робітників за їх відділом, при цьому нас цікавлять лише імена
        Map<String, Set<String>> map4 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName, Collectors.toSet())));
        System.out.println("map4 = " + map4);
//        map4 = {Sales=[Mjay, Mulan, Katara], Finance=[Jasmine, Aladdin], HR=[Aurora, Eve], IT=[Raph, Leo, Mikey, Donnie]}
        
        System.out.println("----------------------------------------------------------------------------------------\n");

//        5. Розрахунок середньої зарплати на цій посаді
        Map<String, Double> map5 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.averagingInt(Worker::getSalary)));
        System.out.println("map5 = " + map5);
//        map5 = {Sales=3400.0, Finance=4500.0, HR=2950.0, IT=5100.0}
        
        System.out.println("----------------------------------------------------------------------------------------\n");

//        6. Групування списку робітників за їх відділом, робітники представлені лише іменами єдиним рядком
        Map<String, String> map6v1 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName, Collectors.joining(", ", "{", "}"))));

        System.out.println("map6v1 = " + map6v1);
//        map6 = {Sales={Mjay, Katara, Mulan}, Finance={Jasmine, Aladdin}, HR={Eve, Aurora}, IT={Leo, Donnie, Mikey, Raph}}
        
        System.out.println("----------------------------------------------------------------------------------------\n");
        Map<String, List<String>> map6v2 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.toList())));
        
        System.out.println("map6v2 = " + map6v2);
//        map6v2 = {Sales=[Mjay, Katara, Mulan], Finance=[Jasmine, Aladdin], HR=[Eve, Aurora], IT=[Leo, Donnie, Mikey, Raph]}

        System.out.println("----------------------------------------------------------------------------------------\n");

//        7. Погрупувати робітників за їх відділом, а потім погрупувати за віком
        
        Map<String, Map<Integer, List<Worker>>> map7 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.groupingBy(Worker::getAge)));
        
        System.out.println("map7 = " + map7);
        /*
        map7 = {
        Sales={19=[Worker{name='Mulan', age=19, salary=5000, position='Sales'}], 
                21=[Worker{name='Katara', age=21, salary=3000, position='Sales'}], 
                22=[Worker{name='Mjay', age=22, salary=2200, position='Sales'}]
               }, 
                
        Finance={21=[Worker{name='Jasmine', age=21, salary=4200, position='Finance'}], 
                 26=[Worker{name='Aladdin', age=26, salary=4800, position='Finance'}]
        }, 
        
        HR={
            18=[Worker{name='Eve', age=18, salary=2700, position='HR'}, 
                Worker{name='Aurora', age=18, salary=3200, position='HR'}]
            }, 
        
        IT={
            32=[Worker{name='Mikey', age=32, salary=4700, position='IT'}], 
            22=[Worker{name='Donnie', age=22, salary=5500, position='IT'}], 
            25=[Worker{name='Leo', age=25, salary=5200, position='IT'}], 
            27=[Worker{name='Raph', age=27, salary=5000, position='IT'}]
            }
        }
         */
        
        System.out.println("----------------------------------------------------------------------------------------\n");

//        8. Порахувати суму зарплати за відділами
        
        Map<String, Integer> map8 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.summingInt(Worker::getSalary)));

        System.out.println("map8 = " + map8);
//        map8 = {Sales=10200, Finance=9000, HR=5900, IT=20400}
        
        System.out.println("----------------------------------------------------------------------------------------\n");

//        9. Згрупувати за відділом і вивести тільки ЗП
        
        Map<String, List<Integer>> map9 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.mapping(Worker::getSalary, Collectors.toList())));

        System.out.println("map9 = " + map9);
//        map9 = {Sales=[2200, 3000, 5000], Finance=[4200, 4800], HR=[2700, 3200], IT=[5200, 5500, 4700, 5000]}
    }
}

class Worker {
    private String name;
    private int age;
    private int salary;
    private String position;

    public Worker(String name, int age, int salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return age == worker.age && salary == worker.salary && Objects.equals(name, worker.name) && Objects.equals(position, worker.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, position);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }
}