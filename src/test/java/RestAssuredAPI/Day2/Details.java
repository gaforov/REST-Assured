package RestAssuredAPI.Day2;

/*
{
  "name": "Said",
  "job": "Tester",
  "skills": ["Java, Selenium"],
  "details": {
    "phone": "123-345-3424",
    "email": "said@gmail.com"
  }
}
 */
public class Details {

    private String phone;
    private String email;

    public Details(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
