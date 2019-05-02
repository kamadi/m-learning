package kz.kamadi.mlearning.model

object DataManager {

    val chapters = LinkedHashMap<Int, Chapter>().apply {
        put(
            1, Chapter(
                1, "Chapter 1", listOf(
                    Question(
                        "Question 1",
                        listOf(
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum.",
                            "Answer 2",
                            "Answer 3",
                            "Answer 4"
                        ),
                        listOf(0),
                        topicId = 11
                    ),
                    Question(
                        "Question 2 multiple",
                        listOf("Answer 1", "Answer 2", "Answer 3", "Answer 4"),
                        listOf(0, 1),
                        type = QuestionType.MULTIPLE,
                        topicId = 12
                    ),
                    Question(
                        "Question 3",
                        listOf("Answer 1", "Answer 2", "Answer 3", "Answer 4"),
                        listOf(2),
                        topicId = 13
                    ),
                    Question(
                        "Question 4",
                        listOf("Answer 1", "Answer 2", "Answer 3", "Answer 4"),
                        listOf(3),
                        topicId = 14
                    ),
                    Question(
                        "Question 5",
                        listOf("Answer 1", "Answer 2", "Answer 3", "Answer 4"),
                        listOf(3),
                        topicId = 15
                    )
                )
            )
        )
        put(
            2, Chapter(
                2, "Chapter 2",
                listOf(Question("", listOf(), listOf()))
            )
        )
        put(
            3, Chapter(
                3, "Chapter 3",
                listOf(Question("", listOf(), listOf()))
            )
        )
        put(
            4, Chapter(
                4, "Chapter 3",
                listOf(Question("", listOf(), listOf()))
            )
        )
    }

    val topics = mutableMapOf<Int, List<Topic>>()

    val questions = mutableMapOf<Int, List<Question>>()

    val topicResults = mutableMapOf<Int, List<QuestionResult>>()

    val chapterExamResults = mutableMapOf<Int, List<QuestionResult>>()

    init {
        topics[1] = listOf(
            Topic(
                11,
                "1Topic 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                12,
                "2Topic 2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                13,
                "3Topic 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                14,
                "4Topic 4",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                15,
                "5Topic 5",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            )
        )
        topics[2] = listOf(
            Topic(
                21,
                "Topic 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                22,
                "Topic 2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                23,
                "Topic 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                24,
                "Topic 4",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                25,
                "Topic 5",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            )
        )
        topics[3] = listOf(
            Topic(
                31,
                "Topic 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                32,
                "Topic 2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                33,
                "Topic 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                34,
                "Topic 4",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                35,
                "Topic 5",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            )
        )
        topics[4] = listOf(
            Topic(
                41,
                "Topic 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                42,
                "Topic 2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                43,
                "Topic 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                44,
                "Topic 4",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            ),
            Topic(
                45,
                "Topic 5",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum. Integer sed mi maximus, pulvinar diam ut, iaculis diam. Suspendisse auctor neque velit, ut rutrum ipsum elementum pretium. Donec eu malesuada augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis et lorem eros. Ut ullamcorper neque at tristique gravida. Sed eget pulvinar elit. Quisque non odio vitae orci aliquet auctor sit amet sit amet augue. Donec tincidunt, neque a elementum vehicula, erat dui volutpat leo, a rhoncus neque turpis eu dolor. In hac habitasse platea dictumst. Aliquam nisl ante, facilisis feugiat nulla eu, molestie ultricies dolor. Nulla ac faucibus dui. Suspendisse sed sapien non lorem eleifend finibus vitae vitae sem"
            )
        )

        questions[11] = listOf(
            Question(
                "Question 1",
                listOf(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum.",
                    "Answer 2",
                    "Answer 3",
                    "Answer 4"
                ),
                listOf(0)
            ),
            Question(
                "Question 2 multiple",
                listOf("Answer 1", "Answer 2", "Answer 3", "Answer 4"),
                listOf(0, 1),
                type = QuestionType.MULTIPLE
            ),
            Question(
                "Question 3",
                listOf("Answer 1", "Answer 2", "Answer 3", "Answer 4"),
                listOf(2)
            ),
            Question(
                "Question 4",
                listOf("Answer 1", "Answer 2", "Answer 3", "Answer 4"),
                listOf(3)
            ),
            Question(
                "Question 5",
                listOf("Answer 1", "Answer 2", "Answer 3", "Answer 4"),
                listOf(3)
            )
        )
        questions[12] = listOf(
            Question(
                "Question 1",
                listOf(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum.",
                    "Answer 2",
                    "Answer 3",
                    "Answer 4"
                ),
                listOf(0)
            )
        )
        questions[13] = listOf(
            Question(
                "Question 1",
                listOf(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum.",
                    "Answer 2",
                    "Answer 3",
                    "Answer 4"
                ),
                listOf(0)
            )
        )
        questions[14] = listOf(
            Question(
                "Question 1",
                listOf(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum.",
                    "Answer 2",
                    "Answer 3",
                    "Answer 4"
                ),
                listOf(0)
            )
        )
        questions[15] = listOf(
            Question(
                "Question 1",
                listOf(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis tristique dui, eget condimentum ipsum.",
                    "Answer 2",
                    "Answer 3",
                    "Answer 4"
                ),
                listOf(0)
            )
        )
    }
}