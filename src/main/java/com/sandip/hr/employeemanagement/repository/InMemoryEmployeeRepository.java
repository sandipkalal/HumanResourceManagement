package com.sandip.hr.employeemanagement.repository;

import com.sandip.hr.employeemanagement.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository{
    private final Map<Long,Employee> inMemoryEmployee=new ConcurrentHashMap<>();
    private final AtomicLong idGenerator=new AtomicLong();

    @Override
    public Employee save(Employee employee) {
        long id= idGenerator.incrementAndGet();
        employee.setId(id);
        inMemoryEmployee.put(id,employee);

        return employee;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(inMemoryEmployee.get(id));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(inMemoryEmployee.values());
    }

    @Override
    public Employee update(Employee employee) {
        inMemoryEmployee.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public boolean deletedBy(Long id) {
        if(inMemoryEmployee.containsKey(id)){
            inMemoryEmployee.remove((long)id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean existsById(Long id) {
        return inMemoryEmployee.containsKey(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        if(email==null){
            return false;
        }
        return inMemoryEmployee.values()
                .stream()
                .anyMatch(employee ->
                        employee.getEmail().equalsIgnoreCase(email));

    }
}