package com.bootcamp.hr.entity;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private float salary;
    private int dept_id;
    private String dept_name;
    private String job_id;
    private String job_title;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String email, float salary, int dept_id,
			String dept_name, String job_id, String job_title) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.job_id = job_id;
		this.job_title = job_title;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return this.id * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee otherEmployee = (Employee)obj;
        return this.id == otherEmployee.getId() && this.email.equals(otherEmployee.getEmail());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.id, this.firstName, this.lastName, this.email, this.salary);
    }
}
