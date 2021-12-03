A sample repro project for chaos monkey spring boot.

https://github.com/codecentric/chaos-monkey-spring-boot/issues/287

----

Sample project to show the problem with final method. 

When `GreetingService#greet()` method is NOT final, output is:
```
Greet: Hello Foo
```

When `GreetingService#greet()` method is final:
```
Greet: Hello null
```

with following debug message from Spring:
```
2021-12-03 11:18:58.239 DEBUG 66449 --- [           main] o.s.aop.framework.CglibAopProxy          : Final method [public final java.lang.String com.example.demochaosmonkey.GreetingService.greet()] cannot get proxied via CGLIB: Calls to this method will NOT be routed to the target instance and might lead to NPEs against uninitialized fields in the proxy instance.
```

When the method is final, the call to the method does not route to the proxy logic; hence the `name` field is not initialized and `null` in this case.
When this method internally calls another injected service, it throws NPE as the debug message shows.
