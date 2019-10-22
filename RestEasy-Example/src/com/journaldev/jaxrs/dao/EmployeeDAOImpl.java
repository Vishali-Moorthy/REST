package com.journaldev.jaxrs.dao;

import java.util.List;

import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.jaxrs.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addEmployee(int i,Employee e) {
		sessionFactory.getCurrentSession().saveOrUpdate(e);
	}

	@Override
	public void deleteEmployee(int id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, id);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}
	}
	
	public Employee getEmployee(int id) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return sessionFactory.getCurrentSession().createQuery("from employee")
				.list();
	}

	

}
