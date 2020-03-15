package com.examples.dip;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
//A. High-level modules should not depend on low-level modules.
//Both should depend on abstraction
//B. Abstraction should not depend on details
//Details should not depend on abstractions.

//Abstruction is an abstruct class or an interface
//you get a signature but you don't work with concrete implementation
enum Relationship{
    parent,
    child,
    sibling
}
class Person {
    public String name;
    public Person (String name){
        this.name = name;
    }
}

class Relationships{
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }
    public void AddParentAndChild(Person Parent, Person Child){
        relations.add(new Triplet<>(Parent, Relationship.parent, Child));
        relations.add(new Triplet<>(Child, Relationship.child, Parent));

    }
}
class Research{
    public Research(Relationships relationships){
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream()
                .filter(x -> x.getValue0().name.equals("John")
                && x.getValue1() == Relationship.parent).forEach(ch ->
                System.out.println("John has a child called " + ch.getValue2().name));
    }
}
public class depInv {
    public static void main(String[] args){
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.AddParentAndChild(parent, child1);
        relationships.AddParentAndChild(parent, child2);

        new Research(relationships);
        }
}
