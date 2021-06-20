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
public class Employee {

    private String name;
    private String job;
    private String[] skills;
    private Details details;

    public Employee(String name, String job, String[] skills, String phone, String email) {
        this.name = name;
        this.job = job;
        this.skills = skills;
        this.details = new Details(phone, email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
