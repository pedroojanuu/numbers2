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
}
