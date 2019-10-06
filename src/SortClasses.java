import java.util.Comparator;

class IdSort implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getId(), p2.getId());
    }
}
class FirstnameSort implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getFirstname().compareToIgnoreCase(p2.getFirstname());
    }
}


class LastnameSort implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getLastname().compareToIgnoreCase(p2.getLastname());
    }
}

