import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import spock.lang.Specification

class ListAggregatorTest extends Specification {
    def "Sum of array should be fourteen"() {
        given:
            def list = [1, 2, 4, 2, 5]
            ListAggregator aggregator = new ListAggregator()
        when:
            int sum = aggregator.sum(list)
        then:
            sum == 14
    }

    def "Max of array should be five"() {
        given:
            def list = [1, 2, 4, 2, 5]
            ListAggregator aggregator = new ListAggregator();
        when:
            int max = aggregator.max(list)
        then:
            max == 5
    }

    def "Min of array should be one"() {
        given:
            def list = [1, 2, 4, 2, 5]
            ListAggregator aggregator = new ListAggregator()
        when:
            int min = aggregator.min(list)
        then:
            min == 1
    }

    def "The number of distinct elements should be four"() {
        given:
            def list = [1, 2, 4, 2, 5]
            ListAggregator aggregator = new ListAggregator()
            def deduplicator = Mock(GenericListDeduplicator)
            deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4, 5)
        when:
            def result = aggregator.distinct(list)
        then:
            result == 4
    }

    def "Distinct bug 8726"() {
        given:
            def list = [1, 2, 4, 2]
            ListAggregator aggregator = new ListAggregator()
            def deduplicator = Mock(GenericListDeduplicator)
            deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
        when:
            def result = aggregator.distinct(list)
        then:
            result == 4
    }
}
