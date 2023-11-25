package socialledger.persistence.collectionbased;

import socialledger.model.Person;
import socialledger.persistence.PersonDAO;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PersonDAOImpl implements PersonDAO {
    private final Set<Person> setOfPeople;

    public PersonDAOImpl() {
        setOfPeople = new HashSet<>();
    }

    public PersonDAOImpl(Collection<Person> people) {
        setOfPeople = new HashSet<>(people);
    }

    @Override
    public Optional<Person> findPersonByEmail(String email) {
        return setOfPeople.stream().filter(p -> p.getEmail().equals(email)).findFirst();
    }

    @Override
    public Person savePerson(Person person) {
        Optional<Person> existingPerson = findPersonByEmail(person.getEmail());
        if (existingPerson.isEmpty() || !existingPerson.get().getPassword().equals(person.getPassword())) {
            setOfPeople.add(person);
        }
        return person;
    }

    @Override
    public boolean validatePerson(String email, String password) {
        Optional<Person> person = findPersonByEmail(email);
        return person.isPresent() && person.get().getPassword().equals(password);
    }
}