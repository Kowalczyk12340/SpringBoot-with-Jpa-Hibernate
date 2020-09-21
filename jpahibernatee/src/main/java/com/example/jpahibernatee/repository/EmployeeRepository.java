package com.example.jpahibernatee.repository;

import com.example.jpahibernatee.entity.Employee;
import com.example.jpahibernatee.entity.FullTimeEmployee;
import com.example.jpahibernatee.entity.PartTimeEmployee;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public void insert(Employee employee)
    {
        entityManager.persist(employee);
    }

    public List<PartTimeEmployee> retrieveAllPartTimeEmployees()
    {
        return entityManager.createQuery("select e from PartTimeEmployee e",PartTimeEmployee.class).getResultList();
    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees()
    {
        return entityManager.createQuery("select e from FullTimeEmployee e",FullTimeEmployee.class).getResultList();
    }
}
