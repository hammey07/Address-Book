import java.util.Comparator;

class LastnameSort implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getLastname().compareToIgnoreCase(p2.getLastname());
    }
}
