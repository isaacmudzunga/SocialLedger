package weshare.server;

import weshare.controller.*;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

public class Routes {
    public static final String LOGIN_PAGE = "/";
    public static final String LOGIN_ACTION = "/login.action";
    public static final String LOGOUT = "/logout";
    public static final String EXPENSES = "/expenses";
    public static final String NEW_EXPENSE = "/newexpense";
    public static final String NEW_EXPENSE_ACTION= "/expense.action";
    public static final String PAYMENTS_SENT = "/paymentrequests_sent";
    public static final String PAYMENTS_RECEIVED = "/paymentrequests_received";
    public static final String NEW_PAYMENT_REQUEST = "/paymentrequest";
    public static final String NEW_PAYMENT_REQUEST_ACTION = "/paymentrequest.action";
    public static final String PAY_ACTION = "/payment.action";


    public static void configure(WeShareServer server) {
        server.routes(() -> {
            post(LOGIN_ACTION,  PersonController.login);
            get(LOGOUT,         PersonController.logout);
            get(EXPENSES,       ExpensesController.expensesView);
            get(NEW_EXPENSE,    ExpensesController.newExpenseForm);
            post(NEW_EXPENSE_ACTION, ExpensesController.newExpenseSubmit);
            get(PAYMENTS_SENT,  ExpensesController.paymentRequestsSent);
            get(PAYMENTS_RECEIVED, ExpensesController.paymentRequestsReceived);
            get(NEW_PAYMENT_REQUEST, ExpensesController.newPaymentRequest);
            post(NEW_PAYMENT_REQUEST_ACTION, ExpensesController.newPaymentRequestSubmit);
            post(PAY_ACTION, ExpensesController.processPayment);
        });
    }
}
