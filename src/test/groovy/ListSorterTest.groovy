import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterTest extends Specification {
    def "The sorted list should be {1, 2, 3, 4, 5, 6, 7}"() {
        given:
            def list = [3, 2, 6, 1, 4, 5, 7]
            def expected = [1, 2, 3, 4, 5, 6, 7]
            ListSorter sorter = new ListSorter()
        when:
            def sorted = sorter.sort(list)
        then:
            expected == sorted
    }
}
