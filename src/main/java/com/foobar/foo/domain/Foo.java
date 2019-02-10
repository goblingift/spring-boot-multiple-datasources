package com.foobar.foo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "foo")
public class Foo {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "FOO")
    private String foo;

    @PrePersist
    private void setId() {
        this.id = System.currentTimeMillis();
    }
    
    public Long getId() {
        return id;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
