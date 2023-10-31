package com.workintech.entity;


import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


@Entity
@Data
@Table(name = "tweet" , schema = "public")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweet_id")
    private int tweetId;
    @Column(name = "content")
    private String content;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "retweet_count")
    private int retweetCount;

    @Column(name = "comment_count")
    private int commentCount;

    @Column(name = "local_date_time")
    private LocalDateTime localDateTime;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;


    /*
        @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinColumn(name = "user_id")
        private User user;



        @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinTable(name ="likes",schema="twitter",
                joinColumns = @JoinColumn(name="tweet_id"),
                inverseJoinColumns = @JoinColumn(name="member_id"))
        private Set<User> likedTweets = new HashSet<>();


    @OneToMany(mappedBy = "likes" , cascade = CascadeType.ALL)
    private List<Like> likeList = new ArrayList<>();
 */



}
