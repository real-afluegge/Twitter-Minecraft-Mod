package com.sqacey.tweetdeath;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfigs {
    public static Twitter getconfigs() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("xCeFnOA15lRTiHxa4QJiJHBzk")
                .setOAuthConsumerSecret("b16RDd1hvA4grG1MUIIZl7mmG950tRJdkXYoFcC7fQ5FQgm2O0")
                .setOAuthAccessToken("2802523530-bqq1Z2or5u6GuoYB99BDbWK6I2GRv5fciebRV66")
                .setOAuthAccessTokenSecret("mHqXY8Fq2tjrNwQodkvT6bYeFseKxicxX44JhJQCTOw4A");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        return twitter;
    }
}
