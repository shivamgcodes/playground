public class Employee {
    String firstname;
    String lastname;
    String post;
    int age;
    int salary;

    public Employee(String firstname, String lastname, String post, int age, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.post = post;
        this.age = age;
        this.salary = salary;
    }
    public Employee(String firstname , String lastname, int salary)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = 0;
        this.salary = salary;
        this.post = null;

    }
    @Override
    public Object clone(){
        return new Employee(this.firstname , this.lastname , this.post , this.age , this.salary);

    }
    @Override
    public boolean equals(Object object){
       Employee obj = (Employee)object;
        return (this.firstname == obj.firstname && this.lastname == obj.lastname &&
                obj.post == this.post && obj.salary == this.salary && this.age == obj.age);
    }
    public void print(){
        System.out.println(this.firstname +" "+ this.lastname);
        System.out.println(this.post);
        System.out.println(this.age);
        System.out.println(this.salary);

    }
}
