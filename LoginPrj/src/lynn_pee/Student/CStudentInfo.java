package lynn_pee.Student;

public class CStudentInfo {
	public CStudentInfo()
    {
    	//默认构造函数javaBean必须要有
    }
    
	private String id;
    private String name;
    private int    age;
    private String password;
    private String phone;
    
    public void setId(String id)  //参数可以不限制，名字有限制
    {
    	this.id = id;
    }
    public String getId()
    {
    	return id;
    }
    
    public void setName(String name)
    {
    	this.name = name;
    }
    public String getName()
    {
    	return this.name;
    }
    
    public void setAge(int age)
    {
    	this.age = age;
    }
    public int getAge()
    {
    	return this.age;
    }
    
    public void setPassword(String password)
    {
    	this.password = password;
    }
    
    public String getPassword()
    {
    	return this.password;
    }
    
    public void setPhone(String phone)
    {
    	this.phone = phone;
    }
    public String getPhone()
    {
    	return this.phone;
    }
}
