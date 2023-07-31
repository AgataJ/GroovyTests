import com.example.GroovyTests.PaymentGateway
import spock.lang.Specification

class FirstSpecification extends Specification {
    def paymentGateway = Mock(PaymentGateway)

    def "one plus one should equal two"() {
        expect:
            1 + 1 == 2
    }

    def "two plus two should equal four"() {
        given:
            int left = 2
            int right = 2

        when:
            int result = left + right

        then:
            result == 4
    }

    def "Should be able to remove from list"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(0)

        then:
        list == [2, 3, 4]
    }

    def "Should get an index out of bounds when removing a non-existent item"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(20)

        then:
        thrown(IndexOutOfBoundsException)
        list.size() == 4
    }

    def "numbers to the power of two"(   ) {
        expect:
            //a * b == c
            Math.pow(a,b) == c

        where:
            a | b | c
            1 | 2 | 1
            2 | 2 | 5
            3 | 2 | 9
    }

    def "test"() {
        given:
        double x = 11.635;
        double y = 2.76;
        expect:
        System.out.printf("The value of e is %.4f%n", Math.E);
        System.out.printf("pow(%.3f, %.3f) is %.3f%n", x, y, Math.pow(x, y));
    }

    def "create mock payment"(payment) {
        given:
            paymentGateway.makePayment(_) >> [true, true, false, true]


        expect:
            paymentGateway.makePayment(payment) == true



        where:
            payment << [20, 100, 20, 5]
    }

    def "Should verify notify was called"() {
        given:
        def notifier = Mock(com.example.GroovyTests.Notifier)

        when:
        notifier.notify('foo')

        then:
        2 * notifier.notify('foo')
    }
}