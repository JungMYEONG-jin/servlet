package main.webapps;

public class HelloBean {

    private String name;
    private String number;

    public HelloBean() {
        name = "이름없음";
        number = "번호없음";
    }

    public HelloBean(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
