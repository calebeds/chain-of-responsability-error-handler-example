public class Client {
    public static void main(String[] args) {
        System.out.println("***Chain of Responsibility Pattern Demo***\n");

        // making the chain first: Fax -> Email
        ReceiverInterface faxHandler, emailHandler;

        // end of chain
        emailHandler = new EmailErrorHandler();

        // fax handler is before email
        faxHandler = new FaxErrorHandler();
        faxHandler.setNextChain(emailHandler);

        // starting point: raiser will raise issues and set the first handler
        IssueRaiser raiser = new IssueRaiser(faxHandler);

        Message m1 = new Message("Fax is reaching late to the destination", MessagePriority.NORMAL);
        Message m2 = new Message("Email is not going", MessagePriority.HIGH);
        Message m3 = new Message("In Email, BBC field is disabled occasionally", MessagePriority.NORMAL);
        Message m4 = new Message("Fax is not reaching destination", MessagePriority.HIGH);

        raiser.raiseMessage(m1);
        raiser.raiseMessage(m2);
        raiser.raiseMessage(m3);
        raiser.raiseMessage(m4);
    }
}