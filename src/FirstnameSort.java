import java.util.Comparator;

class FirstnameSort implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getFirstname().compareToIgnoreCase(p2.getFirstname());
    }
}
