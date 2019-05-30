package kz.kamadi.mlearning.model

object DataManager {

    val chapters = LinkedHashMap<Int, Chapter>().apply {
        put(
            1, Chapter(
                1, "Computer fundamentals", listOf(
                    Question(
                        "A collection of interrelated file  in computer is a-",
                        listOf(
                            "File manager",
                            "Field",
                            "Record",
                            "Database"
                        ),
                        listOf(0),
                        topicId = 11
                    ),
                    Question(
                        "A collection of 8 bit is called -",
                        listOf("Byte", "Record", "Word", "Nibble"),
                        listOf(0, 1),
                        type = QuestionType.MULTIPLE,
                        topicId = 12
                    ),
                    Question(
                        "Magnetic storage devices can represent binary 0 by the absence of?",
                        listOf("A magnetic field", "Magnetic tape", "Static electricity", "It cannot possible."),
                        listOf(2),
                        topicId = 13
                    ),
                    Question(
                        "A device for converting handwritten impressions into coded characters & positional coordinates for input to a computer is",
                        listOf("Touch panel", "Mouse", "Wand", "Writing tablet"),
                        listOf(3),
                        topicId = 14
                    ),
                    Question(
                        "The first electronic digital computer contained?",
                        listOf("Electronic valves", "Vacuum tubes", "Transistors", "Semiconductor memory"),
                        listOf(3),
                        topicId = 15
                    )
                )
            )
        )
        put(
            2, Chapter(
                2, "Information system",
                listOf(Question("", listOf(), listOf()))
            )
        )
        put(
            3, Chapter(
                3, "Database",
                listOf(Question("", listOf(), listOf()))
            )
        )
        put(
            4, Chapter(
                4, "System design",
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
                "Overview",
                ""
            ),
            Topic(
                12,
                "Applications",
                ""
            ),
            Topic(
                13,
                "CPU",
                ""
            ),
            Topic(
                14,
                "Memory",
                ""
            ),
            Topic(
                15,
                "Random Access Memory",
                ""
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
                "Which of the following languages is more suited to a structured program?",
                listOf(
                    "PL/1",
                    "FORTRAN",
                    "BASIC",
                    "PASCAL"
                ),
                listOf(0)
            ),
            Question(
                "A computer assisted method for the recording and analyzing of existing or hypothetical systems is",
                listOf("Data transmission", "Data flow", "Data capture", "Data processing "),
                listOf(0, 1),
                type = QuestionType.MULTIPLE
            ),
            Question(
                "Which protocol provides e-mail facility among different hosts?",
                listOf("FTP", "SMTP", "TELNET", "SNMP"),
                listOf(2)
            ),
            Question(
                "The basic architecture of computer was developed by",
                listOf("John Von Neumann", "Charles Babbage", "Blaise Pascal", "Garden Moore"),
                listOf(3)
            ),
            Question(
                "A light sensitive device that converts drawing, printed text or other images into digital form is",
                listOf(
                    "Answer"
                ),
                listOf(0),
                type = QuestionType.OPEN
            ),
            Question(
                "In how many generations a computer can be classified?",
                listOf("3", "4", "5", "6"),
                listOf(3)
            )
        )
        questions[12] = listOf(
            Question(
                "Which of the following is the product of data processing?",
                listOf(
                    "Information",
                    "Data",
                    "Software Program",
                    "System"
                ),
                listOf(0)
            ),
            Question(
                "DNS in internet technology stands for",
                listOf(
                    "Answer"
                ),
                listOf(0),
                type = QuestionType.OPEN
            )
        )
        questions[13] = listOf(
            Question(
                "What is the correct association between a hardware component and a computer function?",
                listOf(
                    "Monitor > input",
                    "Mouse > input",
                    "CPU > storage",
                    "Hard disk > processing"
                ),
                listOf(0)
            )
        )
        questions[14] = listOf(
            Question(
                "The most recent version of the Mac OS is based on the ......... operating system.",
                listOf(
                    "Windows",
                    "Linux",
                    "Unix",
                    "CMOS"
                ),
                listOf(0)
            )
        )
        questions[15] = listOf(
            Question(
                "A websites main page is called its-",
                listOf(
                    "Home page",
                    "Browser page",
                    "Bookmark page",
                    "Search page"
                ),
                listOf(0)
            )
        )
    }
}