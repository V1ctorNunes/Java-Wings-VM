package Slack;
import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PublishingMessage {


    static void publishMessage(String id, String text) {

        String token = System.getenv("SLACK_TOKEN");


        var client = Slack.getInstance().methods();
        var logger = LoggerFactory.getLogger("my-awesome-slack-app");
        try {
            var result = client.chatPostMessage(r -> r

                            .token(token)
                            .channel(id)
                            .text(text)

            );


        } catch (IOException | SlackApiException e) {

        }
    }

    public static void main(String[] args) {
        System.out.println("Hellow Word");
    }

}
