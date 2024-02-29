# intellij & tomcat

intellij community 버전은 tomcat을 사용하려면 plugin install 이 필요하다.

이 글은 smart tomcat을 사용하였다.

## 환경
- Java8
- Tomcat 8.0.44
- Servlet 3.1.0

### tomcat

tomcat 공식 사이트에서 제공하는 8.x.x 버전 tomcat이다. 본인이 사용하고 싶은 버전을 다운받으면 된다.
[tomcat 8](https://tomcat.apache.org/download-80.cgi)

### servlet

intellij community 는 servlet을 사용하려면 직접 세팅을 해줘야 한다. 나의 경우 maven repo 에서 import 하였다.

project structure -> Libraries -> import new -> java.servlet 검색후 3.1.0 버전을 import 하였다. 

## 프로젝트 구조

context path 지정후 프로젝트 세팅을 해주자.

프로젝트 구조는 다음과 같이 세팅하였다.
```text
├─.idea                          
│  └─libraries
├─out
│  └─production
│      └─tom
│          └─main
│              └─webapps
│                  ├─math
│                  └─WEB-INF
└─src
    └─main
        └─webapps
            ├─math
            └─WEB-INF
```

## Servlet
servlet 멤버변수는 공유된다.

override 하지 않은 경우
init -> service(ServletRequest...) -> service(HttpServletRequest) -> doGet

서블릿 실행순서
client -> WS -> Servlet Container -> first call? ->yes (memory load -> create object -> init call -> service call)
                                                              -> no(service call)

실제로 로그를 보면 처음에만 생성자 call, init 이 실행되고 이후 service call 만 실행된다.

```log
2024-02-26T13:06:49.213 : SecondServlet constructor call
2024-02-26T13:06:49.213 : SecondServlet init call
2024-02-26T13:06:49.216 : SecondServlet service call
2024-02-26T13:06:49.952 : SecondServlet service call
2024-02-26T13:06:50.809 : SecondServlet service call
```
### servlet logic

![img.png](img.png)

service 실행전 HttpServletRequest, HttpServletResponse가 생성이 되고
종료후 삭제된다.

```java
package com.edu.test;

import java.time.LocalDateTime;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hello2")
public class SecondServlet extends HttpServlet{
	
	public SecondServlet(){
		System.out.println(LocalDateTime.now() + " : " + "Second Servlet");
	}
	
	public void init(ServletConfig config) throws ServletException{
		System.out.println(LocalDateTime.now() + " : " + "Second Servlet init call");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(LocalDateTime.now() + " : " + "Second Servlet service call");
		PrintWriter writer = res.getWriter();
		writer.print("<html><head><title>Insert title here</title></head>");
		writer.print("<body>this is writer</body>");
		writer.print("</html>");
	}
}
```

curl http://localhost:9090/edu/hello2 명령어 실행시 다음과 같이 결과가 나온다.
```text
StatusCode        : 200
StatusDescription : OK
Content           : {60, 104, 116, 109...}
RawContent        : HTTP/1.1 200 OK
                    Content-Length: 85
                    Date: Mon, 26 Feb 2024 04:42:19 GMT
                    Server: Apache-Coyote/1.1

                    <html><head><title>Insert title here</title></head><body>this is writer</body></html>
Headers           : {[Content-Length, 85], [Date, Mon, 26 Feb 2024 04:42:19 GMT], [Server, Apache-Coyote/1.1]}
RawContentLength  : 85
```
다음은 doGet을 override 하여 사이트 접속시 정보를 요청하는 것이다.
```java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/netInfo")
public class NetInfoServlet extends HttpServlet {

    public NetInfoServlet() {
        System.out.println(LocalDateTime.now() + " : " + "NetInfo Servlet constructor call");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Call by GET");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Client request this uri by GET!");
        writer.print("<h1>Request Scheme : " + req.getScheme());
        writer.print("<h1>Request Method : " + req.getMethod());
        writer.print("<h1>Request Remote User : " + req.getRemoteUser());
        writer.print("<h1>Request Addr : " + req.getRemoteAddr());
        writer.print("<h1>Request Host : " + req.getRemoteHost());
        writer.print("<h1>Request Port : " + req.getRemotePort());
        writer.close();
    }
}
```
curl http://localhost:9090/edu/netInfo 요청시 결과는 다음과 같다.
```text
StatusCode        : 200
StatusDescription : OK
Content           : <h1>Client request this uri by GET!<h1>Request Scheme : http<h1>Request Method : GET<h1>Request Remote User : null<h1>Request Addr : 0:0:0:0:0:0:0:1<h1>Request 
                     Host : 0:0:0:0:0:0:0:1<h1>Request Port :...
```


### 유지기간 분류

![img_1.png](img_1.png)

- ServletContext : 서버 시작시, 서버 종료시, web application 단위로 사용
- HttpSession : client 접속시, client 종료시, client
- HttpServletRequest : 요청시, 응답시, request


## Filter
![img_2.png](img_2.png)

필터는 서블릿에 요청이 오기전에 요청을 가로채는 기능을 지원한다.
기존 spring boot 같은 경우에는 코드내에서 적용을 해본 경험이 있을 것이다. 하지만 
현 수업에서는 기본 원리를 이해하는게 목적이므로 직접 web.xml에 적용하여 적용해볼것이다.

필터는 다음과 같은 tag를 사용하여 적용이 가능하다.

```xml
    <filter>
        <filter-name>orderFilter</filter-name>
        <filter-class>main.webapps.filter.OrderFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>orderFilter</filter-name>
        <url-pattern>/orderFruit</url-pattern>
    </filter-mapping>
```

servlet 과 동일하게 어노테이션 tag, 매핑 tag 가 쌍방으로 연결이 돼야한다.

url-pattern 은 해당 필터를 적용해주고 싶은 url에 지정을 해주면 된다.
만약 동일한 url-pattern 에 필터 순서를 변경하고 싶다면 filter-mapping 순서만 변경해주면 된다.


```java
public interface ServletContextListener extends EventListener {
    void contextInitialized(ServletContextEvent var1);

    void contextDestroyed(ServletContextEvent var1);
}
``` 
contextInitialized 는 서버 시작시 서비스를 위한 준비작업을 하기 위해 사용된다.
1. Listener 구현
2. Listener 등록

<%! %> 클래스에 들어감
<% %> 서비스에 들어감(지역변수, 스크립트릿이라 부름
<%= > == out,print()


### JSP 자바빈즈
- 패키지화
- 기본 생성자 존재
- 멤버변수는 private
- getter, setter 설정
- public으로 getter, setter선언
- 직렬화구현은 선택

> javax.servlet.ServletException: java.lang.AbstractMethodError: oracle.jdbc.driver.T4CConnection.isValid(I)Z

해당 문제는 jndi 사용시 jdbc library 버전이 달라서 생기는 문제다. 즉 interface는 존재하지만 구현체가 없어서 에러가 나는것이다.
기존 ojdbc14 에서 ojdbc6으로 변경하여 해당 에러를 해결하였다.

new InitialContext()
```jsp
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
```