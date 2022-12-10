package com.vtr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtr.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
