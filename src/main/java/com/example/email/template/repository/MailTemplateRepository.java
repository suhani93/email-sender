package com.example.email.template.repository;

import com.example.email.template.domain.MailTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MailTemplateRepository extends CrudRepository<MailTemplate,Integer> {
    Page<MailTemplate> findAll(Pageable pageable);
}
