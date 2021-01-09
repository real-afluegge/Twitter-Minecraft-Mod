package com.sqacey.tweetdeath;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfigs {
    public static Twitter getconfigs() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("key")
                .setOAuthConsumerSecret("secret")
                .setOAuthAccessToken("token")
                .setOAuthAccessTokenSecret("secret");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        return twitter;
    }
}
