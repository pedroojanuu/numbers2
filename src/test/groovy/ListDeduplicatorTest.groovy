import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListDeduplicatorTest extends Specification {
    def "Deduplicator should return {1, 2, 4, 5}"() {
        given:
            def list = [1, 2, 4, 2, 5]
            def expected = [1, 2, 4, 5]
            ListDeduplicator deduplicator = new ListDeduplicator()
        when:
            def distinct = deduplicator.deduplicate(list)
        then:
            expected == distinct
    }

    def "Deduplicator Bug 8726"() {
        given:
            def list = [1, 2, 4, 2, 5]
            def expected = [1, 2, 4, 5]
            def sorter = Mock(GenericListSorter)
            sorter.sort(_) >> Arrays.asList(1, 2, 2, 4, 5)
            ListDeduplicator deduplicator = new ListDeduplicator()
        when:
            def distinct = deduplicator.deduplicate(list)
        then:
            expected == distinct
    }
}
