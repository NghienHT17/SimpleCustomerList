package com.example.customermanager.repository;

import com.example.customermanager.model.CustomerEntity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
//@Repository(value = "customerRepository")
public class CustomerRepository {
    //extends CrudRepository<CustomerEntity,int>
    @Autowired
    private EntityManager entityManager;

    public void persist(CustomerEntity customer) {
        entityManager.persist(customer);
    }

    public CustomerEntity findById(int id) {
        return entityManager.find(CustomerEntity.class, id);
    }

    public void delete(final CustomerEntity customer) {
        entityManager.remove(customer);
    }

    public List<CustomerEntity> findAll() {
        return entityManager.createQuery("SELECT a FROM CustomerEntity a", CustomerEntity.class).getResultList();
        //tra ra danh sach cac ban ghi ma lay ra truong id thoi
//        "from CustomerEntity "
    }



}