package socialledger.persistence;




import socialledger.model.Expense;
import socialledger.model.PaymentRequest;
import socialledger.model.Person;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseDAO {
    Collection<Expense> findExpensesForPerson(Person person);

    Expense save(Expense expense);

    Optional<Expense> get(UUID id);

    Collection<PaymentRequest> findPaymentRequestsSent(Person person);

    Collection<PaymentRequest> findPaymentRequestsReceived(Person person);
}
