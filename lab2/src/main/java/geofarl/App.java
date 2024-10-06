package geofarl;

import com.google.gson.Gson;

import person.Person;

public class App 
{
    public static void main( String[] args )
    {
        Person person = new Person("Doe", "John", 30);

        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        System.out.println("JSON: " + personJson);

        Person deserializedPerson = gson.fromJson(personJson, Person.class);

        if (person.equals(deserializedPerson)) {
            System.out.println("Deserialization successful");
        } else {
            System.out.println("Deserialization failed");
        }
    }
}
