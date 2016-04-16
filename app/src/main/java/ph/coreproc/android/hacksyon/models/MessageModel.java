package ph.coreproc.android.hacksyon.models;

/**
 * Created by johneris on 4/16/16.
 */
public class MessageModel {

    public String message;
    public MessageSenderEnum messageSenderEnum;

    public MessageModel(MessageSenderEnum messageSenderEnum, String message) {
        this.messageSenderEnum = messageSenderEnum;
        this.message = message;
    }
}
