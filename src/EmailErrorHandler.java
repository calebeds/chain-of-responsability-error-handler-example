public class EmailErrorHandler implements ReceiverInterface {

    private ReceiverInterface nextReceiver;
    @Override
    public boolean processMessage(Message msg) {
        if(msg.text.contains("Email")) {
            System.out.println("EmailErrorHandler processed " + msg.priority + " priority issue: " + msg.text);
            return true;
        } else if (this.nextReceiver != null) {
            this.nextReceiver.processMessage(msg);
        }

        return false;
    }

    @Override
    public void setNextChain(ReceiverInterface nextChain) {
        this.nextReceiver = nextChain;
    }
}
