package com.foobar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gift.goblin.database.model.Foo;
import java.util.List;
import java.util.stream.Collectors;
import gift.goblin.database.repo.backup.BackupRepository;
import gift.goblin.database.repo.embedded.EmbeddedRepository;

@RestController
public class SimpleController {

    @Autowired
    private EmbeddedRepository embeddedRepo;

    @Autowired
    private BackupRepository backupRepo;

    @RequestMapping("/add/{value}")
    public void addEntry(@PathVariable("value") String value) {
        Foo foo = new Foo();
        foo.setFoo(value);
        embeddedRepo.saveAndFlush(foo);
    }

    @RequestMapping("/values")
    public String getValues() {
        List<Foo> allResults = embeddedRepo.findAll();
        return allResults.stream()
                .map(f -> f.getFoo())
                .collect(Collectors.joining(","));
    }

    @RequestMapping("/backup/values")
    public String getBackupValues() {
        List<Foo> allResults = backupRepo.findAll();
        return allResults.stream()
                .map(f -> f.getFoo())
                .collect(Collectors.joining(","));
    }

    @RequestMapping("/backup/add/{value}")
    public void addBackupEntry(@PathVariable("value") String value) {
        Foo foo = new Foo();
        foo.setFoo(value);
        backupRepo.saveAndFlush(foo);
    }

}
