package com.foobar.bar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bar")
public class Bar {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "BAR")
    private String bar;

    @PrePersist
    private void setId() {
        this.id = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String getBar() {
        return bar;
    }
}
