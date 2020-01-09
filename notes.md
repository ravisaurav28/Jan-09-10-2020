GET /person/{id}
DELETE /person/{id}
POST /person/{name}/{age}
PUT /person/{id}/{age}

GET /person/id/{id}
GET /person/age/{age}


/getPerson/{id}
/deletePeron/{id}
/savePerson/{name}/{age}
/updateAgeOfPerson/{id}/{age}





* training
* persons (id primary key auto_increment, name, age)

```sql

create database training;

create table persons( id int(4) not null primary key auto_increment, name varchar(40), age int(4));

```


```
[src]
	[main]
		[java]
		[resources]
		[webapp]
			*.jsp
```





* curl -method POST

``` java

class Account {

	accountNumber, balance;
	
	deposit(amount) {
	}
	withdraw(amount) {
	}
	transferFund(to, amount) {
	}

}
```

* Object Pool
* Transaction for transferFund
* Security for withdraw or transferFund

``` java

interface AccountHome extends XYZ {}
interface AccountRemote extends ABC {}
class AccountBean implements EntityBean {
	//No constructors
	//No final variables
	//No static methods
	//No throws keyword
}

//ejb-jar.xml -> what all services you need
//jboss.xml

```

* Bundle them into Account.jar
* And drop it inside the container


* Spring is a lightweight container
* POJO framework
* Dependency Injection

* Spring Boot is an abstraction of underlying Spring framework
* Latest version is 2.x
* Latest version of spring is 5.x
















