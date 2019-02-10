package com.foobar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foobar.bar.domain.Bar;
import com.foobar.bar.repo.BarRepository;
import com.foobar.foo.domain.Foo;
import com.foobar.foo.repo.FooRepository;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FooBarController {

    private final FooRepository fooRepo;
    private final BarRepository barRepo;

    @Autowired
    FooBarController(FooRepository fooRepo, BarRepository barRepo) {
        this.fooRepo = fooRepo;
        this.barRepo = barRepo;
    }

    @RequestMapping("/foobar/{value}")
    public String fooBar(@PathVariable("value") String value) {
        Foo foo = fooRepo.findByFoo(value);
        Foo bar = barRepo.findByFoo(value);

        return foo.getFoo() + " " + bar.getFoo()+ "!";
    }

    @RequestMapping("/foo/add/{value}")
    public void addFoo(@PathVariable("value") String value) {
        Foo foo = new Foo();
        foo.setFoo(value);
        fooRepo.saveAndFlush(foo);
    }

    @RequestMapping("/foo/values")
    public String getFooValues() {
        List<Foo> allResults = fooRepo.findAll();
        return allResults.stream()
                .map(f -> f.getFoo())
                .collect(Collectors.joining(","));
    }

    @RequestMapping("/bar/values")
    public String getBarValues() {
        List<Foo> allResults = barRepo.findAll();
        return allResults.stream()
                .map(f -> f.getFoo())
                .collect(Collectors.joining(","));
    }

    @RequestMapping("/bar/add/{value}")
    public void addBar(@PathVariable("value") String value) {
        Foo foo = new Foo();
        foo.setFoo(value);
        barRepo.saveAndFlush(foo);
    }

}
