## A java project with Maven

#### Specifications
- A HelloServlet that:
    - prints `Hello Servlet!`
    - prints `Hello` + given parameter (`name`) from URL
    - prints `Hello George!`, `George` is an `<init-param>` stored in web.xml
    - reads the values of `first_name` keys in users.json resource file

#### Structure - Directory layout:

```
-- pom
-- src
    -- main
        -- java
            -- servlets
                -- HelloServlet.java
        -- resources
            -- users.json
        -- webapp
            -- WEB-INF
                -- web.xml
-- target
```