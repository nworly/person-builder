package person.builder;

public class PersonBuilder implements IPersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() throws RuntimeException {
        if (name == null || surname == null) {
            throw new IllegalStateException("Person must have both name and a surname");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age number must a be positive integer");
        }

        if (address == null) {
            if (age == 0) {
                return new Person(name, surname);
            }
            return new Person(name, surname, age);
        }

        return new Person(name, surname, age, address);
    }
}
